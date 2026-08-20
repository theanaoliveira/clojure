(ns vetores-test
  (:require [clojure.test :refer :all]
            [aulas.vetores :refer :all]))

(deftest should-get-vector-item-by-list
  (testing "Deve obter um item do vetor"
    (is (= "Ana" (pegar-item-vetor-list ["Pedro" "João" "Ana"] 2)))))

(deftest should-get-vector-item-by-get
  (testing "Deve obter um item do vetor"
    (is (= "Ana" (pegar-item-vetor-get ["Pedro" "João" "Ana"] 2)))))

(deftest should-replace-vector-item-using-assoc
  (testing "Deve substituir um item do vetor de acordo com a posição"
    (is (= ["Paula" "Maria"] (replace-value ["João" "Maria"] "Paula" 0)))
    (is (= ["João" "Ana"] (replace-value ["João" "Maria"] "Ana" 1)))))

(run-all-tests)

