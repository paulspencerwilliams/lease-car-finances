(ns acceptance-tests.graphs-test
  (:require [clojure.test :refer :all]
            [acceptance-tests.home-page :as home-page]
            [lease-car-finances.repository :as repository]))

(deftest mpg-test
  (testing "I can see a graph of mpg based on fillups"
    (let [fill-ups [(repository/fillup {:date #inst "2016-06-13" :mileage 24 :quantity 37 :cost 0})
                    (repository/fillup {:date #inst "2016-06-17" :mileage 426 :quantity 33.61 :cost 37.95})
                    (repository/fillup {:date #inst "2016-06-20" :mileage 683 :quantity 22.12 :cost 24.97})
                    (repository/fillup {:date #inst "2016-06-24" :mileage 1134 :quantity 36.69 :cost 41.42})
                    (repository/fillup {:date #inst "2016-06-30" :mileage 1577 :quantity 36.95 :cost 40.61})
                    (repository/fillup {:date #inst "2016-07-06" :mileage 2063 :quantity 39.71 :cost 44.83})
                    (repository/fillup {:date #inst "2016-07-09" :mileage 2386 :quantity 25.58 :cost 28.88})
                    (repository/fillup {:date #inst "2016-07-12" :mileage 2783 :quantity 32.72 :cost 36.94})]]
      (repository/create (repository/fillup)))
    (is (= [{:date #inst "2016-06-17" :mpg 54.37453674501638}
            {:date #inst "2016-06-20" :mpg 52.81849593128392}
            {:date #inst "2016-06-24" :mpg 55.88134614336333}
            {:date #inst "2016-06-30" :mpg 54.50386657645467}
            {:date #inst "2016-07-06" :mpg 55.63837169478718}
            {:date #inst "2016-07-09" :mpg 57.40371657544958}
            {:date #inst "2016-07-12" :mpg 55.15885482885085}]
           (home-page/mpgs-over-time)))))
