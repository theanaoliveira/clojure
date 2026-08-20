(ns aulas.tipos)

(defn calcula-media-vetor
  [nomes]
  (let [qtd_items (count nomes)
        vetor_qtd_letters (map count nomes)
        sum_items (reduce + vetor_qtd_letters)]
    (double (/ sum_items qtd_items))))

(calcula-media-vetor ["Carol" "Maria" "Ana"])

;; DESAFIO final: Crie uma função que recebe um vetor de nomes e retorne o
;; tamanho médio dos nomes, mas deve-se ignorar nomes com 3 ou menos caracteres.

(defn filter-function
  [names]
  (let [names-qtd (map count names)
        names-filter (filter #(> % 3) names-qtd)
        qtd-final (count names-filter)
        sum (reduce + names-filter)]
    (double (/ sum qtd-final))))

(filter-function ["Ana" "Joao" "Marta" "Caroline" "Jao"])
