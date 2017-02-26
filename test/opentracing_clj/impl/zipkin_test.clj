(ns opentracing-clj.impl.zipkin-test
  (:require [midje.sweet :refer :all]
            [opentracing-clj.impl.zipkin :refer :all]))

(defn- tracer?
  "for now we will merely check the tracer is of the proper java type"
  [actual]
  (instance? brave.opentracing.BraveTracer actual))

(facts "make-zipkin-tracer"
  (fact "with valid settings"
    (make-zipkin-tracer {:zipkin-apm-uri "http://localhost:9411/api/v1/spans"
                         :zipkin-apm-service-name "test"}) => tracer?)
  (fact "missing uri"
    (make-zipkin-tracer {:zipkin-apm-service-name "test"})
    => (throws Exception #"missing required settings"))
  (fact "missing service name"
    (make-zipkin-tracer {:zipkin-apm-uri "http://localhost:9411/api/v1/spans"})
    => (throws Exception #E"missing required settings")))

