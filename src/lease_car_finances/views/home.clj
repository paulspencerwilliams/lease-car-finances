(ns lease-car-finances.views.home
  (:require [hiccup.page :refer [html5 include-js]]
            [lease-car-finances.views.layout :as layout]))

(defn view [mpgs]
  (layout/common [:div#chartContainer] mpgs))
