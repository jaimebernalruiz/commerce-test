package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.rest.GetProductsRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.GetProductsInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProducts implements GetProductsInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(GetProducts.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public GetProductsRs getProducts() {
        LOGGER.info("@getProducts > will get list of products");

        GetProductsRs result = this.dataMicroserviceClient.getProducts();

        return result;
    }

    @Override
    public GetProductsRs filterProducts(String name, String category, Double minPrice, Double maxPrice) {
        LOGGER.info("@getProducts > Start filter products");

        GetProductsRs result = this.dataMicroserviceClient.filterProducts(name,category,minPrice,maxPrice);

        return result;
    }
}
