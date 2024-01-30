package com.ecom.inventory.repository;

import com.ecom.inventory.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    boolean existsBySku(String sku);

    @Query("{ '$in': { 'sku': ?0 } }")
    List<Inventory> findBySkuIn(List<String> sku);

    @Query("{ '$in': { 'sku': ?0 } }")
    @Update("{ '$inc': { 'quantity': ?1 } }")
    Integer findAndIncrementQuantityBySkuIn(List<String> sku, int increment);

}
