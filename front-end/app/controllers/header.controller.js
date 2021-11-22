(function () {
  "use strict";

  // CONTROLLER
  angular
    .module("listaComprasApp")
    .controller("HeaderController", headerController);

  headerController.$inject = [
    "$location",
    "ListaComprasService",
    "helperfactory",
  ];

  function headerController($location, service, helper) {
    var vm = this;

    /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */

    vm.go = go; //redireciona as rotas setadas no html
    vm.serviceF = serviceF;
    vm.ativo = false;

    function go(_path) {
      var path = _path ? _path : $location.path();
      if (path === "/login" || path === "/register") {
        $location.path(path);
      } else {
        isLoggedIn(path);
      }
      setPage();
    }

    function serviceF(_path) {
      return service.exemplo().then(function (response) {});
    }

    /* ***************    FUNÇÕES INSTERNAS    ******************************** */

    function isLoggedIn(_path) {
      if (helper.getRootScope("userLogged")) {
        $location.path(_path);
      } else {
        $location.path("/login");
        helper.addMsg(
          "Você não tem acesso a esta página",
          "danger",
          "Faça o Login!"
        );
      }
    }

    function setPage() {
      helper.setRootScope("page", $location.path().substring(1));
    }
  }
})();
