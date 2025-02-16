package com.manages_commerce.users_microservice.infraestructure.controller;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
import com.manages_commerce.users_microservice.domain.entities.rest.LoginRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateTokenUserRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.usecases.implementations.CreateUser;
import com.manages_commerce.users_microservice.usecases.implementations.LoginUser;
import com.manages_commerce.users_microservice.usecases.implementations.ValidateToken;
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

    @Autowired
    ValidateToken validateToken;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserRs createUser(@RequestBody UserDTO userDTO,
                                   @RequestHeader(value="token") String token){

        Boolean tokenValidated = this.validateToken.validateToken(token);

        if(tokenValidated){
            CreateUserRs result = this.createUser.create(userDTO);
            return result;
        }

        return null;
    }

    @PostMapping(value = "login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public LoginRs login(@RequestBody UserDTO userDTO){

        LoginRs result = this.loginUser.login(userDTO);

        return result;
    }

    @GetMapping(value = "/token/validate",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ValidateTokenUserRs validateToken(@RequestHeader(value="token") String token){

        return ValidateTokenUserRs.builder()
                .tokenValidate(this.validateToken.validateToken(token))
                .build();
    }

}
