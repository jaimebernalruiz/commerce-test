package com.manages_commerce.orders_microservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderDTO {

    private List<OrderProductDTO> orderProducts;
    private Double total;
    private String idUser;
}
