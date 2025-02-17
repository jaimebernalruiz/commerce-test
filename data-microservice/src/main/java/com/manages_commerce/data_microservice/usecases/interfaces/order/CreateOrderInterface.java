package com.manages_commerce.data_microservice.usecases.interfaces.order;

import com.manages_commerce.data_microservice.domain.entities.dto.OrderDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.order.CreateOrderRs;

public interface CreateOrderInterface {

    CreateOrderRs create(OrderDTO orderDTO);
}
