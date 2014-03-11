;;
;; garageband steinway grand piano synth
;;
(ns oversampler.garageband.steinway-grand-piano.synth
  (:require [overtone.live :as o]
            [oversampler.garageband.steinway-grand-piano.bank :as bank]))

;; provide an alias
(def sample-init bank/sample-init)
;; (sample-init)

;; ======================================================================
;; the sampled-piano instrument
(o/defsynth steinway-grand-piano
  "A sampled piano synth using samples from Apple's Garageband.  Use
note to select the midi pitch and change the global volue via level.
A rate control allows for pitch adjustment.  Use gate to turn off the
provided ADSR envelope.  By default, when the sample goes silent, it
causes a FREE of the instrument to happen.  However, it can be useful
to pass a NO-ACTION in order to only have the instrument freed when
a :gate 0 happens.  Use the pan to control stereo placement and use
out-bus to control where the output of the synth is sent."
  [note    {:default 60  :min bank/min-index :max bank/max-index :step 1}
   level   {:default 1.0 :min 0.0 :max 1.0 :step 0.01}
   rate    {:default 1.0 :min 0.5 :max 2.0 :step 0.01}
   attack  {:default 0.0 :min 0.0 :max 0.5 :step 0.01}
   decay   {:default 0.0 :min 0.0 :max 0.5 :step 0.01}
   sustain {:default 1.0 :min 0.0 :max 1.0 :step 0.01}
   release {:default 0.2 :min 0.0 :max 1.0 :step 0.01}
   curve   {:default -4  :min -5  :max 5   :step 1}
   gate    {:default 1   :min 0   :max 1   :step 1}
   pan     {:default 0.0 :min -1  :max 1   :step 0.01}
   play-buf-action o/FREE
   out-bus 0]
  (let [ofst (o/index:kr (:id bank/level-to-offset-buffer) (o/floor (* 20 level)))
        the-sample-id (o/index:kr (:id bank/note-to-sample-id-buffer) (+ ofst note))
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                       :gate gate :action o/FREE)
        the-samples (o/scaled-play-buf 2 the-sample-id
                                       :rate rate
                                       :level 1.0
                                       :action play-buf-action)]
    ;; FIXME -- level needs adjustment
    (o/out out-bus (o/pan2 (* ;level
                              env the-samples) pan))))

;; (steinway-grand-piano 60 :level 0.6)