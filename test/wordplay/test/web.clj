(ns wordplay.test.web
  (:use clojure.test
        ring.mock.request
        wordplay.web))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "<h2>Hello World</h2>"))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))
