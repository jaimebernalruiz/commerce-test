package com.manages_commerce.data_microservice.usecases.implementations.product;

import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.product.DeleteProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements DeleteProductInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeleteProduct.class);

    @Autowired
    ProductRepository productRepository;


    @Override
    public void deleteProduct(String id) {
        LOGGER.info("@deleteProduct > will delete product with id " + id);

        this.productRepository.deleteById(id);
    }
}
