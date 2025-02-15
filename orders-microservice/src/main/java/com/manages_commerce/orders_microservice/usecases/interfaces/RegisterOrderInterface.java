package com.manages_commerce.orders_microservice.usecases.interfaces;

import com.manages_commerce.orders_microservice.entities.rest.Order;

public interface RegisterOrderInterface {

    public String registerOrder(Order order);
}
