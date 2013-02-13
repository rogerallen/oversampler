(ns oversampler.piano.bank
  (:require [overtone.live :as o]))

(def sample-info-list
  [;;{:index 21 :volume :ff :path (o/freesound-path 148484)} ; make ff match mf
   ;;{:index 22 :volume :ff :path (o/freesound-path 148404)} ; make ff match mf
   {:index 23 :volume :ff :path (o/freesound-path 148477)}
   {:index 24 :volume :ff :path (o/freesound-path 148427)}
   {:index 25 :volume :ff :path (o/freesound-path 148517)}
   {:index 26 :volume :ff :path (o/freesound-path 148425)}
   {:index 27 :volume :ff :path (o/freesound-path 148497)}
   {:index 28 :volume :ff :path (o/freesound-path 148527)}
   {:index 29 :volume :ff :path (o/freesound-path 148492)}
   {:index 30 :volume :ff :path (o/freesound-path 148440)}
   {:index 31 :volume :ff :path (o/freesound-path 148502)}
   {:index 32 :volume :ff :path (o/freesound-path 148490)}
   {:index 33 :volume :ff :path (o/freesound-path 148483)}
   {:index 34 :volume :ff :path (o/freesound-path 148423)}
   {:index 35 :volume :ff :path (o/freesound-path 148476)}
   {:index 36 :volume :ff :path (o/freesound-path 148430)}
   {:index 37 :volume :ff :path (o/freesound-path 148518)}
   {:index 38 :volume :ff :path (o/freesound-path 148511)}
   {:index 39 :volume :ff :path (o/freesound-path 148498)}
   {:index 40 :volume :ff :path (o/freesound-path 148526)}
   {:index 41 :volume :ff :path (o/freesound-path 148499)}
   {:index 42 :volume :ff :path (o/freesound-path 148441)}
   {:index 43 :volume :ff :path (o/freesound-path 148501)}
   {:index 44 :volume :ff :path (o/freesound-path 148489)}
   {:index 45 :volume :ff :path (o/freesound-path 148482)}
   {:index 46 :volume :ff :path (o/freesound-path 148424)}
   {:index 47 :volume :ff :path (o/freesound-path 148475)}
   {:index 48 :volume :ff :path (o/freesound-path 148429)}
   {:index 49 :volume :ff :path (o/freesound-path 148519)}
   {:index 50 :volume :ff :path (o/freesound-path 148512)}
   {:index 51 :volume :ff :path (o/freesound-path 148495)}
   {:index 52 :volume :ff :path (o/freesound-path 148525)}
   {:index 53 :volume :ff :path (o/freesound-path 148500)}
   {:index 54 :volume :ff :path (o/freesound-path 148442)}
   {:index 55 :volume :ff :path (o/freesound-path 148504)}
   {:index 56 :volume :ff :path (o/freesound-path 148474)}
   {:index 57 :volume :ff :path (o/freesound-path 148481)}
   {:index 58 :volume :ff :path (o/freesound-path 148407)}
   {:index 59 :volume :ff :path (o/freesound-path 148480)}
   {:index 60 :volume :ff :path (o/freesound-path 148432)}
   {:index 61 :volume :ff :path (o/freesound-path 148520)}
   {:index 62 :volume :ff :path (o/freesound-path 148513)}
   {:index 63 :volume :ff :path (o/freesound-path 148496)}
   {:index 64 :volume :ff :path (o/freesound-path 148524)}
   {:index 65 :volume :ff :path (o/freesound-path 148506)}
   {:index 66 :volume :ff :path (o/freesound-path 148435)}
   {:index 67 :volume :ff :path (o/freesound-path 148503)}
   {:index 68 :volume :ff :path (o/freesound-path 148473)}
   {:index 69 :volume :ff :path (o/freesound-path 148488)}
   {:index 70 :volume :ff :path (o/freesound-path 148408)}
   {:index 71 :volume :ff :path (o/freesound-path 148479)}
   {:index 72 :volume :ff :path (o/freesound-path 148431)}
   {:index 73 :volume :ff :path (o/freesound-path 148530)}
   {:index 74 :volume :ff :path (o/freesound-path 148514)}
   {:index 75 :volume :ff :path (o/freesound-path 148493)}
   {:index 76 :volume :ff :path (o/freesound-path 148523)}
   {:index 77 :volume :ff :path (o/freesound-path 148505)}
   {:index 78 :volume :ff :path (o/freesound-path 148436)}
   {:index 79 :volume :ff :path (o/freesound-path 148510)}
   {:index 80 :volume :ff :path (o/freesound-path 148472)}
   {:index 81 :volume :ff :path (o/freesound-path 148487)}
   {:index 82 :volume :ff :path (o/freesound-path 148401)}
   {:index 83 :volume :ff :path (o/freesound-path 148405)}
   {:index 84 :volume :ff :path (o/freesound-path 148434)}
   {:index 85 :volume :ff :path (o/freesound-path 148529)}
   {:index 86 :volume :ff :path (o/freesound-path 148515)}
   {:index 87 :volume :ff :path (o/freesound-path 148494)}
   {:index 88 :volume :ff :path (o/freesound-path 148522)}
   {:index 89 :volume :ff :path (o/freesound-path 148508)}
   {:index 90 :volume :ff :path (o/freesound-path 148437)}
   {:index 91 :volume :ff :path (o/freesound-path 148509)}
   {:index 92 :volume :ff :path (o/freesound-path 148471)}
   {:index 93 :volume :ff :path (o/freesound-path 148486)}
   {:index 94 :volume :ff :path (o/freesound-path 148402)}
   {:index 95 :volume :ff :path (o/freesound-path 148406)}
   {:index 96 :volume :ff :path (o/freesound-path 148433)}
   {:index 97 :volume :ff :path (o/freesound-path 148528)}
   {:index 98 :volume :ff :path (o/freesound-path 148516)}
   {:index 99 :volume :ff :path (o/freesound-path 148491)}
   {:index 100 :volume :ff :path (o/freesound-path 148521)}
   {:index 101 :volume :ff :path (o/freesound-path 148507)}
   {:index 102 :volume :ff :path (o/freesound-path 148438)}
   {:index 103 :volume :ff :path (o/freesound-path 148439)}
   {:index 104 :volume :ff :path (o/freesound-path 148478)}
   {:index 105 :volume :ff :path (o/freesound-path 148485)}
   {:index 106 :volume :ff :path (o/freesound-path 148428)}
   {:index 107 :volume :ff :path (o/freesound-path 148403)}
   {:index 108 :volume :ff :path (o/freesound-path 148426)}

   {:index 23 :volume :mf :path (o/freesound-path 148587)}
   {:index 24 :volume :mf :path (o/freesound-path 148554)}
   {:index 25 :volume :mf :path (o/freesound-path 148277)}
   {:index 26 :volume :mf :path (o/freesound-path 148606)}
   {:index 27 :volume :mf :path (o/freesound-path 148570)}
   {:index 28 :volume :mf :path (o/freesound-path 148573)}
   {:index 29 :volume :mf :path (o/freesound-path 148568)}
   {:index 30 :volume :mf :path (o/freesound-path 148596)}
   {:index 31 :volume :mf :path (o/freesound-path 148567)}
   {:index 32 :volume :mf :path (o/freesound-path 148535)}
   {:index 33 :volume :mf :path (o/freesound-path 148534)}
   {:index 34 :volume :mf :path (o/freesound-path 148559)}
   {:index 35 :volume :mf :path (o/freesound-path 148586)}
   {:index 36 :volume :mf :path (o/freesound-path 148601)}
   {:index 37 :volume :mf :path (o/freesound-path 148276)}
   {:index 38 :volume :mf :path (o/freesound-path 148594)}
   {:index 39 :volume :mf :path (o/freesound-path 148597)}
   {:index 40 :volume :mf :path (o/freesound-path 148555)}
   {:index 41 :volume :mf :path (o/freesound-path 148599)}
   {:index 42 :volume :mf :path (o/freesound-path 148578)}
   {:index 43 :volume :mf :path (o/freesound-path 148549)}
   {:index 44 :volume :mf :path (o/freesound-path 148540)}
   {:index 45 :volume :mf :path (o/freesound-path 148533)}
   {:index 46 :volume :mf :path (o/freesound-path 148560)}
   {:index 47 :volume :mf :path (o/freesound-path 148585)}
   {:index 48 :volume :mf :path (o/freesound-path 148600)}
   {:index 49 :volume :mf :path (o/freesound-path 148271)}
   {:index 50 :volume :mf :path (o/freesound-path 148593)}
   {:index 51 :volume :mf :path (o/freesound-path 148592)}
   {:index 52 :volume :mf :path (o/freesound-path 148556)}
   {:index 53 :volume :mf :path (o/freesound-path 148598)}
   {:index 54 :volume :mf :path (o/freesound-path 148544)}
   {:index 55 :volume :mf :path (o/freesound-path 148547)}
   {:index 56 :volume :mf :path (o/freesound-path 148539)}
   {:index 57 :volume :mf :path (o/freesound-path 148532)}
   {:index 58 :volume :mf :path (o/freesound-path 148565)}
   {:index 59 :volume :mf :path (o/freesound-path 148584)}
   {:index 60 :volume :mf :path (o/freesound-path 148603)}
   {:index 61 :volume :mf :path (o/freesound-path 148270)}
   {:index 62 :volume :mf :path (o/freesound-path 148551)}
   {:index 63 :volume :mf :path (o/freesound-path 148588)}
   {:index 64 :volume :mf :path (o/freesound-path 148557)}
   {:index 65 :volume :mf :path (o/freesound-path 148569)}
   {:index 66 :volume :mf :path (o/freesound-path 148576)}
   {:index 67 :volume :mf :path (o/freesound-path 148548)}
   {:index 68 :volume :mf :path (o/freesound-path 148583)}
   {:index 69 :volume :mf :path (o/freesound-path 148531)}
   {:index 70 :volume :mf :path (o/freesound-path 148566)}
   {:index 71 :volume :mf :path (o/freesound-path 148590)}
   {:index 72 :volume :mf :path (o/freesound-path 148602)}
   {:index 73 :volume :mf :path (o/freesound-path 148273)}
   {:index 74 :volume :mf :path (o/freesound-path 148552)}
   {:index 75 :volume :mf :path (o/freesound-path 148574)}
   {:index 76 :volume :mf :path (o/freesound-path 148558)}
   {:index 77 :volume :mf :path (o/freesound-path 148571)}
   {:index 78 :volume :mf :path (o/freesound-path 148545)}
   {:index 79 :volume :mf :path (o/freesound-path 148595)}
   {:index 80 :volume :mf :path (o/freesound-path 148582)}
   {:index 81 :volume :mf :path (o/freesound-path 148538)}
   {:index 82 :volume :mf :path (o/freesound-path 148563)}
   {:index 83 :volume :mf :path (o/freesound-path 148589)}
   {:index 84 :volume :mf :path (o/freesound-path 148605)}
   {:index 85 :volume :mf :path (o/freesound-path 148272)}
   {:index 86 :volume :mf :path (o/freesound-path 148275)}
   {:index 87 :volume :mf :path (o/freesound-path 148579)}
   {:index 88 :volume :mf :path (o/freesound-path 148575)}
   {:index 89 :volume :mf :path (o/freesound-path 148591)}
   {:index 90 :volume :mf :path (o/freesound-path 148541)}
   {:index 91 :volume :mf :path (o/freesound-path 148542)}
   {:index 92 :volume :mf :path (o/freesound-path 148581)}
   {:index 93 :volume :mf :path (o/freesound-path 148537)}
   {:index 94 :volume :mf :path (o/freesound-path 148564)}
   {:index 95 :volume :mf :path (o/freesound-path 148561)}
   {:index 96 :volume :mf :path (o/freesound-path 148604)}
   {:index 97 :volume :mf :path (o/freesound-path 148550)}
   {:index 98 :volume :mf :path (o/freesound-path 148274)}
   {:index 99 :volume :mf :path (o/freesound-path 148543)}
   {:index 100 :volume :mf :path (o/freesound-path 148577)}
   {:index 101 :volume :mf :path (o/freesound-path 148572)}
   {:index 103 :volume :mf :path (o/freesound-path 148546)}
   {:index 104 :volume :mf :path (o/freesound-path 148580)}
   {:index 105 :volume :mf :path (o/freesound-path 148536)}
   {:index 106 :volume :mf :path (o/freesound-path 148553)}
   {:index 107 :volume :mf :path (o/freesound-path 148562)}
   {:index 108 :volume :mf :path (o/freesound-path 148607)}
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
;; 2 buffers (mf,ff) x 128 midi note values
(defonce note-to-sample-id-buffer (o/buffer (* 2 128)))
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
  "reset the buffers when we call init.  allows us to call sampled-piano-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! level-to-offset-buffer     0)
  nil)

;; ======================================================================
;; initialize the piano instrument buffers
(defn sampled-piano-init
  "initialize all things for the piano.  By default, only mf samples will be used."
  [& {:keys [min-note-index max-note-index mf-volume-cutoff]
      :or {min-note-index min-index
           max-note-index max-index
           mf-volume-cutoff 1.0}}]
  (let [load-mf-samples (> mf-volume-cutoff 0.0)
        load-ff-samples (< mf-volume-cutoff 1.0)]
    (reset-buffers)
    (when load-mf-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 0 :mf))
    (when load-ff-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 128 :ff))
    (dotimes [i 21]
      (let [cur-volume (/ i 20.0)
            cur-offset (cond
                        (<= cur-volume mf-volume-cutoff) 0
                        :else 128)]
        (o/buffer-set! level-to-offset-buffer i cur-offset)))
    nil))

;; ======================================================================
;; Initializes the piano banks with the default settings
(println "sampled-piano: initializing default samples...")
;; (time (sampled-piano-init :mf-volume-cutoff 0.85))
(time (sampled-piano-init))
(println "sampled-piano: done.")

