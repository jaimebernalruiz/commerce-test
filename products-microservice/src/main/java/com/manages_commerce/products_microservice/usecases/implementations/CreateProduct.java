package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.infraestructure.controller.ProductController;
import com.manages_commerce.products_microservice.usecases.interfaces.CreateProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProduct implements CreateProductInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateProduct.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public CreateProductRs create(ProductDTO productDTO) {

        CreateProductRs result = dataMicroserviceClient.createProduct(productDTO);

        LOGGER.info("@create > a product was create with id " + result.getIdProduct());
        return result;
    }
}
