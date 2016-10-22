(ns phone-number
  (:require [clojure.string :refer [join starts-with?]]))

(defn clean-number [num]
  "cleans a phone number, returning only the digits, also stripping the long-
  distance prefix"
  (let
    [cleaned (join "" (re-seq #"\d" num))
     length (count cleaned)]
    (if
      (and (> length 10) (starts-with? cleaned "1"))
      (subs cleaned 1)
      cleaned)))

(defn number [num]
  "returns a cleaned phone number or '0000000000' for un-handleable numbers"
  (let
    [cleaned (clean-number num)]
    (cond
      (= 10 (count cleaned)) cleaned
      :else "0000000000")))

(defn area-code [num]
  "returns a phone number's area code"
  (subs (number num) 0 3))

(defn pretty-print [num]
  "pretty-prints a phone number"
  (clojure.string/replace (number num) #"(\d{3})(\d{3})(\d{4})" "($1) $2-$3"))
