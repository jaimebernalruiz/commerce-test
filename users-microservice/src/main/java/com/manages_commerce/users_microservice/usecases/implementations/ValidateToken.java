package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.infraestructure.components.JwtComponent;
import com.manages_commerce.users_microservice.usecases.interfaces.ValidateTokenInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateToken implements ValidateTokenInterface {

    @Autowired
    JwtComponent jwtComponent;

    @Override
    public Boolean validateToken(String token) {

        return this.jwtComponent.validateToken(token);
    }
}
