;;
;; code for the analysis of raw input files for the purpose of creating meta information to use when
;; partitioning the raw input into sound banks and controlling the playback of the information.
;;
;; the code is a bit "ad hoc" at the moment since I've only worked on one set of samples.
;;
;; goal of this code is to use this to create the information used by the sampler.
;; (print-sample-file-info cello-sample-paths)
;; then take that output & use it in cello/bank.clj
;; hopefully this will also work for other instruments & not just the cello.
;;
(ns oversampler.analysis
  (:require [overtone.live :as o]
            [incanter.core :as ico]
            [incanter.charts :as ich]
            [oversampler.utils :as osu]))

(defn rms
  "root mean square of sequence of floats."
  [xs]
  (Math/sqrt (reduce + (map #(* % %) xs))))

(defn abss
  "root mean square of sequence of floats."
  [xs]
  (reduce max (map #(Math/abs %) xs)))

(defn flast
  "like ffirst"
  [xs]
  (nth (last xs) 0))

;; hmm, wonder if Incanter has rms-type algorithms I can use. (didn't find any)
;; after review.  min/max is better than rms for viewing.
;; FIXME -- add version with start/end sample for 'zooming'
;; FIXME -- add way to overlay samples?
(defn view-sample
  "view the sample in an incanter line graph"
  [path]
  (let [the-buffer (o/load-sample path)
        the-samples (o/buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples
                                  (o/buffer-info the-buffer)) num-parts))
        indexed-abs-per-part (map-indexed vector (map abss (partition samples-per-part the-samples)))
        ;;indexed-rms-per-part (map-indexed vector (map rms (partition samples-per-part the-samples)))
        ;;indexed-min-per-part (map-indexed vector
        ;;                                  (map #(* 10 (apply min %)) (partition samples-per-part the-samples)))
        ;;indexed-max-per-part (map-indexed vector
        ;;                                  (map #(* 10 (apply max %)) (partition samples-per-part the-samples)))
        abs-dataset (ico/dataset ["t" "rms"] indexed-abs-per-part)]
        ;;rms-dataset (ico/dataset ["t" "rms"] indexed-rms-per-part)
        ;;min-dataset (ico/dataset ["t" "rms"] indexed-min-per-part)
        ;;max-dataset (ico/dataset ["t" "rms"] indexed-max-per-part)]
    (doto (ich/xy-plot
           ;;(ico/sel rms-dataset :cols 0) (ico/sel rms-dataset :cols 1)
           (ico/sel abs-dataset :cols 0) (ico/sel abs-dataset :cols 1)
           :x-label "samples" :y-label "amp")
      ;;(ich/add-lines (ico/sel max-dataset :cols 0) (ico/sel max-dataset :cols 1))
      ico/view)
    ))
;; (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")

;; Grr...out of memory when trying to view the whole thing. Why? 
(defn view-sample-histogram
  "view the histogram of a sample"
  [path]
  (let [the-buffer (o/load-sample path)
        the-samples (o/buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples
                                  (o/buffer-info the-buffer)) num-parts))
        abs-per-part (map abss (partition samples-per-part the-samples))
        ;the-dataset (ico/dataset ["abs"] (map 'Math/abs the-samples))]
        the-dataset (ico/dataset ["x"] abs-per-part)]
    (doto (ich/histogram (ico/sel the-dataset :col 0) :nbins 20)
      (ico/view))))

;; (require '[oversampler.utils :as osu])
(defn get-sample-norm-cum-histogram
  "do the histogram of a sample"
  [path]
  (let [the-buffer (o/load-sample path)
        the-samples (o/buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples
                                  (o/buffer-info the-buffer)) num-parts))
        abs-per-part (map abss (partition samples-per-part the-samples))
        maxv (reduce max abs-per-part)
        the-histo (osu/histogram abs-per-part (osu/bin-list 0.0 maxv 20))
        the-cum-histo (osu/cum-histogram the-histo)
        norm-cum-histo (osu/norm-cum-histogram the-cum-histo)]
    norm-cum-histo))

(defn view-sample-info
  "view the sample in an incanter line graph.  returns the plot so you can add more lines"
  [sample-info]
  (let [the-buffer (:sample sample-info)
        the-samples (o/buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples
                                  (o/buffer-info the-buffer)) num-parts))
        indexed-min-per-part (map-indexed vector
                                          (map #(* 10 (apply min %)) (partition samples-per-part the-samples)))
        indexed-max-per-part (map-indexed vector
                                          (map #(* 10 (apply max %)) (partition samples-per-part the-samples)))
        min-dataset (ico/dataset ["t" "rms"] indexed-min-per-part)
        max-dataset (ico/dataset ["t" "rms"] indexed-max-per-part)
        the-plot (ich/xy-plot
                  (ico/sel min-dataset :cols 0) (ico/sel min-dataset :cols 1)
                  :x-label "samples" :y-label "amp")
        ]
      (ich/add-lines the-plot (ico/sel max-dataset :cols 0) (ico/sel max-dataset :cols 1))
      (ico/view the-plot)
      the-plot
    ))

(defn add-sample-info
  "add the sample to the-plot"
  [the-plot sample-info]
  (let [the-buffer (:sample sample-info)
        the-samples (o/buffer-data the-buffer)
        num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (:n-samples
                                  (o/buffer-info the-buffer)) num-parts))
        indexed-min-per-part (map-indexed vector
                                          (map #(* 10 (apply min %)) (partition samples-per-part the-samples)))
        indexed-max-per-part (map-indexed vector
                                          (map #(* 10 (apply max %)) (partition samples-per-part the-samples)))
        min-dataset (ico/dataset ["t" "rms"] indexed-min-per-part)
        max-dataset (ico/dataset ["t" "rms"] indexed-max-per-part)
        ]
      (ich/add-lines the-plot (ico/sel min-dataset :cols 0) (ico/sel min-dataset :cols 1))
      (ich/add-lines the-plot (ico/sel max-dataset :cols 0) (ico/sel max-dataset :cols 1))
      the-plot
    ))

;; using the zeros between notes, divide up the samples into single notes
(defn find-start-end-zeros
  "given a path to a set of samples, divide the samples up into regions of sound.
   return a [start-sample end-sample] tuple for each region of active sound"
  [path]
  (let [the-buffer (o/load-sample path)
        the-samples (o/buffer-data the-buffer)
        sample-rate (:rate (o/buffer-info the-buffer))
        nsamp (int (/ sample-rate 10)) ;; 10ms divisions
        indexed-rms-10ms (map-indexed vector (map rms (partition nsamp the-samples)))
        partitioned-rms (filter #(not (zero? (nth (first %) 1)))
                                (partition-by #(zero? (nth % 1)) indexed-rms-10ms))
        start-end-samples (map #(vector (* nsamp (dec (ffirst %)))
                                        (* nsamp (inc (flast %))))
                               partitioned-rms)]
    (vector start-end-samples the-buffer)))

;; (ico/view
;;   (ich/histogram
;;     (ico/sel (ico/dataset ["x"] [1 2 3 4 5 1 2 4]) :col 0) :nbins 100))

;; (require '[oversampler.utils :as osu])
(defn get-percentile-value
  "do the histogram of a sample, normalize it and return the peak
  value that is below the percentile"
  [the-samples percentile]
  (let [num-parts 500 ; to not overload incanter
        samples-per-part (int (/ (count the-samples) num-parts))
        abs-per-part (map abss (partition samples-per-part the-samples))
        maxv (reduce max abs-per-part)
        the-histo (osu/histogram abs-per-part (osu/bin-list 0.0 maxv 20))
        the-cum-histo (osu/cum-histogram the-histo)
        norm-cum-histo (osu/norm-cum-histogram the-cum-histo)]
    (first (last (take-while #(< (second %) percentile) norm-cum-histo)))))

(defn refine-start-end
  "given some known start/end zero points, refine the sound selection
  by finding the histogram of the values and some high percentile peak
  value to use for both scaling the output and finding the midpoint to
  start the sound.  Adjust the sound to start 2*10ms before that
  midpoint.  Return a tuple of start/end/peak-pctile-value"
  [the-buffer start-sample end-sample pctile path]
  (let [;;the-buffer (o/load-sample path)
        the-samples (take (- end-sample start-sample)
                          (drop (dec start-sample) (o/buffer-data the-buffer)))
        ;;_ (println "count samp" (count the-samples))
        sample-rate (:rate (o/buffer-info the-buffer))
        nsamp (int (/ sample-rate 10)) ;; 10ms divisions
        indexed-abs-10ms (map-indexed vector (map abss (partition nsamp the-samples)))
        max-abs (reduce max (map second indexed-abs-10ms))
        ;;_ (println "mabs" max-abs)
        pctile-peak-val (get-percentile-value the-samples pctile)
        ;;_ (println "90%abs" pctile-peak-val)
        first-midpoint-index (ffirst (drop-while #(< (second %) (* 0.5 pctile-peak-val)) indexed-abs-10ms))
        ;;_ (println "fmi" first-midpoint-index)
        start-offset (* (max 0 (- first-midpoint-index 2)) nsamp)
        end-offset 0 ;; not adjusting the end, yet.
        ]
    (vector (+ start-sample start-offset)
            (- end-sample end-offset)
            pctile-peak-val)))

(defn find-start-end-ppeak-samples
  "given a path to a set of samples, divide the samples up into
   regions of sound that have a synchronized starting point.  Also
   return the 90th percentile peak abs value of the sound."
  [path]
  (let [[start-end-sample-map the-buffer] (find-start-end-zeros path)]
    (for [[sample-start sample-end] start-end-sample-map]
      (do
        ;;(println "SE" sample-start sample-end) (flush)
        (refine-start-end the-buffer sample-start sample-end 0.90 path)
        ))))

(defn print-sample-file-info [paths]
  (doseq [[cur-idx cur-vol cur-path] paths]
    (let [ses (find-start-end-ppeak-samples cur-path)]
      (println (format ";; %d samples starting at %d. %s" (count ses) cur-idx cur-path))
      (dotimes [i (count ses)]
        (let [[st en pk] (nth ses i)
              idx (+ cur-idx i)]
          (println (format "{:index %3d :volume %5.2f :start %8d :end %8d :ppeak %6.4f :path \"%s\"}"
                           idx cur-vol st en pk cur-path)))))))

;; ======================================================================
(comment

  (require '[overtone.live :as o]
           '[incanter.core :as ico]
           '[incanter.charts :as ich]
           '[oversampler.utils :as osu])

  )
