package com.manages_commerce.data_microservice.infraestructure.repository;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
