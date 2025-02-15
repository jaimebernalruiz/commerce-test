package com.manages_commerce.orders_microservice.infraestructure.controller;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
import com.manages_commerce.orders_microservice.entities.rest.Order;
import com.manages_commerce.orders_microservice.usecases.implementations.RegisterOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-microservice/orders")
public class OrderController {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    RegisterOrder registerOrder;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderRs cerateOrder(@RequestBody Order order){

        CreateOrderRs result = this.registerOrder.registerOrder(order);
        return result;
    }

}
