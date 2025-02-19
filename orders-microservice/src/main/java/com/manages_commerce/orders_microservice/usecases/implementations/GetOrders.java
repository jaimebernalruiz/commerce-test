package com.manages_commerce.orders_microservice.usecases.implementations;

import com.manages_commerce.orders_microservice.entities.rest.GetOrdersRs;
import com.manages_commerce.orders_microservice.infraestructure.client.DataMicroserviceClient;
import com.manages_commerce.orders_microservice.usecases.interfaces.GetOrdersInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOrders implements GetOrdersInterface {

    public static final Logger LOGGER = LoggerFactory.getLogger(GetOrders.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;
    @Override
    public GetOrdersRs getOrders(String id) {
        LOGGER.info("@getOrders > will obtain the orders of the user with id");

        GetOrdersRs result = this.dataMicroserviceClient.getOrders(id);
        return result;
    }
}
