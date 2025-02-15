package com.manages_commerce.users_microservice.infraestructure.controller;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.usecases.implementations.CreateUser;
import com.manages_commerce.users_microservice.usecases.implementations.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-microservice/users")
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    CreateUser createUser;

    @Autowired
    LoginUser loginUser;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserRs createProduct(@RequestBody UserDTO userDTO){

        CreateUserRs result = this.createUser.create(userDTO);

        return result;
    }

    @PostMapping(value = "login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ValidateUserRs login(@RequestBody UserDTO userDTO){

        ValidateUserRs result = this.loginUser.login(userDTO);

        return result;
    }
}
