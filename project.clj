(defproject oversampler "0.4.0-SNAPSHOT"
  :description "overtone sampler library"
  :url "https://github.com/rogerallen/oversampler"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.5.1"]
   [overtone "0.9.1"]]
  :test-selectors {:quick  :quick
                   :cello  :cello
                   :ektara :ektara}
  ;; okay 128M is not enough when you have 40M files
  :jvm-opts [ "-Xms512m" "-Xmx1g" ]
  ;; use profile for analysis
  :profiles {:dev {:dependencies [[incanter "1.4.1"]]}}
  )
