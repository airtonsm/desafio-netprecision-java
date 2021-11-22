(function () {
  "use strict";

  // MODULO
  angular
    .module("listaComprasApp")
    .service("ListaComprasService", listaComprasService);

  listaComprasService.$inject = ["$http", "constantes", "helperfactory"];

  function listaComprasService($http, constantes, helper) {
    // this.exemplo = exemplo;
    // function exemplo(params) {
    //     //implementação
    // }

    return {
      //exemplo: exemplo,
      logar: logar,
      cadastrar: cadastrar,
    };

    // function exemplo() {
    //   return $http
    //     .get("http://worldclockapi.com/api/json/est/now")
    //     .then(function (response) {
    //       console.log(response);
    //       return response.data;
    //     })
    //     .catch(function (error) {
    //       return error;
    //     });
    // }

    function logar(_params) {
      return $http
        .post(constantes.URL_BASE + "/api/login", _params)
        .then(function (response) {
          return response;
        })
        .catch(function (error) {
          return { error: true, msg: error.data.message };
        });
    }

    function cadastrar(_params) {
      return $http
        .post(constantes.URL_BASE + "/employees", _params)
        .then(function (response) {
          return response;
        })
        .catch(function (error) {
          return { error: true, msg: error };
        });
    }
  }
})();
