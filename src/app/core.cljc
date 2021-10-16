(ns app.core
  (:require [reagent.core :as r]
            [reagent.dom :as dom]
            [re-frame.core :as rf]
            [stylo.core :refer [c]]
            [stylo.rule :refer [rule]]
            [re-frame.db :as db]
            [app.pages]
            [clojure.string :as str]))


(defmethod rule :w-half [_] [[:& {:width "50%"}]])

(rf/reg-event-fx
 :initialize
 (fn [_ _]
   ;; effect
   {}))


(def hiding-text-100
  (c #_[:w 30] [:h 70] :truncate :shadow-xs))

(def global-class
  (c :justify-center :m-auto [:bg :blue-300] [:px 5] [:pb 2] :flex :border-double :rounded #_:flex-grow))


(defn quadrats
  []
  [:div {:class (c :flex :justify-between)}
   [:div {:class (c [:m 2] [:w 95] [:h 50] [:bg :gray-200] :border)}]
   [:div {:class (c :flex :justify-between [:m 2] [:w 95] [:h 50] [:bg :gray-200] :border)}
    [:div {:class (c :flex :flex-col :justify-between [:w 30] [:h 50] [:bg :gray-200] :border)}
     [:div {:class (c :flex :border :rounded :flex-wrap [:bg :green-800] [:w 30] [:h 30])}
      [:div {:class (c :flex)}
       [:div {:class (c :border :self-start :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :self-start :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :self-start :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :rounded :self-start [:bg :yellow-800] [:w 14] [:h 14])}]]
      [:div {:class (c :border :rounded :self-start [:bg :gray-800] [:w 2] [:h 2])}]
      [:div {:class (c :flex)}
       [:div {:class (c :border :self-end :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :self-end :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :self-end :rounded [:bg :yellow-800] [:w 5] [:h 5])}]
       [:div {:class (c :border :rounded :self-end [:bg :yellow-800] [:w 14] [:h 14])}]]]
     [:div {:class (c :border :rounded [:bg :green-800] [:w 20] [:h 20])}]]
    [:div {:class (c :border :rounded [:bg :orange-800] [:w 30] )}]]])

(defn simple-input
  [name placeholder]
  [:div {:class (c :flex [:mb 2] [:mt 2] :justify-between :rounded :border )}
   
   [:div {:class (c :font-light [:mr 2] [:ml 2] [:p 2] :rounded :border [:bg :blue-600])} name]

   [:input {:class (c [:p 2] [:mr 2] [:ml 2] :rounded :border [:bg :green-600])
            :placeholder placeholder}]
   [:button {:class (c :font-light [:mr 2] [:ml 2] [:p 2] :rounded :border [:bg :yellow-600])
             :placeholder placeholder} "delete"]])

(def element-style
  (c :flex [:bg :green-300] :font-mono :border))


(defn form
  []
  [:div {:class (c :w-full :flex :border :rounded :justify-between)}
   [:div
    [:div {:class (c [:w 60] [:h 60]
                     [:bg :yellow-200] :border :rounded)} "Fotka"]
    [:div "Items"]]
   [:div {:class (c :flex-col :justify-end)}
    [:div {:class element-style} [:div {:class (c [:m 2])} "Author:"] [:div {:class (c [:m 2])} "Author name"]]
    [:div {:class element-style} [:div {:class (c [:m 2])} "Sample 1:"] [:div {:class (c [:m 2])} "Sample 1"]]
    [:div {:class element-style} [:div {:class (c [:m 2])} "Sample 2:"] [:div {:class (c [:m 2])} "Sample 2"]]
    [:div "Explanation"]
    [:div "Explanation"]
    [:div "Explanation"]]
   ])

(defn page
  []
  [:div {:class (c [:w 720])}
   [simple-input "Enter name" "plc-holder"]
   [simple-input "Enter name" "plc-holder"]
   [quadrats]
   [form]])


(defn init []
  {})

(defn ui
  []
  [:div {:class global-class}
   [page]])

;; Re-frame machinery
(def compiler
  (r/create-compiler {:function-components true}))

(defn render [] (dom/render [ui] (js/document.getElementById "app") compiler))

(defn ^:dev/after-load clear-cache-and-render!
  []
  (rf/clear-subscription-cache!)
  (render))

(defn run [] (rf/dispatch-sync [:initialize]) (render))

(run)
