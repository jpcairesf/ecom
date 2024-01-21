package com.ecom.inventory.validator;

import com.ecom.inventory.exception.BusinessException;
import com.ecom.inventory.exception.EntityNotFoundException;
import com.ecom.inventory.exception.message.InventoryExceptionMessages;
import com.ecom.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ecom.inventory.exception.message.InventoryExceptionMessages.alreadyExistsBySku;
import static com.ecom.inventory.exception.message.InventoryExceptionMessages.notFoundBySku;

@Service
@RequiredArgsConstructor
public class InventoryValidator {

    private final InventoryRepository repository;

    public void validateSkuExists(String sku) {
        if(!repository.existsBySku(sku)) throw new EntityNotFoundException(notFoundBySku(sku));
    }

    public void validateSkuNotExists(String sku) {
        if(repository.existsBySku(sku)) throw new BusinessException(alreadyExistsBySku(sku));
    }

    public void validateIsInStockBySku(String sku) {
        if(repository.findQuantityBySku(sku) < 1) throw new BusinessException(InventoryExceptionMessages.notInStockBySku(sku));
    }

}
