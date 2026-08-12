(ns aulas.core)

(defn valor-multa
  [valor]
  (println "Calculating fine...")
  (* valor 0.2))

(defn taxa-de-entrega
  "Se valor da compra for até 100, deve-se cobrar 15 reais de taxa de entrega.
   Se for maior que 100 e menor que 200, 5 reais
   Se for acima de 200, a taxa é gratuita"
  [valor]
  (cond
    (<= valor 100) 15
    (and (> valor 100)
         (< valor 200)) 5
    :else 0))