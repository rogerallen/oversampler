# oversampler

A Clojure library for adjusting & playing music samples in the Overtone project.

## TODO List

    X get basic division of code
      X analysis of samples, view samples
      X bank - to load samples for future use
      X inst - the instrument of course
    X cello notes need some processing
      X alignment
        - C2 shows noise before initial attack, delaying start.  
          found start point via midpoint of 90th percentile volume
      X add fade-in/out from/to 0
      X find normalized volume
      ? make each same length?    
    X code is too "cello" centric.
    X upload cello sounds to freesound & adjust interface
    X fix so volume is not discreet in 3 steps
    X fix list of samples to only download files that are actually used.
    X removed some upper cello notes that sounded thin.
    O cello sounds need a good ear to listen/critique/adjust
      O some are out of tune.
    O needs better docs

## Usage

Code is under development.  Use at your own risk.

Cello is "beta" at this point.  Use via:

    (use 'oversampler.cello.inst)
    (sampled-cello :note 50 :level 0.5)

See core.clj comments for other things you can do with the code.

## License

Copyright © 2012 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
