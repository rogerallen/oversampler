(ns oversampler.analysis.ektara
  (:use [oversampler.analysis.analysis])
  (:require [overtone.live :as o]
            [incanter.core :as ico]
            [incanter.charts :as ich]))

;; Notes and code for how the ../ektara/bank.clj file was created.
;;
;; Only looking at the samples that we'll actually use for the ektara
;;
;; Note: guitar strings are [:e2 :a2 :d3 :g3 :b3 :e4]
;; 22222 3333333 4444444 5555555
;; efgab cdefgab cdefgab cdefgab
;;                 EEEEE 
;;             B BB...
;;           GG...
;;        DDD...
;;    AA A...
;; EEE...
(def temp-sample-path-info
  [;;[ (o/note :c5) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sul_E.C5Bb5.aif"]
   [ (o/note :e4) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sul_E.E4B4.aif"]
   ;;[ (o/note :c5) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulB.C5Gb5.aif"]
   [ (o/note :c4) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulB.C4B4.aif"]
   [ (o/note :b3) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulB.B3.aif"]
   ;;[ (o/note :c5) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulG.C5Db5.aif"]
   ;;[ (o/note :c4) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulG.C4B4.aif"]
   [ (o/note :g3) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulG.G3B3.aif"]
   ;;[ (o/note :c4) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulD.C4Ab4.aif"]
   [ (o/note :d3) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulD.D3B3.aif"]
   ;;[ (o/note :c4) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulA.C4E4.aif"]
   [ (o/note :c3) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulA.C3B3.aif"]
   [ (o/note :a2) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulA.A2B2.aif"]
   ;;[ (o/note :c3) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulE.C3B3.aif"]
   [ (o/note :e2) :ff -45 -55 "./src/oversampler/samples/Guitar.ff.sulE.E2B2.aif"]

;; the mf and pp samples are really, really quiet.  going to just use ff for ektara
   
   ;;[ (o/note :c5) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sul_E.C5B5.aif"]
;;   [ (o/note :e4) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sul_E.E4B4.aif"]
   ;;[ (o/note :c5) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulB.C5Gb5.aif"]
;;   [ (o/note :c4) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulB.C4B4.aif"]
;;   [ (o/note :b3) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulB.B3.aif"]
   ;;[ (o/note :c5) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulG.C5Db5.aif"]
   ;;[ (o/note :c4) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulG.C4B4.aif"]
;;   [ (o/note :g3) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulG.G3B3.aif"]
   ;;[ (o/note :c4) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulD.C4Ab4.aif"]
   ;; e and f will need some cleanup.  will e work at all?
;;   [ (o/note :d3) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulD.D3B3.aif"]
   ;;[ (o/note :c4) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulA.C4E4.aif"]
   ;; only using c3 from this one. it'll work
;;   [ (o/note :c3) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulA.C3B3.aif"]
;;   [ (o/note :a2) :mf -40 -55 "./src/oversampler/samples/Guitar.mf.sulA.A2B2.aif"]
   ;;[ (o/note :c3) :mf -45 -55 "./src/oversampler/samples/Guitar.mf.sulE.C3B3.aif"]
;;   [ (o/note :e2) :mf -40 -55 "./src/oversampler/samples/Guitar.mf.sulE.E2B2.aif"]

   ;;[ (o/note :c5) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sul_E.C5B5.aif"]
;;   [ (o/note :e4) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sul_E.E4B4.aif"]
   ;;[ (o/note :c5) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulB.C5Gb5.aif"]
;;   [ (o/note :c4) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulB.C4B4.aif"]
;;   [ (o/note :b3) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulB.B3.aif"]
   ;;[ (o/note :c5) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulG.C5Db5.aif"]
   ;;[ (o/note :c4) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulG.C4B4.aif"]
;;   [ (o/note :g3) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulG.G3B3.aif"]
   ;;[ (o/note :c4) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulD.C4Ab4.aif"]
   ;; ugh this won't work
;;   [ (o/note :d3) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulD.D3B3.aif"]
   ;;[ (o/note :c4) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulA.C4E4.aif"]
   ;; this one will have an extra one.  c# should go across c# and d
;;   [ (o/note :c3) :pp -53 -55 "./src/oversampler/samples/Guitar.pp.sulA.C3B3.aif"]
;;   [ (o/note :a2) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulA.A2B2.aif"]
   ;;[ (o/note :c3) :pp -45 -55 "./src/oversampler/samples/Guitar.pp.sulE.C3B3.aif"]
;;   [ (o/note :e2) :pp -43 -55 "./src/oversampler/samples/Guitar.pp.sulE.E2B2.aif"]
   ])
(comment
  (count temp-sample-path-info) ;; 24
  ;; To fill in the 3rd & 4th parameters in the table above, do a loop
  ;; through the files iterate i from 0 ... 23 and use add-lines to
  ;; check things out on the repl.
  ;;
  ;; You want the top line (3rd param) to select the number of samples
  ;; and the region where the peak will be found.  The lower line (4th
  ;; param) will define the start & end sample surrounding the peak.
  (do
    (def i 17)
    (def p1 (last (nth temp-sample-path-info i)))
    (println "loading" p1)
    (def s1 (o/load-sample p1))
    (def g1 (view-sample-buffer s1 p1))
    (ich/add-lines g1 [0 500] [-45 -45])
    (ich/add-lines g1 [0 500] [-55 -55]))

  ;; iterate through them all to double-check what you plugged in
  (doseq [[cur-index cur-volume db1 db2 cur-path] temp-sample-path-info]
    (let [_ (println "loading" cur-path)
          s1 (o/load-sample cur-path)
          g1 (view-sample-buffer s1 cur-path)]
      (ich/add-lines g1 [0 500] [db1 db1])
      (ich/add-lines g1 [0 500] [db2 db2])))

  ;; now you want to get a list of sample-info via
  (print-sample-file-info temp-sample-path-info)

  ;; take the std-output and put that into cello/bank.clj/sample-info-list

  ;; remember to change the :path to use (find-sample-path ...) in
  ;; order to get data from freesound.
  )


