(ns lease-car-finances.graphs
  (require
  [lease-car-finances.core :refer :all]
  [analemma.charts :refer :all]
  [clj-time.core :as t]))

(def cumulative-miles-driven-data (map vector
                                (map #(t/in-days (t/interval (:date day-of-purchase ) (:date %)) ) current-state)
                                (map #(:mileage %) current-state)))

(defn cumulative-miles-driven [filename]
  (spit filename
        (emit-svg
          (-> (xy-plot :xmin 0 :xmax days-in-contract,
                       :ymin 0 :ymax 75000
                       :height 500 :width 500)
              (add-points cumulative-miles-driven-data)
              (add-points [[0 0] [days-in-contract 75000]]))
          )))
