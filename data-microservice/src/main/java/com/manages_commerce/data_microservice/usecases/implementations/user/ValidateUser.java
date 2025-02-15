package com.manages_commerce.data_microservice.usecases.implementations.user;

import com.manages_commerce.data_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.data_microservice.infraestructure.repository.UserRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.user.ValidateUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateUser implements ValidateUserInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public String validate(UserDTO userDTO) {

        String id = this.userRepository.validateUser(userDTO.getUsername(),userDTO.getPassword());

        return id;
    }
}
