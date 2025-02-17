package com.manages_commerce.orders_microservice.usecases.interfaces;

import com.manages_commerce.orders_microservice.entities.rest.GetOrdersRs;

public interface GetOrdersInterface {

    GetOrdersRs getOrders(String id);
}
