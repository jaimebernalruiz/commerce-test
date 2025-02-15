package com.manages_commerce.data_microservice.domain.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private List<OrderProductDTO> orderProducts;
    private Double total;
    private String idUser;
}
