;;
;; the sampled piano instrument
;;
(ns oversampler.piano.inst
  (:require [overtone.live :as o]
            [oversampler.piano.raw :as raw]
            [oversampler.piano.bank :as bank]))

;; ======================================================================
;; several index buffers to use for grabbing per-note control information
;;
;; Silent buffer used to fill in for any missing notes
(defonce ^:private silent-buffer (o/buffer 0))
;; buffer of buffer ids for instrument note ctl to index through
;; 3 buffers (pp,mf,ff) x 128 midi note values
(defonce ^:private note-to-sample-id-buffer (o/buffer (* 3 128)))
;; buffer of buffer-offsets for level to index through.
;; 0 = mf, 128 = ff
(defonce ^:private level-to-offset-buffer (o/buffer 21))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (bank/get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (bank/get-sample i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-piano-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! level-to-offset-buffer     0)
  nil)

;; ======================================================================
;; initialize the piano instrument buffers
(defn sampled-piano-init
  "initialize all things for the piano.  By default, only mf samples will be used."
  [& {:keys [min-note-index max-note-index mf-volume-cutoff]
      :or {min-note-index bank/min-index
           max-note-index bank/max-index
           pp-volume-cutoff 0.0
           mf-volume-cutoff 0.0}}]
  (let [load-mf-samples (> mf-volume-cutoff 0.0)
        load-ff-samples (< mf-volume-cutoff 1.0)]
    (reset-buffers)
    (when load-mf-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 0 raw/mf))
    (when load-ff-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 128 raw/ff))
    (dotimes [i 21]
      (let [cur-volume (/ i 20.0)
            cur-offset (cond
                        (<= cur-volume mf-volume-cutoff) 0
                        :else 128)]
        (o/buffer-set! level-to-offset-buffer i cur-offset)))
    nil))

;; ======================================================================
;; Initializes the piano banks with the default settings
(println "sampled-piano: initializing default samples...")
;; (time (sampled-piano-init :mf-volume-cutoff 0.85))
(time (sampled-piano-init))
(println "sampled-piano: done.")

;; ======================================================================
;; the sampled-piano instrument
(o/definst sampled-piano
  [note 60 level 1 rate 1
   attack 0 decay 1 sustain 1 release 0.2 curve -4 gate 1]
  (let [ofst (o/index:kr (:id level-to-offset-buffer) (o/floor (* 20 level)))
        the-sample-id (o/index:kr (:id note-to-sample-id-buffer) (+ ofst note))
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                       :gate gate :action o/FREE)]
    (* env (o/scaled-play-buf 2 the-sample-id :rate rate :level level :action o/FREE))))
