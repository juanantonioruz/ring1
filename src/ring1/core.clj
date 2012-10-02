(ns ring1.core
  (:use ring.adapter.jetty))

(defn wrap-content-type [handler content-type]
  (fn [request]
    (let [response (handler request)]
         (assoc-in response [:headers "Content-Type"] content-type))))

  (defn handler [request]
    {:status 200
     :header {"Content-Type" "text/html"}
     :body (str "juanantonioruz@gmail.com \n --- Experiments with RING/Clojure ... \nYour remote-address:\n" :remote-address request )})

(defn controlador[request]
  ((wrap-content-type (handler "text/html") ) request)
  )

(defn -main[]
  (let [port (Integer/parseInt (System/getenv "PORT"))]
   ( run-jetty handler {:port port})))