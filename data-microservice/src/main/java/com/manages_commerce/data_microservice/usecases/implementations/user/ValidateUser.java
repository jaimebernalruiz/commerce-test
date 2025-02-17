package com.manages_commerce.data_microservice.usecases.implementations.user;

import com.manages_commerce.data_microservice.domain.entities.db.User;
import com.manages_commerce.data_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.data_microservice.infraestructure.repository.UserRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.user.ValidateUserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateUser implements ValidateUserInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidateUser.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public String validate(UserDTO userDTO) {

        String id = this.userRepository.validateUser(userDTO.getUsername(),userDTO.getPassword());

        LOGGER.info("@validate > User validated with id " +id );
        return id;
    }

    @Override
    public String validateById(String id) {

        Optional<User> optionalUser = this.userRepository.findById(id);

        if(optionalUser.isPresent()){
            LOGGER.info("@validateById > User validated with id " +id );
            return optionalUser.get().getId();
        }
        return null;
    }
}
