(defproject rescuedogs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.3"]
                 [uk.org.alienscience/leiningen-war "0.0.13"]]
  :main rescuedogs.core)
