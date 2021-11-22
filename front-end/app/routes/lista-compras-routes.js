(function () {
  "use strict";

  // MODULO
  angular
    .module("listaComprasApp", ["ngRoute"])
    .config(routes)
    .run(configSDefault);

  routes.$inject = ["$routeProvider"];
  configSDefault.$inject = ["$rootScope"];

  function routes($routeProvider) {
    $routeProvider
      .when("/home", {
        templateUrl: "./templates/home.tpl.html",
      })
      .when("/login", {
        templateUrl: "./templates/login.tpl.html",
        // controller: 'AcessoController',
        // controller: 'vm'
      })
      .when("/register", {
        templateUrl: "./templates/register.tpl.html",
      })
      .otherwise({
        redirectTo: "/login",
      });
  }
  function configSDefault($rootScope) {
    $rootScope.listaMensagem = [];
  }
})();
