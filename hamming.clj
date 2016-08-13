(ns hamming)

(defn distance [s1 s2]
  (when (= (count s1) (count s2))
    (let [nucleotide-pairs (map vector s1 s2)
          pairs-equal (map #(= (first %) (second %)) nucleotide-pairs)]
      (count (filter #(false? %) pairs-equal)))))
