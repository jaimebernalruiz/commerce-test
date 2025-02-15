package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.UpdateProductRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.UpdateProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProduct implements UpdateProductInterface {


    @Autowired
    DataMicroserviceClient dataMicroserviceClient;
    @Override
    public UpdateProductRs update(ProductDTO product) {

        UpdateProductRs result = this.dataMicroserviceClient.updateProduct(product);

        return result;
    }
}
