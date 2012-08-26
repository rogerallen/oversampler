(ns oversampler.core
  (:use [oversampler analysis]
        [oversampler.cello bank inst]))

(defn -main
  "Not sure what to do about this..."
  [& args]
  (println "No commandline interface at this point."))

;; ======================================================================
(comment

  (use '[oversampler analysis bank inst])
  (use 'overtone.live)
  ;;(use 'oversampler.analysis)
  ;;(use 'oversampler.bank)
  
  ;; use this to create the information used by the sampler.
  (print-sample-file-info cello-sample-paths)

  ;; use Incanter graphs to look over one of the samples
  (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")
  (view-sample (nth (nth cello-sample-paths 3) 2))
  (view-sample-info (get-cello-sample-info (note :c2) *cello-ff*))

  ;; play a sample from a file
  (defn play-sample [path samp-start samp-end]
    (let [size (- samp-end samp-start)]
      (sample-player
       (load-sample path :start samp-start :size size))))
  (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)
  
  ;; hear a sample from the loaded examples
  (sample-player (get-cello-sample (note :c3) *cello-ff*) :vol 1.0)
  (sample-player (get-cello-sample (note :c3) *cello-mf*) :vol 1.0)
  (sample-player (get-cello-sample (note :c3) *cello-pp*) :vol 1.0)

  ;; use the instrument
  (do
    (sampled-cello :note (note :c3) :level 0.5)
    (sampled-cello :note (note :e3) :level 0.5)
    (sampled-cello :note (note :g3) :level 0.5))

  ;; play song
  (def m (metronome 60))
  (defn song [m the-inst level]
    (let [notes [:b3 :a3 :g3 :a3
                 :b3 :b3 :b3 :b3
                 :a3 :a3 :a3 :a3
                 :b3 :d4 :d4 :d4
                 :b3 :a3 :g3 :a3
                 :b3 :b3 :b3 :b3
                 :a3 :a3 :b3 :a3
                 :g3 :g3 :g3 :g3]
          _ (metro-start m 0)] 
      (dotimes [i (count notes)]
        (let [nx (at (m i) (the-inst :note (note (notes i)) :level level))]
          (at (m (+ i 0.75)) (ctl nx :gate 0))))))
  (song m sampled-cello 0.5)
  
  )
