(ns IvannikovG.items-exchange-front.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [IvannikovG.items-exchange-front.events :as events]
   [IvannikovG.items-exchange-front.views :as views]
   [IvannikovG.items-exchange-front.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
