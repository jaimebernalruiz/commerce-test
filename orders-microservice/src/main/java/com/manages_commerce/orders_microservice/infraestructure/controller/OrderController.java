package com.manages_commerce.orders_microservice.infraestructure.controller;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
import com.manages_commerce.orders_microservice.entities.rest.GetOrdersRs;
import com.manages_commerce.orders_microservice.entities.rest.Order;
import com.manages_commerce.orders_microservice.entities.rest.ValidateTokenUserRs;
import com.manages_commerce.orders_microservice.usecases.implementations.GetOrders;
import com.manages_commerce.orders_microservice.usecases.implementations.RegisterOrder;
import com.manages_commerce.orders_microservice.usecases.implementations.ValidateToken;
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

    @Autowired
    ValidateToken validateToken;

    @Autowired
    GetOrders getOrders;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderRs createOrder(@RequestBody Order order,
                                     @RequestHeader(value="token") String token){
        LOGGER.info("@createOrder > Start creation a new order");

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()){
            CreateOrderRs result = this.registerOrder.registerOrder(order,token);
            LOGGER.info("@createOrder > Finished creation of a new order");

            return result;
        }
       return null;
    }

    @GetMapping(value = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetOrdersRs getOrdersByUser(@PathVariable String id,
                                       @RequestHeader(value="token") String token){
        LOGGER.info("@createOrder > Start get order by user");

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()){
            GetOrdersRs result = this.getOrders.getOrders(id);
            LOGGER.info("@createOrder > Finished get order by user");

            return result;
        }
        return null;
    }

}
