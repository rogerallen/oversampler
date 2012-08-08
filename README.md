# oversampler

A Clojure library for playing music samples in the Overtone project.

## TODO List

    X get basic division of code
      X analysis of samples, view samples
      X bank - to load samples for future use
      X inst - the instrument of course
    O code is too "cello" centric.  Needs abstraction
    O cello sounds not ready for playing yet
      O alignment
      O volume
    O upload cello sounds to freesound & adjust interface

## Usage

Code is experimental & under development.  Use at your own risk.

Here are some things that you can do:

First, download http://theremin.music.uiowa.edu/MIScello2012.html
Cello.arco.mono.1644.1.zip and unzip into the src/oversampler/samples directory.

   ;; use this to create & print the information to go into bank/cello-sample-info-list
   (print-all-info cello-sample-paths)

   ;; use Incanter graphs to look over one of the samples
   (view-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif")
   (view-sample (nth (nth cello-sample-paths 3) 2))

   ;; play a sample from a file
   (defn play-sample [path samp-start samp-end]
     (let [size (- samp-end samp-start)]
       (sample-player
        (load-sample path :start samp-start :size size))))
   (play-sample "./src/oversampler/samples/Cello.arco.ff.sulA.A3Ab4.mono.aif" 2734200 2994390)
  
   ;; hear a sample from the loaded examples
   (sample-player (get-cello-sample (note :c3) 1.0) :vol 8)
   (sample-player (get-cello-sample (note :c3) 0.5) :vol 8)
   (sample-player (get-cello-sample (note :c3) 0.3) :vol 8)

   ;; use the instrument
   (do
     (sampled-cello :note (note :c3))
     (sampled-cello :note (note :e3))
     (sampled-cello :note (note :g3)))

## License

Copyright © 2012 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
