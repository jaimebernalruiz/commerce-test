package com.manages_commerce.data_microservice.infraestructure.controller;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.product.CreateProductRs;
import com.manages_commerce.data_microservice.domain.entities.rest.product.GetProductRs;
import com.manages_commerce.data_microservice.domain.entities.rest.product.GetProductsRs;
import com.manages_commerce.data_microservice.domain.entities.rest.product.UpdateProductRs;
import com.manages_commerce.data_microservice.usecases.implementations.product.*;
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
    GetProduct getProduct;

    @Autowired
    DeleteProduct deleteProduct;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductRs createProduct(@RequestBody ProductDTO productDTO){
        LOGGER.info("@createProduct > Start creation a new product");

        String id = this.createProduct.create(productDTO);

        CreateProductRs result = CreateProductRs.builder().idProduct(id).build();
        LOGGER.info("@createProduct > Finished creation of a product");

        return result;
    }

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductsRs getProducts(){
        LOGGER.info("@getProducts > Start get products");

        List< Product> products = this.getProducts.getProducts();

        GetProductsRs result = GetProductsRs.builder()
                .products(products).build();
        LOGGER.info("@getProducts > Finished get products");


        return result;
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetProductRs getProduct(@PathVariable String id){
        LOGGER.info("@getProduct > Start get product");

        ProductDTO productDTO = this.getProduct.getProduct(id);

        GetProductRs result = GetProductRs.builder()
                .product(productDTO).build();
        LOGGER.info("@getProduct > Finished get product");


        return result;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeProduct(@PathVariable String id){
        LOGGER.info("@removeProduct > Start remove product");

        this.deleteProduct.deleteProduct(id);
        LOGGER.info("@removeProduct > Finished remove product");

    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UpdateProductRs updateProduct(@RequestBody Product product){
        LOGGER.info("@updateProduct > Start update product");

        Product result = this.updateProduct.update(product);
        LOGGER.info("@updateProduct > Finished update product");

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
        LOGGER.info("@filterProducts > Start filter product");


        List< Product> products = this.getProducts.filterProducts(name,category,minPrice,maxPrice);

        GetProductsRs result = GetProductsRs.builder()
                .products(products).build();
        LOGGER.info("@filterProducts > Finished filter product");


        return result;
    }

}
