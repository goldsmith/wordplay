(ns wordplay.server
  (:use wordplay.views.api
        wordplay.views.web)
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as ring]))

(defroutes web-routes
  (GET "/" request (home-page request))
  (route/resources "/")
  (route/not-found "Not Found"))

(defroutes api-routes
  (GET "/word" request (word-page request)))

(defroutes all-routes
  web-routes api-routes)


(def app
  (handler/site all-routes))

(defn -main []
  (ring/run-jetty #'all-routes {:port 8080 :join? false}))
