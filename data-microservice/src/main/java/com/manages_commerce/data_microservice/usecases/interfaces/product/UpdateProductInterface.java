package com.manages_commerce.data_microservice.usecases.interfaces.product;

import com.manages_commerce.data_microservice.domain.entities.db.Product;

public interface UpdateProductInterface {

    public Product update(Product product);
}
