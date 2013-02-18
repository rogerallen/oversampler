(defproject oversampler "0.4.0-SNAPSHOT"
  :description "overtone sampler library"
  :url "https://github.com/rogerallen/oversampler"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.4.0"]
   [overtone "0.9.0-SNAPSHOT"]
   ;; When doing analysis, uncomment the Incanter library and the
   ;; analysis use line in core.clj When deploying, comment it out.
   ;; The reason is that Incanter is not necessary for playing samples
   ;; and can sometimes cause troubles (I ran into some odd conflict
   ;; with quil, for example).  {and this seems better than having 2
   ;; repositories.  at least for now}
   [incanter "1.4.1"] ;; was 1.2.3-SNAPSHOT
   ]
  ;; had to comment this out before "lein install" would work
  ;;:main ^{:skip-aot true} oversampler.core
  :test-selectors {:quick :quick
                   :cello :cello}
  ;; okay 128M is not enough when you have 40M files
  :jvm-opts [ "-Xms512m" "-Xmx1g" ]
  )
