;;
;; code that describes the mapping of raw sample data for use in making a sound bank
;;
(ns oversampler.cello.raw
  (:require [overtone.live :as o]))

;; volume values that the raw values are "close" to and we can
;; normalize to these.
;; FIXME may need "input" and "output" versions?
;; FIXME should these be in "raw"?  should they be keywords?
(def ff 0.50)
(def mf 0.25)
(def pp 0.15)

;; these are the raw sample paths for when data is local & not from the freesound cache.
;;
;; download http://theremin.music.uiowa.edu/MIScello2012.html Cello.arco.mono.1644.1.zip
;;    and unzip into samples subdirectory
;;
;; diagram of how each string covers the midi range...
;;
;; 2222222 3333333 4444444 5555555
;; cdefgab cdefgab cdefgab cdefgab
;;              AA AAAAAAA AAAAAA
;;          DDDDdd ddddddd dd
;;     GGG Ggggggg ggggg
;; CCCcccc ccccccc c
;;
;; capital letters show which samples are actually used.
;; FIXME -- review this usage.  It may be possible to avoid downloading
;;          the 2nd half of all sulC, sulG, sulD data.
;;
(def sample-paths
  ;; tuple of starting-index, volume(ish), and path
  [
   [ (o/note :a3) ff "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) ff "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"]
   [ (o/note :d3) ff "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) ff "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"]
   [ (o/note :g2) ff "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) ff "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"]
   [ (o/note :c2) ff "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"]
   [ (o/note :c3) ff "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"] ;; broken name?
   
   [ (o/note :a3) mf "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) mf "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"]
   [ (o/note :d3) mf "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) mf "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"]
   [ (o/note :g2) mf "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) mf "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"]
   [ (o/note :c2) mf "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"]
   [ (o/note :c3) mf "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"]

   [ (o/note :a3) pp "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"]
   [ (o/note :a4) pp "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"]
   [ (o/note :d3) pp "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"]
   [ (o/note :d4) pp "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"]
   [ (o/note :g2) pp "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"]
   [ (o/note :g3) pp "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"]
   [ (o/note :c2) pp "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"]
   [ (o/note :c3) pp "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"]
   ])

;; these are the raw sample paths for when data is from the freesound cache.
;;
;;(freesound-searchm [:id] "Cello" :f "pack:MIS.Cello2012.Arco.Mono")
;;(freesound-info 164125)
(def freesound-ids
  {"Cello.arco.ff.sulA.A3Ab4.mono.aif" 164125 ; used by default
   "Cello.arco.ff.sulA.A4A5.mono.aif"  164124
   "Cello.arco.ff.sulD.D3Db4.mono.aif" 164129 ; used
   "Cello.arco.ff.sulD.D4D5.mono.aif"  164128
   "Cello.arco.ff.sulG.G2Gb3.mono.aif" 164127 ; used
   "Cello.arco.ff.sulG.G3D4.mono.aif"  164126
   "Cello.arco.ff.sulC.C2B2.mono.aif"  164123 ; used
   "Cello.arco.ff.sulC.C2D3.mono.aif"  164122
   
   "Cello.arco.mf.sulA.A3Ab4.mono.aif" 164131 ; used
   "Cello.arco.mf.sulA.A4A5.mono.aif"  164130
   "Cello.arco.mf.sulD.D3Db4.mono.aif" 164137 ; used
   "Cello.arco.mf.sulD.D4D5.mono.aif"  164136
   "Cello.arco.mf.sulG.G2Gb3.mono.aif" 164144 ; used
   "Cello.arco.mf.sulG.G3G4.mono.aif"  164143
   "Cello.arco.mf.sulC.C2B2.mono.aif"  164140 ; used
   "Cello.arco.mf.sulC.C3C4.mono.aif"  164139
   
   "Cello.arco.pp.sulA.A3Ab4.mono.aif" 164142 ; used
   "Cello.arco.pp.sulA.A4A5.mono.aif"  164141
   "Cello.arco.pp.sulD.D3Db4.mono.aif" 164134 ; used
   "Cello.arco.pp.sulD.D4D5.mono.aif"  164135
   "Cello.arco.pp.sulG.G2Gb3.mono.aif" 164132 ; used
   "Cello.arco.pp.sulG.G3G4.mono.aif"  164133
   "Cello.arco.pp.sulC.C2B2.mono.aif"  164146 ; used
   "Cello.arco.pp.sulC.C3C4.mono.aif"  164145
   })
