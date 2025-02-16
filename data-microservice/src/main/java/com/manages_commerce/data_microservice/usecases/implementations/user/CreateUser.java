package com.manages_commerce.data_microservice.usecases.implementations.user;

import com.manages_commerce.data_microservice.domain.entities.db.User;
import com.manages_commerce.data_microservice.domain.entities.dto.UserDTO;
import com.manages_commerce.data_microservice.infraestructure.mappers.UserMapper;
import com.manages_commerce.data_microservice.infraestructure.repository.UserRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.user.CreateUserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements CreateUserInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateUser.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public String create(UserDTO userDTO) {

        LOGGER.info("@create > Cast object user");
        User user = this.userMapper.userDTOToUser(userDTO);

        this.userRepository.save(user);
        LOGGER.info("@create > save new user");

        return user.getId();
    }
}
