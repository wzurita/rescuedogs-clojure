(ns rescuedogs.views.dogs
  (:use [hiccup.core ]
        [hiccup.form :only (form-to label text-area submit-button)])
  (:require [rescuedogs.views.layout :as layout]))


(defn display-dog [dog]
  (def dogid (get dog :id))
  (list [:div.listingImage 
         [:a {:href (str "/dog?id=" dogid) :title ""} [:img {:alt (get dog :breed) :src (str "/img/" dogid ".jpg")}]] 
         ]
        [:div.listingText 
         [:a {:href (str "/dog?id=" dogid) }]
         [:br] 
         "Breed:" (get dog :breed) 
         [:br] 
         "Sex:" (get dog :sex) 
         [:br]
         "Neutered:" (if (get dog :neutered) "yes" "no") 
         [:br]
         "Weight:" (get dog :weight)
         [:br]
         "Birthdate:" (get dog :birth)
         [:br]
         "Place:" (get dog :location)
         [:br]
         ])
  )

(defn display-dogs [dogs items page]
  [:div {:id "maindiv"}
   (map-indexed
     (fn [number dog] (if (= 2 (mod number 3)) (list [:div.span-5.last.dog (display-dog dog)] [:hr] [:hr.space]) [:div.span-4.dog.colborder (display-dog dog)]))
     (take items (drop (* items page) dogs)))
   ])

(defn index [dogs params]
  (def items 
    (try 
      (Integer/parseInt (get params :items "10")) 
      (catch Exception e 10)
      )
    )
  (def page 
    (try 
      (Integer/parseInt (get params :page "0")) 
      (catch Exception e 0)
      )
    )
  (layout/common "All dogs" []
                 params
                 [:div {:class "clear"}]
                 (display-dogs dogs items page)
                 )
  )
