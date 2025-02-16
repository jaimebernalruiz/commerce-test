package com.manages_commerce.data_microservice.infraestructure.controller;

import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.order.GetOrdersRs;
import com.manages_commerce.data_microservice.domain.entities.rest.product.GetProductRs;
import com.manages_commerce.data_microservice.domain.entities.rest.user.CreateUserRs;
import com.manages_commerce.data_microservice.domain.entities.rest.user.ValidateUserRs;
import com.manages_commerce.data_microservice.usecases.implementations.user.CreateUser;
import com.manages_commerce.data_microservice.usecases.implementations.user.GetOrders;
import com.manages_commerce.data_microservice.usecases.implementations.user.ValidateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("data-microservice/users")
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    CreateUser createUser;

    @Autowired
    ValidateUser validateUser;

    @Autowired
    GetOrders getOrders;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserRs createUser(@RequestBody UserDTO userDTO){
        LOGGER.info("@createUser > Start creation a new user");

        String id = this.createUser.create(userDTO);

        CreateUserRs result = CreateUserRs.builder().idUser(id).build();
        LOGGER.info("@createUser > Finished creation of a new user");

        return result;
    }


    @PostMapping(value = "/validate",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ValidateUserRs validateUser(@RequestBody UserDTO userDTO){
        LOGGER.info("@validateUser > Start  validation user");

        String id = this.validateUser.validate(userDTO);
        LOGGER.info("@createUser > Finished validation user");


        return ValidateUserRs.builder().idUser(id).build();
    }

    @GetMapping(value = "/{id}/orders",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetOrdersRs getOrdersByUser(@PathVariable String id){
        LOGGER.info("@getOrdersByUser > Get orders by user");

        GetOrdersRs result = this.getOrders.getOrders(id);
        return result;
    }

    @GetMapping(value = "/{id}/validate",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ValidateUserRs validateUserId(@PathVariable String id){
        LOGGER.info("@validateUserId > Start  validation user with id" );

        String idValidated = this.validateUser.validateById(id);
        LOGGER.info("@validateUserId > Finished validation user");

        return ValidateUserRs.builder().idUser(idValidated).build();
    }

}
