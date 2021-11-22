(function () {
  "use strict";

  // CONTROLLER
  angular
    .module("listaComprasApp")
    .controller("AcessoController", acessoController);

  acessoController.$inject = ["helperfactory", "ListaComprasService"];

  function acessoController(helper, service) {
    var vm = this;

    vm.tiposEmail = [
      { id: 1, desc: "@hotmail.com", disable: false, tipo: "geral" },
      { id: 2, desc: "@outlook.com", disable: false, tipo: "geral" },
      { id: 3, desc: "@gmail.com", disable: false, tipo: "geral" },
      { id: 4, desc: "@stefanini.com", disable: false, tipo: "corporativo" },
      { id: 5, desc: "@yahoo.com.br", disable: true, tipo: "geral" },
      { id: 6, desc: "@empresa.com.br", disable: false, tipo: "corporativo" },
      { id: 7, desc: "@teste.com", disable: true, tipo: "corporativo" },
    ];

    /* ***************    FUNÇÕES EXECUTADAS NA VIEW (HMTL)    **************** */
    vm.logar = logar;
    vm.cadastrar = cadastrar;

    function logar() {
      return service.logar(vm.login).then(function (_resp) {
        if (_resp.error) {
          console.log("erro console", _resp);
          helper.addMsg(_resp.msg, "danger");
        } else {
          helper.addMsg(_resp.data, "success");
          helper.setRootScope("userLogged", _resp.xhrStatus);
        }
      });
    }

    function cadastrar() {
      var newUser = {
        name: vm.user.nome,
        email: vm.user.email,
        cpf: vm.user.cpf,
        login: vm.user.login,
        password: vm.user.password,
      };
      return service.cadastrar(newUser).then(function (_resp) {
        if (_resp.error) {
          helper.addMsg(_resp.msg.data.error, "danger", "tente novamente");
        } else {
          helper.addMsg("Usuário salvo com sucesso", "success");
          helper.setRootScope("userLogged", _resp.xhrStatus);
        }
      });
    }

    /* ***************    FUNÇÕES INSTERNAS    ******************************** */
  }
})();
