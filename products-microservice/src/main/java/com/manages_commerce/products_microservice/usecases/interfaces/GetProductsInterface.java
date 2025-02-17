package com.manages_commerce.products_microservice.usecases.interfaces;

import com.manages_commerce.products_microservice.entities.rest.GetProductsRs;

import java.util.List;

public interface GetProductsInterface {

    public GetProductsRs getProducts();

    public GetProductsRs filterProducts(String name, String category, Double minPrice, Double maxPrice);
}
