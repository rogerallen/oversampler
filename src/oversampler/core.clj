(ns oversampler.core
  (:use [overtone.live :only [sample-player load-sample buffer-data buffer-info]]
        [incanter core charts]))

(defn -main
  "Not sure what to do about this..."
  [& args]
  (println "No commandline interface at this point."))

(defn rms
  "root mean square of sequence of floats."
  [xs]
  (Math/sqrt (reduce + (map #(* % %) xs))))

(defn flast
  "like ffirst"
  [xs]
  (nth (last xs) 0))

(defn view-sample
  "view the sample in an incanter line graph"
  [path]
  (let [the-buffer (load-sample path)
        the-samples (buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples (buffer-info the-buffer)) num-parts))
        indexed-rms-per-part (map-indexed
                              vector
                              (map #(rms %) (partition samples-per-part the-samples)))
        rms-dataset (dataset ["t" "rms"] indexed-rms-per-part)]
    (view (area-chart
           (sel rms-dataset :cols 0)
           (sel rms-dataset :cols 1)
           :x-label "Time" :y-label "RMS"))))
;; (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")

(defn find-start-end-samples [path sample-names] ;; threshold? 
  (let [the-buffer (load-sample path)
        the-samples (buffer-data the-buffer)
        sample-rate (:rate (buffer-info the-buffer))
        nsamp (int (/ sample-rate 10)) ;; 10ms divisions
        indexed-rms-10ms (map-indexed vector (map #(rms %) (partition nsamp the-samples)))
        partitioned-rms (filter #(not (zero? (nth (first %) 1)))
                                (partition-by #(zero? (nth % 1)) indexed-rms-10ms))
        start-end-samples (map #(vector (* nsamp (dec (ffirst %)))
                                        (* nsamp (inc (flast %))))
                               partitioned-rms)]
    (map #(apply vector %1 %2) sample-names start-end-samples)))

#_(println (find-start-end-samples
            "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"
            ["A3" "A#3" "B4" "C4" "C#4" "D4" "D#4" "E4" "F4" "F#4" "G4" "G#4"]))

(comment

  ;; ???(require '[overtone.live :as 'o])
  (use '[overtone.live :only [sample-player load-sample buffer-data buffer-info]])
  (use '(incanter core charts))


??  (defn cello-samples
    {:name "A3"
     :file "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"
     :start-sample 1239000
     :end-sample 1079000
     :norm-factor 1.0})
  
  (sample-player
   (load-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"
              :start 1079000 :size (- 1239000 1079000)))
  
  (defn rms
    "root mean square of sequence"
    [xs]
    (Math/sqrt (reduce + (map #(* % %) xs))))
  
  (map #(rms %) (partition 22050 xd))

  (def x (load-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"))
  (def xd (buffer-data x))
  (def xdi (map-indexed vector (map #(rms %) (partition (/ 44100 4) xd))))
  (def xdid (dataset
             ["t" "rms"]
             (map-indexed vector (map #(rms %) (partition (/ 44100 4) xd)))))

  (view (line-chart (sel xdid :cols 0) (sel xdid :cols 1)))

  ;;(def xdidp (partition-by #(zero? %) (map #(rms %) (partition (/ 44100 4) xd))))
  (def xdidp (partition-by #(zero? (nth % 1)) xdi))
  (def xdidpn (filter #(not (zero? (nth (first %) 1))) xdidp))

  (defn view-nth [pds n]
    (let [ds (dataset ["t" "rms"] (nth pds n))]
      (view (line-chart (sel ds :cols 0)
                        (sel ds :cols 1)))))

  (view-nth xdidpn 0)

  (find-start-end-samples
   "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"
   ["A3" "A#3" "B4" "C4" "C#4" "D4" "D#4" "E4" "F4" "F#4" "G4" "G#4"])

  (defn play-sample [path samp-start samp-end]
    (let [size (- samp-end samp-start)]
      (sample-player
       (load-sample path :start samp-start :size size))))

  (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)
  

  )
