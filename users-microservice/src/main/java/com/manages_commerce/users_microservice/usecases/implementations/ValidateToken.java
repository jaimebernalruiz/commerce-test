package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.infraestructure.components.JwtComponent;
import com.manages_commerce.users_microservice.infraestructure.controller.UserController;
import com.manages_commerce.users_microservice.usecases.interfaces.ValidateTokenInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateToken implements ValidateTokenInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidateToken.class);

    @Autowired
    JwtComponent jwtComponent;

    @Override
    public Boolean validateToken(String token) {

        return this.jwtComponent.validateToken(token);
    }
}
