(ns lease-car-finances.views.layout
  (:require [hiccup.page :refer [html5 include-js]]))

(defn common [scripts body-content]
  (html5
    [:head
     [:title "Welcome to lease car finances"]
     scripts]
    [:body body-content]))
