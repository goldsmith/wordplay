(defproject wordplay "0.1.0-SNAPSHOT"
  :description "API for cheating at board games"
  :url "http://github.com/goldsmith/wordplay"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [postgresql "9.1-901.jdbc4"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler wordplay.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
