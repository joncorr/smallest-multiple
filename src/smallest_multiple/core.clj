(ns smallest-multiple.core
  (:gen-class))

  (defn smallest-multiple? [number max]
   "Checks if number is evenly divisible by all numbers from 1 to max"
    (if (not (zero? (mod number max)))
      false
      (let [mods (map #(mod number %) (range (dec max) 0 -1))
            zeros (take-while zero? mods)]
       (if (not= (count zeros) (dec max)) ;; skipping max
         false
         true
       ))))

  (defn get-middle-value [number]
    (inc (int (/ number 2))))

  (defn find-smallest-multiple [max]
      (let [ min (get-middle-value max)
             largest-multiple (reduce * (range min (inc max)))
             ;; equivalent to max!/(max/2)! which reduces the size of the range
             composites (range min (inc largest-multiple))]
        (first (for [composite composites
              :when (smallest-multiple? composite max)]
              composite))))


(defn -main
  [& args]
  (prn "The smallest-multiple evenly divisible by 1 ... 20 is "
  (time (find-smallest-multiple 20))))
