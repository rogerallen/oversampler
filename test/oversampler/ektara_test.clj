(ns oversampler.ektara-test
  (:use clojure.test
        overtone.live)
  (:require [oversampler.ektara.inst :as inst]
            [oversampler.ektara.synth :as synth]
            [oversampler.ektara.bank :as bank]))

(import 'javax.swing.JOptionPane)

(defn ask-user-tf
  "return True on yes, False on fail"
  [prompt]
  (= 0 (JOptionPane/showConfirmDialog nil prompt "User Input (Ektara Test)" JOptionPane/YES_NO_OPTION)))

(deftest ^:ektara ektara-test-1
  (testing "test the ektara"
    (println "testing 2 volumes across all notes")
    (dotimes [l 3]
      (dotimes [i (inc (- bank/max-index bank/min-index))]
        (let [cur-level (nth [0.5 0.9] l)
              cur-pitch-idx (+ bank/min-index i)
              _ (demo 4 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
              _ (inst/sampled-ektara :note cur-pitch-idx :level cur-level)
              good (ask-user-tf (format "Playing ektara sample + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
          (println cur-pitch-idx cur-level good)
          (is good))))))

(deftest ^:quick ektara-test-2
  (testing "test the ektara"
    (println "testing 2 volumes across a few notes")
    (let [notes [40 50 60]
          volumes [0.5 0.9]]
      (dotimes [i (count notes)]
        (dotimes [l (count volumes)]
          (let [cur-level (nth volumes l)
                cur-pitch-idx (nth notes i)
                _ (demo 0.5 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
                _ (inst/sampled-ektara :note cur-pitch-idx :level cur-level)
                good-inst (ask-user-tf (format "Playing ektara *inst* + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))
                _ (synth/sampled-ektara :note cur-pitch-idx :level cur-level)
                good-synth (ask-user-tf (format "Playing ektara *synth*\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))
                ]
            (println cur-pitch-idx cur-level good-inst good-synth)
            (is (and good-inst good-synth))))))))
  

