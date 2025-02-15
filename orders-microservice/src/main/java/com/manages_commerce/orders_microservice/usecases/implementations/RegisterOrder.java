package com.manages_commerce.orders_microservice.usecases.implementations;

import com.manages_commerce.orders_microservice.entities.rest.Order;
import com.manages_commerce.orders_microservice.usecases.interfaces.RegisterOrderInterface;
import org.springframework.stereotype.Service;

@Service
public class RegisterOrder implements RegisterOrderInterface {


    @Override
    public String registerOrder(Order order) {
        return null;
    }
}
