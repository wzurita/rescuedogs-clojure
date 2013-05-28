(ns rescuedogs.misc.script)


;  {:id (str counter)
;   :name (get params :name "name")
;   :breed (get params :breed  "breed")
;   :birth (get params :birth  "20130201")
;   :location (get params :location  "Jourhem Knutby")
;   :category (get params :category  "Puppy")
;   :neutered (get params :neutered  false)
;   :sex (get params :sex "female") 
(def breeds ["Alaskan Malamute" "Boxer" "Bullmastiff" 
             "Pekingese" "Shih Tzu" "Pug"  "Scottish Terrier" ])
(def births ["20101010" "20101011" "20101012" 
             "20101013" "20101014" "20101015" "20101016"
              "20101017" "20101018" "20101019" "20101020" 
             "20101021" "20101022" "20101023" "20101024" "20101025" "20101026"])
(def locations ["1location" "2location" "3location" "4location"
                 "5location" "6location" "7location" "8location" "9location" "10location"])
(def categories ["puppy" "small" "medium" "big"])

(defn writedogscurls [numbers]
  (map (fn [number ] (str "\ncurl --data \"name=" number 
                                   "&breed=" (get breeds (rand-int (count breeds)))
                                   "&weight=" (rand-int 30)
                                   "&birth=" (get births (rand-int (count births)))
                                   "&location=" (get locations (rand-int (count locations)))
                                   "&sex=" (if (= 0 (rand-int 2)) "male" "female")
                                   "&neutered=" (if (= 0 (rand-int 2)) "true" "false")
                                   "&category=" (get categories (rand-int (count categories)))
                                   "\" http://localhost:8080/add ;\n"
                                                  )) numbers))
                              
                              
                              
                                                                                                                                                                                                  
                                                                                                                                                                        