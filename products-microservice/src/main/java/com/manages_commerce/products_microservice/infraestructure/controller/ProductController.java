package com.manages_commerce.products_microservice.infraestructure.controller;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.*;
import com.manages_commerce.products_microservice.usecases.implementations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-microservice/products")
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    CreateProduct createProduct;

    @Autowired
    GetProducts getListProducts;

    @Autowired
    GetProduct getProduct;

    @Autowired
    ValidateToken validateToken;

    @Autowired
    UpdateProduct updateProduct;

    @Autowired
    DeleteProduct deleteProduct;

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductRs createProduct(@RequestBody ProductDTO productDTO,
                                         @RequestHeader(value="token") String token){

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            CreateProductRs result = this.createProduct.create(productDTO);
            return result;
        }
        return null;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs getProducts(@RequestHeader(value="token") String token){
        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            return this.getListProducts.getProducts();
        }
        return null;
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductRs getProduct(@PathVariable String id,
                                   @RequestHeader(value="token") String token){

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            GetProductRs result = this.getProduct.getProduct(id);
            return result;
        }
        return null;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeProduct(@PathVariable String id,
                              @RequestHeader(value="token") String token){

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            this.deleteProduct.deleteProduct(id);
        }
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UpdateProductRs updateProduct(@RequestBody ProductDTO product,
                                         @RequestHeader(value="token") String token){

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            UpdateProductRs result = this.updateProduct.update(product);
            return result;
        }
        return null;
    }

    @GetMapping( value = "/filter",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs filterProducts(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "category", required = false) String category,
                                        @RequestParam(value = "minPrice", required = false) Double minPrice,
                                        @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                        @RequestHeader(value="token") String token){

        ValidateTokenUserRs validateTokenUserRs =  this.validateToken.validate(token);
        if(validateTokenUserRs.getTokenValidate()) {
            return  getListProducts.filterProducts(name,category,minPrice,maxPrice);
        }
        return null;
    }

}
