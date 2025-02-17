package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.LoginRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.users_microservice.infraestructure.components.JwtComponent;
import com.manages_commerce.users_microservice.usecases.interfaces.LoginUserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUser implements LoginUserInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoginUser.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Autowired
    JwtComponent jwtComponent;

    @Override
    public LoginRs login(UserDTO userDTO) {
        LOGGER.info("@login > Start login with user");

        LOGGER.info("@login > will validate user");
        ValidateUserRs validateUserRs = this.dataMicroserviceClient.validateUser(userDTO);

        LOGGER.info("@login > generation token");
        String token = this.jwtComponent.generateToken(validateUserRs.getIdUser());

        return LoginRs.builder().token(token).build();
    }
}
