package com.manages_commerce.orders_microservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderProductDTO {

    private String idProduct;
    private Integer quantity;
    private Double total;
}
