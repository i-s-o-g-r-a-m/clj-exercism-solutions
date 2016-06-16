(ns rna-transcription)


(defn to-rna [dna-strand]
  "Takes a string representing a DNA strand and returns a
   string containing the transcribed RNA strand"
  (let
    [dna-nucleotides (map str (seq dna-strand))
     dna-to-rna-mapping {"G" "C" "C" "G" "T" "A" "A" "U"}]
    (assert (every? #(contains? dna-to-rna-mapping %) dna-nucleotides))
    (apply str (map dna-to-rna-mapping dna-nucleotides))))
