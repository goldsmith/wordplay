(ns wordplay.web
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]))

(defroutes routes
  (GET "/" [] "<h2>Hello World</h2>")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site routes))

(defn -main []
  (ring/run-jetty #'routes {:port 8080 :join? false}))
