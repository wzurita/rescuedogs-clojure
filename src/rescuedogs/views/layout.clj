(ns rescuedogs.views.layout 
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css)]))

(defn common [title boxes param & body]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
     [:title title]
     (include-css "print.css" "screen.css")
     ]
    [:body
     [:div.container 
      [:h1 title]
      [:hr] 
      [:h2.alt (get boxes :subtitle '([:a {:href "/" } "These dogs"] " need a new home!"))] 
      [:hr]
      [:div.span-7.colborder (get boxes :leftbox 
                                  '(
                                     [:h6 "Add more dogs in need of rescue!"] 
                                     [:a {:href "/add"} "with this link!"]
                                     )
                                  )
       ]
      [:div.span-8.colborder (get boxes :centerbox
                                  '(
                                     [:h6 "And another box"] 
                                     [:p "Lorem ipsum dolor sit amet, consectetur adipisicing elit"]
                                     )
                                  )
       ]
      [:div.span-7.last (get boxes :rightbox
                             '(
                                [:h6 "This box is aligned with the sidebar"] 
                                [:p "Lorem ipsum dolor sit amet, consectetur adipisicing elit"]
                                )
                             )
       ]
      [:hr]
      [:hr.space]
      [:div.span-15.prepend-1.colborder body 
       [:hr]
       [:div.span-7.colborder (get boxes :leftbottombox
                                   '(
                                      [:h6 "This box is aligned with the sidebar"] 
                                      [:p "Lorem ipsum dolor sit amet, consectetur adipisicing elit"]
                                      )
                                   )]
       [:div.span-7.last (get boxes :rightbottombox
                              '(
                                 [:h6 "This box is aligned with the sidebar"] 
                                 [:p "Lorem ipsum dolor sit amet, consectetur adipisicing elit"]
                                 )
                              )]
       ]
      [:div.span-7.last (get boxes :sidebar 
                             '(
                                [:h3 "A simple sidebar"]
                                [:p "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras ornare mattis nunc"]
                                )
                             )
       ]
      [:hr]
      [:h2.alt (get boxes :footer
                    "You may pick and choose amongst these and many more features, so be bold."
                    )]
      ]
     
     ]
    )
  )
(defn four-oh-four []
  (common "Page Not Found" [] []
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))


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