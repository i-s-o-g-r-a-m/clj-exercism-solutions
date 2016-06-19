(ns nucleotide-count)


(def valid-nucleotides #{\A \C \G \T})


(defn count
  [nucleotide dna-strand]
  (do
    (assert (valid-nucleotides nucleotide))
    (or ((frequencies dna-strand) nucleotide) 0)))


(defn nucleotide-counts
  [dna-strand]
  (apply
    merge
    (map #(hash-map % (count % dna-strand)) valid-nucleotides)))
