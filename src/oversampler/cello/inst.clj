;;
;; the sampled cello instrument
;;
;; to use:
;;   (use 'overtone.live)
;;   (use 'oversampler.cello.inst)
;;   (sampled-cello :note 50 :level 0.5) ;; mf sample
;;
;;   (sampled-cello-init :pp-volume-cutoff 0.3 :mf-volume-cutoff 0.85)
;;   (sampled-cello :note 50 :level 0.2) ;; pp sample
;;   (sampled-cello :note 50 :level 0.5) ;; mf sample
;;   (sampled-cello :note 50 :level 0.9) ;; ff sample
;;   
(ns oversampler.cello.inst
  (:require [overtone.live :as o]
            [oversampler.cello.raw :as raw]
            [oversampler.cello.bank :as bank]))

;; ======================================================================
;; several index buffers to use for grabbing per-note control information
;;
;; Silent buffer used to fill in for any missing notes
(defonce ^:private silent-buffer (o/buffer 0))
;; buffer of buffer ids for instrument note ctl to index through
;; 3 buffers (pp,mf,ff) x 128 midi note values
(defonce ^:private note-to-sample-id-buffer (o/buffer (* 3 128)))
;; buffer of scaling values for note ctl to index through
(defonce ^:private note-to-level-scale-buffer (o/buffer (* 3 128)))
;; buffer of sample-lengths for note ctl to index through
(defonce ^:private note-to-length-buffer (o/buffer (* 3 128)))
;; buffer of rates for note ctl to index through
(defonce ^:private note-to-rate-buffer (o/buffer (* 3 128)))
;; buffer of buffer-offsets for level to index through.
;; 0 = pp, 128 = mf, 256 = ff
(defonce ^:private level-to-offset-buffer (o/buffer 21))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (bank/get-sample i volume))))))

(defn- fill-buffer-scaling-factors
  "fill 128 level-scaling-factors in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (/ 2.0 (:ppeak (bank/get-sample-info i volume)))))))

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

(defn- fill-buffer-rates
  "fill 128 rates in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:rate (bank/get-sample-info i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-cello-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! note-to-level-scale-buffer 1.0)
  (o/buffer-fill! note-to-length-buffer      0.0)
  (o/buffer-fill! note-to-rate-buffer        1.0)
  (o/buffer-fill! level-to-offset-buffer     0)
  nil)

;; ======================================================================
;; initialize the cello instrument buffers
(defn sampled-cello-init
  "initialize all things for the cello.  By default, only mf samples will be used."
  [& {:keys [min-note-index max-note-index pp-volume-cutoff mf-volume-cutoff]
      :or {min-note-index bank/min-index
           max-note-index bank/max-index
           pp-volume-cutoff 0.0
           mf-volume-cutoff 1.0}}]
  (let [load-pp-samples (> pp-volume-cutoff 0.0)
        load-mf-samples (> mf-volume-cutoff 0.0)
        load-ff-samples (< mf-volume-cutoff 1.0)]
    (reset-buffers)
    (when load-pp-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 0 raw/pp)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 0 raw/pp)
      (fill-buffer-lengths note-to-length-buffer 0 raw/pp)
      (fill-buffer-rates note-to-rate-buffer 0 raw/pp))
    (when load-mf-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 128 raw/mf)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 128 raw/mf)
      (fill-buffer-lengths note-to-length-buffer 128 raw/mf)
      (fill-buffer-rates note-to-rate-buffer 128 raw/mf))
    (when load-ff-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 256 raw/ff)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 256 raw/ff)
      (fill-buffer-lengths note-to-length-buffer 256 raw/ff)
      (fill-buffer-rates note-to-rate-buffer 256 raw/ff))
    (dotimes [i 21]
      (let [cur-volume (/ i 20.0)
            cur-offset (cond
                        (< cur-volume pp-volume-cutoff) 0
                        (<= cur-volume mf-volume-cutoff) 128
                        :else 256)]
        (o/buffer-set! level-to-offset-buffer i cur-offset)))
    nil))

;; ======================================================================
;; Initializes the cello banks with the default settings
(println "sampled-cello: initializing default samples...")
;; (time (sampled-cello-init :pp-volume-cutoff 0.30 :mf-volume-cutoff 0.85))
(time (sampled-cello-init))
(println "sampled-cello: done.")

;; ======================================================================
;; the sampled-cello instrument
(o/definst sampled-cello
  [note 60 level 1 rate 1 
   attack 0 decay 1 sustain 1 release 0.2 curve -4 gate 1]
  (let [ofst (o/index:kr (:id level-to-offset-buffer) (o/floor (* 20 level)))
        the-sample-id (o/index:kr (:id note-to-sample-id-buffer) (+ ofst note))
        the-sample-scale (o/index:kr (:id note-to-level-scale-buffer) (+ ofst note))
        the-sample-length (o/index:kr (:id note-to-length-buffer) (+ ofst note))
        ;; envelope for making sure we have zeros at start/end, scale height, too.
        env2 (o/env-gen (o/envelope [0 0 1 1 0 0]
                                    [0.01 0.01 (- the-sample-length 0.04) 0.01 0.01]
                                    :sine)
                        :level-scale the-sample-scale
                        :gate gate :action o/FREE)
        ;; regular adsr envelope
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                       :gate gate :action o/FREE)
        the-rate (* rate (o/index:kr (:id note-to-rate-buffer) (+ ofst note)))]
    (* level env2 env (o/scaled-play-buf 1 the-sample-id :rate the-rate :level 1.0 :action o/FREE))))
