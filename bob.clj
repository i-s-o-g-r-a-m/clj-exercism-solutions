(ns bob
  (:require [clojure.string :refer [blank? ends-with? trim upper-case]]))


(defn yelling? [prompt]
  (and
    (some #(Character/isUpperCase %) prompt)
    (= (upper-case prompt) prompt)))


(defn response-for [prompt]
  (cond
    (blank? prompt) "Fine. Be that way!"
    (yelling? prompt) "Whoa, chill out!"
    (ends-with? prompt "?") "Sure."
    :else "Whatever.")
)
