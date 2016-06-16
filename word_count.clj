(ns word-count
  (:require [clojure.string :as str]))


(defn word-count [s]
  "Returns a map representing the word freq for the supplied string"
  (-> s
      str/lower-case
      (str/split #"\W+")
      frequencies))
