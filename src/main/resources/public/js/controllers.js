angular.module('app.controllers', []).controller('FarmaciiListController', function($scope, $state, popupService, $window, Farmacie) {
  $scope.Farmacie = Farmacie.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deletefarmacie = function(farmacie) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      farmacie.$delete(function() {
        $scope.farmacii = Farmacii.query(); 
        $state.go('farmacii');
      });
    }
  };
}).controller('FarmacieViewController', function($scope, $stateParams, Farmacie) {
  $scope.farmacie = farmacie.get({ id_farmacie: $stateParams.id_farmacie }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('FarmacieCreateController', function($scope, $state, $stateParams, Farmacie) {
  $scope.Farmacie = new Farmacie();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addFarmacie = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.farmacie.$save(function() {
      $state.go('farmacii'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('FarmacieEditController', function($scope, $state, $stateParams, Farmacie) {
  $scope.updateFarmacie = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.farmacie.$update(function() {
      $state.go('farmacii'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadShipwreck = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.shipwreck = Shipwreck.get({ id: $stateParams.id });
  };

  $scope.loadShipwreck(); // Load a shipwreck which can be edited on UI
});
