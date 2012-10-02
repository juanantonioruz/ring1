(ns ring1.core
  (:use ring.adapter.jetty))



  (defn handler [request]
    {:status 200
     :header {"Content-Type" "text/html"}
     :body "primer ejemplo con  RING/Clojure!"})

(defn -main[]
  (let [port (Integer/parseInt (System/getenv "PORT"))]
   ( run-jetty handler {:port port})))