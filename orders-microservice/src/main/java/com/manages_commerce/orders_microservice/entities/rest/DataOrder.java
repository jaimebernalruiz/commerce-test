package com.manages_commerce.orders_microservice.entities.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataOrder {

    private String id;
    private Double  total;
    private List<DataOrderProduct> orderProducts;

}
