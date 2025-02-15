package com.manages_commerce.products_microservice.infraestructure.clients;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;
import com.manages_commerce.products_microservice.entities.rest.GetProductRs;
import com.manages_commerce.products_microservice.entities.rest.GetProductsRs;
import com.manages_commerce.products_microservice.entities.rest.UpdateProductRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataMicroserviceClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(DataMicroserviceClient.class);
    private final WebClient webClient;

    @Autowired
    public DataMicroserviceClient() {
        this.webClient = WebClient.builder().build();
    }

        public CreateProductRs createProduct(ProductDTO productDTO){

            CreateProductRs response = this.webClient.post()
                .uri("http://localhost:8082/data-microservice/products")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productDTO)
                .retrieve()
                .bodyToMono(CreateProductRs.class)
                .block();

            return response;
        }

    public void deleteProduct(String id){

        CreateProductRs response = this.webClient.delete()
                .uri("http://localhost:8082/data-microservice/products/"+id)
                .retrieve()
                .bodyToMono(CreateProductRs.class)
                .block();
    }

    public UpdateProductRs updateProduct(ProductDTO productDTO){

        UpdateProductRs response = this.webClient.put()
                .uri("http://localhost:8082/data-microservice/products")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(productDTO)
                .retrieve()
                .bodyToMono(UpdateProductRs.class)
                .block();

        return response;
    }

    public GetProductsRs getProducts(){

        GetProductsRs response = this.webClient.get()
                .uri("http://localhost:8082/data-microservice/products")
                .retrieve()
                .bodyToMono(GetProductsRs.class)
                .block();

        return response;
    }

    public GetProductRs getProduct(String id){

        GetProductRs response = this.webClient.get()
                .uri("http://localhost:8082/data-microservice/products/"+id)
                .retrieve()
                .bodyToMono(GetProductRs.class)
                .block();

        return response;
    }

    public GetProductsRs filterProducts(String name, String category, Double minPrice, Double maxPrice){

        String params = "";

        if(!(name == null)){
            params += "name=" + name;
        }

        if(!(category == null)){
            params += "&category=" + category;
        }

        if(!(minPrice == null)){
            params += "&minPrice=" + minPrice;
        }

        if(!(maxPrice == null)){
            params += "&maxPrice=" + maxPrice;
        }

        GetProductsRs response = this.webClient.get()
                .uri("http://localhost:8082/data-microservice/products/filter?"+params)
                .retrieve()
                .bodyToMono(GetProductsRs.class)
                .block();

        return response;
    }
}
