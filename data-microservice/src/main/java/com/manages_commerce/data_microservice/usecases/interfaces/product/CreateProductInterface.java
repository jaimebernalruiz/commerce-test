package com.manages_commerce.data_microservice.usecases.interfaces.product;

import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;

public interface CreateProductInterface {

    String create(ProductDTO productDTO);
}
