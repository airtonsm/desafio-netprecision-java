package com.airton.desafionetprecision.entities;

import com.airton.desafionetprecision.entities.pk.OrderProductPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public  class OrderProduct implements Serializable {

    @EmbeddedId
    private OrderProductPK id = new OrderProductPK();

    private Integer quantity;

    public OrderProduct(){}

    public OrderProduct(Order order, Product product, Integer quantity){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
    }

    public void setOrder(Order order){
         id.setOrder(order);
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(Integer quantity) {
        this.quantity -= quantity;
    }
}
