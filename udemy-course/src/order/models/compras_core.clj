(ns order.models.compras-core
  (:require [schema.core :as s]))

(s/defschema Order
  {:order-id s/Uuid
   :customer-id s/Uuid
   :customer-name s/Str
   :amount   s/Num})