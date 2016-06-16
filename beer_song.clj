(ns beer-song
  (:require [clojure.string :refer [join]]))


(defn verse [verse-num]
  (let
    [next-bottle (- verse-num 1)
     next-is-plural (> next-bottle 1)]
    (cond
      (> verse-num 1)
      (str verse-num " bottles of beer on the wall, " verse-num " bottles of beer.\n"
           "Take one down and pass it around, " next-bottle " bottle"
           (when next-is-plural "s") " of beer on the wall.\n")
      (= verse-num 1)
      (str verse-num " bottle of beer on the wall, " verse-num " bottle of beer.\n"
           "Take it down and pass it around, no more bottles of beer on the wall.\n")
      :else
      (str "No more bottles of beer on the wall, no more bottles of beer.\n"
           "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))))

(defn sing
  ([start-verse end-verse]
    (let
      [count-down (range start-verse (- end-verse 1) -1)]
      (join "\n" (map verse count-down))))
  ([start-verse]
   (sing start-verse 0)))

(defn -main [& args]
  (doall (map print (apply sing (map #(Integer/parseInt %) args)))))
