package com.manages_commerce.data_microservice.usecases.interfaces.product;

import com.manages_commerce.data_microservice.domain.entities.db.Product;

import java.util.List;

public interface GetProductsInterface {

    public List<Product> getProducts();

    public List<Product> filterProducts(String name, String category, Double minPrice, Double maxPrice);


}
