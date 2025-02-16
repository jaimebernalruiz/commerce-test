package com.manages_commerce.orders_microservice.usecases.implementations;

import com.manages_commerce.orders_microservice.entities.rest.ValidateTokenUserRs;
import com.manages_commerce.orders_microservice.infraestructure.client.UserMicroserviceClient;
import com.manages_commerce.orders_microservice.usecases.interfaces.ValidateTokenInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateToken implements ValidateTokenInterface {

    @Autowired
    UserMicroserviceClient userMicroserviceClient;

    @Override
    public ValidateTokenUserRs validate(String token) {

        ValidateTokenUserRs result = this.userMicroserviceClient.validateToken(token);

        return result;
    }
}
