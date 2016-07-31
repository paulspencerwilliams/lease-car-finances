(ns lease-car-finances.views.home
  (:require [hiccup.page :refer [html5 include-js]]
            [lease-car-finances.views.layout :as layout]))

(defn view [mpgs]
  (layout/common
    [:html
     [:script (str "var mpgs = " mpgs ";")]
     (include-js "https://code.jquery.com/jquery-3.1.0.min.js")
     (include-js "https://code.highcharts.com/highcharts.js")
     (include-js "js/mpg-graph.js")]
    [:div#chartContainer]))
