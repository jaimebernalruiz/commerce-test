package com.manages_commerce.data_microservice.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
