package com.manages_commerce.orders_microservice.infraestructure.client;

import com.manages_commerce.orders_microservice.entities.rest.GetProductRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductsMicroserviceClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductsMicroserviceClient.class);
    private final WebClient webClient;

    @Value("${product.microservice.url}")
    String url;

    @Autowired
    public ProductsMicroserviceClient() {
        this.webClient = WebClient.builder().build();
    }


    public GetProductRs getProduct(String id, String token){

        GetProductRs response = this.webClient.get()
                .uri(url+"/product-microservice/products/"+id)
                .header("token", token)
                .retrieve()
                .bodyToMono(GetProductRs.class)
                .block();

        return response;
    }

}
