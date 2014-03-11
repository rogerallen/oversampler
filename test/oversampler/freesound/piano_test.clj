(ns oversampler.freesound.piano-test
  (:use clojure.test
        overtone.live)
  (:require [oversampler.freesound.piano.inst :as inst]
            [oversampler.freesound.piano.synth :as synth]
            [oversampler.freesound.piano.bank :as bank]))

(println "Setup test piano samples...")
(time (inst/sampled-piano-init :mf-volume-cutoff 0.75))
(println "done.")

(import 'javax.swing.JOptionPane)

(defn ask-user-tf
  "return True on yes, False on fail"
  [prompt]
  (= 0 (JOptionPane/showConfirmDialog nil prompt "User Input (Piano Test)" JOptionPane/YES_NO_OPTION)))

(deftest ^:quick piano-test-2
  (testing "test the piano"
    (println "testing 2 volumes across a few notes")
    (let [notes [40 50 60]
          volumes [0.4 0.8]]
      (dotimes [i (count notes)]
        (dotimes [l (count volumes)]
          (let [cur-level (nth volumes l)
                cur-pitch-idx (nth notes i)
                _ (demo 0.5 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
                _ (inst/sampled-piano :note cur-pitch-idx :level cur-level)
                good-inst (ask-user-tf (format "Playing piano *inst* + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))
                _ (synth/sampled-piano :note cur-pitch-idx :level cur-level)
                good-synth (ask-user-tf (format "Playing piano *synth*\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
            (println cur-pitch-idx cur-level good-inst good-synth)
            (is (and good-inst good-synth))))))))
