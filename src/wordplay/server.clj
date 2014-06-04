(ns wordplay.server
  (:require [wordplay.api :as api]
            [wordplay.views :as views]
            [compojure.core :refer [defroutes GET]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]))

;; routes

(defroutes web-routes
  (GET "/" request (views/home-page request))
  (route/resources "/")
  (route/not-found "Not Found"))

(defroutes api-routes
  (GET "/words/:word" [word]
    (api/get word)))

(defroutes all-routes
  web-routes api-routes)

;; server

(def app
  (handler/site api-routes))

(defn -main []
  (ring/run-jetty #'api-routes {:port 8080 :join? false}))
