package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.CreateProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProduct implements CreateProductInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public CreateProductRs create(ProductDTO productDTO) {

        CreateProductRs result = dataMicroserviceClient.createProduct(productDTO);

        return result;
    }
}
