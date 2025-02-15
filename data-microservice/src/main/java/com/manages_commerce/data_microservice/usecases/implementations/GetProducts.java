package com.manages_commerce.data_microservice.usecases.implementations;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.GetProductsInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProducts implements GetProductsInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {

        List<Product> products = this.productRepository.findAll();
        return products;
    }

    @Override
    public List<Product> filterProducts(String name, String category,Double minPrice, Double maxPrice) {

        List<Product> products = this.productRepository.filterByName(name, category,minPrice,maxPrice);
        return products;
    }
}
