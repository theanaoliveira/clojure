(ns aulas.vetores)

;Vetor pode ser usado como uma função / lista

(defn pegar-item-vetor-list
  [names position] 
  (names position))
;Utilizando a função get, assim evita exceptions, caso o vetor seja vazio/nil ou o index invalido

(defn pegar-item-vetor-get
  [names position]
  (get names position))

(defn replace-value
  [names new-name position]
  (assoc names position new-name))
