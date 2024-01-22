package com.ecom.inventory.service;

import com.ecom.inventory.dto.input.InventoryCreateInput;
import com.ecom.inventory.dto.output.InventoryOutput;
import com.ecom.inventory.usecase.InventoryCreateUseCase;
import com.ecom.inventory.usecase.InventoryIncrementUseCase;
import com.ecom.inventory.usecase.InventoryReadUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ecom.inventory.dto.mapper.InventoryMapper.entityToOutput;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryCreateUseCase createUseCase;
    private final InventoryReadUseCase readUseCase;
    private final InventoryIncrementUseCase incrementUseCase;

    @Transactional
    public InventoryOutput create(InventoryCreateInput input) {
        InventoryOutput output = entityToOutput(createUseCase.create(input));
        log.info("Inventory with ID {} and sku {} created.", output.id(), output.sku());
        return output;
    }

    @Transactional(readOnly = true)
    public Boolean isInStockBySku(String sku) {
        Boolean isInStock = readUseCase.isInStockBySku(sku);
        if(Boolean.TRUE.equals(isInStock))
            log.info("Inventory with sku {} is in stock.", sku);
        else
            log.info("Inventory with sku {} is not in stock.", sku);
        return isInStock;
    }

    @Transactional
    public Integer incrementBySku(String sku) {
        Integer output = incrementUseCase.incrementBySku(sku);
        log.info("Inventory with sku {} incremented quantity by 1.", sku);
        return output;
    }

    @Transactional
    public Integer decrementBySku(String sku) {
        Integer output = incrementUseCase.decrementBySku(sku);
        log.info("Inventory with sku {} decremented quantity by 1.", sku);
        return output;
    }

}
