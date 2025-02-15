package com.manages_commerce.products_microservice.infraestructure.controller;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;
import com.manages_commerce.products_microservice.entities.rest.GetProductRs;
import com.manages_commerce.products_microservice.entities.rest.GetProductsRs;
import com.manages_commerce.products_microservice.entities.rest.UpdateProductRs;
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
    UpdateProduct updateProduct;

    @Autowired
    DeleteProduct deleteProduct;

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductRs createProduct(@RequestBody ProductDTO productDTO){
        CreateProductRs result = this.createProduct.create(productDTO);
        return result;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs getProducts(){

        return this.getListProducts.getProducts();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductRs getProduct(@PathVariable String id){

        GetProductRs result = this.getProduct.getProduct(id);

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
    public UpdateProductRs updateProduct(@RequestBody ProductDTO product){
        UpdateProductRs result = this.updateProduct.update(product);

        return result;
    }

    @GetMapping( value = "/filter",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs filterProducts(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "category", required = false) String category,
                                        @RequestParam(value = "minPrice", required = false) Double minPrice,
                                        @RequestParam(value = "maxPrice", required = false) Double maxPrice){


        return  getListProducts.filterProducts(name,category,minPrice,maxPrice);
    }

}
