(ns rescuedogs.views.pagination
  (:require [rescuedogs.views.layout :as layout]
            )
  )



(defn pagination [dogcount items page params]
  (def totalpage (quot dogcount items))
  [:ul.pagination.center 
   (if
     (> page 0)
     (list [:li
            [:a {:href (layout/calclink 0 params)} "&laquo;"]
            ]
           [:li
            [:a {:href (layout/calclink page params)} "&#9668;"]
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
            [:a {:href (layout/calclink number params)} number]
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
            [:a {:href (layout/calclink (+ page 1) params)} "&#9658;"]
            ]
           [:li
            [:a {:href (layout/calclink (- totalpage 1) params)} "&raquo;"]
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
