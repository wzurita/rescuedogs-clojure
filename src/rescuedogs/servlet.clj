(ns rescuedogs.servlet
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:require [compojure.route :as route])
  (:use ring.util.servlet
        [myapp.core :only [application]]))

(defservice application)