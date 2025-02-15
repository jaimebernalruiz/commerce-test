package com.manages_commerce.data_microservice.domain.entities.rest.order;

import com.manages_commerce.data_microservice.domain.entities.db.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderRs {

    private String idOrder;
}
