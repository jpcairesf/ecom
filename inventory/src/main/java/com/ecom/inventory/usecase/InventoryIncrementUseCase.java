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

    public Integer incrementBySku(List<String> skuList) {
        Integer updated = repository.findAndIncrementQuantityBySkuIn(skuList, 1);
        validator.validateAllSkuExists(skuList.size(), updated);
        return updated;
    }

    public Integer decrementBySku(List<String> skuList) {
        Integer updated = repository.findAndIncrementQuantityBySkuIn(skuList, -1);
        validator.validateAllSkuExists(skuList.size(), updated);
        return updated;
    }

}
