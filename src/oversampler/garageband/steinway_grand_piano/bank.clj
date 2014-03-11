(ns oversampler.garageband.steinway-grand-piano.bank
  (:require [overtone.live :as o]))

(def root "/Library/Application Support/GarageBand/Instrument Library/Sampler/Sampler Files/Steinway Grand Piano/")
(def sample-info-list
  [{:index  21 :volume :v2 :path (str root "Steinway V2/Steinway V2  021.aif")}
   {:index  24 :volume :v2 :path (str root "Steinway V2/Steinway V2  024.aif")}
   {:index  27 :volume :v2 :path (str root "Steinway V2/Steinway V2  027.aif")}
   {:index  30 :volume :v2 :path (str root "Steinway V2/Steinway V2  030.aif")}
   {:index  33 :volume :v2 :path (str root "Steinway V2/Steinway V2  033.aif")}
   {:index  36 :volume :v2 :path (str root "Steinway V2/Steinway V2  036.aif")}
   {:index  39 :volume :v2 :path (str root "Steinway V2/Steinway V2  039.aif")}
   {:index  42 :volume :v2 :path (str root "Steinway V2/Steinway V2  042.aif")}
   {:index  46 :volume :v2 :path (str root "Steinway V2/Steinway V2  046.aif")}
   {:index  48 :volume :v2 :path (str root "Steinway V2/Steinway V2  048.aif")}
   {:index  51 :volume :v2 :path (str root "Steinway V2/Steinway V2  051.aif")}
   {:index  54 :volume :v2 :path (str root "Steinway V2/Steinway V2  054.aif")}
   {:index  57 :volume :v2 :path (str root "Steinway V2/Steinway V2  057.aif")}
   {:index  60 :volume :v2 :path (str root "Steinway V2/Steinway V2  060.aif")}
   {:index  63 :volume :v2 :path (str root "Steinway V2/Steinway V2  063.aif")}
   {:index  66 :volume :v2 :path (str root "Steinway V2/Steinway V2  066.aif")}
   {:index  69 :volume :v2 :path (str root "Steinway V2/Steinway V2  069.aif")}
   {:index  72 :volume :v2 :path (str root "Steinway V2/Steinway V2  072.aif")}
   {:index  75 :volume :v2 :path (str root "Steinway V2/Steinway V2  075.aif")}
   {:index  78 :volume :v2 :path (str root "Steinway V2/Steinway V2  078.aif")}
   {:index  81 :volume :v2 :path (str root "Steinway V2/Steinway V2  081.aif")}
   {:index  84 :volume :v2 :path (str root "Steinway V2/Steinway V2  084.aif")}
   {:index  87 :volume :v2 :path (str root "Steinway V2/Steinway V2  087.aif")}
   {:index  90 :volume :v2 :path (str root "Steinway V2/Steinway V2  090.aif")}
   {:index  93 :volume :v2 :path (str root "Steinway V2/Steinway V2  093.aif")}
   {:index  96 :volume :v2 :path (str root "Steinway V2/Steinway V2  096.aif")}
   {:index  99 :volume :v2 :path (str root "Steinway V2/Steinway V2  099.aif")}
   {:index 102 :volume :v2 :path (str root "Steinway V2/Steinway V2  102.aif")}
   {:index 105 :volume :v2 :path (str root "Steinway V2/Steinway V2  105.aif")}
   {:index 108 :volume :v2 :path (str root "Steinway V2/Steinway V2  108.aif")}

   {:index  21 :volume :v3 :path (str root "Steinway V3/Steinway V3  021.aif")}
   {:index  24 :volume :v3 :path (str root "Steinway V3/Steinway V3  024.aif")}
   {:index  27 :volume :v3 :path (str root "Steinway V3/Steinway V3  027.aif")}
   {:index  30 :volume :v3 :path (str root "Steinway V3/Steinway V3  030.aif")}
   {:index  33 :volume :v3 :path (str root "Steinway V3/Steinway V3  033.aif")}
   {:index  36 :volume :v3 :path (str root "Steinway V3/Steinway V3  036.aif")}
   {:index  39 :volume :v3 :path (str root "Steinway V3/Steinway V3  039.aif")}
   {:index  42 :volume :v3 :path (str root "Steinway V3/Steinway V3  042.aif")}
   {:index  46 :volume :v3 :path (str root "Steinway V3/Steinway V3  046.aif")}
   {:index  48 :volume :v3 :path (str root "Steinway V3/Steinway V3  048.aif")}
   {:index  51 :volume :v3 :path (str root "Steinway V3/Steinway V3  051.aif")}
   {:index  54 :volume :v3 :path (str root "Steinway V3/Steinway V3  054.aif")}
   {:index  57 :volume :v3 :path (str root "Steinway V3/Steinway V3  057.aif")}
   {:index  60 :volume :v3 :path (str root "Steinway V3/Steinway V3  060.aif")}
   {:index  63 :volume :v3 :path (str root "Steinway V3/Steinway V3  063.aif")}
   {:index  66 :volume :v3 :path (str root "Steinway V3/Steinway V3  066.aif")}
   {:index  69 :volume :v3 :path (str root "Steinway V3/Steinway V3  069.aif")}
   {:index  72 :volume :v3 :path (str root "Steinway V3/Steinway V3  072.aif")}
   {:index  75 :volume :v3 :path (str root "Steinway V3/Steinway V3  075.aif")}
   {:index  78 :volume :v3 :path (str root "Steinway V3/Steinway V3  078.aif")}
   {:index  81 :volume :v3 :path (str root "Steinway V3/Steinway V3  081.aif")}
   {:index  84 :volume :v3 :path (str root "Steinway V3/Steinway V3  084.aif")}
   {:index  87 :volume :v3 :path (str root "Steinway V3/Steinway V3  087.aif")}
   {:index  90 :volume :v3 :path (str root "Steinway V3/Steinway V3  090.aif")}
   {:index  93 :volume :v3 :path (str root "Steinway V3/Steinway V3  093.aif")}
   {:index  96 :volume :v3 :path (str root "Steinway V3/Steinway V3  096.aif")}
   {:index  99 :volume :v3 :path (str root "Steinway V3/Steinway V3  099.aif")}
   {:index 102 :volume :v3 :path (str root "Steinway V3/Steinway V3  102.aif")}
   {:index 105 :volume :v3 :path (str root "Steinway V3/Steinway V3  105.aif")}
   {:index 108 :volume :v3 :path (str root "Steinway V3/Steinway V3  108.aif")}

   {:index  21 :volume :v4 :path (str root "Steinway V4/Steinway V4  021.aif")}
   {:index  24 :volume :v4 :path (str root "Steinway V4/Steinway V4  024.aif")}
   {:index  27 :volume :v4 :path (str root "Steinway V4/Steinway V4  027.aif")}
   {:index  30 :volume :v4 :path (str root "Steinway V4/Steinway V4  030.aif")}
   {:index  33 :volume :v4 :path (str root "Steinway V4/Steinway V4  033.aif")}
   {:index  36 :volume :v4 :path (str root "Steinway V4/Steinway V4  036.aif")}
   {:index  39 :volume :v4 :path (str root "Steinway V4/Steinway V4  039.aif")}
   {:index  42 :volume :v4 :path (str root "Steinway V4/Steinway V4  042.aif")}
   {:index  46 :volume :v4 :path (str root "Steinway V4/Steinway V4  046.aif")}
   {:index  48 :volume :v4 :path (str root "Steinway V4/Steinway V4  048.aif")}
   {:index  51 :volume :v4 :path (str root "Steinway V4/Steinway V4  051.aif")}
   {:index  54 :volume :v4 :path (str root "Steinway V4/Steinway V4  054.aif")}
   {:index  57 :volume :v4 :path (str root "Steinway V4/Steinway V4  057.aif")}
   {:index  60 :volume :v4 :path (str root "Steinway V4/Steinway V4  060.aif")}
   {:index  63 :volume :v4 :path (str root "Steinway V4/Steinway V4  063.aif")}
   {:index  66 :volume :v4 :path (str root "Steinway V4/Steinway V4  066.aif")}
   {:index  69 :volume :v4 :path (str root "Steinway V4/Steinway V4  069.aif")}
   {:index  72 :volume :v4 :path (str root "Steinway V4/Steinway V4  072.aif")}
   {:index  75 :volume :v4 :path (str root "Steinway V4/Steinway V4  075.aif")}
   {:index  78 :volume :v4 :path (str root "Steinway V4/Steinway V4  078.aif")}
   {:index  81 :volume :v4 :path (str root "Steinway V4/Steinway V4  081.aif")}
   {:index  84 :volume :v4 :path (str root "Steinway V4/Steinway V4  084.aif")}
   {:index  87 :volume :v4 :path (str root "Steinway V4/Steinway V4  087.aif")}
   {:index  90 :volume :v4 :path (str root "Steinway V4/Steinway V4  090.aif")}
   {:index  93 :volume :v4 :path (str root "Steinway V4/Steinway V4  093.aif")}
   {:index  96 :volume :v4 :path (str root "Steinway V4/Steinway V4  096.aif")}
   {:index  99 :volume :v4 :path (str root "Steinway V4/Steinway V4  099.aif")}
   {:index 102 :volume :v4 :path (str root "Steinway V4/Steinway V4  102.aif")}
   {:index 105 :volume :v4 :path (str root "Steinway V4/Steinway V4  105.aif")}
   {:index 108 :volume :v4 :path (str root "Steinway V4/Steinway V4  108.aif")}

   {:index  21 :volume :v5 :path (str root "Steinway V5/Steinway V5  021.aif")}
   {:index  24 :volume :v5 :path (str root "Steinway V5/Steinway V5  024.aif")}
   {:index  27 :volume :v5 :path (str root "Steinway V5/Steinway V5  027.aif")}
   {:index  30 :volume :v5 :path (str root "Steinway V5/Steinway V5  030.aif")}
   {:index  33 :volume :v5 :path (str root "Steinway V5/Steinway V5  033.aif")}
   {:index  36 :volume :v5 :path (str root "Steinway V5/Steinway V5  036.aif")}
   {:index  39 :volume :v5 :path (str root "Steinway V5/Steinway V5  039.aif")}
   {:index  42 :volume :v5 :path (str root "Steinway V5/Steinway V5  042.aif")}
   {:index  46 :volume :v5 :path (str root "Steinway V5/Steinway V5  046.aif")}
   {:index  48 :volume :v5 :path (str root "Steinway V5/Steinway V5  048.aif")}
   {:index  51 :volume :v5 :path (str root "Steinway V5/Steinway V5  051.aif")}
   {:index  54 :volume :v5 :path (str root "Steinway V5/Steinway V5  054.aif")}
   {:index  57 :volume :v5 :path (str root "Steinway V5/Steinway V5  057.aif")}
   {:index  60 :volume :v5 :path (str root "Steinway V5/Steinway V5  060.aif")}
   {:index  63 :volume :v5 :path (str root "Steinway V5/Steinway V5  063.aif")}
   {:index  66 :volume :v5 :path (str root "Steinway V5/Steinway V5  066.aif")}
   {:index  69 :volume :v5 :path (str root "Steinway V5/Steinway V5  069.aif")}
   {:index  72 :volume :v5 :path (str root "Steinway V5/Steinway V5  072.aif")}
   {:index  75 :volume :v5 :path (str root "Steinway V5/Steinway V5  075.aif")}
   {:index  78 :volume :v5 :path (str root "Steinway V5/Steinway V5  078.aif")}
   {:index  81 :volume :v5 :path (str root "Steinway V5/Steinway V5  081.aif")}
   {:index  84 :volume :v5 :path (str root "Steinway V5/Steinway V5  084.aif")}
   {:index  87 :volume :v5 :path (str root "Steinway V5/Steinway V5  087.aif")}
   {:index  90 :volume :v5 :path (str root "Steinway V5/Steinway V5  090.aif")}
   {:index  93 :volume :v5 :path (str root "Steinway V5/Steinway V5  093.aif")}
   {:index  96 :volume :v5 :path (str root "Steinway V5/Steinway V5  096.aif")}
   {:index  99 :volume :v5 :path (str root "Steinway V5/Steinway V5  099.aif")}
   {:index 102 :volume :v5 :path (str root "Steinway V5/Steinway V5  102.aif")}
   {:index 105 :volume :v5 :path (str root "Steinway V5/Steinway V5  105.aif")}
   {:index 108 :volume :v5 :path (str root "Steinway V5/Steinway V5  108.aif")}
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
;; 4 buffers (v2,v3,v4,v5) x 128 midi note values
(defonce note-to-sample-id-buffer (o/buffer (* 4 128)))
;; buffer of buffer-offsets for level to index through.
;; 0 = mf, 128 = ff
(defonce level-to-offset-buffer (o/buffer 21))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (get-sample i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! level-to-offset-buffer     0)
  nil)

;; ======================================================================
;; initialize the piano instrument buffers
(defn sample-init
  "initialize all things for the piano."
  [& {:keys [min-note-index max-note-index]
      :or {min-note-index min-index
           max-note-index max-index}}]
  (reset-buffers)
  (fill-buffer-sample-ids note-to-sample-id-buffer   0 :v2)
  (fill-buffer-sample-ids note-to-sample-id-buffer 128 :v3)
  (fill-buffer-sample-ids note-to-sample-id-buffer 256 :v4)
  (fill-buffer-sample-ids note-to-sample-id-buffer 384 :v5)
    (dotimes [i 21]
      (let [cur-offset (min 384 (* 128 (int (* 4 (/ i 20)))))]
        (o/buffer-set! level-to-offset-buffer i cur-offset)))
    nil)

;; ======================================================================
;; Initializes the piano banks with the default settings
(println "garageband.steinway-grand-piano: initializing default samples...")
(time (sample-init))
(println "garageband.steinway-grand-piano: done.")
