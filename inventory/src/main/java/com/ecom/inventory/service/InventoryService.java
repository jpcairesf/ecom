package com.ecom.inventory.service;

import com.ecom.inventory.dto.input.InventoryCreateInput;
import com.ecom.inventory.dto.mapper.InventoryMapper;
import com.ecom.inventory.dto.output.InventoryOutput;
import com.ecom.inventory.usecase.InventoryCreateUseCase;
import com.ecom.inventory.usecase.InventoryIncrementUseCase;
import com.ecom.inventory.usecase.InventoryReadUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<InventoryOutput> findBySkuIn(List<String> skuList) {
        List<InventoryOutput> output = readUseCase.findBySkuIn(skuList).stream()
                .map(InventoryMapper::entityToOutput).toList();
        log.info("All {} inventories retrieved.", output.size());
        return output;
    }

    @Transactional
    public List<InventoryOutput> incrementBySkuIn(List<String> skuList) {
        List<InventoryOutput> output = incrementUseCase.incrementBySku(skuList).stream()
                .map(InventoryMapper::entityToOutput).toList();
        log.info("Successfully incremented all {} inventories quantity by 1.", output.size());
        return output;
    }

    @Transactional
    public List<InventoryOutput> decrementBySkuIn(List<String> skuList) {
        List<InventoryOutput> output = incrementUseCase.decrementBySku(skuList).stream()
                .map(InventoryMapper::entityToOutput).toList();
        log.info("Successfully decremented all {} inventories quantity by 1.", output.size());
        return output;
    }

}
