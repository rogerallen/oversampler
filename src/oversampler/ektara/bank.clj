;;
;; code describing the sample bank containing the per-note samples.
;;
(ns oversampler.ektara.bank
  ;;(:use [oversampler.utils])
  (:require [overtone.live :as o]))

(def freesound-ids
  {"Guitar.ff.sul_E.E4B4.aif" :TBD
   "Guitar.ff.sulB.C4B4.aif" :TBD
   "Guitar.ff.sulB.B3.aif" :TBD
   "Guitar.ff.sulG.G3B3.aif" :TBD
   "Guitar.ff.sulD.D3B3.aif" :TBD
   "Guitar.ff.sulA.C3B3.aif" :TBD
   "Guitar.ff.sulA.A2B2.aif" :TBD
   "Guitar.ff.sulE.E2B2.aif" :TBD
   })

(defn- find-sample-path
  "given a string key in the freesound-ids map, respond with the path to that file"
  [s]
  (o/freesound-path (freesound-ids s)))

(def sample-info-list
  ;; just kept a single note pluck over each string
  [
   ;; 8 samples starting at 64. ./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif
   {:index  71 :volume :ff :start  2196180 :end  2271150 :peak 0.3560 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  70 :volume :ff :start  1913940 :end  2002140 :peak 0.3560 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  69 :volume :ff :start  1574370 :end  1627290 :peak 0.3560 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  68 :volume :ff :start  1278900 :end  1349460 :peak 0.3560 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  67 :volume :ff :start   926100 :end  1001070 :peak 0.2614 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  66 :volume :ff :start   608580 :end   696780 :peak 0.1984 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  65 :volume :ff :start   291060 :end   366030 :peak 0.3504 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   {:index  64 :volume :ff :start        0 :end    74970 :peak 0.1842 :path "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif" :rate 1.000}
   ;; 12 samples starting at 60. ./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif
   {:index  63 :volume :ff :start   908460 :end   979020 :peak 0.1565 :path "./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif" :rate 1.000}
   {:index  62 :volume :ff :start   612990 :end   692370 :peak 0.1331 :path "./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif" :rate 1.000}
   {:index  61 :volume :ff :start   335160 :end   414540 :peak 0.1828 :path "./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif" :rate 1.000}
   {:index  60 :volume :ff :start        0 :end    97020 :peak 0.1796 :path "./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif" :rate 1.000}
   ;; 1 samples starting at 59. ./src/oversampler/samples/Guitar.ff.sulB.B3.aif
   {:index  59 :volume :ff :start        0 :end    92610 :peak 0.2688 :path "./src/oversampler/samples/Guitar.ff.sulB.B3.aif" :rate 1.000}
   ;; 5 samples starting at 55. ./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif
   {:index  58 :volume :ff :start  1089270 :end  1146600 :peak 0.2086 :path "./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif" :rate 1.000}
   {:index  57 :volume :ff :start   758520 :end   807030 :peak 0.2438 :path "./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif" :rate 1.000}
   {:index  56 :volume :ff :start   405720 :end   480690 :peak 0.2438 :path "./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif" :rate 1.000}
   {:index  55 :volume :ff :start        0 :end   119070 :peak 0.1384 :path "./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif" :rate 1.000}
   ;; 12 samples starting at 50. ./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif
   {:index  54 :volume :ff :start  2165310 :end  2332890 :peak 0.2472 :path "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif" :rate 1.000}
   {:index  53 :volume :ff :start  1578780 :end  1759590 :peak 0.1255 :path "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif" :rate 1.000}
   {:index  52 :volume :ff :start   877590 :end  1053990 :peak 0.0688 :path "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif" :rate 1.000}
   {:index  51 :volume :ff :start   877590 :end  1053990 :peak 0.0737 :path "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif" :rate 1.000}
   {:index  50 :volume :ff :start        0 :end   242550 :peak 0.0736 :path "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif" :rate 1.000}
   ;; 12 samples starting at 48. ./src/oversampler/samples/Guitar.ff.sulA.C3B3.aif
   {:index  49 :volume :ff :start   621810 :end   710010 :peak 0.0799 :path "./src/oversampler/samples/Guitar.ff.sulA.C3B3.aif" :rate 1.000}
   {:index  48 :volume :ff :start        0 :end    83790 :peak 0.0181 :path "./src/oversampler/samples/Guitar.ff.sulA.C3B3.aif" :rate 1.000}
   ;; 3 samples starting at 45. ./src/oversampler/samples/Guitar.ff.sulA.A2B2.aif
   {:index  47 :volume :ff :start  1186290 :end  1336230 :peak 0.1176 :path "./src/oversampler/samples/Guitar.ff.sulA.A2B2.aif" :rate 1.000}
   {:index  46 :volume :ff :start   714420 :end   767340 :peak 0.1517 :path "./src/oversampler/samples/Guitar.ff.sulA.A2B2.aif" :rate 1.000}
   {:index  45 :volume :ff :start        0 :end    61740 :peak 0.1397 :path "./src/oversampler/samples/Guitar.ff.sulA.A2B2.aif" :rate 1.000}
   ;; 9 samples starting at 40. ./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif
   {:index  44 :volume :ff :start  2006550 :end  2262330 :peak 0.3177 :path "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif" :rate 1.000}
   {:index  43 :volume :ff :start  1468530 :end  1706670 :peak 0.2335 :path "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif" :rate 1.000}
   {:index  42 :volume :ff :start  1468530 :end  1706670 :peak 0.2335 :path "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif" :rate 1.000}
   {:index  41 :volume :ff :start   842310 :end  1093680 :peak 0.1631 :path "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif" :rate 1.000}
   {:index  40 :volume :ff :start     4410 :end   313110 :peak 0.1047 :path "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif" :rate 1.000}
   ])

;; we likely could simplify this since we have uniqified the data already.
;; but the code is here and maybe we'll use it to it's fullest someday.
(defn- get-unique-sample-info-map
  "return map of sample-info, filtered by volume and selecting only
  one sample per index. map key is :index"
  [matching-volume]
  (let [mv-info (filter #(= matching-volume (:volume %)) sample-info-list)
        mv-indexed (group-by :index mv-info)
        unique-mv-info (group-by :index (map #(first (second %)) (sort mv-indexed)))]
    unique-mv-info))

(defn- get-sample-info-map
  "return map of sample-info. map key is :index"
  []
  (get-unique-sample-info-map :ff))

(defn- load-sample-into-info
  "given an info map of the sample, load & add the sample"
  [x]
  (let [the-size (- (:end x) (:start x))
        the-buffer (o/load-sample (:path x) :start (:start x) :size the-size)]
    (assoc x :sample the-buffer)))

(defn- load-samples-into-infos
  "given a key value tuple where the value is an array of sample-info, load samples"
  [xs]
  (map load-sample-into-info xs))

;; the main map of samples. map key is midi-index
(defonce sample-info-map
  (doall (into {} (for [[k v] (get-sample-info-map)] [k (load-samples-into-infos v)]))))

(defonce min-index (apply min (keys sample-info-map)))
(defonce max-index (apply max (keys sample-info-map)))

(defn get-sample-info
  ([i v]
     (if (or (>= i min-index) (<= i max-index))
       (first (filter #(= v (:volume %)) (sample-info-map i)))
       nil)))

(defn get-sample
  ([i] (get-sample i :ff))
  ([i v]
     (let [sample-info (get-sample-info i v)]
       (if sample-info
         (:sample sample-info)
         nil))))

;; ======================================================================
;; several index buffers to use for grabbing per-note control information
;;
;; Silent buffer used to fill in for any missing notes
(defonce silent-buffer (o/buffer 0))
;; buffer of buffer ids for instrument note ctl to index through
;; 1 buffers (ff) x 128 midi note values
(defonce note-to-sample-id-buffer (o/buffer (* 1 128)))
;; buffer of scaling values for note ctl to index through
(defonce note-to-level-scale-buffer (o/buffer (* 1 128)))
;; buffer of sample-lengths for note ctl to index through
(defonce note-to-length-buffer (o/buffer (* 1 128)))
;; buffer of rates for note ctl to index through
(defonce note-to-rate-buffer (o/buffer (* 1 128)))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf"
  [buf volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf i (:id (get-sample i volume))))))

(defn- fill-buffer-scaling-factors
  "fill 128 level-scaling-factors in buf"
  [buf volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf i (/ 1.0 (:peak (get-sample-info i volume)))))))

(defn- fill-buffer-lengths
  "fill 128 length (in seconds) in buf"
  [buf volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (let [the-info (get-sample-info i volume)
            the-length (- (:end the-info) (:start the-info))
            the-rate (:rate (:sample the-info))
            length-in-secs (/ the-length the-rate)] 
        (o/buffer-set! buf i length-in-secs)))))

(defn- fill-buffer-rates
  "fill 128 rates in buf"
  [buf volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf i (:rate (get-sample-info i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-ektara-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! note-to-level-scale-buffer 1.0)
  (o/buffer-fill! note-to-length-buffer      0.0)
  (o/buffer-fill! note-to-rate-buffer        1.0)
  nil)

;; ======================================================================
;; initialize the ektara instrument buffers (only :ff)
(defn sampled-ektara-init
  "initialize all things for the ektara.  By default, only mf samples will be used."
  [& {:keys [min-note-index max-note-index]
      :or {min-note-index min-index
           max-note-index max-index}}]
    (reset-buffers)
    (fill-buffer-sample-ids note-to-sample-id-buffer :ff)
    (fill-buffer-scaling-factors note-to-level-scale-buffer :ff)
    (fill-buffer-lengths note-to-length-buffer :ff)
    (fill-buffer-rates note-to-rate-buffer :ff)
    nil)

;; ======================================================================
;; Initializes the ektara banks with the default settings
(println "sampled-ektara: initializing default samples...")
(time (sampled-ektara-init))
(println "sampled-ektara: done.")

