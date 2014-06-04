(ns wordplay.utils)

(defn in?
  "true if seq contains elm
   from http://stackoverflow.com/questions/3249334/"
  [seq elm]
  (or
    (some #(= elm %) seq)
    false))
