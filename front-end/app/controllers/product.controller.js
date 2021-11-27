(function () {
  "use strict";

  // CONTROLLER
  angular
    .module("listaComprasApp")
    .controller("ProductController", productController);

  productController.$inject = ["helperfactory", "ProductService", "$scope"];

  function productController(helper, service, $scope) {
    var vm = this;

    vm.isImagem = false;
    vm.isEnviado = false;
    vm.cadastrar = cadastrar;
    vm.iniciar = iniciar;
    vm.listarProdutos = listarProdutos;

    vm.sucesso = sucesso;
    vm.erro = erro;

    vm.produtosListados = [];

    vm.produto = {
      id: "",
      nome: "",
      price: null,
      nomeArquivo: null,
      dados: null,
    };

    vm.categoria = [
      { id: 1, desc: "Café da manhã", tipo: "Café da manhã" },
      { id: 2, desc: "Almoço", tipo: "Almoço" },
      { id: 3, desc: "Jantar", tipo: "Jantar" },
      { id: 4, desc: "Kid", tipo: "Kid" },
      { id: 5, desc: "lanche", tipo: "lanche" },
      { id: 6, desc: "Sobremesa", tipo: "Sobremesa" },
    ];

    /**************FUNCÇÕES EXECUTADAS NA VIEW*********** */

    function iniciar() {
      listarProdutos();
    }

    function cadastrar() {
      vm.addFile();
    }

    function enviarCadastro() {
      var newProduct = {
        id: vm.produto.id,
        name: vm.produto.nome,
        price: vm.produto.preco,
        imageName: vm.produto.nomeArquivo,
        base64: vm.produto.dados,
      };
      return service.cadastrar(newProduct).then(function (_resp) {
        console.log("produto enviado: ", newProduct);
        if (_resp.error) {
          helper.addMsg(_resp.msg.data.error, "danger", "tente novamente");
        } else {
          helper.addMsg("Produto cadastrado com sucesso", "success");
          helper.setRootScope("userLogged", _resp.xhrStatus);
        }
      });
    }

    vm.addFile = addFile;
    vm.verificarUpload = verificarUpload;

    function addFile() {
      const arquivoInserido = document.getElementById("arquivo").files[0];

      if (!arquivoInserido) {
        return;
      }

      const reader = new FileReader();

      reader.onloadend = function (loadedFile) {
        vm.verificarUpload(loadedFile.target.result, arquivoInserido.name);
      };

      reader.readAsDataURL(arquivoInserido);
    }

    function verificarUpload(base64, nomeArquivo) {
      vm.produto.nomeArquivo = nomeArquivo;
      vm.produto.dados = base64;
      vm.isImagem = vm.produto.dados.includes("data:image");
      vm.isEnviado = true;
      $scope.$apply();
      console.log("nome imagem: ", vm.produto.nomeArquivo);
      enviarCadastro();
    }

    function listarProdutos() {
      service.listar(vm.sucesso, vm.erro);
    }

    function sucesso(resposta) {
      vm.produtosListados = resposta.data;
    }

    function erro(erro) {
      console.log(erro);
    }
  }
})();
