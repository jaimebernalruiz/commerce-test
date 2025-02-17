package com.manages_commerce.data_microservice.domain.entities.rest.product;

import com.manages_commerce.data_microservice.domain.entities.dto.ProductDTO;
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
