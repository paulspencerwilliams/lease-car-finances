(require '[lease-car-finances.repository :as repository]
         '[lease-car-finances.core :as core]
         '[clj-time.core :as t]
         '[clj-time.format :as f])

(use 'clojure.walk)

(Given #"^the following recorded fill ups$" [fill-ups]
       (->>
         fill-ups
         .asMaps
         (map #(-> (into {} %)
                   keywordize-keys
                   (update :date (fn [d] (f/parse (f/formatter :date) d)))
                   core/map->Fillup))
         repository/create)
       (throw (cucumber.runtime.PendingException.)))

(Then #"^I will see a graph presenting$" []
      (comment Express the Regexp above with the code you wish you had)
      (throw (cucumber.runtime.PendingException.)))