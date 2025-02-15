package com.manages_commerce.data_microservice.usecases.implementations;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.infraestructure.mappers.ProductMapper;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.UpdateProductInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProduct implements UpdateProductInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product update(Product product) {

        Optional<Product> optionalProduct =  this.productRepository.findById(product.getId());

        if(optionalProduct.isPresent()){
            this.productRepository.save(product);
            return  product;
        }
        return null;
    }
}
