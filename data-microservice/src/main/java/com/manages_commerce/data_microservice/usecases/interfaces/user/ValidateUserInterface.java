package com.manages_commerce.data_microservice.usecases.interfaces.user;

import com.manages_commerce.data_microservice.domain.entities.dto.UserDTO;

public interface ValidateUserInterface {

    public String validate(UserDTO userDTO);

    public String validateById(String id);
}
