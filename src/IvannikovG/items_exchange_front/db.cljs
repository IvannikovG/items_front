(ns IvannikovG.items-exchange-front.db)

(def default-db
  {:name "IvannikovG front DB"
   :last-event "App initialisation"
   :test "test"
   :items [{:name "Ledo hammer" :renter "4815162342"
            :date-from "01-01-2021" :date-to "01-11-2021"
            :details "Lorem ipsum" :phone "8-914-234-22-14" :trader-reputation "5"}
           {:name "Guyndyr hammer" :renter "4815162342"
            :date-from "01-01-2021" :date-to "01-11-2021"
            :details "Lorem ipsum" :phone "8-914-234-22-14"
            :trader-reputation "5"}
           {:name "Ledo hammer" :renter "4815162342"
            :date-from "01-01-2021" :date-to "01-11-2021"
            :details "Lorem ipsum" :phone "8-914-234-22-14"}
           ]})
