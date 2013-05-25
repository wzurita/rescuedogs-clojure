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
   }
  )
;Katla
;Ras: Rottweiler/Amstaff
;Kön: Tik
;Kastrerad: Nej
;Vikt: 15 kg
;Född: 2012-12-02
;Plats: Jourhem Hedemora
(def all-dog-vector  [ 
                      {:id "1" :name "Katla" :breed "Rottweiler/Amstaff" :sex "tik" :neutered false :weight 15 :birth "20121202" :location "Jourhem Hedemora"}
                      {:id "2" :name "Jannike" :breed "Cocker/pudel" :sex "tik" :neutered false :birth "20130201" :location "Jourhem Knutby"}
                      {:id "3" :name "Lola O" :breed "centralasiatisk herdehund" :sex "tik" :neutered false :birth "20121111" :location "Jourhem Enskede"}
                      {:id "4" :name "Perky3" :breed "Jack Russel " :sex "hane" :neutered true :weight 7 :birth "20110302" :location "Jourhem Täby"}
                      {:id "5" :name "Tyke" :breed " Yorkshire terrier " :sex "hane" :neutered true :weight 15 :birth "20050701" :location "Jourhem Strömstad"}
                      {:id "6" :name "Nino" :breed "mellanpincher" :sex "hane" :neutered true :weight 15 :birth "20080101" :location "Borås"}
                      {:id "7" :name "Katla" :breed "Rottweiler/Amstaff" :sex "tik" :neutered false :weight 15 :birth "20121202" :location "Jourhem Hedemora"}
                      {:id "8" :name "Jannike" :breed "Cocker/pudel" :sex "tik" :neutered false :birth "20130201" :location "Jourhem Knutby"}
                      {:id "9" :name "Lola O" :breed "centralasiatisk herdehund" :sex "tik" :neutered false :birth "20121111" :location "Jourhem Enskede"}
                      {:id "10" :name "Perky3" :breed "Jack Russel " :sex "hane" :neutered true :weight 7 :birth "20110302" :location "Jourhem Täby"}
                      {:id "11" :name "Tyke" :breed " Yorkshire terrier " :sex "hane" :neutered true :weight 15 :birth "20050701" :location "Jourhem Strömstad"}
                      {:id "12" :name "Nino" :breed "mellanpincher" :sex "hane" :neutered true :weight 15 :birth "20080101" :location "Borås"}
                      {:id "13" :name "Katla" :breed "Rottweiler/Amstaff" :sex "tik" :neutered false :weight 15 :birth "20121202" :location "Jourhem Hedemora"}
                      {:id "14" :name "Jannike" :breed "Cocker/pudel" :sex "tik" :neutered false :birth "20130201" :location "Jourhem Knutby"}
                      {:id "15" :name "Lola O" :breed "centralasiatisk herdehund" :sex "tik" :neutered false :birth "20121111" :location "Jourhem Enskede"}
                      {:id "16" :name "Perky3" :breed "Jack Russel " :sex "hane" :neutered true :weight 7 :birth "20110302" :location "Jourhem Täby"}
                      {:id "17" :name "Tyke" :breed " Yorkshire terrier " :sex "hane" :neutered true :weight 15 :birth "20050701" :location "Jourhem Strömstad"}
                      {:id "18" :name "Nino" :breed "mellanpincher" :sex "hane" :neutered true :weight 15 :birth "20080101" :location "Borås"}
                      {:id "19" :name "Katla" :breed "Rottweiler/Amstaff" :sex "tik" :neutered false :weight 15 :birth "20121202" :location "Jourhem Hedemora"}
                      {:id "20" :name "Jannike" :breed "Cocker/pudel" :sex "tik" :neutered false :birth "20130201" :location "Jourhem Knutby"}
                      ])
(defn finddog [params] all-dog-vector)

(defn hitCount [params] 
  (count (finddog params))
  )

(defn addDog [params] 
  (def all-dog-vector 
    (conj all-dog-vector (extract-dog params))
    )
  )


  