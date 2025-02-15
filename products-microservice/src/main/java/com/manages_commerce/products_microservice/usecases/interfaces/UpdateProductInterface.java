package com.manages_commerce.products_microservice.usecases.interfaces;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.UpdateProductRs;

public interface UpdateProductInterface {

    public UpdateProductRs update(ProductDTO product);
}
