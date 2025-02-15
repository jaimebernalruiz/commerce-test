package com.manages_commerce.users_microservice.infraestructure.clients;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
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

    public CreateUserRs createUser(UserDTO userDTO){

        CreateUserRs response = this.webClient.post()
                .uri("http://localhost:8082/data-microservice/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(CreateUserRs.class)
                .block();

        return response;
    }
}
