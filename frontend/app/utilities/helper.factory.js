(function () {
  "use strict";

  angular.module("listaComprasApp").factory("helperfactory", helperfactory);

  helperfactory.$inject = ["$rootScope", "constantes"];

  function helperfactory($rootScope, constantes) {
    $rootScope.listaMensagens = [];

    return {
      addMsg: addMsg,
      setRootScope: setRootScope,
      getRootScope: getRootScope,
      sendError: sendError,
      sendErrorRegister: sendErrorRegister,
    };

    function addMsg(_msg, _tipo, _acao) {
      $rootScope.listaMensagens.splice(0);
      $rootScope.listaMensagens.push({
        text: _msg ? _msg : constantes.MSG_ERRO,
        tipo: _tipo ? _tipo : "info",
        acao: _acao ? _acao : "",
      });
    }

    function path(_path) {
      $rootScope.listaMensagens = [];
      return _path ? $location.path(_path) : $location.path();
    }

    function setRootScope(_key, _obj) {
      $rootScope[_key] = _obj;
    }

    function getRootScope(_key, _obj) {
      return $rootScope[_key];
    }

    function sendError(_error) {
      return { error: true, msg: _error.data.messagem };
    }

    function sendErrorRegister(_error) {
      return { error: true, msg: _error };
    }
  }
})();
