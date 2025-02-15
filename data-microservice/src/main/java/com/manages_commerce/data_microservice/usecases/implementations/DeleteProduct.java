package com.manages_commerce.data_microservice.usecases.implementations;

import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.DeleteProductInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProduct implements DeleteProductInterface {

    @Autowired
    ProductRepository productRepository;


    @Override
    public void deleteProduct(String id) {

        this.productRepository.deleteById(id);
    }
}
