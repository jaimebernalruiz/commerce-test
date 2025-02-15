package com.manages_commerce.products_microservice.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private String category;
    private Double price;
}
