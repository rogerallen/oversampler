;;
;; the sampled ektara synth
;;
;; to use:
;;   (use 'overtone.live)
;;   (use 'oversampler.ektara.synth)
;;   (sampled-ektara :note 60 :level 0.25)
;;   (sampled-ektara :note 50 :level 0.5)
;;   (sampled-ektara :note 45 :level 0.99)
;;   
(ns oversampler.ektara.synth
  (:require [overtone.live :as o]
            [oversampler.ektara.bank :as bank]))

;; provide an alias
(def sampled-ektara-init bank/sampled-ektara-init)

;; ======================================================================
;; the sampled-ektara synth
(o/defsynth sampled-ektara
  "A sampled ektara synth.  Use note to select the midi pitch and
change the global volue via level.  A rate control allows for pitch
adjustment.  Use gate to turn off the provided ADSR envelope.  By
default, when the sample goes silent, it causes a FREE of the
instrument to happen.  However, it can be useful to pass a NO-ACTION
to the play-buf-action in order to only have the instrument freed when
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
  (let [the-sample-id (o/index:kr (:id bank/note-to-sample-id-buffer) note)
        the-sample-scale (o/index:kr (:id bank/note-to-level-scale-buffer) note)
        the-sample-length (o/index:kr (:id bank/note-to-length-buffer) note)
        the-sample-rate (o/index:kr (:id bank/note-to-rate-buffer) note)
        ;; envelope for making sure we have zeros at start/end, this
        ;; also allows us to scale the height (level), too.
        env2 (o/env-gen (o/envelope [0 0 1 1 0 0]
                                    [0.01 0.01 (- the-sample-length 0.04) 0.01 0.01]
                                    :sine)
                        :level-scale the-sample-scale
                        :gate gate :action o/FREE)
        ;; regular adsr envelope
        env (o/env-gen (o/adsr attack decay sustain release level curve)
                       :gate gate :action o/FREE)
        the-samples (o/scaled-play-buf 1 the-sample-id
                                       :rate (* rate the-sample-rate)
                                       :level 1.0
                                       :action play-buf-action)
        ;; the ektara samples have some crazy low-frequency "issues" that can
        ;; be easily filtered with the leak-dc ugen.
        the-samples (o/leak-dc the-samples 0.995)]
    (o/out out-bus (o/pan2 (* level env2 env the-samples) pan))))
