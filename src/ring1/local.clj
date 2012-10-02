(ns ring1.local
  (:use ring.adapter.jetty ring1.core))

(defn -local[]
  (run-jetty handler {:port 3000}))