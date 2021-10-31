<h1 align="center">Desafio Netprecision Java</h1>

<p align="center">O desafio consiste em realizar servicos com o objetivo de auxiliar 
na venda de produtos de uma empresa que atua no ramo de lanchonetes.</p>

<br>
<br>

<h1 align="center">Tecnologias utilizadas</h1>
- Java 11 </br>
- Spring-boot  </br>
- Banco h2 e Postgres  </br>
- Docker  </br>
- Insomnia  </br>

 </br>


<h1 align="center"> Features </h1>

- [x] cria pedido
- [x] Adicionar produto no pedido
- [x] Retirar produto do pedido
- [x] Retirar produto do pedido
- [x] Calcular o preço total do pedido
- [ ] Fechar o pedido
- [ ] Calcular o preço total do pedido, passando os parâmetros: id do pedido, lista com os 
ids dos produtos e quantidade dos produtos. Deve retornar o preço total do pedido, 
levando em consideração os produtos e quantidades passados como parâmetro.

</br>

# Banco de dados

</br>

## H2
Segue endereço para console do H2 (dados de acesso padrão):

http://localhost:8080/h2-console

Foram criados três tabelas:

- TB_PRODUCT (Tabela para guardar Produtos)
- TB_ORDER_PRODUCT  (Tabela de relacionamento entre Produtos e Carrinhos)
- TB_ORDER  (Tabela para guardar Pedidos)

</br>

## Postgres

Foi utilizado imagem docker para criação do bando de dados Postgres.
Informações da imagem estão do arquivo ``docker-compose.yml`` e informações de acesso ao banco estão no arquivo ``application-dev.properties``

- comando para subir a image docker postgres

    ``` docker-compose -d```

</br>
</br>

# Endpoints

### Criar pedido ```POST``` /orders

http://localhost:8080/orders


### Adicionar produto Carrinho ```POST``` /orders/add-product/{id}

http://localhost:8080/orders/add-product/{id}


- JSON utilizado para inserir produto a um carrinho existente

```Json
[
	{
		"id": 1154,
		"quantity": 1
	}
]
```


### Retirar produto do carrinho ```DELETE``` /orders/remove-product/{id}

http://localhost:8080/orders/remove-product/1

- JSON utilizado para remover o produto do pedido é conforme o exemplo mostrado do endpoint anterior.


