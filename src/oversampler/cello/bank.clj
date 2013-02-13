;;
;; code describing the individual sampled notes from the raw samples.
;;
(ns oversampler.cello.bank
  (:use [oversampler.utils])
  (:require [overtone.live :as o]))

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

(defn- find-sample-path
  "given a string key in the freesound-ids map, respond with the path to that file"
  [s]
  (o/freesound-path (freesound-ids s)))

(def sample-info-list
  ;; ordered by low-to-high string C/G/D/A within the volume groups.
  ;; Since there are multiple notes with same index, this allows you
  ;; to grab the first matching index.
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
  ;; capital letters show which samples are actually used.  FIXME --
  ;; It may be possible to avoid downloading the 2nd half of all sulC,
  ;; sulG, sulD data.
  ;;
  ;; NOTE: comments for reducing this to only one matching index,
  ;; we'll avoid downloading useless files to the cache.  anyone
  ;; wanting to play, say, index 60 on the D string would need to
  ;; modify this.
  ;;
  ;; NOTE: commented out samples above index 68.  They were not as
  ;; good as the notes below.
  [
;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif
{:index  57 :volume  :ff :start    88200 :end   383670 :ppeak 0.1103 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  58 :volume  :ff :start   418950 :end   710010 :ppeak 0.1251 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  59 :volume  :ff :start   754110 :end  1045170 :ppeak 0.0845 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  60 :volume  :ff :start  1080450 :end  1358280 :ppeak 0.1169 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  61 :volume  :ff :start  1393560 :end  1680210 :ppeak 0.1238 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.010}
{:index  62 :volume  :ff :start  1719900 :end  2028600 :ppeak 0.0658 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  63 :volume  :ff :start  2059470 :end  2385810 :ppeak 0.0873 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  64 :volume  :ff :start  2425500 :end  2716560 :ppeak 0.0971 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  65 :volume  :ff :start  2734200 :end  2994390 :ppeak 0.0957 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  66 :volume  :ff :start  3029670 :end  3258990 :ppeak 0.1144 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  67 :volume  :ff :start  3303090 :end  3545640 :ppeak 0.0883 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 0.995}
{:index  68 :volume  :ff :start  3598560 :end  3801420 :ppeak 0.1188 :path (find-sample-path "Cello.arco.ff.sulA.A3Ab4.mono.aif") :rate 1.000}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif
;;{:index  69 :volume  :ff :start   123480 :end   449820 :ppeak 0.0668 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :ff :start   489510 :end   771750 :ppeak 0.0781 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :ff :start   807030 :end  1111320 :ppeak 0.0691 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :ff :start  1146600 :end  1415610 :ppeak 0.0954 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :ff :start  1450890 :end  1737540 :ppeak 0.1142 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :ff :start  1772820 :end  2046240 :ppeak 0.0731 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  75 :volume  :ff :start  2081520 :end  2368170 :ppeak 0.0708 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  76 :volume  :ff :start  2407860 :end  2685690 :ppeak 0.0936 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  77 :volume  :ff :start  2720970 :end  3003210 :ppeak 0.0956 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  78 :volume  :ff :start  3038490 :end  3289860 :ppeak 0.0900 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  79 :volume  :ff :start  3325140 :end  3554460 :ppeak 0.0613 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  80 :volume  :ff :start  3589740 :end  3832290 :ppeak 0.0402 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  81 :volume  :ff :start  3867570 :end  4220370 :ppeak 0.0630 :path (find-sample-path "Cello.arco.ff.sulA.A4A5.mono.aif") :rate 1.000}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif
{:index  50 :volume  :ff :start   127890 :end   441000 :ppeak 0.1220 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  51 :volume  :ff :start   476280 :end   784980 :ppeak 0.1424 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  52 :volume  :ff :start   820260 :end  1142190 :ppeak 0.0999 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  53 :volume  :ff :start  1177470 :end  1512630 :ppeak 0.1739 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  54 :volume  :ff :start  1547910 :end  1865430 :ppeak 0.1847 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  55 :volume  :ff :start  1900710 :end  2240280 :ppeak 0.1088 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  56 :volume  :ff :start  2275560 :end  2628360 :ppeak 0.1098 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :ff :start  2663640 :end  2989980 :ppeak 0.1240 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :ff :start  3025260 :end  3311910 :ppeak 0.0840 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :ff :start  3347190 :end  3638250 :ppeak 0.0808 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :ff :start  3673530 :end  3951360 :ppeak 0.0752 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :ff :start  3986640 :end  4233600 :ppeak 0.1235 :path (find-sample-path "Cello.arco.ff.sulD.D3Db4.mono.aif") :rate 1.000}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif
;;{:index  62 :volume  :ff :start   119070 :end   449820 :ppeak 0.0735 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  63 :volume  :ff :start   485100 :end   815850 :ppeak 0.1202 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  64 :volume  :ff :start   851130 :end  1137780 :ppeak 0.1032 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  65 :volume  :ff :start  1173060 :end  1459710 :ppeak 0.1231 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  66 :volume  :ff :start  1494990 :end  1764000 :ppeak 0.1354 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  67 :volume  :ff :start  1799280 :end  2196180 :ppeak 0.1125 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  68 :volume  :ff :start  2231460 :end  2548980 :ppeak 0.0721 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  69 :volume  :ff :start  2584260 :end  3020850 :ppeak 0.0444 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :ff :start  3056130 :end  3382470 :ppeak 0.0542 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :ff :start  3417750 :end  3766140 :ppeak 0.0631 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :ff :start  3801420 :end  4145400 :ppeak 0.0690 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :ff :start  4180680 :end  4498200 :ppeak 0.0687 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :ff :start  4533480 :end  4789260 :ppeak 0.0928 :path (find-sample-path "Cello.arco.ff.sulD.D4D5.mono.aif") :rate 1.000}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif
{:index  43 :volume  :ff :start    39690 :end   427770 :ppeak 0.2414 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  44 :volume  :ff :start   463050 :end   837900 :ppeak 0.1752 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  45 :volume  :ff :start   873180 :end  1212750 :ppeak 0.1595 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  46 :volume  :ff :start  1248030 :end  1587600 :ppeak 0.1771 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  47 :volume  :ff :start  1622880 :end  1984500 :ppeak 0.1386 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  48 :volume  :ff :start  2019780 :end  2399040 :ppeak 0.1270 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  49 :volume  :ff :start  2434320 :end  2791530 :ppeak 0.1600 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  50 :volume  :ff :start  2826810 :end  3175200 :ppeak 0.2007 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  51 :volume  :ff :start  3210480 :end  3563280 :ppeak 0.1543 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  52 :volume  :ff :start  3598560 :end  3916080 :ppeak 0.1539 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  53 :volume  :ff :start  3951360 :end  4299750 :ppeak 0.2335 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  54 :volume  :ff :start  4335030 :end  4555530 :ppeak 0.2327 :path (find-sample-path "Cello.arco.ff.sulG.G2Gb3.mono.aif") :rate 1.000}
;; 8 samples starting at 55. ./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif
;;{:index  55 :volume  :ff :start    30870 :end   401310 :ppeak 0.1682 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  56 :volume  :ff :start   436590 :end   798210 :ppeak 0.1239 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :ff :start   833490 :end  1155420 :ppeak 0.1330 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :ff :start  1190700 :end  1508220 :ppeak 0.1231 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :ff :start  1543500 :end  1861020 :ppeak 0.0899 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :ff :start  1896300 :end  2218230 :ppeak 0.1053 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :ff :start  2253510 :end  2610720 :ppeak 0.0793 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;;{:index  62 :volume  :ff :start  2646000 :end  2906190 :ppeak 0.1303 :path (find-sample-path "Cello.arco.ff.sulG.G3D4.mono.aif") :rate 1.000}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif
{:index  36 :volume  :ff :start    88200 :end   471870 :ppeak 0.2077 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  37 :volume  :ff :start   507150 :end   877590 :ppeak 0.1634 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  38 :volume  :ff :start   912870 :end  1292130 :ppeak 0.1266 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  39 :volume  :ff :start  1327410 :end  1666980 :ppeak 0.1648 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  40 :volume  :ff :start  1702260 :end  2010960 :ppeak 0.1171 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  41 :volume  :ff :start  2046240 :end  2416680 :ppeak 0.2417 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  42 :volume  :ff :start  2451960 :end  2817990 :ppeak 0.2271 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
{:index  43 :volume  :ff :start  2853270 :end  3131100 :ppeak 0.2303 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  44 :volume  :ff :start  3166380 :end  3505950 :ppeak 0.1658 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  45 :volume  :ff :start  3541230 :end  3849930 :ppeak 0.1838 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  46 :volume  :ff :start  3885210 :end  4215960 :ppeak 0.1728 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  47 :volume  :ff :start  4251240 :end  4515840 :ppeak 0.1882 :path (find-sample-path "Cello.arco.ff.sulC.C2B2.mono.aif") :rate 1.000}
;; 15 samples starting at 48. ./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif
;;{:index  48 :volume  :ff :start    92610 :end   471870 :ppeak 0.2077 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  49 :volume  :ff :start   507150 :end   882000 :ppeak 0.1634 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  50 :volume  :ff :start   917280 :end  1292130 :ppeak 0.1392 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  51 :volume  :ff :start  1327410 :end  1671390 :ppeak 0.1647 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  52 :volume  :ff :start  1706670 :end  2015370 :ppeak 0.1172 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  53 :volume  :ff :start  2050650 :end  2421090 :ppeak 0.2417 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  54 :volume  :ff :start  2456370 :end  2822400 :ppeak 0.2272 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  55 :volume  :ff :start  2857680 :end  3135510 :ppeak 0.2303 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  56 :volume  :ff :start  3170790 :end  3510360 :ppeak 0.1658 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  57 :volume  :ff :start  3545640 :end  3854340 :ppeak 0.1838 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  58 :volume  :ff :start  3889620 :end  4220370 :ppeak 0.1728 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  59 :volume  :ff :start  4255650 :end  4595220 :ppeak 0.1738 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  60 :volume  :ff :start  4630500 :end  4974480 :ppeak 0.1391 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  61 :volume  :ff :start  5009760 :end  5331690 :ppeak 0.2514 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}
;;{:index  62 :volume  :ff :start  5366970 :end  5816790 :ppeak 0.2227 :path (find-sample-path "Cello.arco.ff.sulC.C2D3.mono.aif") :rate 1.000}

;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif
{:index  57 :volume  :mf :start    44100 :end   282240 :ppeak 0.0845 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  58 :volume  :mf :start   321930 :end   577710 :ppeak 0.0565 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  59 :volume  :mf :start   626220 :end   899640 :ppeak 0.0632 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  60 :volume  :mf :start   939330 :end  1181880 :ppeak 0.0562 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  61 :volume  :mf :start  1225980 :end  1494990 :ppeak 0.0668 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  62 :volume  :mf :start  1534680 :end  1777230 :ppeak 0.0555 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  63 :volume  :mf :start  1821330 :end  2055060 :ppeak 0.0881 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  64 :volume  :mf :start  2103570 :end  2324070 :ppeak 0.0772 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  65 :volume  :mf :start  2368170 :end  2593080 :ppeak 0.0833 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  66 :volume  :mf :start  2641590 :end  2862090 :ppeak 0.0546 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  67 :volume  :mf :start  2906190 :end  3153150 :ppeak 0.0639 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  68 :volume  :mf :start  3197250 :end  3400110 :ppeak 0.0575 :path (find-sample-path "Cello.arco.mf.sulA.A3Ab4.mono.aif") :rate 1.000}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif
;;{:index  69 :volume  :mf :start    48510 :end   299880 :ppeak 0.0628 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :mf :start   352800 :end   586530 :ppeak 0.0600 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :mf :start   621810 :end   890820 :ppeak 0.0458 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :mf :start   926100 :end  1195110 :ppeak 0.0687 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :mf :start  1234800 :end  1512630 :ppeak 0.0813 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :mf :start  1552320 :end  1812510 :ppeak 0.0617 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  75 :volume  :mf :start  1852200 :end  2152080 :ppeak 0.0385 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  76 :volume  :mf :start  2191770 :end  2443140 :ppeak 0.0526 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  77 :volume  :mf :start  2478420 :end  2751840 :ppeak 0.0343 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  78 :volume  :mf :start  2787120 :end  3025260 :ppeak 0.0398 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  79 :volume  :mf :start  3064950 :end  3294270 :ppeak 0.0402 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  80 :volume  :mf :start  3329550 :end  3541230 :ppeak 0.0493 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  81 :volume  :mf :start  3580920 :end  3841110 :ppeak 0.0443 :path (find-sample-path "Cello.arco.mf.sulA.A4A5.mono.aif") :rate 1.000}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif
{:index  50 :volume  :mf :start    39690 :end   277830 :ppeak 0.1216 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  51 :volume  :mf :start   326340 :end   582120 :ppeak 0.0974 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  52 :volume  :mf :start   630630 :end   912870 :ppeak 0.0776 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  53 :volume  :mf :start   956970 :end  1261260 :ppeak 0.1080 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  54 :volume  :mf :start  1309770 :end  1592010 :ppeak 0.1004 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  55 :volume  :mf :start  1631700 :end  1949220 :ppeak 0.0806 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  56 :volume  :mf :start  1993320 :end  2293200 :ppeak 0.0702 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :mf :start  2337300 :end  2637180 :ppeak 0.0707 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :mf :start  2676870 :end  2937060 :ppeak 0.0539 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :mf :start  2972340 :end  3258990 :ppeak 0.0569 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :mf :start  3298680 :end  3594150 :ppeak 0.0465 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :mf :start  3647070 :end  3863160 :ppeak 0.0797 :path (find-sample-path "Cello.arco.mf.sulD.D3Db4.mono.aif") :rate 1.000}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif
;;{:index  62 :volume  :mf :start    35280 :end   326340 :ppeak 0.0522 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  63 :volume  :mf :start   374850 :end   661500 :ppeak 0.0647 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  64 :volume  :mf :start   705600 :end  1018710 :ppeak 0.0855 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  65 :volume  :mf :start  1058400 :end  1345050 :ppeak 0.0508 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  66 :volume  :mf :start  1380330 :end  1640520 :ppeak 0.0765 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  67 :volume  :mf :start  1680210 :end  1944810 :ppeak 0.0494 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  68 :volume  :mf :start  1984500 :end  2240280 :ppeak 0.0451 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  69 :volume  :mf :start  2288790 :end  2540160 :ppeak 0.0428 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :mf :start  2579850 :end  2848860 :ppeak 0.0474 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :mf :start  2892960 :end  3131100 :ppeak 0.0443 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :mf :start  3166380 :end  3417750 :ppeak 0.0536 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :mf :start  3453030 :end  3713220 :ppeak 0.0604 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :mf :start  3748500 :end  4008690 :ppeak 0.0417 :path (find-sample-path "Cello.arco.mf.sulD.D4D5.mono.aif") :rate 1.000}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif
{:index  43 :volume  :mf :start    44100 :end   348390 :ppeak 0.1486 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  44 :volume  :mf :start   396900 :end   727650 :ppeak 0.0976 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  45 :volume  :mf :start   771750 :end  1089270 :ppeak 0.0785 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  46 :volume  :mf :start  1142190 :end  1437660 :ppeak 0.0895 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  47 :volume  :mf :start  1486170 :end  1772820 :ppeak 0.0747 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  48 :volume  :mf :start  1825740 :end  2174130 :ppeak 0.0635 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  49 :volume  :mf :start  2213820 :end  2526930 :ppeak 0.0738 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  50 :volume  :mf :start  2566620 :end  2870910 :ppeak 0.0814 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  51 :volume  :mf :start  2915010 :end  3188430 :ppeak 0.0876 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  52 :volume  :mf :start  3228120 :end  3523590 :ppeak 0.0601 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  53 :volume  :mf :start  3567690 :end  3894030 :ppeak 0.1214 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  54 :volume  :mf :start  3946950 :end  4163040 :ppeak 0.1241 :path (find-sample-path "Cello.arco.mf.sulG.G2Gb3.mono.aif") :rate 1.000}
;; 13 samples starting at 55. ./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif
;;{:index  55 :volume  :mf :start    44100 :end   291060 :ppeak 0.1573 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  56 :volume  :mf :start   335160 :end   577710 :ppeak 0.0740 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :mf :start   617400 :end   952560 :ppeak 0.0639 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :mf :start   987840 :end  1239210 :ppeak 0.0661 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :mf :start  1278900 :end  1543500 :ppeak 0.0505 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :mf :start  1578780 :end  1878660 :ppeak 0.0422 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :mf :start  1922760 :end  2200590 :ppeak 0.0512 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  62 :volume  :mf :start  2235870 :end  2641590 :ppeak 0.0366 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  63 :volume  :mf :start  2685690 :end  2959110 :ppeak 0.0697 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  64 :volume  :mf :start  2998800 :end  3236940 :ppeak 0.0649 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  65 :volume  :mf :start  3276630 :end  3536820 :ppeak 0.0700 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  66 :volume  :mf :start  3580920 :end  3885210 :ppeak 0.0769 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  67 :volume  :mf :start  3929310 :end  4189500 :ppeak 0.0596 :path (find-sample-path "Cello.arco.mf.sulG.G3G4.mono.aif") :rate 1.000}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif
{:index  36 :volume  :mf :start    39690 :end   480690 :ppeak 0.0900 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  37 :volume  :mf :start   524790 :end   934920 :ppeak 0.1032 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  38 :volume  :mf :start   974610 :end  1384740 :ppeak 0.0558 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  39 :volume  :mf :start  1424430 :end  1812510 :ppeak 0.1043 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  40 :volume  :mf :start  1856610 :end  2213820 :ppeak 0.0517 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  41 :volume  :mf :start  2253510 :end  2646000 :ppeak 0.1117 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
{:index  42 :volume  :mf :start  2685690 :end  3038490 :ppeak 0.1309 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  43 :volume  :mf :start  3078180 :end  3444210 :ppeak 0.1527 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  44 :volume  :mf :start  3483900 :end  3819060 :ppeak 0.0932 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  45 :volume  :mf :start  3858750 :end  4193910 :ppeak 0.0782 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  46 :volume  :mf :start  4242420 :end  4687830 :ppeak 0.0892 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  47 :volume  :mf :start  4727520 :end  4987710 :ppeak 0.0744 :path (find-sample-path "Cello.arco.mf.sulC.C2B2.mono.aif") :rate 1.000}
;; 13 samples starting at 48. ./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif
;;{:index  48 :volume  :mf :start    44100 :end   366030 :ppeak 0.0697 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  49 :volume  :mf :start   410130 :end   798210 :ppeak 0.1073 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  50 :volume  :mf :start   837900 :end  1173060 :ppeak 0.0567 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  51 :volume  :mf :start  1208340 :end  1543500 :ppeak 0.0800 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  52 :volume  :mf :start  1578780 :end  1887480 :ppeak 0.0656 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  53 :volume  :mf :start  1922760 :end  2249100 :ppeak 0.1234 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  54 :volume  :mf :start  2284380 :end  2619540 :ppeak 0.0908 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  55 :volume  :mf :start  2654820 :end  2994390 :ppeak 0.0625 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  56 :volume  :mf :start  3034080 :end  3316320 :ppeak 0.0507 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :mf :start  3356010 :end  3642660 :ppeak 0.0590 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :mf :start  3682350 :end  3964590 :ppeak 0.0471 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :mf :start  4004280 :end  4290930 :ppeak 0.0487 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :mf :start  4326210 :end  4652550 :ppeak 0.0330 :path (find-sample-path "Cello.arco.mf.sulC.C3C4.mono.aif") :rate 1.000}

;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif
{:index  57 :volume  :pp :start    30870 :end   286650 :ppeak 0.0393 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  58 :volume  :pp :start   330750 :end   621810 :ppeak 0.0296 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  59 :volume  :pp :start   661500 :end   961380 :ppeak 0.0271 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  60 :volume  :pp :start  1005480 :end  1252440 :ppeak 0.0368 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  61 :volume  :pp :start  1296540 :end  1539090 :ppeak 0.0313 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  62 :volume  :pp :start  1592010 :end  1843380 :ppeak 0.0320 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  63 :volume  :pp :start  1883070 :end  2156490 :ppeak 0.0357 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  64 :volume  :pp :start  2196180 :end  2447550 :ppeak 0.0296 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 0.990}
{:index  65 :volume  :pp :start  2500470 :end  2729790 :ppeak 0.0328 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  66 :volume  :pp :start  2769480 :end  3029670 :ppeak 0.0359 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
{:index  67 :volume  :pp :start  3069360 :end  3329550 :ppeak 0.0329 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 0.985}
{:index  68 :volume  :pp :start  3373650 :end  3594150 :ppeak 0.0365 :path (find-sample-path "Cello.arco.pp.sulA.A3Ab4.mono.aif") :rate 1.000}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif
;;{:index  69 :volume  :pp :start    39690 :end   295470 :ppeak 0.0316 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :pp :start   335160 :end   590940 :ppeak 0.0294 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :pp :start   635040 :end   882000 :ppeak 0.0260 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :pp :start   917280 :end  1203930 :ppeak 0.0213 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :pp :start  1248030 :end  1525860 :ppeak 0.0379 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :pp :start  1561140 :end  1847790 :ppeak 0.0242 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  75 :volume  :pp :start  1887480 :end  2174130 :ppeak 0.0218 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  76 :volume  :pp :start  2209410 :end  2562210 :ppeak 0.0208 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  77 :volume  :pp :start  2601900 :end  2906190 :ppeak 0.0229 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  78 :volume  :pp :start  2941470 :end  3188430 :ppeak 0.0257 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  79 :volume  :pp :start  3223710 :end  3483900 :ppeak 0.0252 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  80 :volume  :pp :start  3536820 :end  3797010 :ppeak 0.0293 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;;{:index  81 :volume  :pp :start  3832290 :end  4136580 :ppeak 0.0231 :path (find-sample-path "Cello.arco.pp.sulA.A4A5.mono.aif") :rate 1.000}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif
{:index  50 :volume  :pp :start    44100 :end   273420 :ppeak 0.0424 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  51 :volume  :pp :start   286650 :end   542430 :ppeak 0.0468 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  52 :volume  :pp :start   560070 :end   833490 :ppeak 0.0282 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  53 :volume  :pp :start   864360 :end  1115730 :ppeak 0.0418 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  54 :volume  :pp :start  1155420 :end  1406790 :ppeak 0.0445 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  55 :volume  :pp :start  1442070 :end  1666980 :ppeak 0.0602 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
{:index  56 :volume  :pp :start  1693440 :end  1935990 :ppeak 0.0328 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :pp :start  1966860 :end  2178540 :ppeak 0.0320 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :pp :start  2218230 :end  2443140 :ppeak 0.0253 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :pp :start  2474010 :end  2712150 :ppeak 0.0283 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :pp :start  2769480 :end  2994390 :ppeak 0.0236 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :pp :start  3042900 :end  3254580 :ppeak 0.0309 :path (find-sample-path "Cello.arco.pp.sulD.D3Db4.mono.aif") :rate 1.000}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif
;;{:index  62 :volume  :pp :start    30870 :end   273420 :ppeak 0.0281 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  63 :volume  :pp :start   295470 :end   546840 :ppeak 0.0322 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  64 :volume  :pp :start   630630 :end   842310 :ppeak 0.0340 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  65 :volume  :pp :start   882000 :end  1093680 :ppeak 0.0289 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  66 :volume  :pp :start  1151010 :end  1420020 :ppeak 0.0528 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  67 :volume  :pp :start  1437660 :end  1680210 :ppeak 0.0265 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  68 :volume  :pp :start  1728720 :end  1944810 :ppeak 0.0235 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  69 :volume  :pp :start  1993320 :end  2240280 :ppeak 0.0236 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  70 :volume  :pp :start  2275560 :end  2478420 :ppeak 0.0267 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  71 :volume  :pp :start  2531340 :end  2729790 :ppeak 0.0250 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  72 :volume  :pp :start  2787120 :end  2985570 :ppeak 0.0250 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  73 :volume  :pp :start  3042900 :end  3272220 :ppeak 0.0328 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;;{:index  74 :volume  :pp :start  3298680 :end  3519180 :ppeak 0.0241 :path (find-sample-path "Cello.arco.pp.sulD.D4D5.mono.aif") :rate 1.000}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif
{:index  43 :volume  :pp :start    70560 :end   330750 :ppeak 0.0711 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  44 :volume  :pp :start   352800 :end   595350 :ppeak 0.0515 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  45 :volume  :pp :start   621810 :end   877590 :ppeak 0.0373 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  46 :volume  :pp :start   921690 :end  1146600 :ppeak 0.0376 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  47 :volume  :pp :start  1199520 :end  1411200 :ppeak 0.0355 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  48 :volume  :pp :start  1446480 :end  1662570 :ppeak 0.0326 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
{:index  49 :volume  :pp :start  1715490 :end  1940400 :ppeak 0.0300 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  50 :volume  :pp :start  1984500 :end  2196180 :ppeak 0.0367 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  51 :volume  :pp :start  2231460 :end  2443140 :ppeak 0.0429 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  52 :volume  :pp :start  2474010 :end  2707740 :ppeak 0.0289 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  53 :volume  :pp :start  2751840 :end  2994390 :ppeak 0.0499 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;;{:index  54 :volume  :pp :start  3029670 :end  3276630 :ppeak 0.0574 :path (find-sample-path "Cello.arco.pp.sulG.G2Gb3.mono.aif") :rate 1.000}
;; 13 samples starting at 55. ./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif
;;{:index  55 :volume  :pp :start    52920 :end   286650 :ppeak 0.0470 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  56 :volume  :pp :start   339570 :end   564480 :ppeak 0.0284 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :pp :start   630630 :end   868770 :ppeak 0.0291 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :pp :start   899640 :end  1186290 :ppeak 0.0304 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :pp :start  1243620 :end  1433250 :ppeak 0.0478 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  60 :volume  :pp :start  1459710 :end  1671390 :ppeak 0.0264 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  61 :volume  :pp :start  1715490 :end  1913940 :ppeak 0.0340 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  62 :volume  :pp :start  1958040 :end  2169720 :ppeak 0.0352 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  63 :volume  :pp :start  2205000 :end  2385810 :ppeak 0.0318 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  64 :volume  :pp :start  2421090 :end  2641590 :ppeak 0.0407 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  65 :volume  :pp :start  2654820 :end  2862090 :ppeak 0.0258 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  66 :volume  :pp :start  2906190 :end  3148740 :ppeak 0.0387 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;;{:index  67 :volume  :pp :start  3197250 :end  3475080 :ppeak 0.0329 :path (find-sample-path "Cello.arco.pp.sulG.G3G4.mono.aif") :rate 1.000}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif
{:index  36 :volume  :pp :start    39690 :end   317520 :ppeak 0.0349 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  37 :volume  :pp :start   352800 :end   652680 :ppeak 0.0421 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  38 :volume  :pp :start   692370 :end   992250 :ppeak 0.0265 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  39 :volume  :pp :start  1036350 :end  1327410 :ppeak 0.0393 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  40 :volume  :pp :start  1362690 :end  1675800 :ppeak 0.0236 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  41 :volume  :pp :start  1719900 :end  1997730 :ppeak 0.0698 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
{:index  42 :volume  :pp :start  2050650 :end  2328480 :ppeak 0.0727 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  43 :volume  :pp :start  2372580 :end  2663640 :ppeak 0.0802 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  44 :volume  :pp :start  2707740 :end  2985570 :ppeak 0.0512 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  45 :volume  :pp :start  3025260 :end  3338370 :ppeak 0.0379 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  46 :volume  :pp :start  3378060 :end  3669120 :ppeak 0.0375 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;;{:index  47 :volume  :pp :start  3717630 :end  3951360 :ppeak 0.0475 :path (find-sample-path "Cello.arco.pp.sulC.C2B2.mono.aif") :rate 1.000}
;; 12 samples starting at 48. ./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif
;;{:index  48 :volume  :pp :start    39690 :end   326340 :ppeak 0.0311 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  49 :volume  :pp :start   361620 :end   665910 :ppeak 0.0398 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  50 :volume  :pp :start   710010 :end   979020 :ppeak 0.0350 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  51 :volume  :pp :start  1023120 :end  1296540 :ppeak 0.0451 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  52 :volume  :pp :start  1340640 :end  1627290 :ppeak 0.0627 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  53 :volume  :pp :start  1671390 :end  1909530 :ppeak 0.0619 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  54 :volume  :pp :start  1953630 :end  2218230 :ppeak 0.0407 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  55 :volume  :pp :start  2257920 :end  2522520 :ppeak 0.0366 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  56 :volume  :pp :start  2562210 :end  2862090 :ppeak 0.0278 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  57 :volume  :pp :start  2901780 :end  3153150 :ppeak 0.0281 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  58 :volume  :pp :start  3188430 :end  3470670 :ppeak 0.0202 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
;;{:index  59 :volume  :pp :start  3510360 :end  3849930 :ppeak 0.0239 :path (find-sample-path "Cello.arco.pp.sulC.C3C4.mono.aif") :rate 1.000}
   ])

;; similar to sampled_piano.clj...
(defn- get-unique-sample-info-map
  "return map of sample-info, filtered by volume and selecting only
  one sample per index. map key is :index"
  [matching-volume]
  (let [mv-info (filter #(= matching-volume (:volume %)) sample-info-list)
        mv-indexed (group-by :index mv-info)
        unique-mv-info (group-by :index (map #(first (second %)) (sort mv-indexed)))]
    unique-mv-info))

(defn- get-sample-info-map
  "return map of sample-info. map key is :index"
  []
  (let [unique-pp-info (get-unique-sample-info-map :pp)
        unique-mf-info (get-unique-sample-info-map :mf)
        unique-ff-info (get-unique-sample-info-map :ff)
        sample-info-map (merge-with concat unique-pp-info unique-mf-info unique-ff-info)]
    sample-info-map))

(defn- adjust-sample
  "smoothly adjust the samples to start from 0 and end at 0 and have
  scaled ppeak value matching the buffer-volume"
  [sample-offset buffer-size buffer-volume buffer-ppeak index value]
  (let [smooth-value (* value (smoothpulse 0 sample-offset (- buffer-size sample-offset) buffer-size index))
        scaled-value (* smooth-value (/ buffer-volume buffer-ppeak))]
    scaled-value))

(defn- load-sample-into-info
  "given an info map of the sample, load & add the sample"
  [x]
  (let [the-size (- (:end x) (:start x))
        ;; _ (println "load sample..." (:end x) (:start x) (:path x))
        the-buffer (o/load-sample (:path x) :start (:start x) :size the-size)
        ;; this is an interesting idea, but takes WAAY too long.  Going to try either:
        ;; 1) envelope to accomplish the same
        ;; 2) prepare these samples into files
        ;; sample-rate (:rate (o/buffer-info the-buffer))
        ;; sample-offset (int (* 2 (/ sample-rate 10)))
        ;; ;; adjust the samples to have a smooth start & end.  
        ;; _ (println "process sample")
        ;; the-samples (map-indexed #(adjust-sample sample-offset the-size (:volume x) (:ppeak x) %1 %2) (o/buffer-data the-buffer))
        ;; _ (println "write sample")
        ;; _ (buffer-write-relay! the-buffer the-samples)
        ;; _ (println "done.")
        ]
    (assoc x :sample the-buffer)))

(defn- load-samples-into-infos
  "given a key value tuple where the value is an array of sample-info, load samples"
  [xs]
  (map load-sample-into-info xs))

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
  ([i] (get-sample i :ff))
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
;; buffer of scaling values for note ctl to index through
(defonce note-to-level-scale-buffer (o/buffer (* 3 128)))
;; buffer of sample-lengths for note ctl to index through
(defonce note-to-length-buffer (o/buffer (* 3 128)))
;; buffer of rates for note ctl to index through
(defonce note-to-rate-buffer (o/buffer (* 3 128)))
;; buffer of buffer-offsets for level to index through.
;; 0 = pp, 128 = mf, 256 = ff
(defonce level-to-offset-buffer (o/buffer 21))

;; ======================================================================
;; buffer filling routines
(defn- fill-buffer-sample-ids
  "fill 128 sample-ids in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:id (get-sample i volume))))))

(defn- fill-buffer-scaling-factors
  "fill 128 level-scaling-factors in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf (+ offset i) (/ 2.0 (:ppeak (get-sample-info i volume)))))))

(defn- fill-buffer-lengths
  "fill 128 length (in seconds) in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (let [the-info (get-sample-info i volume)
            the-length (- (:end the-info) (:start the-info))
            the-rate (:rate (:sample the-info))
            length-in-secs (/ the-length the-rate)] 
        (o/buffer-set! buf (+ offset i) length-in-secs)))))

(defn- fill-buffer-rates
  "fill 128 rates in buf starting at offset for a particular volume (pp, mf, ff)"
  [buf offset volume]
  (dotimes [i 128]
    (if (get-sample i volume)
      (o/buffer-set! buf (+ offset i) (:rate (get-sample-info i volume))))))

(defn- reset-buffers
  "reset the buffers when we call init.  allows us to call sampled-cello-init multiple times"
  []
  (o/buffer-fill! note-to-sample-id-buffer   (:id silent-buffer))
  (o/buffer-fill! note-to-level-scale-buffer 1.0)
  (o/buffer-fill! note-to-length-buffer      0.0)
  (o/buffer-fill! note-to-rate-buffer        1.0)
  (o/buffer-fill! level-to-offset-buffer     0)
  nil)

;; ======================================================================
;; initialize the cello instrument buffers
(defn sampled-cello-init
  "initialize all things for the cello.  By default, only mf samples will be used."
  [& {:keys [min-note-index max-note-index pp-volume-cutoff mf-volume-cutoff]
      :or {min-note-index min-index
           max-note-index max-index
           pp-volume-cutoff 0.0
           mf-volume-cutoff 1.0}}]
  (let [load-pp-samples (> pp-volume-cutoff 0.0)
        load-mf-samples (> mf-volume-cutoff 0.0)
        load-ff-samples (< mf-volume-cutoff 1.0)]
    (reset-buffers)
    (when load-pp-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 0 :pp)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 0 :pp)
      (fill-buffer-lengths note-to-length-buffer 0 :pp)
      (fill-buffer-rates note-to-rate-buffer 0 :pp))
    (when load-mf-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 128 :mf)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 128 :mf)
      (fill-buffer-lengths note-to-length-buffer 128 :mf)
      (fill-buffer-rates note-to-rate-buffer 128 :mf))
    (when load-ff-samples
      (fill-buffer-sample-ids note-to-sample-id-buffer 256 :ff)
      (fill-buffer-scaling-factors note-to-level-scale-buffer 256 :ff)
      (fill-buffer-lengths note-to-length-buffer 256 :ff)
      (fill-buffer-rates note-to-rate-buffer 256 :ff))
    (dotimes [i 21]
      (let [cur-volume (/ i 20.0)
            cur-offset (cond
                        (< cur-volume pp-volume-cutoff) 0
                        (<= cur-volume mf-volume-cutoff) 128
                        :else 256)]
        (o/buffer-set! level-to-offset-buffer i cur-offset)))
    nil))

;; ======================================================================
;; Initializes the cello banks with the default settings
(println "sampled-cello: initializing default samples...")
(time (sampled-cello-init))
(println "sampled-cello: done.")

