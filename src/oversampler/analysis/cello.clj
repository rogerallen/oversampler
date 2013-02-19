(ns oversampler.analysis.cello
  (:use [oversampler.analysis.analysis])
  (:require [overtone.live :as o]
            [incanter.core :as ico]
            [incanter.charts :as ich]))

;; Notes and code for how the ../cello/bank.clj file was created.
;; Doing a 2nd pass through this to refine the code, the samples and
;; document the process to match with the docs/howto.md 
;;
;; Only looking at the samples that we'll actually use (some extra
;; freesound files are not listed below)
;;
(def temp-sample-path-info
  [ [ (o/note :a3) :ff -31 -40 "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"]
    [ (o/note :d3) :ff -31 -40 "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"]
    [ (o/note :g2) :ff -31 -40 "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"]
    [ (o/note :c2) :ff -31 -40 "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"]
    [ (o/note :a3) :mf -31 -45 "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"]
    [ (o/note :d3) :mf -31 -45 "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"]
    [ (o/note :g2) :mf -31 -45 "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"]
    [ (o/note :c2) :mf -31 -45 "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"]
    [ (o/note :a3) :pp -38 -45 "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"]
    [ (o/note :d3) :pp -38 -45 "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"]
    [ (o/note :g2) :pp -40 -50 "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"]
    [ (o/note :c2) :pp -42 -50 "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"] ])

(comment
  
  ;; To fill in the 3rd & 4th parameters in the table above, do a loop
  ;; through the files iterate i from 0 ... 11 and use add-lines to
  ;; check things out on the repl.
  ;;
  ;; You want the top line (3rd param) to select the number of samples
  ;; and the region where the peak will be found.  The lower line (4th
  ;; param) will define the start & end sample surrounding the peak.
  (do
    (def i 11)
    (def p1 (last (nth temp-sample-path-info i)))
    (println "loading" p1)
    (def s1 (o/load-sample p1))
    (def g1 (view-sample-buffer s1))
    (ich/add-lines g1 [0 500] [-42 -42])
    (ich/add-lines g1 [0 500] [-50 -50]))

  ;; iterate through them all to double-check what you plugged in
  (doseq [[cur-index cur-volume db1 db2 cur-path] temp-sample-path-info]
    (let [_ (println "loading" cur-path)
          s1 (o/load-sample cur-path)
          g1 (view-sample-buffer s1)]
      (ich/add-lines g1 [0 500] [db1 db1])
      (ich/add-lines g1 [0 500] [db2 db2])))

  ;; now you want to get a list of sample-info via
  (print-sample-file-info temp-sample-path-info)

  ;; take the std-output and put that into cello/bank.clj/sample-info-list

  ;; remember to change the :path to use (find-sample-path ...) in
  ;; order to get data from freesound.
  )


