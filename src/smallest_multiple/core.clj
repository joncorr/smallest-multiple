(ns smallest-multiple.core
  (:gen-class))

(defn prime? [number]
  (if (<= number 1)
   false
  (if (= number 2)
   true
  (= nil (first
           (for [i (range 2 number)
            :when (zero? (mod number i))] i))))))

(defn get-smallest-prime-factor [number]
  (first (filter
      #(and (prime? %) (zero? (mod number %)))
      (range 2 (inc number)))))



(defn prime-factorize [number]
  (loop [no number result []]
        (if (prime? no)
          (conj result no)
          (do
           (def prime-factor (get-smallest-prime-factor no))
           (def quotient (quot no prime-factor))
              (if (prime? quotient)
                 (conj result prime-factor quotient)
                 (recur quotient (conj result prime-factor)))
              ))))

(defn get-prime-factors-for-range [range]
  (sort (map (partial prime-factorize) range)))

(defn get-highest-exponents [coll-of-vectors]
  (loop [vectors coll-of-vectors result {}]
   (if (empty? vectors)
      result
      (do
       (let [first-vector (first vectors)]
          (recur (rest vectors)
                 (assoc result (first first-vector)
                               (count first-vector))))))))

(defn x-to-the-y-power [x y]
  (reduce * (repeat y x)))

(defn compute-exponents [map]
 (for [keyval map]
      (x-to-the-y-power (key keyval) (val keyval))))

(defn find-smallest-multiple [max]
  (->> (range 2 (inc max))
       (get-prime-factors-for-range)
       (get-highest-exponents)
       (compute-exponents)
       (reduce *)
       ))

(defn -main
  [& args]
  (prn "The smallest-multiple evenly divisible by 1 ... 20 is "
  (time (find-smallest-multiple 20))))
