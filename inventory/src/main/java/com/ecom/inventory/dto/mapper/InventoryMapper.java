package com.ecom.inventory.dto.mapper;

import com.ecom.inventory.dto.output.InventoryOutput;
import com.ecom.inventory.entity.Inventory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryMapper {

    public static InventoryOutput entityToOutput(Inventory inventory) {
        return new InventoryOutput(
                inventory.getId(),
                inventory.getSku(),
                inventory.getQuantity()
        );
    }

}
