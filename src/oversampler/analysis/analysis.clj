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

;; to not overload incanter graphs, reduce # samples
(def NUM-GRAPH-POINTS 500) 

(defn rms
  "root mean square of sequence of floats."
  ^double [^doubles xs]
  (Math/sqrt (reduce + (map #(* % %) xs))))

;; adding the ^double takes this from 18s -> 4s on one view-sample (W00t!)
;; continual use seemed to drop this down to < 2s.
;; tried a custom version to get rid of wrapping map-indexed & got nothing
(defn abss
  "max absolute value of sequence of doubles."
  ^double [^doubles xs] ;; tried using only ^doubles here...no speedup.
  (reduce (fn [^double x ^double y] (max (Math/abs x) (Math/abs y))) xs))

;; disappointing that I have to in-line the abss function.  runs out of memory otherwise
;; dBs is definitely the right way to look at things, though.  it really separates out
;; the silence from the signal.
(defn dbss
  "max db sequence of doubles. 20*log10(max(x))"
  ^double [^doubles xs]
  (* 20.0 (Math/log10 (reduce (fn [^double x ^double y] (max (Math/abs x) (Math/abs y))) xs))))

(defn flast
  "like ffirst"
  [xs]
  (nth (last xs) 0))

;; this leak-dc fix cleans up the sample really nicely & cost almost nothing
;; https://github.com/supercollider/supercollider/blob/master/server/plugins/FilterUGens.cpp#L1543
(defn leak-dc-samples
  [^doubles xsa]
  (let [k 0.95]
    (dotimes [i0 (dec (dec (count xsa)))] ;; leaves 1st & last sample alone.  FIXME?
      (let [i1 (inc i0)
            i2 (inc i1)
            x0 ^double (aget xsa i0)
            x1 ^double (aget xsa i1)
            x2 ^double (aget xsa i2)
            y (+ (* 0.95 x0) (- x2 x1))]
        (aset xsa i1 y)))
    xsa))

;; FIXME -- add version with start/end sample for 'zooming'
;; FIXME -- add way to overlay samples?
(defn view-sample-buffer
  [the-buffer]
  (let [_ (println "applying leak-dc to samples...")
        the-samples (leak-dc-samples (double-array (o/buffer-data the-buffer)))
        num-samples (count the-samples)
        samples-per-point (int (/ num-samples NUM-GRAPH-POINTS))
        _ (println "reducing" num-samples "samples to" NUM-GRAPH-POINTS
                   "points (" samples-per-point "samples/point)")
        fn dbss ;; dbss ;; rms ;; abss
        fn-name "dB" ;; "dB" ;;"rms" ;; "abs"
        ;;indexed-fn-per-point (map-indexed vector (map fn (partition samples-per-point the-samples)))
        fn-dataset (ico/dataset ["t" fn-name] (map-indexed vector (map fn (partition samples-per-point the-samples))))
        ;;_ (println (take 50 (ico/sel fn-dataset :cols 1)))
        ]
    (let [the-plot (ich/xy-plot
                    (ico/sel fn-dataset :cols 0)
                    (ico/sel fn-dataset :cols 1)
                    :x-label "reduced samples"
                    :y-label fn-name)]
      (ich/set-y-range the-plot -80 0) ;; for dB chart
      ;;(ich/add-lines (ico/sel max-dataset :cols 0) (ico/sel max-dataset :cols 1))
      (ico/view the-plot)
      the-plot)))
(defn view-sample-file
  "load the sample & view the sample in an incanter line graph"
  [path]
  (view-sample-buffer (o/load-sample path)))
;; (def s1 (o/load-sample "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"))
;; (def g1 (view-sample-buffer s1))
;; (ich/add-lines g1 [0 500] [-31 -31])


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
   return a [start-sample end-sample] tuple for each region of active sound.  The
   threshold is in dB so it will be a negative number."
  [path threshold]
  (let [the-buffer (o/load-sample path)
        _ (println "applying leak-dc to samples...")
        the-samples (leak-dc-samples (double-array (o/buffer-data the-buffer)))
        sample-rate (:rate (o/buffer-info the-buffer))
        nsamp (int (/ sample-rate 10)) ;; 10ms divisions
        indexed-dB-10ms (map-indexed vector (map dbss (partition nsamp the-samples)))
        partitioned-dB (filter #(>= (nth (first %) 1) threshold)
                                (partition-by #(< (nth % 1) threshold) indexed-dB-10ms))
        start-end-samples (map #(vector (* nsamp (dec (ffirst %)))
                                        (* nsamp (inc (flast %))))
                               partitioned-dB)]
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

;; this is the goal of analysis, printing out this information for use by the
;; instrument's sample-bank.  You run this when the samples have not been uploaded
;; to freesound.
;;
;; The paths parameter is a vector of vectors describing the sample files
;;  (print-sample-file-info
;;   [ [ (note :e2) :mf -31 "./src/oversampler/samples/Guitar.mf.sulE.E2B2.aif"]
;;     [ (note :c3) :mf -31 "./src/oversampler/samples/Guitar.mf.sulE.C3B3.aif"] ])
;;
(defn print-sample-file-info [paths]
  (doseq [[start-idx cur-vol cur-thresh cur-path] paths]
    (let [ses (find-start-end-ppeak-samples cur-path)]
      (println (format ";; %d samples starting at %d. %s" (count ses) start-idx cur-path))
      (dotimes [i (count ses)]
        (let [[st en pk] (nth ses i)
              cur-idx (+ start-idx i)]
          (println (format "{:index %3d :volume %5.2f :start %8d :end %8d :ppeak %6.4f :path \"%s\" :rate 1.000}"
                           cur-idx cur-vol st en pk cur-path)))))))
(comment
  (print-sample-file-info
   [ [ (note :e2) :mf -31 12 "./src/oversampler/samples/Guitar.mf.sulE.E2B2.aif"]
     [ (note :c3) :mf -31 12 "./src/oversampler/samples/Guitar.mf.sulE.C3B3.aif"] ])
 )

;; ======================================================================
;; mem debug stuff I found on the web
(defn- as-megabytes
  "Given a sequence of byte amounts, return megabyte amounts
   as string, with an M suffix."
  [memory]
  (map #(str (int (/ % 1024 1024)) "M") memory))

(defn- as-percentage
  "Given a pair of values, return the percentage as a string."
  [[a b]]
  (str (int (* 100 (/ a b))) "%"))

(defn- memory-bean
  "Return the MemoryMXBean."
  []
  (java.lang.management.ManagementFactory/getMemoryMXBean))

(defn- heap-usage
  "Given a MemoryMXBean, return the heap memory usage."
  [^java.lang.management.MemoryMXBean bean]
  (.getHeapMemoryUsage bean))

(defn- heap-used-max
  "Given heap memory usage, return a pair of used/max values."
  [^java.lang.management.MemoryUsage usage]
  [(.getUsed usage) (.getMax usage)])

(defn memory-usage
  "Return percentage, used, max heap as strings."
  []
  (let [used-max (-> (memory-bean) (heap-usage) (heap-used-max))]
    (cons (as-percentage used-max)
          (as-megabytes used-max))))

;; ======================================================================


(comment

  (use 'oversampler.analysis)
  (ns oversampler.analysis)
  
  (def s1 (o/load-sample "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"))
  (view-sample-buffer s1)
   
  )
