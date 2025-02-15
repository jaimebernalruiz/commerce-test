package com.manages_commerce.products_microservice.usecases.implementations;

import com.manages_commerce.products_microservice.entities.rest.GetProductsRs;
import com.manages_commerce.products_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.products_microservice.usecases.interfaces.GetProductsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetProducts implements GetProductsInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public GetProductsRs getProducts() {

        GetProductsRs result = this.dataMicroserviceClient.getProducts();

        return result;
    }

    @Override
    public GetProductsRs filterProducts(String name, String category, Double minPrice, Double maxPrice) {

        GetProductsRs result = this.dataMicroserviceClient.filterProducts(name,category,minPrice,maxPrice);

        return result;
    }
}
