(ns oversampler.utils)

;; ======================================================================
;; histogram functions

(defn- in-range
  [min-x max-x x]
  (and (>= x min-x) (< x max-x)))

(defn- find-bin
  [bins bin-delta x]
  (first (drop-while #(not (in-range % (+ % bin-delta) x)) bins)))

(defn bin-list
  "given a min-value, max-value and num-buckets, return a list appropriate for histogram bins"
  [min-value max-value num-buckets]
  (let [delta (- max-value min-value)
        dbucket (/ delta num-buckets)]
    (map #(+ min-value (* dbucket %)) (range num-buckets))))
              
(defn histogram
  "given a list of data and a list of bins, create a histogram sorted-map.
   For data outside the list of bins, use the nil key"
  [data bins]
  (let [h-init (into (apply sorted-map (flatten (map #(vector % 0) bins))) [[nil 0]])
        bin-delta (- (second bins) (first bins))
        data-bins (map #(find-bin bins bin-delta %) data)
        h (reduce #(assoc %1 %2 (inc (%1 %2 0))) h-init data-bins)]
    h))
;;(histogram [1 2 2 3 3 3] [0 1 2 3])

(defn cum-histogram
  "given a histogram, find cumulative frequencies from low-to-high
   not including things in the nil category"
  [histo]
  (apply sorted-map
         (flatten (reductions
                   #(vector (first %2)
                            (if (first %1)
                              (+ (second %1) (second %2))
                              (second %2)))
                   histo))))

(defn norm-cum-histogram
  "given a cum-histogram, normalize all values relative to the total count
   in the last entry of the cum-histogram. Note that the nil entry is
   normalized, but that is a bit bogus since the total does not include
   the nil category."
  [cum-histo]
  (let [max-val (second (last cum-histo))]
    (apply sorted-map
           (flatten (map #(vector (first %)
                                  (float (/ (second %) max-val)))
                         cum-histo)))))

;; ======================================================================
;; smoothstep — perform Hermite interpolation between two values
;; from http://www.opengl.org/sdk/docs/manglsl/xhtml/smoothstep.xml
(defn- clamp
  "clamp x to the range [minx,maxx]"
  [minx maxx x]
  (min (max x minx) maxx))

(defn smoothstep
  "smoothstep performs smooth Hermite interpolation between 0 and 1
   when edge0 < x < edge1. This is useful in cases where a threshold
   function with a smooth transition is desired."
  [edge0 edge1 x]
  (let [t (clamp 0.0 1.0 (/ (- x edge0) (- edge1 edge0)))]
    (* t t (- 3.0 (* 2.0 t)))))

(defn smoothpulse
  "use smoothstep to transition from 0->1 between edge0->1 and 1->0 on
   edge2->3"
  [edge0 edge1 edge2 edge3 x]
  (let [ss0 (smoothstep edge0 edge1 x)
        ss1 (- 1.0 (smoothstep edge2 edge3 x))]
    (* ss0 ss1)))

