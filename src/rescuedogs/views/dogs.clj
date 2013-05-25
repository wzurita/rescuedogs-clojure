(ns rescuedogs.views.dogs
  (:use [hiccup.core ]
        [hiccup.form ]
        )
  (:require [rescuedogs.views.layout :as layout]))

(defn addform-body []
  [:div.addDogForm 
   (form-to [:post "/add"]
            [:div.span-7.colborder
             (label "breed" "Whats the breed of the dog?")
             ]
            [:div.span-7.last
             (text-field "breed")
             ]
            [:div.span-7.colborder
             (label "weight" "How much does the dog weight?")
             ]
            [:div.span-7.last
             (text-field "weight")
             ]
            [:div.span-7.colborder
             (label "birth" "When was the dog born? YYYYMMDD, please")
             ]
            [:div.span-7.last
             (text-field "birth")
             ]
            
            [:div.span-7.colborder
             (label "location" "Where is the dog waiting for adoption?")
             ]
            [:div.span-7.last
             (text-field "location")
             ]
            
            [:div.span-7.colborder
             (label "sex" "What' the sex of the dog?")
             ]
            [:div.span-7.last
             (radio-button "sex" false "Male") 
             [:span "Male"]
             [:br]
             (radio-button "sex" false "Female") 
             [:span "Female"]
             ]
            [:div.span-7.colborder
             (label "neutered" "Has the dog been neutered?")
             ]
            [:div.span-7.last
             (check-box "neutered" false)
             ]
            [:div.span-8
             [:span "&nbsp;"]
             ]
            [:div.span-7.last
             (submit-button "Add dog!")
             ]
            )
   ]
  )
  

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

(defn calclink [number params]
  (str (str "?page=" number)
       
       (reduce str (map (fn [param-key] 
                          (if (not= :page param-key) 
                            (str "&"  (name param-key) "=" (get params param-key))
                            ""))
                        (keys params)
                        
                        ))
       )
  )

(defn pagination [dogcount items page params]
  (def totalpage (quot dogcount items))
  [:ul.pagination.center 
   (if
     (> page 0)
     (list [:li
            [:a {:href (calclink 0 params)} "&laquo;"]
            ]
           [:li
            [:a {:href (calclink page params)} "&#9668;"]
            ]
           )
     (list [:li
            [:a {:class "disabled"} "&laquo;"]
            ]
           [:li
            [:a {:class "disabled"} "&#9668;"]
            ]
           )
     )
   [:li 
    [:ul
     (map 
       (fn [number] 
         [:li 
          (if (not= page number) 
            [:a {:href (calclink number params)} number]
            [:a {:class "selected"} number]
            )
          ]
         )
       (range
         totalpage
         )
       )
     ]
    ]
   (if
     (< page (- totalpage 1))
     (list [:li
            [:a {:href (calclink (+ page 1) params)} "&#9658;"]
            ]
           [:li
            [:a {:href (calclink (- totalpage 1) params)} "&raquo;"]
            ]
           )
     (list [:li
            [:a {:class "disabled"} "&#9658;"]
            ]
           [:li
            [:a {:class "disabled"} "&raquo;"]
            ]
           )
     )
   ]
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
                 []
                 params
                 [:div (pagination dogcount items page params)]
                 (display-dogs dogs items page)
                 )
  )
(defn addform []
  (layout/common "Add a dog"
                 [];otherboxes
                 {};params 
                 (addform-body)
                 )
  )