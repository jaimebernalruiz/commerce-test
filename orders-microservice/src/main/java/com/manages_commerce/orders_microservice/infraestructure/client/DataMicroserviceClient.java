package com.manages_commerce.orders_microservice.infraestructure.client;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
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

    public CreateOrderRs createOrder(OrderDTO orderDTO){

        CreateOrderRs response = this.webClient.post()
                .uri("http://localhost:8082/data-microservice/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(orderDTO)
                .retrieve()
                .bodyToMono(CreateOrderRs.class)
                .block();

        return response;
    }

}
