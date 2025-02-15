package com.manages_commerce.data_microservice.usecases.implementations.user;

import com.manages_commerce.data_microservice.domain.entities.db.Order;
import com.manages_commerce.data_microservice.domain.entities.db.User;
import com.manages_commerce.data_microservice.domain.entities.rest.order.GetOrdersRs;
import com.manages_commerce.data_microservice.infraestructure.repository.OrderRepository;
import com.manages_commerce.data_microservice.infraestructure.repository.UserRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.user.GetOrdersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrders implements GetOrdersInterface {


    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public GetOrdersRs getOrders(String id) {

        User user = this.userRepository.findById(id).get();

        List<Order> orders = this.orderRepository.findByUser(user);

        return GetOrdersRs.builder().orders(orders).build();
    }
}
