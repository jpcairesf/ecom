package com.ecom.inventory.usecase;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.repository.InventoryRepository;
import com.ecom.inventory.validator.InventoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryReadUseCase {

    private final InventoryRepository repository;
    private final InventoryValidator validator;

    public List<Inventory> findBySkuIn(List<String> skuList) {
        List<Inventory> inventoryList = repository.findBySkuIn(skuList);
        validator.validateAllSkuExists(skuList.size(), inventoryList.size());
        return inventoryList;
    }

}
