(ns opentracing-clj.impl.zipkin
  (:import [brave Tracer]
           [brave.opentracing BraveTracer]
           [zipkin.reporter AsyncReporter]
           [zipkin.reporter.okhttp3 OkHttpSender]))


(defn make-zipkin-tracer
  "Create a Zipkin Tracer using settings in a hash-map:
  {
    :zipkin-apm-uri          \"http://localhost:8080\"
    :zipkin-apm-service-name \"my-service-name\"
  }

  Where the settings provided are mandatory for the initialization
  of the tracer.  See Zipkin documentation for details.

  This implementation will delect the aforementioned keywords
  out of a hash-map containing other unrelated keys; we do this
  so the caller can directly pass a map produced by weavejester's
  \"environ\".

  The resulting tracer implements the opentracing.io Tracer interface
  and can therefore be used in any application instrumented with
  opentracing-clj."
  [settings]
  "Create Zipkin/Brave tracer using the settings provided"
  (let [sender (OkHttpSender/create (settings :zipkin-apm-uri))
        reporter (-> sender
                     AsyncReporter/builder
                     .build)
        brave (-> (Tracer/newBuilder)
                  (.localServiceName (settings :zipkin-apm-service-name))
                  (.reporter reporter)
                  .build)]
    (BraveTracer/wrap brave)))
