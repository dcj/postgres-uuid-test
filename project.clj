(defproject postgres-uuid-test "1.0.0-SNAPSHOT"
  :description "Test the problem I have with writing UUIDs into Postgres"
  :dependencies [[org.clojure/clojure "1.2.1"]
  		 [postgresql/postgresql "9.1-901.jdbc4"]
	         [org.clojure/java.jdbc "0.1.1"]
		 [clojureql "1.1.0-SNAPSHOT"]
		 ])