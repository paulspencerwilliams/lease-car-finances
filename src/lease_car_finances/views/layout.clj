(ns lease-car-finances.views.layout
  (:require [hiccup.page :refer [html5 include-js]]))

(defn common [body-content mpgs]
  (html5
    [:head
     [:title "Welcome to lease car finances"]
     (include-js "https://code.jquery.com/jquery-3.1.0.min.js")
     (include-js "https://code.highcharts.com/highcharts.js")
     [:script (str "var mpgs = " mpgs ";")]
     (include-js "js/mpg-graph.js")]
    [:body body-content]))
