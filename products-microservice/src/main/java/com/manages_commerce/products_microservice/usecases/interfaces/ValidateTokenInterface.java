package com.manages_commerce.products_microservice.usecases.interfaces;


import com.manages_commerce.products_microservice.entities.rest.ValidateTokenUserRs;

public interface ValidateTokenInterface {

    ValidateTokenUserRs validate(String token);
}
