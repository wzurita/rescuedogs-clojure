(ns rescuedogs.models.dogs)

(def counter 20)

(defn extract-dog [params]
  (def counter (inc counter))
  {:id (str counter)
   :name (get params :name "name")
   :breed (get params :breed  "breed")
   :sex (get params :sex "female")
   :neutered (if (.equals "true" (get params :neutered "false")) true false)
   :birth (get params :birth  "20130201")
   :location (get params :location  "Jourhem Knutby")
   :category (get params :category  "Puppy")
   :weight (get params :weight  17)
   }
  )
(def all-dog-vector  [])
(defn finddog [params] all-dog-vector)

(defn hitCount [params]
  (count (finddog params))
  )

(defn addDog [params]
  (def all-dog-vector
    (conj all-dog-vector (extract-dog params))
    )
  )


