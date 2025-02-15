package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.rest.GetProductRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.GetProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetProduct implements GetProductInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public GetProductRs getProduct(String id) {

        GetProductRs result = this.dataMicroserviceClient.getProduct(id);
        result.getProduct().setId(id);

        return result;
    }
}
