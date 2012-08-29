(ns oversampler.cello.raw
  (:require [overtone.live :as o]))

;; volume values that the raw values are "close" to and we can normalize to these.  FIXME may need "input" and "output" versions.
(def ff 0.50)
(def mf 0.25)
(def pp 0.15)

;; these are the raw sample paths.
;; FIXME upload to freesound.
;;
;; download http://theremin.music.uiowa.edu/MIScello2012.html Cello.arco.mono.1644.1.zip
;;    and unzip into samples subdirectory
;;
;; diagram of how each string covers the midi range...
;;
;; 2222222 3333333 4444444 5555555
;; cdefgab cdefgab cdefgab cdefgab
;;              aa aaaaaaa aaaaaa
;;          dddddd ddddddd dd
;;     ggg ggggggg ggggg
;; ccccccc ccccccc c
;;
(def sample-paths
  ;; tuple of starting-index, volume(ish), and path(FIXME freesound id)
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


;;(freesound-searchm [:id] "Cello" :f "pack:MIS.Cello2012.Arco.Mono")
;;(freesound-info 164125)
(def freesound-ids
  {"Cello.arco.ff.sulA.A3Ab4.mono.aif" 164125
   "Cello.arco.ff.sulA.A4A5.mono.aif"  164124
   "Cello.arco.ff.sulD.D3Db4.mono.aif" 164129
   "Cello.arco.ff.sulD.D4D5.mono.aif"  164128
   "Cello.arco.ff.sulG.G2Gb3.mono.aif" 164127
   "Cello.arco.ff.sulG.G3D4.mono.aif"  164126
   "Cello.arco.ff.sulC.C2B2.mono.aif"  164123
   "Cello.arco.ff.sulC.C2D3.mono.aif"  164122
   
   "Cello.arco.mf.sulA.A3Ab4.mono.aif" 164131
   "Cello.arco.mf.sulA.A4A5.mono.aif"  164130
   "Cello.arco.mf.sulD.D3Db4.mono.aif" 164137
   "Cello.arco.mf.sulD.D4D5.mono.aif"  164136
   "Cello.arco.mf.sulG.G2Gb3.mono.aif" 164144
   "Cello.arco.mf.sulG.G3G4.mono.aif"  164143
   "Cello.arco.mf.sulC.C2B2.mono.aif"  164140
   "Cello.arco.mf.sulC.C3C4.mono.aif"  164139
   
   "Cello.arco.pp.sulA.A3Ab4.mono.aif" 164142
   "Cello.arco.pp.sulA.A4A5.mono.aif"  164141
   "Cello.arco.pp.sulD.D3Db4.mono.aif" 164134
   "Cello.arco.pp.sulD.D4D5.mono.aif"  164135
   "Cello.arco.pp.sulG.G2Gb3.mono.aif" 164132
   "Cello.arco.pp.sulG.G3G4.mono.aif"  164133
   "Cello.arco.pp.sulC.C2B2.mono.aif"  164146
   "Cello.arco.pp.sulC.C3C4.mono.aif"  164145
   })
