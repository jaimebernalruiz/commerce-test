package com.manages_commerce.data_microservice.infraestructure.controller;

import com.manages_commerce.data_microservice.domain.entities.dto.OrderDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.order.CreateOrderRs;
import com.manages_commerce.data_microservice.usecases.implementations.order.CreateOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("data-microservice/orders")
public class OrderController {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    CreateOrder createOrder;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderRs createOrder(@RequestBody OrderDTO orderDTO){
        LOGGER.info("@createOrder > Start save a new order");

        CreateOrderRs result = this.createOrder.create(orderDTO);
        LOGGER.info("@createOrder > Finished save a new order");
        return result;
    }

}
