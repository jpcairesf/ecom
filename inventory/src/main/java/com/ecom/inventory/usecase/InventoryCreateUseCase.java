package com.ecom.inventory.usecase;

import com.ecom.inventory.dto.input.InventoryCreateInput;
import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.repository.InventoryRepository;
import com.ecom.inventory.validator.InventoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryCreateUseCase {

    private final InventoryRepository repository;
    private final InventoryValidator validator;

    public Inventory create(InventoryCreateInput input) {
        validator.validateSkuNotExists(input.sku());

        Inventory inventory = new Inventory(input.sku(), input.quantity());
        return repository.save(inventory);
    }

}
