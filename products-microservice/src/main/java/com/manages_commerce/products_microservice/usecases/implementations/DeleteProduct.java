package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.DeleteProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements DeleteProductInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeleteProduct.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public void deleteProduct(String id) {
        LOGGER.info("@deleteProduct > will remove product with id " + id);

        this.dataMicroserviceClient.deleteProduct(id);
    }
}
