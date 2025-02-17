package com.manages_commerce.orders_microservice.infraestructure.client;

import com.manages_commerce.orders_microservice.entities.rest.GetOrdersRs;
import com.manages_commerce.orders_microservice.entities.rest.ValidateTokenUserRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserMicroserviceClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserMicroserviceClient.class);

    private final WebClient webClient;

    @Value("${user.microservice.url}")
    String url;

    @Autowired
    public UserMicroserviceClient() {
        this.webClient = WebClient.builder().build();
    }


    public ValidateTokenUserRs validateToken(String token){

        ValidateTokenUserRs response = this.webClient.get()
                .uri(url+"/user-microservice/users/token/validate")
                .header("token",token)
                .retrieve()
                .bodyToMono(ValidateTokenUserRs.class)
                .block();

        return response;
    }

}
