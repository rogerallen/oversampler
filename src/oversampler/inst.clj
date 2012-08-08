(ns oversampler.inst
  (:require [overtone.live :as o]
            [oversampler.bank :as bank]))

;; ??? should these buffers be part of oversampler.bank?

;; Silent buffer used to fill in the gaps.
(defonce ^:private silent-buffer (o/buffer 0))

;; Index of buffer ids for instrument note ctl to index through
(defonce ^:private index-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf (:id silent-buffer))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.3)
        (o/buffer-set! buf i (:id (bank/get-cello-sample i 0.3)))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.5)
        (o/buffer-set! buf (+ 128 i) (:id (bank/get-cello-sample i 0.5)))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 1.0)
        (o/buffer-set! buf (+ 256 i) (:id (bank/get-cello-sample i 1.0)))))
    buf))

;; the sampled-cello instrument
(o/definst sampled-cello
  [note 60 level 1 rate 1 loop? 0
   attack 0 decay 1 sustain 1 release 0.1 curve -4 gate 1]
  (let [buf (o/index:kr (:id index-buffer) (+ 256 note)) ;; FIXME pp/mf samples
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                     :gate gate
                     :action o/FREE)]
    (* env (o/scaled-play-buf 1 buf :level level :loop loop? :action o/FREE))))
