package com.manages_commerce.data_microservice.infraestructure.repository;

import com.manages_commerce.data_microservice.domain.entities.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("SELECT p FROM Product p WHERE " +
            "(p.name LIKE %:name% OR :name IS NULL) AND " +
            "(p.category LIKE %:category% OR :category IS NULL) AND " +
            "(p.price >= :minPrice OR :minPrice IS NULL) AND " +
            "(p.price <= :maxPrice OR :maxPrice IS NULL)")
    List<Product> filterByName(@Param("name") String name, @Param("category") String category,
                               @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}


