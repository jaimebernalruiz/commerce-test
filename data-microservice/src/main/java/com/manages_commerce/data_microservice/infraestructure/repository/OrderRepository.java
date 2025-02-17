package com.manages_commerce.data_microservice.infraestructure.repository;

import com.manages_commerce.data_microservice.domain.entities.db.Order;
import com.manages_commerce.data_microservice.domain.entities.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findByUser(User user);

}
