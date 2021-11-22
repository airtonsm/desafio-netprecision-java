package com.airton.desafionetprecision.repositories;

import com.airton.desafionetprecision.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
