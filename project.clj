;https://devcenter.heroku.com/articles/clojure-web-application

(defproject rescuedogs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [javax.servlet/servlet-api "2.5"]
                 [org.clojure/data.json "0.2.4"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [uk.org.alienscience/leiningen-war "0.0.13"]]
  :main rescuedogs.core)
