(ns rescuedogs.controllers.dogs
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [rescuedogs.views.dogs :as view]
            [rescuedogs.models.dogs :as model]))

(defn index [params]
  (view/index (model/all) params)
)

(defroutes routes
           (GET  "/" {params :params} (index params)))
