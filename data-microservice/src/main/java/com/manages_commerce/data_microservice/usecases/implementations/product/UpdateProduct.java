package com.manages_commerce.data_microservice.usecases.implementations.product;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.product.UpdateProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProduct implements UpdateProductInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(UpdateProduct.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product update(Product product) {

        Optional<Product> optionalProduct =  this.productRepository.findById(product.getId());

        if(optionalProduct.isPresent()){
            this.productRepository.save(product);
            LOGGER.info("@update > product was update");

            return  product;
        }
        return null;
    }
}
