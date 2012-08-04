(defproject oversampler "0.1.0-SNAPSHOT"
  :description "overtone sampler library"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [overtone "0.7.1"]
                 [incanter "1.2.3-SNAPSHOT"]]
  :plugins [ [lein-swank "1.4.4"] ]
  :main ^{:skip-aot true} oversampler.core
  )
