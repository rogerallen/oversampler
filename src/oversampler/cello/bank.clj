(ns oversampler.cello.bank
  (:use [oversampler.utils])
  (:require [overtone.live :as o]
            [oversampler.cello.raw :as raw]))

(def sample-info-list
  ;; ordered by low-to-high string C/G/D/A within the volume groups.
  ;; Since there are multiple notes with same index, this allows you
  ;; to grab the first matching index.
  [
;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif
{:index  57 :volume  raw/ff :start    88200 :end   383670 :ppeak 0.1103 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  raw/ff :start   418950 :end   710010 :ppeak 0.1251 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  raw/ff :start   754110 :end  1045170 :ppeak 0.0845 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  raw/ff :start  1080450 :end  1358280 :ppeak 0.1169 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  raw/ff :start  1393560 :end  1680210 :ppeak 0.1238 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  raw/ff :start  1719900 :end  2028600 :ppeak 0.0658 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  raw/ff :start  2059470 :end  2385810 :ppeak 0.0873 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  raw/ff :start  2425500 :end  2716560 :ppeak 0.0971 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  raw/ff :start  2734200 :end  2994390 :ppeak 0.0957 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  raw/ff :start  3029670 :end  3258990 :ppeak 0.1144 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  raw/ff :start  3303090 :end  3545640 :ppeak 0.0883 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  raw/ff :start  3598560 :end  3801420 :ppeak 0.1188 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif
{:index  69 :volume  raw/ff :start   123480 :end   449820 :ppeak 0.0668 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  70 :volume  raw/ff :start   489510 :end   771750 :ppeak 0.0781 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  71 :volume  raw/ff :start   807030 :end  1111320 :ppeak 0.0691 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  72 :volume  raw/ff :start  1146600 :end  1415610 :ppeak 0.0954 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  73 :volume  raw/ff :start  1450890 :end  1737540 :ppeak 0.1142 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  74 :volume  raw/ff :start  1772820 :end  2046240 :ppeak 0.0731 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  75 :volume  raw/ff :start  2081520 :end  2368170 :ppeak 0.0708 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  76 :volume  raw/ff :start  2407860 :end  2685690 :ppeak 0.0936 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  77 :volume  raw/ff :start  2720970 :end  3003210 :ppeak 0.0956 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  78 :volume  raw/ff :start  3038490 :end  3289860 :ppeak 0.0900 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  79 :volume  raw/ff :start  3325140 :end  3554460 :ppeak 0.0613 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  80 :volume  raw/ff :start  3589740 :end  3832290 :ppeak 0.0402 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  81 :volume  raw/ff :start  3867570 :end  4220370 :ppeak 0.0630 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif
{:index  50 :volume  raw/ff :start   127890 :end   441000 :ppeak 0.1220 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  51 :volume  raw/ff :start   476280 :end   784980 :ppeak 0.1424 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  52 :volume  raw/ff :start   820260 :end  1142190 :ppeak 0.0999 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  53 :volume  raw/ff :start  1177470 :end  1512630 :ppeak 0.1739 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  54 :volume  raw/ff :start  1547910 :end  1865430 :ppeak 0.1847 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  55 :volume  raw/ff :start  1900710 :end  2240280 :ppeak 0.1088 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  56 :volume  raw/ff :start  2275560 :end  2628360 :ppeak 0.1098 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  57 :volume  raw/ff :start  2663640 :end  2989980 :ppeak 0.1240 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  58 :volume  raw/ff :start  3025260 :end  3311910 :ppeak 0.0840 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  59 :volume  raw/ff :start  3347190 :end  3638250 :ppeak 0.0808 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  60 :volume  raw/ff :start  3673530 :end  3951360 :ppeak 0.0752 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  61 :volume  raw/ff :start  3986640 :end  4233600 :ppeak 0.1235 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif
{:index  62 :volume  raw/ff :start   119070 :end   449820 :ppeak 0.0735 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  63 :volume  raw/ff :start   485100 :end   815850 :ppeak 0.1202 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  64 :volume  raw/ff :start   851130 :end  1137780 :ppeak 0.1032 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  65 :volume  raw/ff :start  1173060 :end  1459710 :ppeak 0.1231 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  66 :volume  raw/ff :start  1494990 :end  1764000 :ppeak 0.1354 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  67 :volume  raw/ff :start  1799280 :end  2196180 :ppeak 0.1125 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  68 :volume  raw/ff :start  2231460 :end  2548980 :ppeak 0.0721 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  69 :volume  raw/ff :start  2584260 :end  3020850 :ppeak 0.0444 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  70 :volume  raw/ff :start  3056130 :end  3382470 :ppeak 0.0542 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  71 :volume  raw/ff :start  3417750 :end  3766140 :ppeak 0.0631 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  72 :volume  raw/ff :start  3801420 :end  4145400 :ppeak 0.0690 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  73 :volume  raw/ff :start  4180680 :end  4498200 :ppeak 0.0687 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  74 :volume  raw/ff :start  4533480 :end  4789260 :ppeak 0.0928 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif
{:index  43 :volume  raw/ff :start    39690 :end   427770 :ppeak 0.2414 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  raw/ff :start   463050 :end   837900 :ppeak 0.1752 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  raw/ff :start   873180 :end  1212750 :ppeak 0.1595 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  raw/ff :start  1248030 :end  1587600 :ppeak 0.1771 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  raw/ff :start  1622880 :end  1984500 :ppeak 0.1386 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  raw/ff :start  2019780 :end  2399040 :ppeak 0.1270 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  raw/ff :start  2434320 :end  2791530 :ppeak 0.1600 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  raw/ff :start  2826810 :end  3175200 :ppeak 0.2007 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  raw/ff :start  3210480 :end  3563280 :ppeak 0.1543 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  raw/ff :start  3598560 :end  3916080 :ppeak 0.1539 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  raw/ff :start  3951360 :end  4299750 :ppeak 0.2335 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  raw/ff :start  4335030 :end  4555530 :ppeak 0.2327 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
;; 8 samples starting at 55. ./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif
{:index  55 :volume  raw/ff :start    30870 :end   401310 :ppeak 0.1682 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  56 :volume  raw/ff :start   436590 :end   798210 :ppeak 0.1239 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  57 :volume  raw/ff :start   833490 :end  1155420 :ppeak 0.1330 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  58 :volume  raw/ff :start  1190700 :end  1508220 :ppeak 0.1231 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  59 :volume  raw/ff :start  1543500 :end  1861020 :ppeak 0.0899 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  60 :volume  raw/ff :start  1896300 :end  2218230 :ppeak 0.1053 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  61 :volume  raw/ff :start  2253510 :end  2610720 :ppeak 0.0793 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  62 :volume  raw/ff :start  2646000 :end  2906190 :ppeak 0.1303 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif
{:index  36 :volume  raw/ff :start    88200 :end   471870 :ppeak 0.2077 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  37 :volume  raw/ff :start   507150 :end   877590 :ppeak 0.1634 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  38 :volume  raw/ff :start   912870 :end  1292130 :ppeak 0.1266 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  39 :volume  raw/ff :start  1327410 :end  1666980 :ppeak 0.1648 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  40 :volume  raw/ff :start  1702260 :end  2010960 :ppeak 0.1171 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  41 :volume  raw/ff :start  2046240 :end  2416680 :ppeak 0.2417 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  42 :volume  raw/ff :start  2451960 :end  2817990 :ppeak 0.2271 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  43 :volume  raw/ff :start  2853270 :end  3131100 :ppeak 0.2303 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  44 :volume  raw/ff :start  3166380 :end  3505950 :ppeak 0.1658 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  45 :volume  raw/ff :start  3541230 :end  3849930 :ppeak 0.1838 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  46 :volume  raw/ff :start  3885210 :end  4215960 :ppeak 0.1728 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  47 :volume  raw/ff :start  4251240 :end  4515840 :ppeak 0.1882 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
;; 15 samples starting at 48. ./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif
{:index  48 :volume  raw/ff :start    92610 :end   471870 :ppeak 0.2077 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  49 :volume  raw/ff :start   507150 :end   882000 :ppeak 0.1634 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  50 :volume  raw/ff :start   917280 :end  1292130 :ppeak 0.1392 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  51 :volume  raw/ff :start  1327410 :end  1671390 :ppeak 0.1647 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  52 :volume  raw/ff :start  1706670 :end  2015370 :ppeak 0.1172 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  53 :volume  raw/ff :start  2050650 :end  2421090 :ppeak 0.2417 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  54 :volume  raw/ff :start  2456370 :end  2822400 :ppeak 0.2272 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  55 :volume  raw/ff :start  2857680 :end  3135510 :ppeak 0.2303 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  56 :volume  raw/ff :start  3170790 :end  3510360 :ppeak 0.1658 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  57 :volume  raw/ff :start  3545640 :end  3854340 :ppeak 0.1838 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  58 :volume  raw/ff :start  3889620 :end  4220370 :ppeak 0.1728 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  59 :volume  raw/ff :start  4255650 :end  4595220 :ppeak 0.1738 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  60 :volume  raw/ff :start  4630500 :end  4974480 :ppeak 0.1391 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  61 :volume  raw/ff :start  5009760 :end  5331690 :ppeak 0.2514 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  62 :volume  raw/ff :start  5366970 :end  5816790 :ppeak 0.2227 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif
{:index  57 :volume  raw/mf :start    44100 :end   282240 :ppeak 0.0845 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  raw/mf :start   321930 :end   577710 :ppeak 0.0565 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  raw/mf :start   626220 :end   899640 :ppeak 0.0632 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  raw/mf :start   939330 :end  1181880 :ppeak 0.0562 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  raw/mf :start  1225980 :end  1494990 :ppeak 0.0668 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  raw/mf :start  1534680 :end  1777230 :ppeak 0.0555 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  raw/mf :start  1821330 :end  2055060 :ppeak 0.0881 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  raw/mf :start  2103570 :end  2324070 :ppeak 0.0772 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  raw/mf :start  2368170 :end  2593080 :ppeak 0.0833 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  raw/mf :start  2641590 :end  2862090 :ppeak 0.0546 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  raw/mf :start  2906190 :end  3153150 :ppeak 0.0639 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  raw/mf :start  3197250 :end  3400110 :ppeak 0.0575 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif
{:index  69 :volume  raw/mf :start    48510 :end   299880 :ppeak 0.0628 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  70 :volume  raw/mf :start   352800 :end   586530 :ppeak 0.0600 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  71 :volume  raw/mf :start   621810 :end   890820 :ppeak 0.0458 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  72 :volume  raw/mf :start   926100 :end  1195110 :ppeak 0.0687 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  73 :volume  raw/mf :start  1234800 :end  1512630 :ppeak 0.0813 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  74 :volume  raw/mf :start  1552320 :end  1812510 :ppeak 0.0617 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  75 :volume  raw/mf :start  1852200 :end  2152080 :ppeak 0.0385 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  76 :volume  raw/mf :start  2191770 :end  2443140 :ppeak 0.0526 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  77 :volume  raw/mf :start  2478420 :end  2751840 :ppeak 0.0343 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  78 :volume  raw/mf :start  2787120 :end  3025260 :ppeak 0.0398 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  79 :volume  raw/mf :start  3064950 :end  3294270 :ppeak 0.0402 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  80 :volume  raw/mf :start  3329550 :end  3541230 :ppeak 0.0493 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  81 :volume  raw/mf :start  3580920 :end  3841110 :ppeak 0.0443 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif
{:index  50 :volume  raw/mf :start    39690 :end   277830 :ppeak 0.1216 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  51 :volume  raw/mf :start   326340 :end   582120 :ppeak 0.0974 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  52 :volume  raw/mf :start   630630 :end   912870 :ppeak 0.0776 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  53 :volume  raw/mf :start   956970 :end  1261260 :ppeak 0.1080 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  54 :volume  raw/mf :start  1309770 :end  1592010 :ppeak 0.1004 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  55 :volume  raw/mf :start  1631700 :end  1949220 :ppeak 0.0806 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  56 :volume  raw/mf :start  1993320 :end  2293200 :ppeak 0.0702 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  57 :volume  raw/mf :start  2337300 :end  2637180 :ppeak 0.0707 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  58 :volume  raw/mf :start  2676870 :end  2937060 :ppeak 0.0539 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  59 :volume  raw/mf :start  2972340 :end  3258990 :ppeak 0.0569 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  60 :volume  raw/mf :start  3298680 :end  3594150 :ppeak 0.0465 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  61 :volume  raw/mf :start  3647070 :end  3863160 :ppeak 0.0797 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif
{:index  62 :volume  raw/mf :start    35280 :end   326340 :ppeak 0.0522 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  63 :volume  raw/mf :start   374850 :end   661500 :ppeak 0.0647 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  64 :volume  raw/mf :start   705600 :end  1018710 :ppeak 0.0855 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  65 :volume  raw/mf :start  1058400 :end  1345050 :ppeak 0.0508 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  66 :volume  raw/mf :start  1380330 :end  1640520 :ppeak 0.0765 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  67 :volume  raw/mf :start  1680210 :end  1944810 :ppeak 0.0494 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  68 :volume  raw/mf :start  1984500 :end  2240280 :ppeak 0.0451 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  69 :volume  raw/mf :start  2288790 :end  2540160 :ppeak 0.0428 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  70 :volume  raw/mf :start  2579850 :end  2848860 :ppeak 0.0474 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  71 :volume  raw/mf :start  2892960 :end  3131100 :ppeak 0.0443 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  72 :volume  raw/mf :start  3166380 :end  3417750 :ppeak 0.0536 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  73 :volume  raw/mf :start  3453030 :end  3713220 :ppeak 0.0604 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  74 :volume  raw/mf :start  3748500 :end  4008690 :ppeak 0.0417 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif
{:index  43 :volume  raw/mf :start    44100 :end   348390 :ppeak 0.1486 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  raw/mf :start   396900 :end   727650 :ppeak 0.0976 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  raw/mf :start   771750 :end  1089270 :ppeak 0.0785 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  raw/mf :start  1142190 :end  1437660 :ppeak 0.0895 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  raw/mf :start  1486170 :end  1772820 :ppeak 0.0747 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  raw/mf :start  1825740 :end  2174130 :ppeak 0.0635 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  raw/mf :start  2213820 :end  2526930 :ppeak 0.0738 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  raw/mf :start  2566620 :end  2870910 :ppeak 0.0814 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  raw/mf :start  2915010 :end  3188430 :ppeak 0.0876 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  raw/mf :start  3228120 :end  3523590 :ppeak 0.0601 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  raw/mf :start  3567690 :end  3894030 :ppeak 0.1214 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  raw/mf :start  3946950 :end  4163040 :ppeak 0.1241 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
;; 13 samples starting at 55. ./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif
{:index  55 :volume  raw/mf :start    44100 :end   291060 :ppeak 0.1573 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  56 :volume  raw/mf :start   335160 :end   577710 :ppeak 0.0740 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  57 :volume  raw/mf :start   617400 :end   952560 :ppeak 0.0639 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  58 :volume  raw/mf :start   987840 :end  1239210 :ppeak 0.0661 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  59 :volume  raw/mf :start  1278900 :end  1543500 :ppeak 0.0505 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  60 :volume  raw/mf :start  1578780 :end  1878660 :ppeak 0.0422 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  61 :volume  raw/mf :start  1922760 :end  2200590 :ppeak 0.0512 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  62 :volume  raw/mf :start  2235870 :end  2641590 :ppeak 0.0366 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  63 :volume  raw/mf :start  2685690 :end  2959110 :ppeak 0.0697 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  64 :volume  raw/mf :start  2998800 :end  3236940 :ppeak 0.0649 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  65 :volume  raw/mf :start  3276630 :end  3536820 :ppeak 0.0700 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  66 :volume  raw/mf :start  3580920 :end  3885210 :ppeak 0.0769 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  67 :volume  raw/mf :start  3929310 :end  4189500 :ppeak 0.0596 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif
{:index  36 :volume  raw/mf :start    39690 :end   480690 :ppeak 0.0900 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  37 :volume  raw/mf :start   524790 :end   934920 :ppeak 0.1032 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  38 :volume  raw/mf :start   974610 :end  1384740 :ppeak 0.0558 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  39 :volume  raw/mf :start  1424430 :end  1812510 :ppeak 0.1043 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  40 :volume  raw/mf :start  1856610 :end  2213820 :ppeak 0.0517 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  41 :volume  raw/mf :start  2253510 :end  2646000 :ppeak 0.1117 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  42 :volume  raw/mf :start  2685690 :end  3038490 :ppeak 0.1309 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  43 :volume  raw/mf :start  3078180 :end  3444210 :ppeak 0.1527 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  44 :volume  raw/mf :start  3483900 :end  3819060 :ppeak 0.0932 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  45 :volume  raw/mf :start  3858750 :end  4193910 :ppeak 0.0782 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  46 :volume  raw/mf :start  4242420 :end  4687830 :ppeak 0.0892 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  47 :volume  raw/mf :start  4727520 :end  4987710 :ppeak 0.0744 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
;; 13 samples starting at 48. ./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif
{:index  48 :volume  raw/mf :start    44100 :end   366030 :ppeak 0.0697 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  49 :volume  raw/mf :start   410130 :end   798210 :ppeak 0.1073 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  50 :volume  raw/mf :start   837900 :end  1173060 :ppeak 0.0567 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  51 :volume  raw/mf :start  1208340 :end  1543500 :ppeak 0.0800 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  52 :volume  raw/mf :start  1578780 :end  1887480 :ppeak 0.0656 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  53 :volume  raw/mf :start  1922760 :end  2249100 :ppeak 0.1234 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  54 :volume  raw/mf :start  2284380 :end  2619540 :ppeak 0.0908 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  55 :volume  raw/mf :start  2654820 :end  2994390 :ppeak 0.0625 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  56 :volume  raw/mf :start  3034080 :end  3316320 :ppeak 0.0507 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  57 :volume  raw/mf :start  3356010 :end  3642660 :ppeak 0.0590 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  58 :volume  raw/mf :start  3682350 :end  3964590 :ppeak 0.0471 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  59 :volume  raw/mf :start  4004280 :end  4290930 :ppeak 0.0487 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  60 :volume  raw/mf :start  4326210 :end  4652550 :ppeak 0.0330 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
;; 12 samples starting at 57. ./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif
{:index  57 :volume  raw/pp :start    30870 :end   286650 :ppeak 0.0393 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  raw/pp :start   330750 :end   621810 :ppeak 0.0296 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  raw/pp :start   661500 :end   961380 :ppeak 0.0271 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  raw/pp :start  1005480 :end  1252440 :ppeak 0.0368 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  raw/pp :start  1296540 :end  1539090 :ppeak 0.0313 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  raw/pp :start  1592010 :end  1843380 :ppeak 0.0320 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  raw/pp :start  1883070 :end  2156490 :ppeak 0.0357 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  raw/pp :start  2196180 :end  2447550 :ppeak 0.0296 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  raw/pp :start  2500470 :end  2729790 :ppeak 0.0328 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  raw/pp :start  2769480 :end  3029670 :ppeak 0.0359 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  raw/pp :start  3069360 :end  3329550 :ppeak 0.0329 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  raw/pp :start  3373650 :end  3594150 :ppeak 0.0365 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
;; 13 samples starting at 69. ./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif
{:index  69 :volume  raw/pp :start    39690 :end   295470 :ppeak 0.0316 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  70 :volume  raw/pp :start   335160 :end   590940 :ppeak 0.0294 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  71 :volume  raw/pp :start   635040 :end   882000 :ppeak 0.0260 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  72 :volume  raw/pp :start   917280 :end  1203930 :ppeak 0.0213 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  73 :volume  raw/pp :start  1248030 :end  1525860 :ppeak 0.0379 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  74 :volume  raw/pp :start  1561140 :end  1847790 :ppeak 0.0242 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  75 :volume  raw/pp :start  1887480 :end  2174130 :ppeak 0.0218 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  76 :volume  raw/pp :start  2209410 :end  2562210 :ppeak 0.0208 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  77 :volume  raw/pp :start  2601900 :end  2906190 :ppeak 0.0229 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  78 :volume  raw/pp :start  2941470 :end  3188430 :ppeak 0.0257 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  79 :volume  raw/pp :start  3223710 :end  3483900 :ppeak 0.0252 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  80 :volume  raw/pp :start  3536820 :end  3797010 :ppeak 0.0293 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  81 :volume  raw/pp :start  3832290 :end  4136580 :ppeak 0.0231 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
;; 12 samples starting at 50. ./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif
{:index  50 :volume  raw/pp :start    44100 :end   273420 :ppeak 0.0424 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  51 :volume  raw/pp :start   286650 :end   542430 :ppeak 0.0468 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  52 :volume  raw/pp :start   560070 :end   833490 :ppeak 0.0282 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  53 :volume  raw/pp :start   864360 :end  1115730 :ppeak 0.0418 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  54 :volume  raw/pp :start  1155420 :end  1406790 :ppeak 0.0445 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  55 :volume  raw/pp :start  1442070 :end  1666980 :ppeak 0.0602 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  56 :volume  raw/pp :start  1693440 :end  1935990 :ppeak 0.0328 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  57 :volume  raw/pp :start  1966860 :end  2178540 :ppeak 0.0320 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  58 :volume  raw/pp :start  2218230 :end  2443140 :ppeak 0.0253 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  59 :volume  raw/pp :start  2474010 :end  2712150 :ppeak 0.0283 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  60 :volume  raw/pp :start  2769480 :end  2994390 :ppeak 0.0236 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  61 :volume  raw/pp :start  3042900 :end  3254580 :ppeak 0.0309 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
;; 13 samples starting at 62. ./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif
{:index  62 :volume  raw/pp :start    30870 :end   273420 :ppeak 0.0281 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  63 :volume  raw/pp :start   295470 :end   546840 :ppeak 0.0322 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  64 :volume  raw/pp :start   630630 :end   842310 :ppeak 0.0340 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  65 :volume  raw/pp :start   882000 :end  1093680 :ppeak 0.0289 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  66 :volume  raw/pp :start  1151010 :end  1420020 :ppeak 0.0528 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  67 :volume  raw/pp :start  1437660 :end  1680210 :ppeak 0.0265 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  68 :volume  raw/pp :start  1728720 :end  1944810 :ppeak 0.0235 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  69 :volume  raw/pp :start  1993320 :end  2240280 :ppeak 0.0236 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  70 :volume  raw/pp :start  2275560 :end  2478420 :ppeak 0.0267 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  71 :volume  raw/pp :start  2531340 :end  2729790 :ppeak 0.0250 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  72 :volume  raw/pp :start  2787120 :end  2985570 :ppeak 0.0250 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  73 :volume  raw/pp :start  3042900 :end  3272220 :ppeak 0.0328 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  74 :volume  raw/pp :start  3298680 :end  3519180 :ppeak 0.0241 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
;; 12 samples starting at 43. ./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif
{:index  43 :volume  raw/pp :start    70560 :end   330750 :ppeak 0.0711 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  raw/pp :start   352800 :end   595350 :ppeak 0.0515 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  raw/pp :start   621810 :end   877590 :ppeak 0.0373 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  raw/pp :start   921690 :end  1146600 :ppeak 0.0376 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  raw/pp :start  1199520 :end  1411200 :ppeak 0.0355 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  raw/pp :start  1446480 :end  1662570 :ppeak 0.0326 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  raw/pp :start  1715490 :end  1940400 :ppeak 0.0300 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  raw/pp :start  1984500 :end  2196180 :ppeak 0.0367 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  raw/pp :start  2231460 :end  2443140 :ppeak 0.0429 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  raw/pp :start  2474010 :end  2707740 :ppeak 0.0289 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  raw/pp :start  2751840 :end  2994390 :ppeak 0.0499 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  raw/pp :start  3029670 :end  3276630 :ppeak 0.0574 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
;; 13 samples starting at 55. ./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif
{:index  55 :volume  raw/pp :start    52920 :end   286650 :ppeak 0.0470 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  56 :volume  raw/pp :start   339570 :end   564480 :ppeak 0.0284 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  57 :volume  raw/pp :start   630630 :end   868770 :ppeak 0.0291 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  58 :volume  raw/pp :start   899640 :end  1186290 :ppeak 0.0304 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  59 :volume  raw/pp :start  1243620 :end  1433250 :ppeak 0.0478 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  60 :volume  raw/pp :start  1459710 :end  1671390 :ppeak 0.0264 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  61 :volume  raw/pp :start  1715490 :end  1913940 :ppeak 0.0340 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  62 :volume  raw/pp :start  1958040 :end  2169720 :ppeak 0.0352 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  63 :volume  raw/pp :start  2205000 :end  2385810 :ppeak 0.0318 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  64 :volume  raw/pp :start  2421090 :end  2641590 :ppeak 0.0407 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  65 :volume  raw/pp :start  2654820 :end  2862090 :ppeak 0.0258 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  66 :volume  raw/pp :start  2906190 :end  3148740 :ppeak 0.0387 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  67 :volume  raw/pp :start  3197250 :end  3475080 :ppeak 0.0329 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
;; 12 samples starting at 36. ./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif
{:index  36 :volume  raw/pp :start    39690 :end   317520 :ppeak 0.0349 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  37 :volume  raw/pp :start   352800 :end   652680 :ppeak 0.0421 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  38 :volume  raw/pp :start   692370 :end   992250 :ppeak 0.0265 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  39 :volume  raw/pp :start  1036350 :end  1327410 :ppeak 0.0393 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  40 :volume  raw/pp :start  1362690 :end  1675800 :ppeak 0.0236 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  41 :volume  raw/pp :start  1719900 :end  1997730 :ppeak 0.0698 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  42 :volume  raw/pp :start  2050650 :end  2328480 :ppeak 0.0727 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  43 :volume  raw/pp :start  2372580 :end  2663640 :ppeak 0.0802 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  44 :volume  raw/pp :start  2707740 :end  2985570 :ppeak 0.0512 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  45 :volume  raw/pp :start  3025260 :end  3338370 :ppeak 0.0379 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  46 :volume  raw/pp :start  3378060 :end  3669120 :ppeak 0.0375 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  47 :volume  raw/pp :start  3717630 :end  3951360 :ppeak 0.0475 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
;; 12 samples starting at 48. ./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif
{:index  48 :volume  raw/pp :start    39690 :end   326340 :ppeak 0.0311 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  49 :volume  raw/pp :start   361620 :end   665910 :ppeak 0.0398 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  50 :volume  raw/pp :start   710010 :end   979020 :ppeak 0.0350 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  51 :volume  raw/pp :start  1023120 :end  1296540 :ppeak 0.0451 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  52 :volume  raw/pp :start  1340640 :end  1627290 :ppeak 0.0627 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  53 :volume  raw/pp :start  1671390 :end  1909530 :ppeak 0.0619 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  54 :volume  raw/pp :start  1953630 :end  2218230 :ppeak 0.0407 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  55 :volume  raw/pp :start  2257920 :end  2522520 :ppeak 0.0366 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  56 :volume  raw/pp :start  2562210 :end  2862090 :ppeak 0.0278 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  57 :volume  raw/pp :start  2901780 :end  3153150 :ppeak 0.0281 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  58 :volume  raw/pp :start  3188430 :end  3470670 :ppeak 0.0202 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  59 :volume  raw/pp :start  3510360 :end  3849930 :ppeak 0.0239 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
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
  (let [unique-pp-info (get-unique-sample-info-map raw/pp)
        unique-mf-info (get-unique-sample-info-map raw/mf)
        unique-ff-info (get-unique-sample-info-map raw/ff)
        sample-info-map (merge-with concat unique-pp-info unique-mf-info unique-ff-info)]
    sample-info-map))

(defn- adjust-sample
  "smoothly adjust the samples to start from 0 and end at 0 and have
  scaled ppeak value matching the buffer-volume"
  [sample-offset buffer-size buffer-volume buffer-ppeak index value]
  (let [smooth-value (* value (smoothpulse 0 sample-offset (- buffer-size sample-offset) buffer-size index))
        scaled-value (* smooth-value (/ buffer-volume buffer-ppeak))]
    scaled-value))

;; must only be in later versions.  HACK! FIXME!
(def MAX-OSC-SAMPLES
  "Max number of samples supported in a UDP OSC message"
  4096)
(defn buffer-write-relay!
  "Similar to buffer-write! except it is capable of handling very large
  buffers by slicing them up and writing each slice separately. Can be
  very slow."
  ([buf data] (buffer-write-relay! buf 0 data))
  ([buf start-idx data]
     (assert (o/buffer? buf))
     (loop [data-left data
            idx       0]
       (let [to-write  (take MAX-OSC-SAMPLES data-left)
             data-left (drop MAX-OSC-SAMPLES data-left)]
         (when-not (empty? to-write)
           (o/buffer-write! buf idx to-write)
           (recur data-left (+ idx (count to-write))))))))

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
  ([i] (get-sample i raw/ff))
  ([i v]
     (let [sample-info (get-sample-info i v)]
       (if sample-info
         (:sample sample-info)
         nil))))

(comment

  ;; start-index (:index (first sample-info-list))
  ;; end-index (:index (last sample-info-list))
        
)
