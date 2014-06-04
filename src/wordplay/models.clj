(ns wordplay.models
  (:use clojure.java.io
        wordplay.utils))

;; helper functions to help generate Word records

(defn is-valid
  "Check whether `word` is a valid word
   in the ENABLE word list."
  [word]
  (with-open [rdr (reader "src/wordplay/data/enable.txt")]
    (in? (line-seq rdr) word)))

;; the actual Word record & fns

(defrecord Word [word length letters is_valid])


(defn word-from-string [word]
  "Constructor function for a Word record
   that generates relevant data from a string."
  (Word. word
         (count word)
         (map str word)
         (is-valid word)))