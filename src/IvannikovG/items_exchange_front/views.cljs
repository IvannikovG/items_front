(ns IvannikovG.items-exchange-front.views
    (:require
     [re-frame.core :as re-frame]
     [IvannikovG.items-exchange-front.subs :as subs]
     ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        last-event (re-frame/subscribe [::subs/last-event])]
    [:div
     [:h1 "Hello from " @name]
     [:h1 "Last event:" @last-event]]))
