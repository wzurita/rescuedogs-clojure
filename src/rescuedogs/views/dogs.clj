(ns rescuedogs.views.dogs
  (:require [rescuedogs.views.layout :as layout]
            [rescuedogs.views.pagination :as pagination]
            [hiccup.form :as form]
            [hiccup.core :as core]
            )
  )

(defn addform-body []
  [:div.addDogForm 
   (form/form-to [:post "/add"]
                 [:div.span-7.colborder
                  (form/label "name" "Whats the name of the dog?")
                  ]
                 [:div.span-7.last
                  (form/text-field "name")
                  ]
                 [:div.span-7.colborder
                  (form/label "breed" "Whats the breed of the dog?")
                  ]
                 [:div.span-7.last
                  (form/text-field "breed")
                  ]
                 [:div.span-7.colborder
                  (form/label "weight" "How much does the dog weight?")
                  ]
                 [:div.span-7.last
                  (form/text-field "weight")
                  ]
                 [:div.span-7.colborder
                  (form/label "birth" "When was the dog born? YYYYMMDD, please")
                  ]
                 [:div.span-7.last
                  (form/text-field "birth")
                  ]
                 
                 [:div.span-7.colborder
                  (form/label "location" "Where is the dog waiting for adoption?")
                  ]
                 [:div.span-7.last
                  (form/text-field "location")
                  ]
                 
                 [:div.span-7.colborder
                  (form/label "sex" "What' the sex of the dog?")
                  ]
                 [:div.span-7.last
                  (form/radio-button "sex" false "Male") 
                  [:span "Male"]
                  [:br]
                  (form/radio-button "sex" false "Female") 
                  [:span "Female"]
                  ]
                 [:div.span-7.colborder
                  (form/label "neutered" "Has the dog been neutered?")
                  ]
                 [:div.span-7.last
                  (form/check-box "neutered" false)
                  ]
                 [:div.span-7.colborder
                  (form/label "category" "What kind of dog?")
                  ]
                 [:div.span-7.last
                  [:select {:name "category"} (form/select-options ["Puppy" "Small" "Medium" "Big"])
                   ]
                  ]
                 [:div.span-8
                  [:span "&nbsp;"]
                  ]
                 [:div.span-7.last
                  (form/submit-button "Add dog!")
                  ]
                 )
   ]
  )
  

(defn display-dog [dog]
  (def dogid (get dog :id))
  (list [:div.listingImage 
         [:a {:href (str "/dog?id=" dogid) :title ""} [:img {:alt (get dog :breed) :src (str "http://placedog.com/150/150?" (rand))}]] 
         ]
        [:div.listingText 
         [:a {:href (str "/dog?id=" dogid) }]
         [:br] 
         "Name:" (get dog :name) 
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
  
(defn show [dogs dogcount params]
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
  (layout/common "All dogs" 
                 {:leftbox '(
                              [:h6 "Add more dogs in need of rescue!"] 
                              [:a {:href "/add"} "with this link!"]
                              )}
                 params
                 [:div (pagination/pagination dogcount items page params)]
                 (display-dogs dogs items page)
                 )
  )
(defn addform []
  (layout/common "Add a dog"
                 {:subtitle '([:a {:href "/" } "These dogs"] " need a new home!")};otherboxes
                 {};params 
                 (addform-body)
                 )
  )