(ns oversampler.garageband.steel-string-acoustic-guitar.bank
  (:require [overtone.live :as o]))

(def root "/Library/Application Support/GarageBand/Instrument Library/Sampler/Sampler Files/Steel String Acoustic Guitar/")
(def rate-1 (/ (Math/pow 2 (/ 11 12)) 2)) ;; 0.9438743126816935
(def rate+1 (Math/pow 2 (/ 1 12)))        ;; 1.0594630943592953
(def rate+2 (Math/pow 2 (/ 2 12)))        ;; 1.122462048309373
(def level-steps 20)
(def sample-info-list
  [{:index 27 :rate rate-1 :volume :pp :path (str root "50B-1GA1-E1.aif")}
   {:index 28              :volume :pp :path (str root "50B-1GA1-E1.aif")}
   {:index 29 :rate rate+1 :volume :pp :path (str root "50B-1GA1-E1.aif")}
   {:index 30              :volume :pp :path (str root "50B-1GA1-F#1.aif")}
   {:index 31              :volume :pp :path (str root "50B-1GA1-G1.aif")}
   {:index 32 :rate rate+1 :volume :pp :path (str root "50B-1GA1-G1.aif")}
   {:index 33              :volume :pp :path (str root "50B-1GA1-A1.aif")}
   {:index 34 :rate rate+1 :volume :pp :path (str root "50B-1GA1-A1.aif")}
   {:index 35 :rate rate-1 :volume :pp :path (str root "50B-1GA1-C2.aif")}
   {:index 36              :volume :pp :path (str root "50B-1GA1-C2.aif")}
   {:index 37 :rate rate+1 :volume :pp :path (str root "50B-1GA1-C2.aif")}
   {:index 38              :volume :pp :path (str root "50B-1GA1-D2.aif")}
   {:index 39 :rate rate+1 :volume :pp :path (str root "50B-1GA1-D2.aif")}
   {:index 40              :volume :pp :path (str root "50B-1GA1-E2.aif")}
   {:index 41 :rate rate+1 :volume :pp :path (str root "50B-1GA1-E2.aif")}
   {:index 42              :volume :pp :path (str root "50B-1GA1-F#2.aif")}
   {:index 43              :volume :pp :path (str root "50B-1GA1-G2.aif")}
   {:index 44 :rate rate+1 :volume :pp :path (str root "50B-1GA1-G2.aif")}
   {:index 45              :volume :pp :path (str root "50B-1GA1-A2.aif")}
   {:index 46 :rate rate+1 :volume :pp :path (str root "50B-1GA1-A2.aif")}
   {:index 47              :volume :pp :path (str root "50B-1GA1-B2.aif")}
   {:index 48              :volume :pp :path (str root "50B-1GA1-C3.aif")}
   {:index 49 :rate rate+1 :volume :pp :path (str root "50B-1GA1-C3.aif")}
   {:index 50              :volume :pp :path (str root "50B-1GA1-D3.aif")}
   {:index 51 :rate rate+1 :volume :pp :path (str root "50B-1GA1-D3.aif")}
   {:index 52              :volume :pp :path (str root "50B-1GA1-E3.aif")}
   {:index 53 :rate rate+1 :volume :pp :path (str root "50B-1GA1-E3.aif")}
   {:index 54 :rate rate-1 :volume :pp :path (str root "50B-1GA1-G3.aif")}
   {:index 55              :volume :pp :path (str root "50B-1GA1-G3.aif")}
   {:index 56 :rate rate+1 :volume :pp :path (str root "50B-1GA1-G3.aif")}
   {:index 57              :volume :pp :path (str root "50B-1GA1-A3.aif")}
   {:index 58 :rate rate+1 :volume :pp :path (str root "50B-1GA1-A3.aif")}
   {:index 59 :rate rate-1 :volume :pp :path (str root "50B-1GA1-C4.aif")}
   {:index 60              :volume :pp :path (str root "50B-1GA1-C4.aif")}
   {:index 61 :rate rate+1 :volume :pp :path (str root "50B-1GA1-C4.aif")}
   {:index 62 :rate rate+2 :volume :pp :path (str root "50B-1GA1-C4.aif")}
   {:index 63 :rate rate-1 :volume :pp :path (str root "50B-1GA1-E4.aif")}
   {:index 64              :volume :pp :path (str root "50B-1GA1-E4.aif")}
   {:index 65 :rate rate+1 :volume :pp :path (str root "50B-1GA1-E4.aif")}

   {:index 27 :rate rate-1 :volume :mf :path (str root "50B-1GA2-E1.aif")}
   {:index 28              :volume :mf :path (str root "50B-1GA2-E1.aif")}
   {:index 29 :rate rate+1 :volume :mf :path (str root "50B-1GA2-E1.aif")}
   {:index 30              :volume :mf :path (str root "50B-1GA2-F#1.aif")}
   {:index 31              :volume :mf :path (str root "50B-1GA2-G1.aif")}
   {:index 32 :rate rate+1 :volume :mf :path (str root "50B-1GA2-G1.aif")}
   {:index 33              :volume :mf :path (str root "50B-1GA2-A1.aif")}
   {:index 34 :rate rate+1 :volume :mf :path (str root "50B-1GA2-A1.aif")}
   {:index 35 :rate rate-1 :volume :mf :path (str root "50B-1GA2-C2.aif")}
   {:index 36              :volume :mf :path (str root "50B-1GA2-C2.aif")}
   {:index 37 :rate rate+1 :volume :mf :path (str root "50B-1GA2-C2.aif")}
   {:index 38              :volume :mf :path (str root "50B-1GA2-D2.aif")}
   {:index 39 :rate rate+1 :volume :mf :path (str root "50B-1GA2-D2.aif")}
   {:index 40              :volume :mf :path (str root "50B-1GA2-E2.aif")}
   {:index 41 :rate rate+1 :volume :mf :path (str root "50B-1GA2-E2.aif")}
   {:index 42              :volume :mf :path (str root "50B-1GA2-F#2.aif")}
   {:index 43              :volume :mf :path (str root "50B-1GA2-G2.aif")}
   {:index 44 :rate rate+1 :volume :mf :path (str root "50B-1GA2-G2.aif")}
   {:index 45              :volume :mf :path (str root "50B-1GA2-A2.aif")}
   {:index 46 :rate rate+1 :volume :mf :path (str root "50B-1GA2-A2.aif")}
   {:index 47              :volume :mf :path (str root "50B-1GA2-B2.aif")}
   {:index 48              :volume :mf :path (str root "50B-1GA2-C3.aif")}
   {:index 49 :rate rate+1 :volume :mf :path (str root "50B-1GA2-C3.aif")}
   {:index 50              :volume :mf :path (str root "50B-1GA2-D3.aif")}
   {:index 51 :rate rate+1 :volume :mf :path (str root "50B-1GA2-D3.aif")}
   {:index 52              :volume :mf :path (str root "50B-1GA2-E3.aif")}
   {:index 53 :rate rate+1 :volume :mf :path (str root "50B-1GA2-E3.aif")}
   {:index 54 :rate rate-1 :volume :mf :path (str root "50B-1GA2-G3.aif")}
   {:index 55              :volume :mf :path (str root "50B-1GA2-G3.aif")}
   {:index 56 :rate rate+1 :volume :mf :path (str root "50B-1GA2-G3.aif")}
   {:index 57              :volume :mf :path (str root "50B-1GA2-A3.aif")}
   {:index 58 :rate rate+1 :volume :mf :path (str root "50B-1GA2-A3.aif")}
   {:index 59 :rate rate-1 :volume :mf :path (str root "50B-1GA2-C4.aif")}
   {:index 60              :volume :mf :path (str root "50B-1GA2-C4.aif")}
   {:index 61 :rate rate+1 :volume :mf :path (str root "50B-1GA2-C4.aif")}
   {:index 62 :rate rate+2 :volume :mf :path (str root "50B-1GA2-C4.aif")}
   {:index 63 :rate rate-1 :volume :mf :path (str root "50B-1GA2-E4.aif")}
   {:index 64              :volume :mf :path (str root "50B-1GA2-E4.aif")}
   {:index 65 :rate rate+1 :volume :mf :path (str root "50B-1GA2-E4.aif")}

   {:index 27 :rate rate-1 :volume :ff :path (str root "50B-1GA3-E1.aif")}
   {:index 28              :volume :ff :path (str root "50B-1GA3-E1.aif")}
   {:index 29 :rate rate+1 :volume :ff :path (str root "50B-1GA3-E1.aif")}
   {:index 30              :volume :ff :path (str root "50B-1GA3-F#1.aif")}
   {:index 31              :volume :ff :path (str root "50B-1GA3-G1.aif")}
   {:index 32 :rate rate+1 :volume :ff :path (str root "50B-1GA3-G1.aif")}
   {:index 33              :volume :ff :path (str root "50B-1GA3-A1.aif")}
   {:index 34 :rate rate+1 :volume :ff :path (str root "50B-1GA3-A1.aif")}
   {:index 35 :rate rate-1 :volume :ff :path (str root "50B-1GA3-C2.aif")}
   {:index 36              :volume :ff :path (str root "50B-1GA3-C2.aif")}
   {:index 37 :rate rate+1 :volume :ff :path (str root "50B-1GA3-C2.aif")}
   {:index 38              :volume :ff :path (str root "50B-1GA3-D2.aif")}
   {:index 39 :rate rate+1 :volume :ff :path (str root "50B-1GA3-D2.aif")}
   {:index 40              :volume :ff :path (str root "50B-1GA3-E2.aif")}
   {:index 41 :rate rate+1 :volume :ff :path (str root "50B-1GA3-E2.aif")}
   {:index 42              :volume :ff :path (str root "50B-1GA3-F#2.aif")}
   {:index 43              :volume :ff :path (str root "50B-1GA3-G2.aif")}
   {:index 44 :rate rate+1 :volume :ff :path (str root "50B-1GA3-G2.aif")}
   {:index 45              :volume :ff :path (str root "50B-1GA3-A2.aif")}
   {:index 46 :rate rate+1 :volume :ff :path (str root "50B-1GA3-A2.aif")}
   {:index 47              :volume :ff :path (str root "50B-1GA3-B2.aif")}
   {:index 48              :volume :ff :path (str root "50B-1GA3-C3.aif")}
   {:index 49 :rate rate+1 :volume :ff :path (str root "50B-1GA3-C3.aif")}
   {:index 50              :volume :ff :path (str root "50B-1GA3-D3.aif")}
   {:index 51 :rate rate+1 :volume :ff :path (str root "50B-1GA3-D3.aif")}
   {:index 52              :volume :ff :path (str root "50B-1GA3-E3.aif")}
   {:index 53 :rate rate+1 :volume :ff :path (str root "50B-1GA3-E3.aif")}
   {:index 54 :rate rate-1 :volume :ff :path (str root "50B-1GA3-G3.aif")}
   {:index 55              :volume :ff :path (str root "50B-1GA3-G3.aif")}
   {:index 56 :rate rate+1 :volume :ff :path (str root "50B-1GA3-G3.aif")}
   {:index 57              :volume :ff :path (str root "50B-1GA3-A3.aif")}
   {:index 58 :rate rate+1 :volume :ff :path (str root "50B-1GA3-A3.aif")}
   {:index 59 :rate rate-1 :volume :ff :path (str root "50B-1GA3-C4.aif")}
   {:index 60              :volume :ff :path (str root "50B-1GA3-C4.aif")}
   {:index 61 :rate rate+1 :volume :ff :path (str root "50B-1GA3-C4.aif")}
   {:index 62 :rate rate+2 :volume :ff :path (str root "50B-1GA3-C4.aif")}
   {:index 63 :rate rate-1 :volume :ff :path (str root "50B-1GA3-E4.aif")}
   {:index 64              :volume :ff :path (str root "50B-1GA3-E4.aif")}
   {:index 65 :rate rate+1 :volume :ff :path (str root "50B-1GA3-E4.aif")}

   ;; extra-loud 'messy' sounds
   ;;50B-1GA4-E1.aif
   ;;50B-1GA4-F#1.aif
   ;;50B-1GA4-A1.aif
   ;;50B-1GA4-C2.aif
   ;;50B-1GA4-D2.aif
   ;;50B-1GA4-E2.aif
   ;;50B-1GA4-F#2.aif
   ;;50B-1GA4-G2.aif
   ;;50B-1GA4-A2.aif
   ;;50B-1GA4-B2.aif
   ;;50B-1GA4-D3.aif
   ;;50B-1GA4-E3.aif

   ;; 2-note slides
   ;;50B-1GA5-A1.aif
   ;;50B-1GA5-B2.aif
   ;;50B-1GA5-C2.aif
   ;;50B-1GA5-D3.aif
   ;;50B-1GA5-E2.aif
   ;;50B-1GA5-F#2.aif

   ;; "scratches"
   ;;50B-2GA1-06.aif
   ;;50B-2GA1-07.aif
   ;;50B-2GA1-08.aif
   ;;50B-2GA1-09.aif
   ;;50B-2GA1-10.aif
   ;;50B-2GA1-11.aif
   ])

