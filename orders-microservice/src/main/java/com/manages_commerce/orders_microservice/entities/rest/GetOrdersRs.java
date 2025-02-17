package com.manages_commerce.orders_microservice.entities.rest;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetOrdersRs {

    private List<DataOrder> orders;
}
