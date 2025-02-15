package com.manages_commerce.data_microservice.usecases.implementations.product;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.product.GetProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProduct implements GetProductInterface {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO getProduct(String id) {

        Optional<Product> optionalProduct =  this.productRepository.findById(id);

        Product product = optionalProduct.orElse(null);

        if(product != null){
            return ProductDTO.builder().
                    price(product.getPrice()).
                    name(product.getName()).
                    category(product.getCategory()).
                    build();
        }
        return null;
    }
}
