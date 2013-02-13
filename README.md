# oversampler

A Clojure library for analyzing, adjusting & playing music samples in
the [Overtone](http://github.com/overtone/overtone) project.

## Usage

Sampled instruments are provided in both definst and defsynth flavors.
Use whichever one you would like.

### Piano

Uses the same samples that the overtone.inst.sampled-piano uses, but
allows you to have both loud & medium versions available for a bit
more flexibility.  By default, oversampler uses the medium (mf)
samples & overtone's uses just the loud (ff) ones.

Basic use via:

    (use 'oversampler.piano.inst) 
    *OR*
    (use 'oversampler.piano.synth)
    (sampled-piano :note 50 :level 0.5)
    
To get access to 2 sets of samples medium (mf) and loud (ff) you need
to init to have a cutoff point like:

    (sampled-piano-init :mf-volume-cutoff 0.85)
    (sampled-piano :note 50 :level 0.5) ;; mf sample
    (sampled-piano :note 50 :level 0.9) ;; ff sample

### Cello

The sampled-cello is usable at this point, but could use review from
others for tuning and guidance on the best way to map the samples to
volumes.

Basic use via:

    (use 'oversampler.cello.inst)
    ;; *OR*
    (use 'oversampler.cello.synth)
    (sampled-cello :note 50 :level 0.5)
    
There are 3 sets of samples soft (pp), medium (mf) and loud (ff).  By
default only the mf samples are used.  If you want all 3 sets of
samples, try something like:

    (sampled-cello-init :pp-volume-cutoff 0.30 :mf-volume-cutoff 0.85)
    (sampled-cello :note 50 :level 0.2) ;; pp sample
    (sampled-cello :note 50 :level 0.5) ;; mf sample
    (sampled-cello :note 50 :level 0.9) ;; ff sample

### Note on/off control

For precise control of both note on & note off, consider using
explicit gate control of the envelope.  Setting the :play-buf-action
to NO-ACTION will prevent overtone from complaining if you try to turn
off a synth that no longer exists.

    (def synth-id (sampled-piano :note 60 :gate 1 :play-buf-action NO-ACTION))
    ;; ...wait until you get a note-off, then stop the synth....
    (o/ctl synth-id :gate 0)

### Analysis

Analysis code is under development & doesn't have any docs.  See
core.clj comments for other things you can do with the code.  It is
also commented out for normal distribution, since it uses Incanter and
that's not something normal sample players should need.

## TODO List

    o cello sounds need review by others for loudness, timing, tuning, etc.
    o looping
    o needs better docs
    o http://theremin.music.uiowa.edu/MISguitar.html
    o http://theremin.music.uiowa.edu/MISflute.html

## License

Copyright © 2012, 2013 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
