(ns lease-car-finances.repository
  (require
    [spark.spec-tacular :as sp :refer [defspec]]
    [spark.spec-tacular.datomic :as sd]
    [spark.spec-tacular.schema :as schema]))


(defspec Fillup
         [date    :is-a :instant :identity :unique]
         [mileage :is-a :long :unique]
         [quantity :is-a :bigdec]
         [cost :is-a :bigdec])

(def conn-ctx {:conn (schema/to-database! (schema/from-namespace *ns*))})

(defn create [fill-ups]
  (dorun (map #(sd/create! conn-ctx %) fill-ups)))
