(ns postgres-uuid-test.core
  (:use clojureql.core)
  (:require [clojure.java.jdbc :as sql])
  (:import [java.util UUID]))

(def postgres-db {;; :classname "org.postgresql.Driver"
		  :subprotocol "postgresql"
                  :subname "//localhost:5432/clojure_test"
                  :user "postgres"
                  :password ""})

(defn create-test-table
  []
  (sql/with-connection postgres-db
    (sql/create-table
     :testuuid
      [:uid "UUID"]
      [:name "VARCHAR(32)"])))

(def u1 (. UUID (randomUUID)))
(def u2 (. UUID (randomUUID)))

(defn write-uuid-jdbc
  [uid name]
  (sql/with-connection postgres-db
    (sql/insert-values
     :testuuid
     [:uid :name]
     [uid name])))

(defn read-table-clojureql
  []
  @(table postgres-db :testuuid))

(defn write-uuid-clojureql
  [uid name]
  (conj! (table postgres-db :testuuid)
	 {:uid uid :name name}))





  