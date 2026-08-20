(ns aulas.aula-let)

;Aula sobre `let`, uma forma especial usada para criar associações locais
;(bindings) entre nomes e valores. Esses nomes podem ser utilizados apenas dentro
;do bloco do `let`, o que ajuda a organizar cálculos intermediários sem criar
;variáveis globais. As associações são avaliadas em sequência: uma pode usar as
;que foram declaradas antes dela.

(defn valor-multa
  "Calcula o valor da multa"
  [valor]
  (let [percentual-multa 0.1]
    (* valor percentual-multa)))

(defn valor-total
  [valor]
  (let [percentual-multa 0.1
        valor-multa (* valor percentual-multa)]
    (println "Calculando valor total com let" valor)
    (+ valor valor-multa)))

(valor-total 266)

(defn valor-total-2
  "Calcula o valor total chamando outra function"
  [valor]
  (println "Calculando valor total chamando outra function" valor)
  (+ valor (valor-multa valor)))

(valor-total-2 266)
