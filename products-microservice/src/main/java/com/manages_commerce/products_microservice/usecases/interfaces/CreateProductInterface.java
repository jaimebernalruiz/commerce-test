package com.manages_commerce.products_microservice.usecases.interfaces;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;

public interface CreateProductInterface {

    CreateProductRs create(ProductDTO productDTO);
}
