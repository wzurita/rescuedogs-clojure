(ns rescuedogs.controllers.dogs
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [clojure.data.json :as json]
            [rescuedogs.views.dogs :as view]
            [rescuedogs.models.dogs :as model]))

(defn show [params]
  (view/show (model/finddog params) (model/hitCount params) params)
  )

(defn addform [params]
  (view/addform)
  )

(defn postform [params]
  (def response (model/addDog params))
        (json/write-str {:response true :id rescuedogs.models.dogs/all-dog-vector})
  )


(defroutes routes
           (GET "/" {params :params} (show params))
           (GET "/add" {params :params} (addform params))
           (POST "/add" {params :params} (postform params))
           )
