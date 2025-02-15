package com.manages_commerce.products_microservice.infraestructure.clients;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import com.manages_commerce.products_microservice.entities.rest.CreateProductRs;
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

            System.out.println(response);

        return response;
    }
}
