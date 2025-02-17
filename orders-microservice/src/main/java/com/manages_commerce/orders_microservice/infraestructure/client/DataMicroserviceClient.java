package com.manages_commerce.orders_microservice.infraestructure.client;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
import com.manages_commerce.orders_microservice.entities.rest.GetOrdersRs;
import com.manages_commerce.orders_microservice.entities.rest.GetProductRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataMicroserviceClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(DataMicroserviceClient.class);

    private final WebClient webClient;

    @Value("${data.microservice.url}")
    String url;

    @Autowired
    public DataMicroserviceClient() {
        this.webClient = WebClient.builder().build();
    }

    public CreateOrderRs createOrder(OrderDTO orderDTO){

        CreateOrderRs response = this.webClient.post()
                .uri(url+"/data-microservice/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(orderDTO)
                .retrieve()
                .bodyToMono(CreateOrderRs.class)
                .block();

        return response;
    }

    public GetOrdersRs getOrders(String id){

        GetOrdersRs response = this.webClient.get()
                .uri(url+"/data-microservice/users/"+id+"/orders")
                .retrieve()
                .bodyToMono(GetOrdersRs.class)
                .block();

        return response;
    }

}
