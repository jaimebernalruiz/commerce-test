package com.manages_commerce.data_microservice.domain.entities.rest;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductsRs {

    private List<Product> products;
 }
