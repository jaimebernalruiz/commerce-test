package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.users_microservice.usecases.interfaces.CreateUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements CreateUserInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public CreateUserRs create(UserDTO userDTO) {

        CreateUserRs result = this.dataMicroserviceClient.createUser(userDTO);

        return result;
    }
}
