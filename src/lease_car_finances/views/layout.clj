(ns lease-car-finances.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to lease car finances"]
     (include-css "/css/screen.css")]
    [:body body]))
