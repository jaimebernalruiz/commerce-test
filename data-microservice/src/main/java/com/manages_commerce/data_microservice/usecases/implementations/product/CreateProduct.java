package com.manages_commerce.data_microservice.usecases.implementations.product;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.infraestructure.mappers.ProductMapper;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.product.CreateProductInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProduct implements CreateProductInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateProduct.class);

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    public String create(ProductDTO productDTO) {

        LOGGER.info("@create > Cast object product");
        Product product = this.productMapper.productDTOToProduct(productDTO);

        this.productRepository.save(product);
        LOGGER.info("@create > product was create with id " + product.getId());

        return product.getId();
    }
}
