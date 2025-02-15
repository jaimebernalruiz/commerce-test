package com.manages_commerce.orders_microservice.usecases.implementations;

import com.manages_commerce.orders_microservice.entities.dto.OrderDTO;
import com.manages_commerce.orders_microservice.entities.dto.OrderProductDTO;
import com.manages_commerce.orders_microservice.entities.dto.ProductDTO;
import com.manages_commerce.orders_microservice.entities.rest.CreateOrderRs;
import com.manages_commerce.orders_microservice.entities.rest.GetProductRs;
import com.manages_commerce.orders_microservice.entities.rest.Order;
import com.manages_commerce.orders_microservice.infraestructure.client.DataMicroserviceClient;
import com.manages_commerce.orders_microservice.infraestructure.client.ProductsMicroserviceClient;
import com.manages_commerce.orders_microservice.usecases.interfaces.RegisterOrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterOrder implements RegisterOrderInterface {

    @Autowired
    ProductsMicroserviceClient productsMicroserviceClient;

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;


    @Override
    public CreateOrderRs registerOrder(Order order) {


        List<OrderProductDTO> orderProducts = order.getProducts()
                .stream().map(product -> {
                    GetProductRs result = this.productsMicroserviceClient.getProduct(product.getIdProduct());

                    return OrderProductDTO.builder()
                            .idProduct(result.getProduct().getId())
                            .quantity(product.getQuantity())
                            .total(result.getProduct().getPrice() * product.getQuantity())
                            .build();
                }).toList();

        Double totalOrder = orderProducts.stream().mapToDouble(OrderProductDTO::getTotal).sum();
        OrderDTO orderDTO = OrderDTO.builder()
                .orderProducts(orderProducts)
                .idUser(order.getIdUser())
                .total(totalOrder)
                .build();


        CreateOrderRs response = this.dataMicroserviceClient.createOrder(orderDTO);
        return response;
    }
}
