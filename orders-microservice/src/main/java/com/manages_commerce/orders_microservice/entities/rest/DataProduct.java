package com.manages_commerce.orders_microservice.entities.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataProduct {

    private String id;
    private String name;
    private String category;
    private Double price;
}
