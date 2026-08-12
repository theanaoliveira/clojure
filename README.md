# Clojure Course

An introductory Clojure project with small lessons and tests.

## Running

Start a REPL from the project directory:

```bash
clj
```

Then load a namespace and call a function:

```clojure
(require '[aulas.core :as core])
(core/taxa-de-entrega 150) ; => 5
```

Run the test namespace with:

```bash
clj -Sdeps '{:paths ["src" "test"]}' -M -e "(require 'core-test) (clojure.test/run-tests 'core-test)"
```

## Concepts Covered

### REPL

REPL means *Read, Eval, Print, Loop*. It is an interactive environment: we
write an expression, Clojure evaluates it, and immediately prints the result.
It is useful for trying functions and checking ideas quickly.

```clojure
(+ 2 3) ; => 5
```

### Immutability

Values such as vectors and maps are not changed in place. Operations such as
`conj` return a new collection, while the original stays unchanged. This makes
code more predictable and avoids unexpected side effects.

```clojure
(def purchases ["bread" "milk"])
(conj purchases "coffee") ; => ["bread" "milk" "coffee"]
purchases                  ; => ["bread" "milk"]
```

### Pure and Impure Functions

A pure function always returns the same result for the same input and does not
cause external effects. An impure function depends on or changes something
outside itself, for example by using `println`. `valor-multa` in `aulas.core`
is impure because it prints a message as well as calculating a value.

```clojure
(defn double-number [number] (* number 2)) ; pure
(defn display [text] (println text))        ; impure
```

### `def`, `let`, and `defn`

`def` creates a namespace-level binding, usually for values that need to be
reused. `let` creates local bindings, valid only inside its block. `defn`
defines a named function.

```clojure
(def fine-rate 0.1)

(defn total-with-fine [amount]
  (let [fine (* amount fine-rate)]
    (+ amount fine)))
```

### Expressions and Prefix Notation

In Clojure, almost everything is an expression: code is evaluated and produces
a value. Function calls use prefix notation: the function comes before its
arguments, inside parentheses.

```clojure
(+ 2 3)       ; => 5
(= 5 (+ 2 3)) ; => true
```

### Collections

The main collections are vectors `[]`, lists `()`, maps `{}`, and sets `#{}`.
Vectors preserve order, maps associate keys with values, and sets do not keep
duplicate items.

```clojure
["Ana" "Bia"]              ; vector
'(1 2 3)                    ; list
{:name "Ana" :age 25}       ; map
#{:clojure :java :clojure}  ; => #{:clojure :java}
```

### `nil` and Truthiness

In a condition, only `false` and `nil` are considered false. Every other value
— including `0`, empty strings, and empty collections — is true.

```clojure
(if [] "true" "false")  ; => "true"
(if nil "true" "false") ; => "false"
```

### Conditionals and Predicates

`if` chooses between two paths, `when` evaluates code only when its condition
is true, and `cond` handles several conditions. Predicates are functions that
return `true` or `false`; by convention, their names end in `?`.

```clojure
(cond
  (neg? -2) "negative"
  (zero? -2) "zero"
  :else "positive")
```

### Namespaces and `require`

Namespaces organize code and prevent name conflicts. `require` loads another
namespace; an alias such as `core` makes calls shorter.

```clojure
(require '[aulas.core :as core])
(core/taxa-de-entrega 150) ; => 5
```

### Higher-Order Functions

Higher-order functions receive functions as arguments or return functions.
`map`, `filter`, and `reduce` are common examples for transforming, selecting,
and combining data without changing the original collection.

```clojure
(map inc [1 2 3])        ; => (2 3 4)
(filter even? [1 2 3 4]) ; => (2 4)
(reduce + [1 2 3 4])     ; => 10
```

### Recursion

Recursion is when a function calls itself to solve a problem in smaller parts.
In Clojure, `recur` performs that call efficiently in tail position, without
growing the call stack.

```clojure
(defn sum-to [number]
  (loop [current number total 0]
    (if (zero? current)
      total
      (recur (dec current) (+ total current)))))

(sum-to 3) ; => 6
```

### Testing

Automated tests check that behavior remains correct when code changes. In this
project, `test/core_test.clj` uses `clojure.test`: `deftest` defines a test,
`testing` describes the scenario, and `is` checks an expectation. The
`taxa-de-entrega` function is tested across its three price ranges.

```clojure
(is (= 5 (taxa-de-entrega 150)))
```

## Project Structure

- `src/aulas/`: lesson namespaces.
- `test/core_test.clj`: tests for delivery-fee rules.
