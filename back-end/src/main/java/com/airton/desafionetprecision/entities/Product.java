package com.airton.desafionetprecision.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    private Integer id;
    private String name;
    private BigDecimal price;
    private String ImageName;

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private Set<OrderProduct> orders = new HashSet<>();

    public Product(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
