(ns oversampler.cello-test
  (:use clojure.test
        oversampler.cello.inst
        oversampler.cello.bank
        overtone.live))

(import 'javax.swing.JOptionPane)

(defn ask-user-tf
  "return True on yes, False on fail"
  [prompt]
  (= 0 (JOptionPane/showConfirmDialog nil prompt "User Input" JOptionPane/YES_NO_OPTION)))

(deftest cello-test-1
  (testing "test the cello"
    (println "testing 3 volumes across all notes")
    (dotimes [l 3]
      (dotimes [i (inc (- max-index min-index))]
        (let [cur-level (nth [0.25 0.5 0.9] l)
              cur-pitch-idx (+ min-index i)
              _ (demo 4 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
              _ (sampled-cello :note cur-pitch-idx :level cur-level)
              good (ask-user-tf (format "Playing pitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
          (println cur-pitch-idx cur-level good)
          (is good))))))


(deftest cello-test-2
  (testing "test the cello"
    (println "testing 5 volumes across a few notes")
    (dotimes [i 3]
      (dotimes [l 5]
        (let [cur-level (nth [0.2 0.4 0.6 0.8 1.0] l)
              cur-pitch-idx (nth [40 50 60] i)
              _ (demo 4 (pan2 (sin-osc (midicps (+ 12 cur-pitch-idx))) 0.0 cur-level))
              _ (sampled-cello :note cur-pitch-idx :level cur-level)
              good (ask-user-tf (format "Playing pitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
          (println cur-pitch-idx cur-level good)
          (is good))))))


