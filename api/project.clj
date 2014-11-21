(defproject api "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [io.pedestal/pedestal.service "0.3.1"]
                 [io.pedestal/pedestal.jetty "0.3.1"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]
                 [com.datomic/datomic-pro "0.9.4815.12" :exclusions [org.slf4j/slf4j-nop]]
                 [com.taoensso/carmine "2.7.0"]
                 [turbovote.datomic-toolbox "0.2.4" :exclusions [com.datomic/datomic-pro]]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :profiles {:dev {:resource-paths ["dev-resources"]
                   :source-paths ["dev-src"]
                   :aliases {"run-dev" ["trampoline" "run" "-m" "api.server/run-dev"]
                             "reset-db" ["run" "-m" "dev.db"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.3.1"]]}}
  :repositories {"my.datomic.com" {:url "https://my.datomic.com/repo"
                                   :username [:gpg :env]
                                   :password [:gpg :env]}}
  :main ^{:skip-aot true} api.server)
