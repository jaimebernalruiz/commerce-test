package com.manages_commerce.data_microservice.infraestructure.controller;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.CreateProductRs;
import com.manages_commerce.data_microservice.domain.entities.rest.GetProductsRs;
import com.manages_commerce.data_microservice.domain.entities.rest.UpdateProductRs;
import com.manages_commerce.data_microservice.usecases.implementations.CreateProduct;
import com.manages_commerce.data_microservice.usecases.implementations.DeleteProduct;
import com.manages_commerce.data_microservice.usecases.implementations.GetProducts;
import com.manages_commerce.data_microservice.usecases.implementations.UpdateProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data-microservice/products")
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    CreateProduct createProduct;

    @Autowired
    UpdateProduct updateProduct;

    @Autowired
    GetProducts getProducts;

    @Autowired
    DeleteProduct deleteProduct;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductRs createProduct(@RequestBody ProductDTO productDTO){

        String id = this.createProduct.create(productDTO);

        CreateProductRs result = CreateProductRs.builder().idProduct(id).build();
        return result;
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs getProducts(){

        List< Product> products = this.getProducts.getProducts();

        GetProductsRs result = GetProductsRs.builder()
                .products(products).build();

        return result;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeProduct(@PathVariable String id){
        this.deleteProduct.deleteProduct(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UpdateProductRs updateProduct(@RequestBody Product product){
        Product result = this.updateProduct.update(product);

        return UpdateProductRs.builder().product(result).build();
    }

    @GetMapping( value = "/filter",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs filterProducts(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "category", required = false) String category,
                                        @RequestParam(value = "minPrice", required = false) Double minPrice,
                                        @RequestParam(value = "maxPrice", required = false) Double maxPrice){

        List< Product> products = this.getProducts.filterProducts(name,category,minPrice,maxPrice);

        GetProductsRs result = GetProductsRs.builder()
                .products(products).build();

        return result;
    }

}
