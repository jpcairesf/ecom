package com.ecom.inventory.usecase;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.repository.InventoryRepository;
import com.ecom.inventory.validator.InventoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryIncrementUseCase {

    private final InventoryRepository repository;
    private final InventoryValidator validator;

    public List<Inventory> incrementBySku(List<String> skuList) {
        List<Inventory> inventoryList = repository.findAndIncrementQuantityBySkuIn(skuList, 1);
        validator.validateAllSkuExists(skuList.size(), inventoryList.size());
        return inventoryList;
    }

    public List<Inventory> decrementBySku(List<String> skuList) {
        List<Inventory> inventoryList = repository.findAndIncrementQuantityBySkuIn(skuList, -1);
        validator.validateAllSkuExists(skuList.size(), inventoryList.size());
        return inventoryList;
    }

}
