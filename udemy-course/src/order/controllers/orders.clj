(ns order.controllers.orders
  (:require [io.pedestal.connector :as conn]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.http-kit :as hk]
            [schema.core :as s]
            [order.models.compras-core :as model]))

(defn create-order
  [request]
  (let [order (:json-params request)]
    (s/validate model/Order order)
    {:status 201}))

(def routes
  #{["/orders"
     :post
     [(body-params/body-params)
      create-order]]})

(defn create-connector []
  (-> (conn/default-connector-map 8080)
      (conn/with-default-interceptors)
      (conn/with-routes routes)
      (hk/create-connector nil)))

(defonce *connector (atom nil))

(defn start []
  (reset! *connector
          (conn/start! (create-connector))))

(defn stop []
  (conn/stop! @*connector)
  (reset! *connector nil))

(defn restart []
  (when @*connector
    (stop))
  (start))