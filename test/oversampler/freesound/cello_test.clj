(ns oversampler.freesound.cello-test
  (:use clojure.test
        overtone.live)
  (:require [oversampler.freesound.cello.inst :as inst]
            [oversampler.freesound.cello.synth :as synth]
            [oversampler.freesound.cello.bank :as bank]))

(println "Setup test cello samples...")
(time (inst/sampled-cello-init :pp-volume-cutoff 0.30 :mf-volume-cutoff 0.85))
(println "done.")

(import 'javax.swing.JOptionPane)

(defn ask-user-tf
  "return True on yes, False on fail"
  [prompt]
  (= 0 (JOptionPane/showConfirmDialog nil prompt "User Input (Cello Test)" JOptionPane/YES_NO_OPTION)))

;; FYI - after leak-dc added, only 62, 63 and 67 fail "TOO LOUD!!" when played alone
;; a few more fail when played with sin-osc at the same time.

(deftest ^:cello cello-test-1
  (testing "test the cello"
    (println "testing 3 volumes across all notes")
    (dotimes [l 3]
      (dotimes [i (inc (- bank/max-index bank/min-index))]
        (let [cur-level (nth [0.25 0.5 0.9] l)
              cur-pitch-idx (+ bank/min-index i)
              _ (demo 4 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
              _ (inst/sampled-cello :note cur-pitch-idx :level cur-level)
              good (ask-user-tf (format "Playing cello sample + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
          (println cur-pitch-idx cur-level good)
          (is good))))))

(deftest ^:quick cello-test-2
  (testing "test the cello"
    (println "testing 2 volumes across a few notes")
    (let [notes [40 50 60]
          volumes [0.4 0.8]]
      (dotimes [i (count notes)]
        (dotimes [l (count volumes)]
          (let [cur-level (nth volumes l)
                cur-pitch-idx (nth notes i)
                _ (demo 0.5 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
                _ (inst/sampled-cello :note cur-pitch-idx :level cur-level)
                good-inst (ask-user-tf (format "Playing cello *inst* + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))
                _ (synth/sampled-cello :note cur-pitch-idx :level cur-level)
                good-synth (ask-user-tf (format "Playing cello *synth*\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))
                ]
            (println cur-pitch-idx cur-level good-inst good-synth)
            (is (and good-inst good-synth))))))))
