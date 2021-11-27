package com.airton.desafionetprecision.repositories;

import com.airton.desafionetprecision.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
