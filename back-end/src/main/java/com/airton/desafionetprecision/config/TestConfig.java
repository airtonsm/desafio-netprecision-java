package com.airton.desafionetprecision.config;

import com.airton.desafionetprecision.entities.Order;
import com.airton.desafionetprecision.entities.OrderProduct;
import com.airton.desafionetprecision.entities.Product;
import com.airton.desafionetprecision.repositories.OrderRepository;
import com.airton.desafionetprecision.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile({"test","dev"})
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product(1147L, "Cachorro quente", BigDecimal.valueOf(3.00));
        Product p2 = new Product(1154L, "Bauru", BigDecimal.valueOf(2.50));
        Product p3 = new Product(1164L, "Misto Quente", BigDecimal.valueOf(2.00));
        Product p4 = new Product(1155L, "x-Burger", BigDecimal.valueOf(6.00));

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();

        order1.getProducts().add(new OrderProduct(order1, p1, 4));
        order1.getProducts().add(new OrderProduct(order1, p3, 3));

        order2.getProducts().add(new OrderProduct(order2, p4, 2));
        order2.getProducts().add(new OrderProduct(order2, p2, 3));

        order3.getProducts().add(new OrderProduct(order3, p2, 1));

        orderRepository.saveAll((Arrays.asList(order1,order2,order3)));

    }
}
