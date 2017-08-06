(ns smallest-multiple.core-test
  (:require [clojure.test :refer :all]
            [smallest-multiple.core :refer :all]))

  (deftest prime-factorize-2
    (testing "the prime factor of 2 is 2"
      (is (= (prime-factorize 2) [2]))))

  (deftest prime-factorize-4
    (testing "the prime factor of 4 is 2 2"
      (is (= (prime-factorize 4) [2 2]))))

   (deftest prime-factorize-20
     (testing "the prime factors of 20 are 2 2 5"
      (is (= (prime-factorize 20) [2 2 5]))))

   (deftest prime-factorize-2520
     (testing "the prime factors of 20 are 2 2 2 3 3 5 7"
      (is (= (prime-factorize 2520) [2 2 2 3 3 5 7]))))

    (deftest find-smallest-multiple-from1to10-2520
     (testing "2520 is the smallest-multiple2 divisible by 1 ... 10"
        (is (= (find-smallest-multiple 10) 2520))))

    (deftest x-to-the-y-power-2-to-the-3
      (testing "2 to the 3 power is 8"
         (is (= (x-to-the-y-power 2 3) 8))))

    (deftest compute-exponents-vector
      (testing "map {2 3, 3 2, 5 1, 7 1} computes to [8, 9, 5, 7]"
         (is (= (compute-exponents {2 3, 3 2, 5 1, 7 1}) [8, 9, 5, 7]))))

; (run-tests 'smallest-multiple.core-test)
