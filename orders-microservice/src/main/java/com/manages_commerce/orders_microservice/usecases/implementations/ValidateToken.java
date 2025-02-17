package com.manages_commerce.orders_microservice.usecases.implementations;

import com.manages_commerce.orders_microservice.entities.rest.ValidateTokenUserRs;
import com.manages_commerce.orders_microservice.infraestructure.client.UserMicroserviceClient;
import com.manages_commerce.orders_microservice.usecases.interfaces.ValidateTokenInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateToken implements ValidateTokenInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidateToken.class);

    @Autowired
    UserMicroserviceClient userMicroserviceClient;

    @Override
    public ValidateTokenUserRs validate(String token) {
        LOGGER.info("@validate > will validate token");

        ValidateTokenUserRs result = this.userMicroserviceClient.validateToken(token);

        LOGGER.info("@validate > validation result " +result.toString());
        return result;
    }
}
