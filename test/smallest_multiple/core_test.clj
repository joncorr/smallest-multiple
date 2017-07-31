(ns smallest-multiple.core-test
  (:require [clojure.test :refer :all]
            [smallest-multiple.core :refer :all]))

(deftest test-smallest-multiple?-2520-to10-true
 (testing "2520 is divisible by all numbers from 1 to 10"
   (is true? (smallest-multiple? 2520 10))))

(deftest test-smallest-multiple?-2520-to20-false
 (testing "2520 is NOT divisible by all numbers from 1 to 20"
   (is false? (smallest-multiple? 2520 20))))

; (run-tests 'smallest-multiple.core-test)
