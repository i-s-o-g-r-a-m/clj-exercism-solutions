(ns anagram
  (:require [clojure.string :refer [join lower-case]]))


(defn- normalize
  [s]
  (join (apply str (sort (lower-case s)))))

(defn- is-anagram?
  [s1 s2]
  (apply = (map normalize [s1 s2])))

(defn- same-word?
  [s1 s2]
  (= (lower-case s1) (lower-case s2)))

(defn anagrams-for
  "Identifies anagrams of `word` from the set of `possibles`"
  [word possibles]
  (filter
    #(and (is-anagram? word %) (not (same-word? word %)))
    possibles))
