(ns oversampler.analysis
  (:require [overtone.live :as o]
            [incanter.core :as ico]
            [incanter.charts :as ich]))

(defn rms
  "root mean square of sequence of floats."
  [xs]
  (Math/sqrt (reduce + (map #(* % %) xs))))

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
        ;;indexed-rms-per-part (map-indexed vector (map rms (partition samples-per-part the-samples)))
        indexed-min-per-part (map-indexed vector
                                          (map #(* 10 (apply min %)) (partition samples-per-part the-samples)))
        indexed-max-per-part (map-indexed vector
                                          (map #(* 10 (apply max %)) (partition samples-per-part the-samples)))
        ;;rms-dataset (ico/dataset ["t" "rms"] indexed-rms-per-part)
        min-dataset (ico/dataset ["t" "rms"] indexed-min-per-part)
        max-dataset (ico/dataset ["t" "rms"] indexed-max-per-part)]
    (doto (ich/xy-plot
           ;;(ico/sel rms-dataset :cols 0) (ico/sel rms-dataset :cols 1)
           (ico/sel min-dataset :cols 0) (ico/sel min-dataset :cols 1)
           :x-label "samples" :y-label "amp")
      (ich/add-lines (ico/sel max-dataset :cols 0) (ico/sel max-dataset :cols 1))
      ico/view)
    ))
;; (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")

;; using the zeros between notes, divide up the samples into single notes
(defn find-start-end-samples [path] ;; threshold? 
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
    start-end-samples))

;; NB download http://theremin.music.uiowa.edu/MIScello2012.html Cello.arco.mono.1644.1.zip
;;    and unzip into samples.
;; TBD upload to freesound.
;;
;; 2222222 3333333 4444444 5555555
;; cdefgab cdefgab cdefgab cdefgab
;;              aa aaaaaaa aaaaaa
;;          dddddd ddddddd dd
;;     ggg ggggggg ggggg
;; ccccccc ccccccc c
(def cello-sample-paths
  ;; tuple of starting-index, volume(ish), and path(FIXME freesound id)
  [[ (o/note :a3) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"]
   [ (o/note :c2) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"]
   [ (o/note :c3) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"] ;; broken name?
   [ (o/note :d3) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"]
   [ (o/note :g2) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) 1.0 "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"]
   
   [ (o/note :a3) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"]
   [ (o/note :c2) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"]
   [ (o/note :c3) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"]
   [ (o/note :d3) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"]
   [ (o/note :g2) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) 0.5 "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"]

   [ (o/note :a3) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"]
   [ (o/note :c2) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"]
   [ (o/note :c3) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"]
   [ (o/note :d3) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"]
   [ (o/note :g2) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) 0.3 "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"]])

(defn print-all-info [paths]
  (doseq [[cur-idx cur-vol cur-path] paths]
    (let [ses (find-start-end-samples cur-path)]
      ;;(println (count ses) cur-idx cur-path)
      (dotimes [i (count ses)]
        (let [[st en] (nth ses i)
              idx (+ cur-idx i)]
          (println (format "{:index %3d :volume %5.2f :start %8d :end %8d :path \"%s\"}"
                           idx cur-vol st en cur-path)))))))

;; use this to create the information used by the sampler.
;; (print-all-info cello-sample-paths)

;; ======================================================================
(comment

  (require '[overtone.live :as o]
           '[incanter.core :as ico]
           '[incanter.charts :as ich])

  (defn play-sample [path samp-start samp-end]
    (let [size (- samp-end samp-start)]
      (sample-player
       (load-sample path :start samp-start :size size))))
  
  (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)

  )
