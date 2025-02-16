package com.manages_commerce.orders_microservice.entities.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateTokenUserRs {

    private Boolean tokenValidate;
}
