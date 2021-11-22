(function () {
    "use strict";

    // MODULO
    angular.module('listaComprasApp')
        .factory('ListaComprasFactory', listaComprasFactory);
    
    listaComprasFactory.$inject = [];

    function listaComprasFactory(){

        return {
            name : name
        }
        
        function name(params){
            // implementar
        }

    }

})();