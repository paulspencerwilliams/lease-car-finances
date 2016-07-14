(ns lease-car-finances.core
  (require [clj-time.core :as t]))

(defrecord Fillup [date mileage quantity cost])

(def current-state
  [(->Fillup (t/date-time 2016 6 13) 24 37 0)
   (->Fillup (t/date-time 2016 6 17) 426 33.61 37.95)
   (->Fillup (t/date-time 2016 6 20) 683 22.12 24.97)
   (->Fillup (t/date-time 2016 6 24) 1134 36.69 41.42)
   (->Fillup (t/date-time 2016 6 30) 1577 36.95 40.61)
   (->Fillup (t/date-time 2016 7 6) 2063 39.71 44.83)
   (->Fillup (t/date-time 2016 7 9) 2386 25.58 28.88)
   (->Fillup (t/date-time 2016 7 16) 2783 32.72 36.94)])

(def day-of-purchase (first current-state))

(def last-fillup (last current-state))

(def days-owned (t/in-days (t/interval (:date day-of-purchase) (:date last-fillup))))

(def days-in-contract (+ 366 365 365))

(def predicted-yearly
  (float
    (/
      (* (:mileage last-fillup) (/ days-in-contract days-owned))
      3)))

(def total-miles-done (- (:mileage (last current-state)) (:mileage (first current-state))))

(def burnt-litres (reduce + (map :quantity (rest current-state))))
(def burnt-litres (reduce (fn [total fillup] (+ total (:quantity fillup))) 0 (rest current-state)))

(def avg-mpg (/ total-miles-done (/ burnt-litres 4.54609)))
