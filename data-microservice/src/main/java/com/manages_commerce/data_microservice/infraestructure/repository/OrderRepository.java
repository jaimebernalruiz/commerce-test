package com.manages_commerce.data_microservice.infraestructure.repository;

import com.manages_commerce.data_microservice.domain.entities.db.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
