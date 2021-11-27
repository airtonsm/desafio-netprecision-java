(function () {
  "use strict";

  // MODULO
  angular.module("listaComprasApp").service("ProductService", productService);

  productService.$inject = ["$http", "constantes", "helperfactory"];

  function productService($http, constantes, helper) {
    return {
      listar: listar,
      cadastrar: cadastrar,
    };

    function cadastrar(_params) {
      return $http
        .post(constantes.URL_BASE + "/products", _params)
        .then(function (response) {
          return response;
        })
        .catch(function (error) {
          return { error: true, msg: error };
        });
    }

    function listar(fnSucesso, fnErro) {
      return $http({
        url: PATH_REST_SERVICES + "/nomeServizio",
        headers: { "Content-Type": undefined },
        data: formData,
        method: "POST",
      }).then(fnSucesso, fnErro);
    }

    // function listar() {
    //   return $http
    //     .get(constantes.URL_BASE + "/products")
    //     .then(function (response) {
    //       console.log("dentro da service: ", response.data);
    //       return response.data;
    //     })
    //     .catch(function (error) {
    //       console.log("error aqui");
    //       return { error: true, msg: error };
    //     });
    // }
  }
})();
