package com.ecom.inventory.usecase;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.repository.InventoryRepository;
import com.ecom.inventory.validator.InventoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryIncrementUseCase {

    private final InventoryRepository repository;
    private final InventoryValidator validator;

    public Inventory incrementBySku(String sku) {
        validator.validateSkuExists(sku);

        return repository.findAndIncrementQuantityBySku(sku, 1);
    }

    public Inventory decrementBySku(String sku) {
        validator.validateSkuExists(sku);
        validator.validateIsInStockBySku(sku);

        return repository.findAndIncrementQuantityBySku(sku, -1);
    }

}
