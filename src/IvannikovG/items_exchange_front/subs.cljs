(ns IvannikovG.items-exchange-front.subs
    (:require
     [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))


(re-frame/reg-sub
 ::last-event
 (fn [db]
   (:last-event db)))
