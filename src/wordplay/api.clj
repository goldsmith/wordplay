(ns wordplay.api
  (:use wordplay.models
        wordplay.utils)
  (:require [cheshire.core :as json]))


;; api views

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data {:pretty true})})


(defn get [word]
  (json-response (word-from-string word)))
