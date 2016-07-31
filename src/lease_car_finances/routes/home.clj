(ns lease-car-finances.routes.home

  (:require [compojure.core :refer :all]
            [lease-car-finances.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "lease car finances"]))

(defroutes home-routes
           (GET "/" [] (home)))
