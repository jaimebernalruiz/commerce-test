package com.manages_commerce.users_microservice.infraestructure.clients;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
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

    public CreateUserRs createUser(UserDTO userDTO){

        CreateUserRs response = this.webClient.post()
                .uri(url+"/data-microservice/users")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(CreateUserRs.class)
                .block();

        return response;
    }

    public ValidateUserRs validateUser(UserDTO userDTO){

        ValidateUserRs response = this.webClient.post()
                .uri(url+"/data-microservice/users/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userDTO)
                .retrieve()
                .bodyToMono(ValidateUserRs.class)
                .block();

        return response;
    }

    public ValidateUserRs validateUserById(String userId){

        ValidateUserRs response = this.webClient.get()
                .uri(url+"/data-microservice/users/"+userId+"/validate")
                .retrieve()
                .bodyToMono(ValidateUserRs.class)
                .block();

        return response;
    }
}
