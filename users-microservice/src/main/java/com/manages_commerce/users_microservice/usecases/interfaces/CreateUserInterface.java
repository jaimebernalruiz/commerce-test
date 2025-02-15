package com.manages_commerce.users_microservice.usecases.interfaces;

import com.manages_commerce.users_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.users_microservice.domain.entities.rest.CreateUserRs;

public interface CreateUserInterface {

    public CreateUserRs create(UserDTO userDTO);
}
