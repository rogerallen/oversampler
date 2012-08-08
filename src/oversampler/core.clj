(ns oversampler.core
  (:use [oversampler analysis bank]))

(defn -main
  "Not sure what to do about this..."
  [& args]
  (println "No commandline interface at this point."))

;; ======================================================================
(comment

  (use '[oversampler analysis bank])
  (use 'overtone.live)
  (use 'oversampler.analysis)
  (use 'oversampler.bank)
  
  ;; use this to create the information used by the sampler.
  (print-all-info cello-sample-paths)

  ;; use Incanter graphs to look over one of the samples
  (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")
  (view-sample (nth (nth cello-sample-paths 3) 2))

  ;; play a sample from a file
  (defn play-sample [path samp-start samp-end]
    (let [size (- samp-end samp-start)]
      (sample-player
       (load-sample path :start samp-start :size size))))
  (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)
  
  ;; hear a sample from the loaded examples
  (sample-player (get-cello-sample (note :c3) 1.0) :vol 8)
  (sample-player (get-cello-sample (note :c3) 0.5) :vol 8)
  (sample-player (get-cello-sample (note :c3) 0.3) :vol 8)

  )
