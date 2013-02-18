# How to add a sampled-instrument to Oversampler

1. download samples locally
   
   I typically download the sample files and store them in the
   src/oversampler/samples subdirectory.  

   If the samples are already in separate files per note and otherwise
   prepared, you can skip of large portions of this.  What follows
   assumes you have a number of files, each with a series of notes.

2. create temporary structure to describe the samples and provide a
   way to create a more permanent structure

   Something like this.
   
   (def temp-sample-path-info
     [ [ (note :e2) :mf -31 12 
         "./src/oversampler/samples/Guitar.mf.sulE.E2B2.aif"]
       [ (note :c3) :mf -31 12 
         "./src/oversampler/samples/Guitar.mf.sulE.C3B3.aif"] ])

   The first parameter is the midi-index of the starting note to be
   found in the sample-file defined by the last parameter.  Note, for
   the last parameter, you could use (freesound-path #), too.

   The second parameter is a volume keyword that you will use to
   describe a group of samples that were all taken to represent a
   timbre group.  Typically, I've used :pp, :mf and :ff.  

   The third parameter is used to find the separate notes within the
   sample file.  This dB level partitions the notes in order to find
   the peak values.  Use the (view-sample "path") command to decide
   where to set this for each file.  Values above this line will
   decide the number of notes contained in the file and what the peak
   value of each of those notes are.  Perhaps consider this a "rough"
   selection of the sample.

   The fourth parameter is used to decide precisely what part of the
   sound will be selected.  The peak value will be found via the 3rd
   parameter.  Then this value will be subtracted and used to select
   the sample.  6 dB is 1/2 the volume, 12 dB is 1/4 the volume, etc.

   These values may need to be set on a per-file basis and you can use
   the view-sample function to help with this.

3. run automatic analysis

   (print-sample-file-info temp-sample-path-info)

   The output will be a some dict elements for each note

   {:index 36 :volume :ff :start 88200 :end 471870 :ppeak 0.2077 :path
   "src/oversampler/samples/Cello.arco.ff.sulC.C2B2.mono.aif" :rate
   1.000}

   These describe how each note is found within the larger sample
   file.  :start & :end refer to the sample numbers for the start &
   end of the sample.
 
   :ppeak is a value that is used to scale the sample to a max-volume
   of 2.0 peak-to-peak.  Every sample is scaled by 2.0/:ppeak via the
   env-gen :level-scale.  Then it is multiplied by the incoming
   overall instrument level.  Something like (* inst-level (* 2.0
   ppeak) each-sample).  ??? why do we use 2.0?

   :rate is 1.000 always, but allows you to adjust the rate if the
   sample is slightly out of tune.

4. Manual processing

   Now create a instrument directory in src/oversampler to contain
   your samples.  The rest of the instructions will not be too
   detailed as every instrument is a little different.  But hopefully
   you can use the existing instruments as a pattern to match.

   Create a bank.clj file to hold that per-note dictionary from step 3
   and associated code to set the instrument up.

   Create a inst.clj and synth.clj for the actual definst and defsynth.

   Things you'll need to think about:
   a) decide which samples will actually be used.  

5. Tests and final review.

   See the tests/src/cello_test.clj for an example of testing every
   single note.  You'll want to do this in order to make sure every
   note is at the proper volume and is in tune.

   Add a full test for this review process.  

   Add a :quick test to just cover the basics and make sure things are
   not flat-broken.