(defn- load-sample-into-info
  "given an info map of the sample, load & add the sample"
  [x]
  (assoc x :sample (o/load-sample (:path x))))

(defn- load-samples-into-infos
  "given a key value tuple where the value is an array of sample-info, load samples"
  [xs]
  (map load-sample-into-info xs))

(defn- get-sample-info-map
  "return map of sample-info. map key is :index"
  []
  (group-by :index sample-info-list))

;; the main map of cello samples. map key is midi-index
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
  ([i] (get-sample i :v3))
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
;; 3 buffers (pp,mf,ff) x 128 midi note values
(defonce note-to-sample-id-buffer (o/buffer (* 3 128)))
;; buffer of rates for instrument note ctl to index through
;; 3 buffers (pp,mf,ff) x 128 midi note values
(defonce note-to-rate-buffer (o/buffer (* 3 128)))
;; buffer of buffer-offsets for level to index through.
;; 0 = pp, 128 = mf, 256 = ff
(defonce level-to-offset-buffer (o/buffer (inc level-steps)))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (get-sample i volume))))))

(defn- fill-buffer-rates
  "fill 128 rates in buf starting at offset for a particular volume"
  [buf offset volume]
  (dotimes [i 128]
    (if (:rate (get-sample-info i volume))
      (o/buffer-set! buf (+ offset i) (:rate (get-sample-info i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer (:id silent-buffer))
  (o/buffer-fill! note-to-rate-buffer      1.0)
  (o/buffer-fill! level-to-offset-buffer   0)
  nil)

;; ======================================================================
;; initialize the piano instrument buffers
(defn sample-init
  "initialize all things for the piano."
  [& {:keys [min-note-index max-note-index]
      :or {min-note-index min-index
           max-note-index max-index}}]
  (reset-buffers)
  (fill-buffer-sample-ids note-to-sample-id-buffer   0 :pp)
  (fill-buffer-sample-ids note-to-sample-id-buffer 128 :mf)
  (fill-buffer-sample-ids note-to-sample-id-buffer 256 :ff)
  (fill-buffer-rates note-to-rate-buffer   0 :pp)
  (fill-buffer-rates note-to-rate-buffer 128 :mf)
  (fill-buffer-rates note-to-rate-buffer 256 :ff)
  (dotimes [i (inc level-steps)]
    (let [cur-offset (min 256 (* 128 (int (* 3 (/ i level-steps)))))]
      (o/buffer-set! level-to-offset-buffer i cur-offset)))
  nil)

;; ======================================================================
;; Initializes the sample banks with the default settings
(println "garageband.steel-string-acoustic-guitar: initializing default samples...")
(time (sample-init))
(println "garageband.steel-string-acoustic-guitar: done.")
