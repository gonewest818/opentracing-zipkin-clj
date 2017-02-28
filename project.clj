(defproject org.clojars.gonewest818/opentracing-zipkin-clj "0.1.0-SNAPSHOT"
  :description "Send OpenTracing trace information via Brave to Zipkin"
  :url "http://github.com/gonewest818/opentracing-zipkin-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.opentracing.brave/brave-opentracing "0.18.1"]
                 [io.zipkin.reporter/zipkin-sender-okhttp3 "0.6.12"]
                 [io.zipkin.brave/brave "4.0.6"]]
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_username
                                    :password :env/clojars_password}]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]
                   :plugins [[lein-midje "3.2.1"]
                             [lein-cloverage "1.0.9"]]}})
