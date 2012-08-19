(ns oversampler.bank
  (:require [overtone.live :as o]))

(def cello-sample-info-list
  ;; ordered by low-to-high string C/G/D/A within the volume groups.
  ;; Since there are multiple notes with same index, this allows you
  ;; to grab the first matching index.
  [
{:index  57 :volume  1.00 :start    88200 :end   383670 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  1.00 :start   418950 :end   710010 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  1.00 :start   754110 :end  1045170 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  1.00 :start  1080450 :end  1358280 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  1.00 :start  1393560 :end  1680210 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  1.00 :start  1719900 :end  2028600 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  1.00 :start  2059470 :end  2385810 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  1.00 :start  2425500 :end  2716560 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  1.00 :start  2734200 :end  2994390 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  1.00 :start  3029670 :end  3258990 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  1.00 :start  3303090 :end  3545640 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  1.00 :start  3598560 :end  3801420 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif"}
{:index  69 :volume  1.00 :start   123480 :end   449820 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  70 :volume  1.00 :start   489510 :end   771750 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  71 :volume  1.00 :start   807030 :end  1111320 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  72 :volume  1.00 :start  1146600 :end  1415610 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  73 :volume  1.00 :start  1450890 :end  1737540 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  74 :volume  1.00 :start  1772820 :end  2046240 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  75 :volume  1.00 :start  2081520 :end  2368170 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  76 :volume  1.00 :start  2407860 :end  2685690 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  77 :volume  1.00 :start  2720970 :end  3003210 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  78 :volume  1.00 :start  3038490 :end  3289860 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  79 :volume  1.00 :start  3325140 :end  3554460 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  80 :volume  1.00 :start  3589740 :end  3832290 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  81 :volume  1.00 :start  3867570 :end  4220370 :path "./src/oversampler/samples/Cello.arco.ff.sulA.A4A5.mono.aif"}
{:index  50 :volume  1.00 :start   127890 :end   441000 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  51 :volume  1.00 :start   476280 :end   784980 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  52 :volume  1.00 :start   820260 :end  1142190 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  53 :volume  1.00 :start  1177470 :end  1512630 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  54 :volume  1.00 :start  1547910 :end  1865430 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  55 :volume  1.00 :start  1900710 :end  2240280 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  56 :volume  1.00 :start  2275560 :end  2628360 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  57 :volume  1.00 :start  2663640 :end  2989980 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  58 :volume  1.00 :start  3025260 :end  3311910 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  59 :volume  1.00 :start  3347190 :end  3638250 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  60 :volume  1.00 :start  3673530 :end  3951360 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  61 :volume  1.00 :start  3986640 :end  4233600 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D3Db4.mono.aif"}
{:index  62 :volume  1.00 :start   119070 :end   449820 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  63 :volume  1.00 :start   485100 :end   815850 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  64 :volume  1.00 :start   851130 :end  1137780 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  65 :volume  1.00 :start  1173060 :end  1459710 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  66 :volume  1.00 :start  1494990 :end  1764000 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  67 :volume  1.00 :start  1799280 :end  2196180 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  68 :volume  1.00 :start  2231460 :end  2548980 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  69 :volume  1.00 :start  2584260 :end  3020850 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  70 :volume  1.00 :start  3056130 :end  3382470 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  71 :volume  1.00 :start  3417750 :end  3766140 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  72 :volume  1.00 :start  3801420 :end  4145400 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  73 :volume  1.00 :start  4180680 :end  4498200 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  74 :volume  1.00 :start  4533480 :end  4789260 :path "./src/oversampler/samples/Cello.arco.ff.sulD.D4D5.mono.aif"}
{:index  43 :volume  1.00 :start    39690 :end   427770 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  1.00 :start   463050 :end   837900 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  1.00 :start   873180 :end  1212750 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  1.00 :start  1248030 :end  1587600 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  1.00 :start  1622880 :end  1984500 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  1.00 :start  2019780 :end  2399040 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  1.00 :start  2434320 :end  2791530 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  1.00 :start  2826810 :end  3175200 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  1.00 :start  3210480 :end  3563280 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  1.00 :start  3598560 :end  3916080 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  1.00 :start  3951360 :end  4299750 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  1.00 :start  4335030 :end  4555530 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G2Gb3.mono.aif"}
{:index  55 :volume  1.00 :start    30870 :end   401310 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  56 :volume  1.00 :start   436590 :end   798210 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  57 :volume  1.00 :start   833490 :end  1155420 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  58 :volume  1.00 :start  1190700 :end  1508220 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  59 :volume  1.00 :start  1543500 :end  1861020 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  60 :volume  1.00 :start  1896300 :end  2218230 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  61 :volume  1.00 :start  2253510 :end  2610720 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  62 :volume  1.00 :start  2646000 :end  2906190 :path "./src/oversampler/samples/Cello.arco.ff.sulG.G3D4.mono.aif"}
{:index  36 :volume  1.00 :start    88200 :end   471870 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  37 :volume  1.00 :start   507150 :end   877590 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  38 :volume  1.00 :start   912870 :end  1292130 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  39 :volume  1.00 :start  1327410 :end  1666980 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  40 :volume  1.00 :start  1702260 :end  2010960 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  41 :volume  1.00 :start  2046240 :end  2416680 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  42 :volume  1.00 :start  2451960 :end  2817990 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  43 :volume  1.00 :start  2853270 :end  3131100 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  44 :volume  1.00 :start  3166380 :end  3505950 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  45 :volume  1.00 :start  3541230 :end  3849930 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  46 :volume  1.00 :start  3885210 :end  4215960 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  47 :volume  1.00 :start  4251240 :end  4515840 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif"}
{:index  48 :volume  1.00 :start    92610 :end   471870 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  49 :volume  1.00 :start   507150 :end   882000 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  50 :volume  1.00 :start   917280 :end  1292130 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  51 :volume  1.00 :start  1327410 :end  1671390 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  52 :volume  1.00 :start  1706670 :end  2015370 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  53 :volume  1.00 :start  2050650 :end  2421090 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  54 :volume  1.00 :start  2456370 :end  2822400 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  55 :volume  1.00 :start  2857680 :end  3135510 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  56 :volume  1.00 :start  3170790 :end  3510360 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  57 :volume  1.00 :start  3545640 :end  3854340 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  58 :volume  1.00 :start  3889620 :end  4220370 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  59 :volume  1.00 :start  4255650 :end  4595220 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  60 :volume  1.00 :start  4630500 :end  4974480 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  61 :volume  1.00 :start  5009760 :end  5331690 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  62 :volume  1.00 :start  5366970 :end  5816790 :path "./src/oversampler/samples/Cello.arco.ff.sulC.C2D3.mono.aif"}
{:index  57 :volume  0.50 :start    44100 :end   282240 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  0.50 :start   321930 :end   577710 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  0.50 :start   626220 :end   899640 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  0.50 :start   939330 :end  1181880 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  0.50 :start  1225980 :end  1494990 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  0.50 :start  1534680 :end  1777230 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  0.50 :start  1821330 :end  2055060 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  0.50 :start  2103570 :end  2324070 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  0.50 :start  2368170 :end  2593080 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  0.50 :start  2641590 :end  2862090 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  0.50 :start  2906190 :end  3153150 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  0.50 :start  3197250 :end  3400110 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A3Ab4.mono.aif"}
{:index  69 :volume  0.50 :start    48510 :end   299880 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  70 :volume  0.50 :start   352800 :end   586530 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  71 :volume  0.50 :start   621810 :end   890820 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  72 :volume  0.50 :start   926100 :end  1195110 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  73 :volume  0.50 :start  1234800 :end  1512630 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  74 :volume  0.50 :start  1552320 :end  1812510 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  75 :volume  0.50 :start  1852200 :end  2152080 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  76 :volume  0.50 :start  2191770 :end  2443140 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  77 :volume  0.50 :start  2478420 :end  2751840 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  78 :volume  0.50 :start  2787120 :end  3025260 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  79 :volume  0.50 :start  3064950 :end  3294270 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  80 :volume  0.50 :start  3329550 :end  3541230 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  81 :volume  0.50 :start  3580920 :end  3841110 :path "./src/oversampler/samples/Cello.arco.mf.sulA.A4A5.mono.aif"}
{:index  50 :volume  0.50 :start    39690 :end   277830 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  51 :volume  0.50 :start   326340 :end   582120 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  52 :volume  0.50 :start   630630 :end   912870 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  53 :volume  0.50 :start   956970 :end  1261260 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  54 :volume  0.50 :start  1309770 :end  1592010 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  55 :volume  0.50 :start  1631700 :end  1949220 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  56 :volume  0.50 :start  1993320 :end  2293200 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  57 :volume  0.50 :start  2337300 :end  2637180 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  58 :volume  0.50 :start  2676870 :end  2937060 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  59 :volume  0.50 :start  2972340 :end  3258990 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  60 :volume  0.50 :start  3298680 :end  3594150 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  61 :volume  0.50 :start  3647070 :end  3863160 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D3Db4.mono.aif"}
{:index  62 :volume  0.50 :start    35280 :end   326340 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  63 :volume  0.50 :start   374850 :end   661500 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  64 :volume  0.50 :start   705600 :end  1018710 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  65 :volume  0.50 :start  1058400 :end  1345050 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  66 :volume  0.50 :start  1380330 :end  1640520 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  67 :volume  0.50 :start  1680210 :end  1944810 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  68 :volume  0.50 :start  1984500 :end  2240280 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  69 :volume  0.50 :start  2288790 :end  2540160 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  70 :volume  0.50 :start  2579850 :end  2848860 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  71 :volume  0.50 :start  2892960 :end  3131100 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  72 :volume  0.50 :start  3166380 :end  3417750 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  73 :volume  0.50 :start  3453030 :end  3713220 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  74 :volume  0.50 :start  3748500 :end  4008690 :path "./src/oversampler/samples/Cello.arco.mf.sulD.D4D5.mono.aif"}
{:index  43 :volume  0.50 :start    44100 :end   348390 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  0.50 :start   396900 :end   727650 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  0.50 :start   771750 :end  1089270 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  0.50 :start  1142190 :end  1437660 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  0.50 :start  1486170 :end  1772820 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  0.50 :start  1825740 :end  2174130 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  0.50 :start  2213820 :end  2526930 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  0.50 :start  2566620 :end  2870910 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  0.50 :start  2915010 :end  3188430 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  0.50 :start  3228120 :end  3523590 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  0.50 :start  3567690 :end  3894030 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  0.50 :start  3946950 :end  4163040 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G2Gb3.mono.aif"}
{:index  55 :volume  0.50 :start    44100 :end   291060 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  56 :volume  0.50 :start   335160 :end   577710 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  57 :volume  0.50 :start   617400 :end   952560 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  58 :volume  0.50 :start   987840 :end  1239210 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  59 :volume  0.50 :start  1278900 :end  1543500 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  60 :volume  0.50 :start  1578780 :end  1878660 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  61 :volume  0.50 :start  1922760 :end  2200590 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  62 :volume  0.50 :start  2235870 :end  2641590 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  63 :volume  0.50 :start  2685690 :end  2959110 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  64 :volume  0.50 :start  2998800 :end  3236940 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  65 :volume  0.50 :start  3276630 :end  3536820 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  66 :volume  0.50 :start  3580920 :end  3885210 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  67 :volume  0.50 :start  3929310 :end  4189500 :path "./src/oversampler/samples/Cello.arco.mf.sulG.G3G4.mono.aif"}
{:index  36 :volume  0.50 :start    39690 :end   480690 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  37 :volume  0.50 :start   524790 :end   934920 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  38 :volume  0.50 :start   974610 :end  1384740 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  39 :volume  0.50 :start  1424430 :end  1812510 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  40 :volume  0.50 :start  1856610 :end  2213820 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  41 :volume  0.50 :start  2253510 :end  2646000 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  42 :volume  0.50 :start  2685690 :end  3038490 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  43 :volume  0.50 :start  3078180 :end  3444210 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  44 :volume  0.50 :start  3483900 :end  3819060 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  45 :volume  0.50 :start  3858750 :end  4193910 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  46 :volume  0.50 :start  4242420 :end  4687830 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  47 :volume  0.50 :start  4727520 :end  4987710 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C2B2.mono.aif"}
{:index  48 :volume  0.50 :start    44100 :end   366030 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  49 :volume  0.50 :start   410130 :end   798210 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  50 :volume  0.50 :start   837900 :end  1173060 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  51 :volume  0.50 :start  1208340 :end  1543500 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  52 :volume  0.50 :start  1578780 :end  1887480 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  53 :volume  0.50 :start  1922760 :end  2249100 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  54 :volume  0.50 :start  2284380 :end  2619540 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  55 :volume  0.50 :start  2654820 :end  2994390 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  56 :volume  0.50 :start  3034080 :end  3316320 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  57 :volume  0.50 :start  3356010 :end  3642660 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  58 :volume  0.50 :start  3682350 :end  3964590 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  59 :volume  0.50 :start  4004280 :end  4290930 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  60 :volume  0.50 :start  4326210 :end  4652550 :path "./src/oversampler/samples/Cello.arco.mf.sulC.C3C4.mono.aif"}
{:index  57 :volume  0.30 :start    30870 :end   286650 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  58 :volume  0.30 :start   330750 :end   621810 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  59 :volume  0.30 :start   661500 :end   961380 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  60 :volume  0.30 :start  1005480 :end  1252440 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  61 :volume  0.30 :start  1296540 :end  1539090 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  62 :volume  0.30 :start  1592010 :end  1843380 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  63 :volume  0.30 :start  1883070 :end  2156490 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  64 :volume  0.30 :start  2196180 :end  2447550 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  65 :volume  0.30 :start  2500470 :end  2729790 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  66 :volume  0.30 :start  2769480 :end  3029670 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  67 :volume  0.30 :start  3069360 :end  3329550 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  68 :volume  0.30 :start  3373650 :end  3594150 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A3Ab4.mono.aif"}
{:index  69 :volume  0.30 :start    39690 :end   295470 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  70 :volume  0.30 :start   335160 :end   590940 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  71 :volume  0.30 :start   635040 :end   882000 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  72 :volume  0.30 :start   917280 :end  1203930 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  73 :volume  0.30 :start  1248030 :end  1525860 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  74 :volume  0.30 :start  1561140 :end  1847790 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  75 :volume  0.30 :start  1887480 :end  2174130 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  76 :volume  0.30 :start  2209410 :end  2562210 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  77 :volume  0.30 :start  2601900 :end  2906190 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  78 :volume  0.30 :start  2941470 :end  3188430 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  79 :volume  0.30 :start  3223710 :end  3483900 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  80 :volume  0.30 :start  3536820 :end  3797010 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  81 :volume  0.30 :start  3832290 :end  4136580 :path "./src/oversampler/samples/Cello.arco.pp.sulA.A4A5.mono.aif"}
{:index  50 :volume  0.30 :start    44100 :end   273420 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  51 :volume  0.30 :start   286650 :end   542430 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  52 :volume  0.30 :start   560070 :end   833490 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  53 :volume  0.30 :start   864360 :end  1115730 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  54 :volume  0.30 :start  1155420 :end  1406790 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  55 :volume  0.30 :start  1442070 :end  1666980 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  56 :volume  0.30 :start  1693440 :end  1935990 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  57 :volume  0.30 :start  1966860 :end  2178540 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  58 :volume  0.30 :start  2218230 :end  2443140 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  59 :volume  0.30 :start  2474010 :end  2712150 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  60 :volume  0.30 :start  2769480 :end  2994390 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  61 :volume  0.30 :start  3042900 :end  3254580 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D3Db4.mono.aif"}
{:index  62 :volume  0.30 :start    30870 :end   273420 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  63 :volume  0.30 :start   295470 :end   546840 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  64 :volume  0.30 :start   630630 :end   842310 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  65 :volume  0.30 :start   882000 :end  1093680 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  66 :volume  0.30 :start  1151010 :end  1420020 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  67 :volume  0.30 :start  1437660 :end  1680210 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  68 :volume  0.30 :start  1728720 :end  1944810 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  69 :volume  0.30 :start  1993320 :end  2240280 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  70 :volume  0.30 :start  2275560 :end  2478420 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  71 :volume  0.30 :start  2531340 :end  2729790 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  72 :volume  0.30 :start  2787120 :end  2985570 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  73 :volume  0.30 :start  3042900 :end  3272220 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  74 :volume  0.30 :start  3298680 :end  3519180 :path "./src/oversampler/samples/Cello.arco.pp.sulD.D4D5.mono.aif"}
{:index  43 :volume  0.30 :start    70560 :end   330750 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  44 :volume  0.30 :start   352800 :end   595350 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  45 :volume  0.30 :start   621810 :end   877590 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  46 :volume  0.30 :start   921690 :end  1146600 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  47 :volume  0.30 :start  1199520 :end  1411200 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  48 :volume  0.30 :start  1446480 :end  1662570 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  49 :volume  0.30 :start  1715490 :end  1940400 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  50 :volume  0.30 :start  1984500 :end  2196180 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  51 :volume  0.30 :start  2231460 :end  2443140 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  52 :volume  0.30 :start  2474010 :end  2707740 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  53 :volume  0.30 :start  2751840 :end  2994390 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  54 :volume  0.30 :start  3029670 :end  3276630 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G2Gb3.mono.aif"}
{:index  55 :volume  0.30 :start    52920 :end   286650 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  56 :volume  0.30 :start   339570 :end   564480 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  57 :volume  0.30 :start   630630 :end   868770 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  58 :volume  0.30 :start   899640 :end  1186290 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  59 :volume  0.30 :start  1243620 :end  1433250 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  60 :volume  0.30 :start  1459710 :end  1671390 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  61 :volume  0.30 :start  1715490 :end  1913940 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  62 :volume  0.30 :start  1958040 :end  2169720 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  63 :volume  0.30 :start  2205000 :end  2385810 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  64 :volume  0.30 :start  2421090 :end  2641590 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  65 :volume  0.30 :start  2654820 :end  2862090 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  66 :volume  0.30 :start  2906190 :end  3148740 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  67 :volume  0.30 :start  3197250 :end  3475080 :path "./src/oversampler/samples/Cello.arco.pp.sulG.G3G4.mono.aif"}
{:index  36 :volume  0.30 :start    39690 :end   317520 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  37 :volume  0.30 :start   352800 :end   652680 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  38 :volume  0.30 :start   692370 :end   992250 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  39 :volume  0.30 :start  1036350 :end  1327410 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  40 :volume  0.30 :start  1362690 :end  1675800 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  41 :volume  0.30 :start  1719900 :end  1997730 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  42 :volume  0.30 :start  2050650 :end  2328480 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  43 :volume  0.30 :start  2372580 :end  2663640 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  44 :volume  0.30 :start  2707740 :end  2985570 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  45 :volume  0.30 :start  3025260 :end  3338370 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  46 :volume  0.30 :start  3378060 :end  3669120 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  47 :volume  0.30 :start  3717630 :end  3951360 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C2B2.mono.aif"}
{:index  48 :volume  0.30 :start    39690 :end   326340 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  49 :volume  0.30 :start   361620 :end   665910 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  50 :volume  0.30 :start   710010 :end   979020 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  51 :volume  0.30 :start  1023120 :end  1296540 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  52 :volume  0.30 :start  1340640 :end  1627290 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  53 :volume  0.30 :start  1671390 :end  1909530 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  54 :volume  0.30 :start  1953630 :end  2218230 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  55 :volume  0.30 :start  2257920 :end  2522520 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  56 :volume  0.30 :start  2562210 :end  2862090 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  57 :volume  0.30 :start  2901780 :end  3153150 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  58 :volume  0.30 :start  3188430 :end  3470670 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
{:index  59 :volume  0.30 :start  3510360 :end  3849930 :path "./src/oversampler/samples/Cello.arco.pp.sulC.C3C4.mono.aif"}
   ])

;; similar to sampled_piano.clj...
(defn- get-unique-cello-sample-info-map
  "return map of sample-info, filtered by volume and selecting only one sample per index. map key is :index"
  [matching-volume]
  (let [mv-info (filter #(= matching-volume (:volume %)) cello-sample-info-list)
        mv-indexed (group-by :index mv-info)
        unique-mv-info (group-by :index (map #(first (second %)) (sort mv-indexed)))]
    unique-mv-info))

(defn- get-cello-sample-info-map
  "return map of sample-info. map key is :index"
  []
  (let [unique-pp-info (get-unique-cello-sample-info-map 0.3)
        unique-mf-info (get-unique-cello-sample-info-map 0.5)
        unique-ff-info (get-unique-cello-sample-info-map 1.0)
        sample-info-map (merge-with concat unique-pp-info unique-mf-info unique-ff-info)]
    sample-info-map))
    
(defn- load-sample-into-info
  "given an info map of the sample, load & add the sample"
  [x]
  (assoc x
    :sample (o/load-sample (:path x) :start (:start x) :size (- (:end x) (:start x)))))

(defn- load-samples-into-infos
  "given a key value tuple where the value is an array of sample-info, load samples"
  [xs]
  (map load-sample-into-info xs))

;; the main map of cello samples. map key is midi-index
(defonce cello-sample-info-map
  (doall (into {} (for [[k v] (get-cello-sample-info-map)] [k (load-samples-into-infos v)]))))

(defonce min-cello-index (apply min (keys cello-sample-info-map)))
(defonce max-cello-index (apply max (keys cello-sample-info-map)))

;; FIXME -- only gets the precise volume 1.0, 0.5, or 0.3
;; FIXME -- add version that provides 2 versions to blend between
(defn get-cello-sample
  ([i] (get-cello-sample i 1.0))
  ([i v]
     (if (or (>= i min-cello-index) (<= i max-cello-index))
       (:sample (first (filter #(= v (:volume %)) (cello-sample-info-map i))))
       nil)))

(defn get-cello-sample-info
  ([i v]
     (if (or (>= i min-cello-index) (<= i max-cello-index))
       (first (filter #(= v (:volume %)) (cello-sample-info-map i)))
       nil)))

(defn get-cello-sample
  ([i] (get-cello-sample i 1.0))
  ([i v]
     (let [sample-info (get-cello-sample-info i v)]
       (if sample-info
       (:sample sample-info)
       nil))))

(comment

  ;; start-index (:index (first cello-sample-info-list))
  ;; end-index (:index (last cello-sample-info-list))
        
)
