(defproject org.clojars.gonewest818/opentracing-zipkin-clj "0.1.0-SNAPSHOT"
  :description "Send OpenTracing trace information via Brave to Zipkin"
  :url "http://github.com/gonewest818/opentracing-zipkin-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.opentracing.brave/brave-opentracing "0.18.1"]
                 [io.zipkin.reporter/zipkin-sender-okhttp3 "0.6.12"]
                 [io.zipkin.brave/brave "4.0.6"]])
