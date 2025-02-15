package com.manages_commerce.products_microservice.usecases.interfaces;

import com.manages_commerce.products_microservice.entities.rest.GetProductRs;

public interface GetProductInterface {

    GetProductRs getProduct(String id);
}
