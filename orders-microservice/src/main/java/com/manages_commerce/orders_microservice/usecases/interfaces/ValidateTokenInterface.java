package com.manages_commerce.orders_microservice.usecases.interfaces;

import com.manages_commerce.orders_microservice.entities.rest.ValidateTokenUserRs;

public interface ValidateTokenInterface {

    ValidateTokenUserRs validate(String token);
}
