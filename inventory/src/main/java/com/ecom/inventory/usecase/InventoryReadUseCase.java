package com.ecom.inventory.usecase;

import com.ecom.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryReadUseCase {

    private final InventoryRepository repository;

    public Boolean isInStockBySku(String sku) {
        return repository.findQuantityBySku(sku) > 0;
    }

}
