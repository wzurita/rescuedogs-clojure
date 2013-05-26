(ns rescuedogs.models.dogs)

(def counter 20)

(defn extract-dog [params]
  (def counter (inc counter))
  {:id (str counter)
   :name (get params :name "name")
   :breed (get params :breed  "breed")
   :sex (get params :sex "female") 
   :neutered (get params :neutered  false)
   :birth (get params :birth  "20130201")
   :location (get params :location  "Jourhem Knutby")
   :category (get params :category  "Puppy")
   }
  )
(def all-dog-vector  [ 
                      {:id "20" :name "Jannike" :breed "Cocker/pudel" :sex "tik" :neutered false :birth "20130201" :location "Jourhem Knutby" :category "medium"}
                      ])
(defn finddog [params] all-dog-vector)

(defn hitCount [params] 
  (count (finddog params))
  )

(defn addDog [params] 
  (def all-dog-vector 
    (conj all-dog-vector (extract-dog params))
    )
  counter
  )


  