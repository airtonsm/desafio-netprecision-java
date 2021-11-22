package com.airton.desafionetprecision.entities.pk;

import com.airton.desafionetprecision.entities.Order;
import com.airton.desafionetprecision.entities.Product;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


/*
    classe auxiliar, serve como chave primária segundária
 para relacionamento e gerenciamento entre classes
 com itens extras
 */

@Data
@Embeddable
public class OrderProductPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
