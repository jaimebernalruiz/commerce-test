package com.manages_commerce.data_microservice.usecases.interfaces.user;

import com.manages_commerce.data_microservice.domain.entities.rest.order.GetOrdersRs;

public interface GetOrdersInterface {

    GetOrdersRs getOrders(String id);
}
