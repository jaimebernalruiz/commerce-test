package com.manages_commerce.products_microservice.entities.rest;

import com.manages_commerce.products_microservice.entities.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductRs {

    private ProductDTO product;
}
