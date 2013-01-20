(ns oversampler.piano-test
  (:use clojure.test
        oversampler.piano.inst
        oversampler.piano.bank
        overtone.live))

(println "Setup test piano samples...")
(time (sampled-piano-init :pp-volume-cutoff 0.30 :mf-volume-cutoff 0.85))
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
                _ (sampled-piano :note cur-pitch-idx :level cur-level)
                good (ask-user-tf (format "Playing piano sample + comparison sin-osc\npitch: %d level:%.2f...\nDoes it sound good?" cur-pitch-idx cur-level))]
            (println cur-pitch-idx cur-level good)
            (is good)))))))
  

