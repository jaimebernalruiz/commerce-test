package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.DeleteProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements DeleteProductInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public void deleteProduct(String id) {

        this.dataMicroserviceClient.deleteProduct(id);
    }
}
