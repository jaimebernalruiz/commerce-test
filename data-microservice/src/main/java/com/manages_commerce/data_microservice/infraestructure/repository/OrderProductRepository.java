package com.manages_commerce.data_microservice.infraestructure.repository;

import com.manages_commerce.data_microservice.domain.entities.db.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, String> {
}
