package com.manages_commerce.users_microservice.infraestructure.components;

import com.manages_commerce.users_microservice.domain.entities.rest.ValidateUserRs;
import com.manages_commerce.users_microservice.infraestructure.clients.DataMicroserviceClient;
import com.manages_commerce.users_microservice.usecases.implementations.ValidateToken;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtComponent {

    public static final Logger LOGGER = LoggerFactory.getLogger(ValidateToken.class);

    @Autowired
    DataMicroserviceClient dataMicroserviceClient;

    private String secretKey = "(3C$jI&+S8cr:a.$g7pw7X7MVg~QZLc:";
    private final long expirationTime = 1000 * 60 * 60;

    public String generateToken(String userId) {

        LOGGER.info("@generateToken > Start generation token");

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        LOGGER.info("@generateToken > Key was cipher");

        String token = Jwts.builder()
                .subject(userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();

        LOGGER.info("@generateToken > generation token with validation one hour");
        return token;
    }

    public Boolean validateToken(String token){
        LOGGER.info("@validateToken > start validation token");

        SecretKey key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        LOGGER.info("@validateToken > Key was cipher");

        String userId = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
        LOGGER.info("@validateToken > user id was obtained from token");

        LOGGER.info("@validateToken > will validate user id");
        ValidateUserRs result = dataMicroserviceClient.validateUserById(userId);

        Date expirationDate = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        LOGGER.info("@validateToken > expiration date was obtained from token");

        if(!expirationDate.before(new Date()) && result.getIdUser().equals(userId)){
            LOGGER.info("@validateToken > token validated");
            return true;
        }
        return false;
    }

}
