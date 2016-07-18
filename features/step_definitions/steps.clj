(require '[lease-car-finances.repository :as repository]
         '[lease-car-finances.home-page :as home-page]
         '[clj-time.core :as t]
         '[clj-time.format :as f]
         '[clj-time.coerce :as c])

(use 'clojure.walk)
(use 'clojure.test)
(import org.openqa.selenium.firefox.FirefoxDriver)

(def driver (atom false))


(Given #"^the following recorded fill ups$" [fill-ups]
       (->>
         fill-ups
         .asMaps
         (map #(-> (into {} %)
                   keywordize-keys
                   (update :date (fn [d] (c/to-date (f/parse (f/formatter :date) d))))
                   (update :mileage (fn [m] (long (read-string m))))
                   (repository/fillup)))
         repository/create))

(Then #"^I will see a graph presenting$" [expected-mpgs-over-time]
      (is (= expected-mpgs-over-time (home-page/mpgs-over-time @driver))))

(Before []
        (reset! driver (new FirefoxDriver)))

(After [] (.close @driver))