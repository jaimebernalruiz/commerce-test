package com.manages_commerce.orders_microservice.usecases.interfaces;

import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
import com.manages_commerce.orders_microservice.entities.rest.Order;

public interface RegisterOrderInterface {

    public CreateOrderRs registerOrder(Order order, String token);
}
