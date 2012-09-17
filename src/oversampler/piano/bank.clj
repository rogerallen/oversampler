(ns oversampler.piano.bank
  (:require [overtone.live :as o]
            [oversampler.piano.raw :as raw]))

(def sample-info-list
  [;;{:index 21 :volume raw/ff :path (o/freesound-path 148484)} ; make ff match mf
   ;;{:index 22 :volume raw/ff :path (o/freesound-path 148404)} ; make ff match mf
   {:index 23 :volume raw/ff :path (o/freesound-path 148477)}
   {:index 24 :volume raw/ff :path (o/freesound-path 148427)}
   {:index 25 :volume raw/ff :path (o/freesound-path 148517)}
   {:index 26 :volume raw/ff :path (o/freesound-path 148425)}
   {:index 27 :volume raw/ff :path (o/freesound-path 148497)}
   {:index 28 :volume raw/ff :path (o/freesound-path 148527)}
   {:index 29 :volume raw/ff :path (o/freesound-path 148492)}
   {:index 30 :volume raw/ff :path (o/freesound-path 148440)}
   {:index 31 :volume raw/ff :path (o/freesound-path 148502)}
   {:index 32 :volume raw/ff :path (o/freesound-path 148490)}
   {:index 33 :volume raw/ff :path (o/freesound-path 148483)}
   {:index 34 :volume raw/ff :path (o/freesound-path 148423)}
   {:index 35 :volume raw/ff :path (o/freesound-path 148476)}
   {:index 36 :volume raw/ff :path (o/freesound-path 148430)}
   {:index 37 :volume raw/ff :path (o/freesound-path 148518)}
   {:index 38 :volume raw/ff :path (o/freesound-path 148511)}
   {:index 39 :volume raw/ff :path (o/freesound-path 148498)}
   {:index 40 :volume raw/ff :path (o/freesound-path 148526)}
   {:index 41 :volume raw/ff :path (o/freesound-path 148499)}
   {:index 42 :volume raw/ff :path (o/freesound-path 148441)}
   {:index 43 :volume raw/ff :path (o/freesound-path 148501)}
   {:index 44 :volume raw/ff :path (o/freesound-path 148489)}
   {:index 45 :volume raw/ff :path (o/freesound-path 148482)}
   {:index 46 :volume raw/ff :path (o/freesound-path 148424)}
   {:index 47 :volume raw/ff :path (o/freesound-path 148475)}
   {:index 48 :volume raw/ff :path (o/freesound-path 148429)}
   {:index 49 :volume raw/ff :path (o/freesound-path 148519)}
   {:index 50 :volume raw/ff :path (o/freesound-path 148512)}
   {:index 51 :volume raw/ff :path (o/freesound-path 148495)}
   {:index 52 :volume raw/ff :path (o/freesound-path 148525)}
   {:index 53 :volume raw/ff :path (o/freesound-path 148500)}
   {:index 54 :volume raw/ff :path (o/freesound-path 148442)}
   {:index 55 :volume raw/ff :path (o/freesound-path 148504)}
   {:index 56 :volume raw/ff :path (o/freesound-path 148474)}
   {:index 57 :volume raw/ff :path (o/freesound-path 148481)}
   {:index 58 :volume raw/ff :path (o/freesound-path 148407)}
   {:index 59 :volume raw/ff :path (o/freesound-path 148480)}
   {:index 60 :volume raw/ff :path (o/freesound-path 148432)}
   {:index 61 :volume raw/ff :path (o/freesound-path 148520)}
   {:index 62 :volume raw/ff :path (o/freesound-path 148513)}
   {:index 63 :volume raw/ff :path (o/freesound-path 148496)}
   {:index 64 :volume raw/ff :path (o/freesound-path 148524)}
   {:index 65 :volume raw/ff :path (o/freesound-path 148506)}
   {:index 66 :volume raw/ff :path (o/freesound-path 148435)}
   {:index 67 :volume raw/ff :path (o/freesound-path 148503)}
   {:index 68 :volume raw/ff :path (o/freesound-path 148473)}
   {:index 69 :volume raw/ff :path (o/freesound-path 148488)}
   {:index 70 :volume raw/ff :path (o/freesound-path 148408)}
   {:index 71 :volume raw/ff :path (o/freesound-path 148479)}
   {:index 72 :volume raw/ff :path (o/freesound-path 148431)}
   {:index 73 :volume raw/ff :path (o/freesound-path 148530)}
   {:index 74 :volume raw/ff :path (o/freesound-path 148514)}
   {:index 75 :volume raw/ff :path (o/freesound-path 148493)}
   {:index 76 :volume raw/ff :path (o/freesound-path 148523)}
   {:index 77 :volume raw/ff :path (o/freesound-path 148505)}
   {:index 78 :volume raw/ff :path (o/freesound-path 148436)}
   {:index 79 :volume raw/ff :path (o/freesound-path 148510)}
   {:index 80 :volume raw/ff :path (o/freesound-path 148472)}
   {:index 81 :volume raw/ff :path (o/freesound-path 148487)}
   {:index 82 :volume raw/ff :path (o/freesound-path 148401)}
   {:index 83 :volume raw/ff :path (o/freesound-path 148405)}
   {:index 84 :volume raw/ff :path (o/freesound-path 148434)}
   {:index 85 :volume raw/ff :path (o/freesound-path 148529)}
   {:index 86 :volume raw/ff :path (o/freesound-path 148515)}
   {:index 87 :volume raw/ff :path (o/freesound-path 148494)}
   {:index 88 :volume raw/ff :path (o/freesound-path 148522)}
   {:index 89 :volume raw/ff :path (o/freesound-path 148508)}
   {:index 90 :volume raw/ff :path (o/freesound-path 148437)}
   {:index 91 :volume raw/ff :path (o/freesound-path 148509)}
   {:index 92 :volume raw/ff :path (o/freesound-path 148471)}
   {:index 93 :volume raw/ff :path (o/freesound-path 148486)}
   {:index 94 :volume raw/ff :path (o/freesound-path 148402)}
   {:index 95 :volume raw/ff :path (o/freesound-path 148406)}
   {:index 96 :volume raw/ff :path (o/freesound-path 148433)}
   {:index 97 :volume raw/ff :path (o/freesound-path 148528)}
   {:index 98 :volume raw/ff :path (o/freesound-path 148516)}
   {:index 99 :volume raw/ff :path (o/freesound-path 148491)}
   {:index 100 :volume raw/ff :path (o/freesound-path 148521)}
   {:index 101 :volume raw/ff :path (o/freesound-path 148507)}
   {:index 102 :volume raw/ff :path (o/freesound-path 148438)}
   {:index 103 :volume raw/ff :path (o/freesound-path 148439)}
   {:index 104 :volume raw/ff :path (o/freesound-path 148478)}
   {:index 105 :volume raw/ff :path (o/freesound-path 148485)}
   {:index 106 :volume raw/ff :path (o/freesound-path 148428)}
   {:index 107 :volume raw/ff :path (o/freesound-path 148403)}
   {:index 108 :volume raw/ff :path (o/freesound-path 148426)}

   {:index 23 :volume raw/mf :path (o/freesound-path 148587)}
   {:index 24 :volume raw/mf :path (o/freesound-path 148554)}
   {:index 25 :volume raw/mf :path (o/freesound-path 148277)}
   {:index 26 :volume raw/mf :path (o/freesound-path 148606)}
   {:index 27 :volume raw/mf :path (o/freesound-path 148570)}
   {:index 28 :volume raw/mf :path (o/freesound-path 148573)}
   {:index 29 :volume raw/mf :path (o/freesound-path 148568)}
   {:index 30 :volume raw/mf :path (o/freesound-path 148596)}
   {:index 31 :volume raw/mf :path (o/freesound-path 148567)}
   {:index 32 :volume raw/mf :path (o/freesound-path 148535)}
   {:index 33 :volume raw/mf :path (o/freesound-path 148534)}
   {:index 34 :volume raw/mf :path (o/freesound-path 148559)}
   {:index 35 :volume raw/mf :path (o/freesound-path 148586)}
   {:index 36 :volume raw/mf :path (o/freesound-path 148601)}
   {:index 37 :volume raw/mf :path (o/freesound-path 148276)}
   {:index 38 :volume raw/mf :path (o/freesound-path 148594)}
   {:index 39 :volume raw/mf :path (o/freesound-path 148597)}
   {:index 40 :volume raw/mf :path (o/freesound-path 148555)}
   {:index 41 :volume raw/mf :path (o/freesound-path 148599)}
   {:index 42 :volume raw/mf :path (o/freesound-path 148578)}
   {:index 43 :volume raw/mf :path (o/freesound-path 148549)}
   {:index 44 :volume raw/mf :path (o/freesound-path 148540)}
   {:index 45 :volume raw/mf :path (o/freesound-path 148533)}
   {:index 46 :volume raw/mf :path (o/freesound-path 148560)}
   {:index 47 :volume raw/mf :path (o/freesound-path 148585)}
   {:index 48 :volume raw/mf :path (o/freesound-path 148600)}
   {:index 49 :volume raw/mf :path (o/freesound-path 148271)}
   {:index 50 :volume raw/mf :path (o/freesound-path 148593)}
   {:index 51 :volume raw/mf :path (o/freesound-path 148592)}
   {:index 52 :volume raw/mf :path (o/freesound-path 148556)}
   {:index 53 :volume raw/mf :path (o/freesound-path 148598)}
   {:index 54 :volume raw/mf :path (o/freesound-path 148544)}
   {:index 55 :volume raw/mf :path (o/freesound-path 148547)}
   {:index 56 :volume raw/mf :path (o/freesound-path 148539)}
   {:index 57 :volume raw/mf :path (o/freesound-path 148532)}
   {:index 58 :volume raw/mf :path (o/freesound-path 148565)}
   {:index 59 :volume raw/mf :path (o/freesound-path 148584)}
   {:index 60 :volume raw/mf :path (o/freesound-path 148603)}
   {:index 61 :volume raw/mf :path (o/freesound-path 148270)}
   {:index 62 :volume raw/mf :path (o/freesound-path 148551)}
   {:index 63 :volume raw/mf :path (o/freesound-path 148588)}
   {:index 64 :volume raw/mf :path (o/freesound-path 148557)}
   {:index 65 :volume raw/mf :path (o/freesound-path 148569)}
   {:index 66 :volume raw/mf :path (o/freesound-path 148576)}
   {:index 67 :volume raw/mf :path (o/freesound-path 148548)}
   {:index 68 :volume raw/mf :path (o/freesound-path 148583)}
   {:index 69 :volume raw/mf :path (o/freesound-path 148531)}
   {:index 70 :volume raw/mf :path (o/freesound-path 148566)}
   {:index 71 :volume raw/mf :path (o/freesound-path 148590)}
   {:index 72 :volume raw/mf :path (o/freesound-path 148602)}
   {:index 73 :volume raw/mf :path (o/freesound-path 148273)}
   {:index 74 :volume raw/mf :path (o/freesound-path 148552)}
   {:index 75 :volume raw/mf :path (o/freesound-path 148574)}
   {:index 76 :volume raw/mf :path (o/freesound-path 148558)}
   {:index 77 :volume raw/mf :path (o/freesound-path 148571)}
   {:index 78 :volume raw/mf :path (o/freesound-path 148545)}
   {:index 79 :volume raw/mf :path (o/freesound-path 148595)}
   {:index 80 :volume raw/mf :path (o/freesound-path 148582)}
   {:index 81 :volume raw/mf :path (o/freesound-path 148538)}
   {:index 82 :volume raw/mf :path (o/freesound-path 148563)}
   {:index 83 :volume raw/mf :path (o/freesound-path 148589)}
   {:index 84 :volume raw/mf :path (o/freesound-path 148605)}
   {:index 85 :volume raw/mf :path (o/freesound-path 148272)}
   {:index 86 :volume raw/mf :path (o/freesound-path 148275)}
   {:index 87 :volume raw/mf :path (o/freesound-path 148579)}
   {:index 88 :volume raw/mf :path (o/freesound-path 148575)}
   {:index 89 :volume raw/mf :path (o/freesound-path 148591)}
   {:index 90 :volume raw/mf :path (o/freesound-path 148541)}
   {:index 91 :volume raw/mf :path (o/freesound-path 148542)}
   {:index 92 :volume raw/mf :path (o/freesound-path 148581)}
   {:index 93 :volume raw/mf :path (o/freesound-path 148537)}
   {:index 94 :volume raw/mf :path (o/freesound-path 148564)}
   {:index 95 :volume raw/mf :path (o/freesound-path 148561)}
   {:index 96 :volume raw/mf :path (o/freesound-path 148604)}
   {:index 97 :volume raw/mf :path (o/freesound-path 148550)}
   {:index 98 :volume raw/mf :path (o/freesound-path 148274)}
   {:index 99 :volume raw/mf :path (o/freesound-path 148543)}
   {:index 100 :volume raw/mf :path (o/freesound-path 148577)}
   {:index 101 :volume raw/mf :path (o/freesound-path 148572)}
   {:index 103 :volume raw/mf :path (o/freesound-path 148546)}
   {:index 104 :volume raw/mf :path (o/freesound-path 148580)}
   {:index 105 :volume raw/mf :path (o/freesound-path 148536)}
   {:index 106 :volume raw/mf :path (o/freesound-path 148553)}
   {:index 107 :volume raw/mf :path (o/freesound-path 148562)}
   {:index 108 :volume raw/mf :path (o/freesound-path 148607)}
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
  ([i] (get-sample i raw/ff))
  ([i v]
     (let [sample-info (get-sample-info i v)]
       (if sample-info
         (:sample sample-info)
         nil))))

