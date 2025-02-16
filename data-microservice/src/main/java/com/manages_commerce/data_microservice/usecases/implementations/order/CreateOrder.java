package com.manages_commerce.data_microservice.usecases.implementations.order;

import com.manages_commerce.data_microservice.domain.entities.db.Order;
import com.manages_commerce.data_microservice.domain.entities.db.OrderProduct;
import com.manages_commerce.data_microservice.domain.entities.db.Product;
import com.manages_commerce.data_microservice.domain.entities.db.User;
import com.manages_commerce.data_microservice.domain.entities.dto.OrderDTO;
import com.manages_commerce.data_microservice.domain.entities.dto.OrderProductDTO;
import com.manages_commerce.data_microservice.domain.entities.rest.order.CreateOrderRs;
import com.manages_commerce.data_microservice.infraestructure.repository.OrderProductRepository;
import com.manages_commerce.data_microservice.infraestructure.repository.OrderRepository;
import com.manages_commerce.data_microservice.infraestructure.repository.ProductRepository;
import com.manages_commerce.data_microservice.infraestructure.repository.UserRepository;
import com.manages_commerce.data_microservice.usecases.interfaces.order.CreateOrderInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrder implements CreateOrderInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(CreateOrder.class);

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public CreateOrderRs create(OrderDTO orderDTO) {


        User user = this.userRepository.findById(orderDTO.getIdUser()).get();
        LOGGER.info("@create > will create a new order with user " + user.getId());


        Order order = Order.builder()
                .total(orderDTO.getTotal())
                .user(user)
                .build();

        this.orderRepository.save(order);

        List<OrderProduct> orderProducts = orderDTO.getOrderProducts().stream()
                .map(orderProductDTO -> this.createOrderProducts(orderProductDTO, order)).toList();

        this.orderProductRepository.saveAll(orderProducts);
        LOGGER.info("@create > was save order with id " + order.getId());

        return CreateOrderRs.builder().idOrder(order.getId()).build();
    }

    private  OrderProduct createOrderProducts(OrderProductDTO orderProductDTO, Order order){
        LOGGER.info("@create > will create a new order_products with order id  " + order.getId());

        Product product = this.productRepository.
                findById(orderProductDTO.getIdProduct()).get();

        return  OrderProduct.builder()
                .total(orderProductDTO.getTotal())
                .quantity(orderProductDTO.getQuantity())
                .order(order)
                .product(product)
                .build();
    }
}
