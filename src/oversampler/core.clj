(ns oversampler.core
  (:use
   ;; When doing analysis, uncomment the Incanter library in project.clj and the analysis use line below.
   ;; When deploying, comment this out.  See project.clj for more info.
   ;;[oversampler analysis]
   [oversampler.cello.inst])
  (:require [oversampler.cello.raw :as cello.raw]
            [oversampler.cello.bank :as cello.bank]))

(defn -main
  "Not sure what to do about this..."
  [& args]
  (println "No commandline interface at this point."))

;; ======================================================================
(comment

  (use 'overtone.live)
  (use 'oversampler analysis) ;; !!! see above !!!
  (use 'oversampler.cello.inst)

  (require '[oversampler.cello.raw :as cello.raw])
  (require '[oversampler.cello.bank :as cello.bank])
  
  ;; ============================================================
  ;; do analysis on the raw sound files
  
  ;; use this to create the information used by the sampler.
  (print-sample-file-info cello.raw/sample-paths)

  ;; use Incanter graphs to look over one of the samples
  (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")
  (view-sample (nth (nth cello.raw/sample-paths 3) 2))

  ;; play a sample from a file
  (defn play-sample [path samp-start samp-end]
    (let [size (- samp-end samp-start)]
      (sample-player
       (load-sample path :start samp-start :size size))))
  (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)
  
  ;; ============================================================
  ;; do analysis on the sampled notes stored in the sample bank
  
  (view-sample-info (cello.bank/get-sample-info (note :c2) cello.raw/ff))

  ;; hear a sample from the loaded examples
  (sample-player (cello.bank/get-sample (note :c3) cello.raw/ff) :vol 1.0)
  (sample-player (cello.bank/get-sample (note :c3) cello.raw/mf) :vol 1.0)
  (sample-player (cello.bank/get-sample (note :c3) cello.raw/pp) :vol 1.0)

  ;; ============================================================
  ;; use the instrument
  (do
    (sampled-cello :note (note :c3) :level 0.5)
    (sampled-cello :note (note :e3) :level 0.5)
    (sampled-cello :note (note :g3) :level 0.5))

  ;; play a song
  (defn play-song [the-inst level m notes]
    (dotimes [i (count notes)]
      (let [nx (at (m i) (the-inst :note (note (notes i)) :level level))]
        (at (m (+ i 0.75)) (ctl nx :gate 0)))))

  ;; some songs...
  (defn mary [the-inst level]
    (let [m (metronome 72)
          notes [:b2 :a2 :g2 :a2
                 :b2 :b2 :b2 :b2
                 :a2 :a2 :a2 :a2
                 :b2 :d3 :d3 :d3
                 :b2 :a2 :g2 :a2
                 :b2 :b2 :b2 :b2
                 :a2 :a2 :b2 :a2
                 :g2 :g2 :g2 :g2]]
      (play-song the-inst level m notes)))

  (mary sampled-cello 0.5)
  
  (defn full-scale [the-inst level]
    (let [m (metronome 180)
          notes [:c2 :c#2 :d2 :d#2 :e2 :f2 :f#2 :g2 :g#2 :a2 :a#2 :b2
                 :c3 :c#3 :d3 :d#3 :e3 :f3 :f#3 :g3 :g#3 :a3 :a#3 :b3
                 :c4 :c#4 :d4 :d#4 :e4 :f4 :f#4 :g4 :g#4 :a4 :a#4 :b4
                 :c5 :c#5 :d5 :d#5 :e5 :f5 :f#5 :g5 :g#5 :a5 :a#5 :b5
                 ]]
      (play-song the-inst level m notes)))

  (full-scale sampled-cello 0.5)
  
  (defn c-scale [the-inst level]
    (let [m (metronome 180)
          notes [:c2 :d2 :e2 :f2 :g2 :a2 :b2]]
      (play-song the-inst level m notes)))

  (defn bach-pre-1 [the-inst level]
    (let [m (metronome 240)
          notes [:g2 :d3  :b3 :a3 :b3 :d3  :b3 :d3
                 :g2 :d3  :b3 :a3 :b3 :d3  :b3 :d3
                 :g2 :e3  :c4 :b3 :c4 :e3  :c4 :e3
                 :g2 :e3  :c4 :b3 :c4 :e3  :c4 :e3
                 :g2 :f#3 :c4 :b3 :c4 :f#3 :c4 :f#3
                 :g2 :f#3 :c4 :b3 :c4 :f#3 :c4 :f#3
                 ]]
      (play-song the-inst level m notes)))

  (bach-pre-1 sampled-cello 0.5)

  ;; ============================================================
  ;; test to get levels right
  (defn test-levels [the-level]
    (demo 1 (* the-level (sin-osc [440 440])))
    (Thread/sleep 1000)
    (c-scale sampled-cello the-level)
    (Thread/sleep 3000))

  (defn record-testing []
    (recording-start "~/cello-test.wav")
    (demo 1 (* 1.0 (sin-osc [440 440])))
    (Thread/sleep 1000)
    (demo 1 (* 0.5 (sin-osc [440 440])))
    (Thread/sleep 1000)
    (demo 1 (* 0.25 (sin-osc [440 440])))
    (Thread/sleep 1000)
    (test-levels 0.8)
    (test-levels 0.4)
    (test-levels 0.2)
    (recording-stop)
    )

  (record-testing)

  ;; ======================================================================
  ;; getting things in tune

  (Math/pow 2 (/ 2 12)) ; 1.122462048309373
  ;; these are consonant
  (sampled-cello :note (note :c3) :level 0.5 :rate 1.1225)
  (sampled-cello :note (note :d3) :level 0.5)

  (defn check-note [n l r]
    (sampled-cello :note n :level l :rate r)
    (demo 4 (pan2 (sin-osc (midicps n)))))
  
  ;; ======================================================================
  ;; notes on looping
  ;; ff.C2 file
  ;; find spot near 3.5s (154,317) & 4.0s (176,500) to loop
  ;; [154393, 176349]
  ;; no good just picking arbitrary points like that.  need to find
  ;; areas that sound right.
  ;; try near 169845 and 189737 Z [169924 189704]
  ;;

  )
