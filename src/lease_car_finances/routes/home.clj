(ns lease-car-finances.routes.home
  (:use clojure.string)
  (:require [compojure.core :refer :all]
            [lease-car-finances.repository :as repository]
            [lease-car-finances.views.home :as home]
            [clj-time.coerce :as c]
            [clj-time.core :as t]))

(defn home [mpgs]
  (->> mpgs
      (map
        (fn [mpg]
          (let [date (c/from-date (:date mpg))
                year (t/year date)
                month (- (t/month date) 1)
                day (t/day date)]
            (str "[Date.UTC(" year ", " month ", " day "), " (:mpg mpg) "]")))
        )
       (join ",")
       (format "[%s]")
      (home/view)))

(defroutes home-routes
           (GET "/" [] (home (repository/mpgs))))
