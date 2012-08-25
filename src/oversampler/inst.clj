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
      (if (bank/get-cello-sample i 0.15)
        (o/buffer-set! buf i (:id (bank/get-cello-sample i 0.15)))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.3)
        (o/buffer-set! buf (+ 128 i) (:id (bank/get-cello-sample i 0.3)))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.5)
        (o/buffer-set! buf (+ 256 i) (:id (bank/get-cello-sample i 0.5)))))
    buf))

(defonce ^:private sample-scale-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf 1.0)
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.15)
        (o/buffer-set! buf i (/ 0.15 (:ppeak (bank/get-cello-sample-info i 0.15))))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.3)
        (o/buffer-set! buf (+ 128 i) (/ 0.3 (:ppeak (bank/get-cello-sample-info i 0.3))))))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.5)
        (o/buffer-set! buf (+ 256 i) (/ 0.5 (:ppeak (bank/get-cello-sample-info i 0.5))))))
    buf))

(defonce ^:private sample-length-buffer
  (let [buf (o/buffer (* 3 128))]
    (o/buffer-fill! buf 0.0)
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.15)
        (o/buffer-set! buf i (/ (- (:end (bank/get-cello-sample-info i 0.15)) (:start (bank/get-cello-sample-info i 0.15)) (* 4 4410)) 44100.0)
                                   )))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.3)
        (o/buffer-set! buf (+ 128 i) (/ (- (:end (bank/get-cello-sample-info i 0.3)) (:start (bank/get-cello-sample-info i 0.3)) (* 4 4410)) 44100.0)
                       )))
    (dotimes [i 128]
      (if (bank/get-cello-sample i 0.5)
        (o/buffer-set! buf (+ 256 i) (/ (- (:end (bank/get-cello-sample-info i 0.5)) (:start (bank/get-cello-sample-info i 0.5)) (* 4 4410)) 44100.0)
                       )))
    buf))

;; the sampled-cello instrument
(o/definst sampled-cello
  [note 60 level 1 rate 1 loop? 0
   attack 0 decay 1 sustain 1 release 0.1 curve -4 gate 1]
  (let [buf (o/index:kr (:id index-buffer) (+ 256 note)) ;; FIXME pp/mf samples
        the-sample-scale (o/index:kr (:id sample-scale-buffer) (+ 256 note))
        the-sample-length (o/index:kr (:id sample-length-buffer) (+ 256 note))
        ;; envelope for making sure we have zeros at start/end, scale height, too.
        env2 (o/env-gen (o/envelope [0 0 1 1 0 0] [0.01 0.01 the-sample-length 0.01 0.01] :sine)
                        :level-scale the-sample-scale
                        :gate gate :action o/FREE)
        ;; regular adsr envelope
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                     :gate gate
                     :action o/FREE ;; ?? only need one of these, I think?
                     )]
    (* env2 env (o/scaled-play-buf 1 buf :level level :loop loop? :action o/FREE))))
