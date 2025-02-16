package com.manages_commerce.users_microservice.usecases.implementations;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.LoginRs;
import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.users_microservice.infraestructure.components.JwtComponent;
import com.manages_commerce.users_microservice.usecases.interfaces.LoginUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUser implements LoginUserInterface {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    @Autowired
    JwtComponent jwtComponent;

    @Override
    public LoginRs login(UserDTO userDTO) {

        ValidateUserRs validateUserRs = this.dataMicroserviceClient.validateUser(userDTO);

        String token = this.jwtComponent.generateToken(validateUserRs.getIdUser());

        return LoginRs.builder().token(token).build();
    }
}
