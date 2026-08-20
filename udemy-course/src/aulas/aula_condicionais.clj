(ns aulas.aula-condicionais)

;Aula sobre condicionais em Clojure.
;
;`if` é uma forma especial usada para escolher entre dois caminhos: executa uma
;expressão quando a condição é verdadeira e outra quando ela é falsa.
;A condição normalmente é avaliada por uma função predicado, isto é, uma função
;que responde `true` ou `false`. Por convenção, nomes de predicados terminam em
;`?`, como `pos?`, `neg?` e `nil?`.


(defn imposto-retido
  "Calcula o imposto do salario com base no valor"
  [salario]
  (let [isento                 0
        imposto-primeira-faixa 0.1
        imposto-segunda-faixa  0.2]
    (if (<= salario 1000)
      (* salario isento)
      (if (< salario 2000)
        (* salario imposto-primeira-faixa)
        (* salario imposto-segunda-faixa)))))

(println (imposto-retido 950))

(defn isento-imposto-?
  [valor]
  (if (<= valor 1000)
    true))

(isento-imposto-? 900)

(defn isento-imposto-?
  [valor]
  (<= valor 1000))

(isento-imposto-? 900)

(defn imprimir-mensagem-boas-vindas
  [idade]
  (let [idade-valida 18]
    (when (>= idade idade-valida)
      (println "Esta mensagem será exibida apenas para usuários (as) maior que 18 anos"))))

(defn imprimir-mensagem-boas-vindas*
  [idade idade-valida]
  (->> idade
       (>= idade-valida)
       (when (println "Esta mensagem será exibida apenas para usuários (as) maior que 18 anos"))))

(imprimir-mensagem-boas-vindas* 17 18)