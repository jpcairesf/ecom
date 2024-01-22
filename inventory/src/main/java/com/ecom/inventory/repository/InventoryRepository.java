package com.ecom.inventory.repository;

import com.ecom.inventory.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    boolean existsBySku(String sku);

    Integer findQuantityBySku(String sku);

    @Update("{ '$inc': { 'quantity': ?1 } }")
    Integer findAndIncrementQuantityBySku(String sku, int increment);

}
