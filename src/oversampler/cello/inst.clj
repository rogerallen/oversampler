;;
;; the sampled cello instrument
;;
;; to use:
;;   (use 'overtone.live)
;;   (use 'oversampler.cello.inst)
;;   (sampled-cello :note 50 :level 0.2) ;; pp sample
;;   (sampled-cello :note 50 :level 0.5) ;; mf sample
;;   (sampled-cello :note 50 :level 0.8) ;; ff sample
;;   
(ns oversampler.cello.inst
  (:require [overtone.live :as o]
            [oversampler.cello.raw :as raw]
            [oversampler.cello.bank :as bank]))

;; Silent buffer used to fill in for any missing notes
(defonce ^:private silent-buffer (o/buffer 0))

;; ======================================================================
;; several index buffers to use for grabbing per-note control information

(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (bank/get-sample i volume))))))

;; buffer of buffer ids for instrument note ctl to index through
(defonce ^:private note-to-sample-id-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf (:id silent-buffer))
    (fill-buffer-sample-ids buf 0 raw/pp)
    (fill-buffer-sample-ids buf 128 raw/mf)
    (fill-buffer-sample-ids buf 256 raw/ff)
    buf))

(defn- fill-buffer-scaling-factors
  "fill 128 level-scaling-factors in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (/ 2.0 (:ppeak (bank/get-sample-info i volume)))))))

;; buffer of scaling values for note ctl to index through
(defonce ^:private note-to-level-scale-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf 1.0)
    (fill-buffer-scaling-factors buf 0 raw/pp)
    (fill-buffer-scaling-factors buf 128 raw/mf)
    (fill-buffer-scaling-factors buf 256 raw/ff)
    buf))

(defn- fill-buffer-lengths
  "fill 128 length (in seconds) in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (let [the-info (bank/get-sample-info i volume)
            the-length (- (:end the-info) (:start the-info))
            the-rate (:rate (:sample the-info))
            length-in-secs (/ the-length the-rate)] 
        (o/buffer-set! buf (+ offset i) length-in-secs)))))

;; buffer of sample-lengths for note ctl to index through
(defonce ^:private note-to-length-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf 0.0)
    (fill-buffer-lengths buf 0 raw/pp)
    (fill-buffer-lengths buf 128 raw/mf)
    (fill-buffer-lengths buf 256 raw/ff)
    buf))

;; buffer of buffer-offsets for level to index through.
;; 0 = pp, 128 = mf, 256 = ff
(defonce ^:private level-to-offset-buffer
  (let [buf (o/buffer 21)]
    (o/buffer-set! buf  0 0) ;; 0.00
    (o/buffer-set! buf  1 0) ;; 0.05
    (o/buffer-set! buf  2 0) ;; 0.10
    (o/buffer-set! buf  3 0)
    (o/buffer-set! buf  4 0)
    (o/buffer-set! buf  5 0)
    (o/buffer-set! buf  6 128) ;; 0.30
    (o/buffer-set! buf  7 128)
    (o/buffer-set! buf  8 128) ;; 0.40
    (o/buffer-set! buf  9 128)
    (o/buffer-set! buf 10 128) ;; 0.50
    (o/buffer-set! buf 11 128)
    (o/buffer-set! buf 12 128) ;; 0.60
    (o/buffer-set! buf 13 128)
    (o/buffer-set! buf 14 128) ;; 0.70
    (o/buffer-set! buf 15 128)
    (o/buffer-set! buf 16 128) ;; 0.80
    (o/buffer-set! buf 17 256) ;; 0.85
    (o/buffer-set! buf 18 256) ;; 0.90
    (o/buffer-set! buf 19 256) ;; 0.95
    (o/buffer-set! buf 20 256)
    buf)) ;; 1.00

;; ======================================================================
;; the sampled-cello instrument
(o/definst sampled-cello
  [note 60 level 1 rate 1 loop? 0
   attack 0 decay 1 sustain 1 release 0.2 curve -4 gate 1]
  (let [ofst (o/index:kr (:id level-to-offset-buffer) (o/floor (* 20 level))) ;; FIXME? -- (o/max 0.0 (o/min 1.0 level)))))
        the-sample-id (o/index:kr (:id note-to-sample-id-buffer) (+ ofst note))
        the-sample-scale (o/index:kr (:id note-to-level-scale-buffer) (+ ofst note))
        the-sample-length (o/index:kr (:id note-to-length-buffer) (+ ofst note))
        ;; envelope for making sure we have zeros at start/end, scale height, too.
        env2 (o/env-gen (o/envelope [0 0 1 1 0 0] [0.01 0.01 (- the-sample-length 0.04) 0.01 0.01] :sine)
                        :level-scale the-sample-scale
                        :gate gate :action o/FREE)
        ;; regular adsr envelope
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                       :gate gate :action o/FREE)]
    (* level env2 env (o/scaled-play-buf 1 the-sample-id :level 1.0 :loop loop? :action o/FREE))))
