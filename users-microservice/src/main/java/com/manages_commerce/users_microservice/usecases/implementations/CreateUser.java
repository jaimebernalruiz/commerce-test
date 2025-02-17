package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.users_microservice.usecases.interfaces.CreateUserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements CreateUserInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateUser.class);


    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Override
    public CreateUserRs create(UserDTO userDTO) {

        CreateUserRs result = this.dataMicroserviceClient.createUser(userDTO);
        LOGGER.info("@create > an user was create with id " + result.getIdUser());

        return result;
    }
}
