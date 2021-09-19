(ns IvannikovG.items-exchange-front.views
    (:require
     [re-frame.core :as re-frame]
     [IvannikovG.items-exchange-front.subs :as subs]
     [garden.core :refer [css]]))


(defn grid
  [column-names columns]


  )

(defn item-element [{:keys [name renter date-from
                            date-to details phone
                            trader-reputation]}]
  [:div
   [:span name]
   [:span renter]
   [:span date-from]
   [:span date-to]
   [:span details]
   [:span phone]
   [:span trader-reputation]
   ])

(defn items-view-header
  []
  [:div
   [:span "Item name"]
   [:span "Renter"]
   [:span "Date from"]
   [:span "Date to"]
   [:span "Details"]
   [:span "Phone"]
   [:span "Reputation"]]
  )

(defn items-view
  [items]
  (when-not (nil? items)
    [:div
     [:div [items-view-header]]
     (for [item items]
       ^{:key item} [item-element item])]))


(defn main-panel []
  (let [name       (re-frame/subscribe [::subs/name])
        last-event (re-frame/subscribe [::subs/last-event])
        items      (re-frame/subscribe [::subs/items])]
    [:div {:style {:display "flex"
                   :margin "auto"
                   :padding "2px"
                   :justify-content "center"
                   #_#_:flexdirection "row"}}
     [:div {:style {:padding "2px"}} "test" ]
     [:div {:style {:padding "2px"}} "test" ]]
    #_[:div
     [:h1 {:color "red"} "Hello from " @name]
     [:h1 {:style {:font-size "16px"}} "Last event:" @last-event]
     (items-view @items)]))
