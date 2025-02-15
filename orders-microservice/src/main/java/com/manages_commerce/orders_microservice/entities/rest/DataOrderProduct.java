package com.manages_commerce.orders_microservice.entities.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataOrderProduct {

    private String id;
    private Double total;
    private Integer quantity;
    private DataProduct product;
}
