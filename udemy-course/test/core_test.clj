(ns core-test
  (:require [clojure.test :refer :all]
            [aulas.core :refer :all]))

(deftest taxa-para-compras-ate-100-test
  (testing "cobra 15 reais"
    (is (= 15 (taxa-de-entrega 0)))
    (is (= 15 (taxa-de-entrega 95)))
    (is (= 15 (taxa-de-entrega 100)))))

(deftest taxa-para-compras-entre-100-e-200-test
  (testing "cobra 5 reais"
    (is (= 5 (taxa-de-entrega 101)))
    (is (= 5 (taxa-de-entrega 150)))
    (is (= 5 (taxa-de-entrega 199)))))

(deftest taxa-para-compras-a-partir-de-200-test
  (testing "não cobra taxa"
    (is (= 0 (taxa-de-entrega 200)))
    (is (= 0 (taxa-de-entrega 200.1)))
    (is (= 0 (taxa-de-entrega 201)))))

(deftest should-sum-values
  (testing "Deve somar dois valores"
    (is (= 4 (soma 2 2)))))