(defproject oversampler "0.1.0-SNAPSHOT"
  :description "overtone sampler library"
  :url "https://github.com/rogerallen/oversampler"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.4.0"]
   [overtone "0.7.1"]
   ;; When doing analysis, uncomment the Incanter library and the analysis use line in core.clj
   ;; When deploying, comment it out.
   ;; The reason is that Incanter is not necessary for playing samples and can sometimes
   ;; cause troubles (I ran into some odd conflict with quil, for example).
   ;; {and this seems better than having 2 repositories.  at least for now}
   ;;[incanter "1.2.3-SNAPSHOT"]
   ]
  :plugins [ [lein-swank "1.4.4"] ]
  :main ^{:skip-aot true} oversampler.core
  )
