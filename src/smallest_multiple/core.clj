(ns smallest-multiple.core
  (:gen-class)
  (:import (java.lang.Math)))

 (defn get-factors
  ([number]
  (get-factors 1 number))
  ([start number]
   (let [stop (int (Math/sqrt number))
         factors (conj #{1} number)]
     (sort (into factors (for [i (range start (inc stop))
     :when (zero? (mod number i))] i))))))

 (defn prime? [number]
   (let [factors (get-factors number)]
   (if (= (count factors) 2)
       true
       false)))

 (defn smallest-multiple? [number max]
   "Checks if number is evenly divisible by all numbers from 1 to max"
   (every? zero? (map #(mod number %) (range 1 (inc max)))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
