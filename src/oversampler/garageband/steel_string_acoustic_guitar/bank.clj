(ns oversampler.garageband.steel-string-acoustic-guitar.bank
  (:require [overtone.live :as o]))

;; NOTE: the guitar samples are MONO
(def root "/Library/Application Support/GarageBand/Instrument Library/Sampler/Sampler Files/Steel String Acoustic Guitar/")
(def rate-1 (/ (Math/pow 2 (/ 11 12)) 2)) ;; 0.9438743126816935
(def rate+1 (Math/pow 2 (/ 1 12)))        ;; 1.0594630943592953
(def rate+2 (Math/pow 2 (/ 2 12)))        ;; 1.122462048309373
(def level-steps 20)

(def sample-info-list
  ;; added :size parameter because there are a couple samples with audible glitches at the end
  ;; for example 50B-1GA2-E2.aif.  Looks like removing 0.02s from the end will fix this
  ;;
  ;; how I got the sample length
  ;; (:rate (o/buffer-info (get-sample 40 :mf))) => 44100.0
  ;; (* 0.02 (:rate (o/buffer-info (get-sample 40 :mf)))) => 882.0
  ;; (dorun (doseq [s (range 27 66)]
  ;;          (println (- (:n-samples (o/buffer-info (get-sample s))) 882))))
  ;; ...sample lengths - 0.02s of samples
  [{:index 27 :rate rate-1 :volume :pp :size 239757 :path (str root "50B-1GA1-E1.aif")}
   {:index 28              :volume :pp :size 239757 :path (str root "50B-1GA1-E1.aif")}
   {:index 29 :rate rate+1 :volume :pp :size 239757 :path (str root "50B-1GA1-E1.aif")}
   {:index 30              :volume :pp :size 224041 :path (str root "50B-1GA1-F#1.aif")}
   {:index 31              :volume :pp :size 248529 :path (str root "50B-1GA1-G1.aif")}
   {:index 32 :rate rate+1 :volume :pp :size 248529 :path (str root "50B-1GA1-G1.aif")}
   {:index 33              :volume :pp :size 234518 :path (str root "50B-1GA1-A1.aif")}
   {:index 34 :rate rate+1 :volume :pp :size 234518 :path (str root "50B-1GA1-A1.aif")}
   {:index 35 :rate rate-1 :volume :pp :size 231556 :path (str root "50B-1GA1-C2.aif")}
   {:index 36              :volume :pp :size 231556 :path (str root "50B-1GA1-C2.aif")}
   {:index 37 :rate rate+1 :volume :pp :size 231556 :path (str root "50B-1GA1-C2.aif")}
   {:index 38              :volume :pp :size 226326 :path (str root "50B-1GA1-D2.aif")}
   {:index 39 :rate rate+1 :volume :pp :size 226326 :path (str root "50B-1GA1-D2.aif")}
   {:index 40              :volume :pp :size 216131 :path (str root "50B-1GA1-E2.aif")}
   {:index 41 :rate rate+1 :volume :pp :size 216131 :path (str root "50B-1GA1-E2.aif")}
   {:index 42              :volume :pp :size 227469 :path (str root "50B-1GA1-F#2.aif")}
   {:index 43              :volume :pp :size 209629 :path (str root "50B-1GA1-G2.aif")}
   {:index 44 :rate rate+1 :volume :pp :size 209629 :path (str root "50B-1GA1-G2.aif")}
   {:index 45              :volume :pp :size 218105 :path (str root "50B-1GA1-A2.aif")}
   {:index 46 :rate rate+1 :volume :pp :size 218105 :path (str root "50B-1GA1-A2.aif")}
   {:index 47              :volume :pp :size 225288 :path (str root "50B-1GA1-B2.aif")}
   {:index 48              :volume :pp :size 211915 :path (str root "50B-1GA1-C3.aif")}
   {:index 49 :rate rate+1 :volume :pp :size 211915 :path (str root "50B-1GA1-C3.aif")}
   {:index 50              :volume :pp :size 211085 :path (str root "50B-1GA1-D3.aif")}
   {:index 51 :rate rate+1 :volume :pp :size 211085 :path (str root "50B-1GA1-D3.aif")}
   {:index 52              :volume :pp :size 225401 :path (str root "50B-1GA1-E3.aif")}
   {:index 53 :rate rate+1 :volume :pp :size 225401 :path (str root "50B-1GA1-E3.aif")}
   {:index 54 :rate rate-1 :volume :pp :size 219249 :path (str root "50B-1GA1-G3.aif")}
   {:index 55              :volume :pp :size 219249 :path (str root "50B-1GA1-G3.aif")}
   {:index 56 :rate rate+1 :volume :pp :size 219249 :path (str root "50B-1GA1-G3.aif")}
   {:index 57              :volume :pp :size 221179 :path (str root "50B-1GA1-A3.aif")}
   {:index 58 :rate rate+1 :volume :pp :size 221179 :path (str root "50B-1GA1-A3.aif")}
   {:index 59 :rate rate-1 :volume :pp :size 159949 :path (str root "50B-1GA1-C4.aif")}
   {:index 60              :volume :pp :size 159949 :path (str root "50B-1GA1-C4.aif")}
   {:index 61 :rate rate+1 :volume :pp :size 159949 :path (str root "50B-1GA1-C4.aif")}
   {:index 62 :rate rate+2 :volume :pp :size 159949 :path (str root "50B-1GA1-C4.aif")}
   {:index 63 :rate rate-1 :volume :pp :size 178109 :path (str root "50B-1GA1-E4.aif")}
   {:index 64              :volume :pp :size 178109 :path (str root "50B-1GA1-E4.aif")}
   {:index 65 :rate rate+1 :volume :pp :size 178109 :path (str root "50B-1GA1-E4.aif")}

   {:index 27 :rate rate-1 :volume :mf :size 256939 :path (str root "50B-1GA2-E1.aif")}
   {:index 28              :volume :mf :size 256939 :path (str root "50B-1GA2-E1.aif")}
   {:index 29 :rate rate+1 :volume :mf :size 256939 :path (str root "50B-1GA2-E1.aif")}
   {:index 30              :volume :mf :size 229296 :path (str root "50B-1GA2-F#1.aif")}
   {:index 31              :volume :mf :size 254530 :path (str root "50B-1GA2-G1.aif")}
   {:index 32 :rate rate+1 :volume :mf :size 254530 :path (str root "50B-1GA2-G1.aif")}
   {:index 33              :volume :mf :size 235400 :path (str root "50B-1GA2-A1.aif")}
   {:index 34 :rate rate+1 :volume :mf :size 235400 :path (str root "50B-1GA2-A1.aif")}
   {:index 35 :rate rate-1 :volume :mf :size 232438 :path (str root "50B-1GA2-C2.aif")}
   {:index 36              :volume :mf :size 232438 :path (str root "50B-1GA2-C2.aif")}
   {:index 37 :rate rate+1 :volume :mf :size 232438 :path (str root "50B-1GA2-C2.aif")}
   {:index 38              :volume :mf :size 239241 :path (str root "50B-1GA2-D2.aif")}
   {:index 39 :rate rate+1 :volume :mf :size 239241 :path (str root "50B-1GA2-D2.aif")}
   {:index 40              :volume :mf :size 237709 :path (str root "50B-1GA2-E2.aif")}
   {:index 41 :rate rate+1 :volume :mf :size 237709 :path (str root "50B-1GA2-E2.aif")}
   {:index 42              :volume :mf :size 235661 :path (str root "50B-1GA2-F#2.aif")}
   {:index 43              :volume :mf :size 229294 :path (str root "50B-1GA2-G2.aif")}
   {:index 44 :rate rate+1 :volume :mf :size 229294 :path (str root "50B-1GA2-G2.aif")}
   {:index 45              :volume :mf :size 235498 :path (str root "50B-1GA2-A2.aif")}
   {:index 46 :rate rate+1 :volume :mf :size 235498 :path (str root "50B-1GA2-A2.aif")}
   {:index 47              :volume :mf :size 229470 :path (str root "50B-1GA2-B2.aif")}
   {:index 48              :volume :mf :size 229083 :path (str root "50B-1GA2-C3.aif")}
   {:index 49 :rate rate+1 :volume :mf :size 229083 :path (str root "50B-1GA2-C3.aif")}
   {:index 50              :volume :mf :size 225283 :path (str root "50B-1GA2-D3.aif")}
   {:index 51 :rate rate+1 :volume :mf :size 225283 :path (str root "50B-1GA2-D3.aif")}
   {:index 52              :volume :mf :size 226283 :path (str root "50B-1GA2-E3.aif")}
   {:index 53 :rate rate+1 :volume :mf :size 226283 :path (str root "50B-1GA2-E3.aif")}
   {:index 54 :rate rate-1 :volume :mf :size 230237 :path (str root "50B-1GA2-G3.aif")}
   {:index 55              :volume :mf :size 230237 :path (str root "50B-1GA2-G3.aif")}
   {:index 56 :rate rate+1 :volume :mf :size 230237 :path (str root "50B-1GA2-G3.aif")}
   {:index 57              :volume :mf :size 222156 :path (str root "50B-1GA2-A3.aif")}
   {:index 58 :rate rate+1 :volume :mf :size 222156 :path (str root "50B-1GA2-A3.aif")}
   {:index 59 :rate rate-1 :volume :mf :size 168414 :path (str root "50B-1GA2-C4.aif")}
   {:index 60              :volume :mf :size 168414 :path (str root "50B-1GA2-C4.aif")}
   {:index 61 :rate rate+1 :volume :mf :size 168414 :path (str root "50B-1GA2-C4.aif")}
   {:index 62 :rate rate+2 :volume :mf :size 168414 :path (str root "50B-1GA2-C4.aif")}
   {:index 63 :rate rate-1 :volume :mf :size 182178 :path (str root "50B-1GA2-E4.aif")}
   {:index 64              :volume :mf :size 182178 :path (str root "50B-1GA2-E4.aif")}
   {:index 65 :rate rate+1 :volume :mf :size 182178 :path (str root "50B-1GA2-E4.aif")}

   {:index 27 :rate rate-1 :volume :ff :size 256057 :path (str root "50B-1GA3-E1.aif")}
   {:index 28              :volume :ff :size 256057 :path (str root "50B-1GA3-E1.aif")}
   {:index 29 :rate rate+1 :volume :ff :size 256057 :path (str root "50B-1GA3-E1.aif")}
   {:index 30              :volume :ff :size 228414 :path (str root "50B-1GA3-F#1.aif")}
   {:index 31              :volume :ff :size 253648 :path (str root "50B-1GA3-G1.aif")}
   {:index 32 :rate rate+1 :volume :ff :size 253648 :path (str root "50B-1GA3-G1.aif")}
   {:index 33              :volume :ff :size 234518 :path (str root "50B-1GA3-A1.aif")}
   {:index 34 :rate rate+1 :volume :ff :size 234518 :path (str root "50B-1GA3-A1.aif")}
   {:index 35 :rate rate-1 :volume :ff :size 231556 :path (str root "50B-1GA3-C2.aif")}
   {:index 36              :volume :ff :size 231556 :path (str root "50B-1GA3-C2.aif")}
   {:index 37 :rate rate+1 :volume :ff :size 231556 :path (str root "50B-1GA3-C2.aif")}
   {:index 38              :volume :ff :size 237528 :path (str root "50B-1GA3-D2.aif")}
   {:index 39 :rate rate+1 :volume :ff :size 237528 :path (str root "50B-1GA3-D2.aif")}
   {:index 40              :volume :ff :size 236827 :path (str root "50B-1GA3-E2.aif")}
   {:index 41 :rate rate+1 :volume :ff :size 236827 :path (str root "50B-1GA3-E2.aif")}
   {:index 42              :volume :ff :size 234779 :path (str root "50B-1GA3-F#2.aif")}
   {:index 43              :volume :ff :size 228412 :path (str root "50B-1GA3-G2.aif")}
   {:index 44 :rate rate+1 :volume :ff :size 228412 :path (str root "50B-1GA3-G2.aif")}
   {:index 45              :volume :ff :size 234616 :path (str root "50B-1GA3-A2.aif")}
   {:index 46 :rate rate+1 :volume :ff :size 234616 :path (str root "50B-1GA3-A2.aif")}
   {:index 47              :volume :ff :size 228588 :path (str root "50B-1GA3-B2.aif")}
   {:index 48              :volume :ff :size 228201 :path (str root "50B-1GA3-C3.aif")}
   {:index 49 :rate rate+1 :volume :ff :size 228201 :path (str root "50B-1GA3-C3.aif")}
   {:index 50              :volume :ff :size 224401 :path (str root "50B-1GA3-D3.aif")}
   {:index 51 :rate rate+1 :volume :ff :size 224401 :path (str root "50B-1GA3-D3.aif")}
   {:index 52              :volume :ff :size 225401 :path (str root "50B-1GA3-E3.aif")}
   {:index 53 :rate rate+1 :volume :ff :size 225401 :path (str root "50B-1GA3-E3.aif")}
   {:index 54 :rate rate-1 :volume :ff :size 215994 :path (str root "50B-1GA3-G3.aif")}
   {:index 55              :volume :ff :size 215994 :path (str root "50B-1GA3-G3.aif")}
   {:index 56 :rate rate+1 :volume :ff :size 215994 :path (str root "50B-1GA3-G3.aif")}
   {:index 57              :volume :ff :size 218015 :path (str root "50B-1GA3-A3.aif")}
   {:index 58 :rate rate+1 :volume :ff :size 218015 :path (str root "50B-1GA3-A3.aif")}
   {:index 59 :rate rate-1 :volume :ff :size 163283 :path (str root "50B-1GA3-C4.aif")}
   {:index 60              :volume :ff :size 163283 :path (str root "50B-1GA3-C4.aif")}
   {:index 61 :rate rate+1 :volume :ff :size 163283 :path (str root "50B-1GA3-C4.aif")}
   {:index 62 :rate rate+2 :volume :ff :size 163283 :path (str root "50B-1GA3-C4.aif")}
   {:index 63 :rate rate-1 :volume :ff :size 170906 :path (str root "50B-1GA3-E4.aif")}
   {:index 64              :volume :ff :size 170906 :path (str root "50B-1GA3-E4.aif")}
   {:index 65 :rate rate+1 :volume :ff :size 170906 :path (str root "50B-1GA3-E4.aif")}

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
  (assoc x :sample (o/load-sample (:path x) :size (:size x)))) ;; NOTE :size

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
  ([i] (get-sample i :mf))
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
;; initialize the instrument buffers
(defn sample-init
  "initialize all things for the instrument."
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
