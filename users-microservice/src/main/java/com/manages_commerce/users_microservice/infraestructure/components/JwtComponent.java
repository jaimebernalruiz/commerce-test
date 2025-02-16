package com.manages_commerce.users_microservice.infraestructure.components;

import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Signature;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtComponent {

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    private String secretKey = "(3C$jI&+S8cr:a.$g7pw7X7MVg~QZLc:";
    private final long expirationTime = 1000 * 60 * 60;

    public String generateToken(String userId) {

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

        String token = Jwts.builder()
                .subject(userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();

        return token;
    }

    public Boolean validateToken(String token){

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

        String userId = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        ValidateUserRs result = dataMicroserviceClient.validateUserById(userId);

        Date expirationDate = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        if(!expirationDate.before(new Date()) && result.getIdUser().equals(userId)){
            return true;
        }
        return false;
    }

}
