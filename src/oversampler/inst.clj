(ns oversampler.inst
  (:require [overtone.live :as o]
            [oversampler.bank :as bank]))

(o/definst sampled-cello
  [note 60 level 1 rate 1 loop? 0
   attack 0 decay 1 sustain 1 release 0.1 curve -4 gate 1]
  (let [buf 20 ;;(:id (bank/get-cello-sample note)) ;; FIXME--this doesn't work
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                     :gate gate
                     :action o/FREE)]
    (* env (o/scaled-play-buf 1 buf :level level :loop loop? :action o/FREE))))

;; (definst sampled-piano
;;   [note 60 level 1 rate 1 loop? 0
;;    attack 0 decay 1 sustain 1 release 0.1 curve -4 gate 1]
;;   (let [buf (index:kr (:id index-buffer) note)
;;         env (env-gen (adsr attack decay sustain release level curve)
;;                      :gate gate
;;                      :action FREE)]
;;     (* env (scaled-play-buf 2 buf :level level :loop loop? :action FREE))))
