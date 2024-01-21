package com.ecom.product.repository;

import com.ecom.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findByName(String name);
    boolean existsById(String id);
    boolean existsByName(String name);
}
