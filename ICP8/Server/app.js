'use strict'
angular.module('know', [])

    .controller('knowctrl', function($scope, $http) {
        $scope.a=false;
        $scope.getdetails = function () {
            $http.get("https://kgsearch.googleapis.com/v1/entities:search?query="+ $scope.search+"&key=%20AIzaSyDMEBecZDKiws3eLRFIi1IO1E6Vm9s4Xj8%20&limit=1&indent=True").then(function (t) {
                console.log(t);
                $scope.nam=t.data.itemListElement[0].result.name;
                $scope.x = t.data.itemListElement[0].result.description;
                $scope.y=t.data.itemListElement[0].result.detailedDescription.url;
                $scope.a=true;

            })
        }
    })