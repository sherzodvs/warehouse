package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseCostItemDtoMapper extends GenericDtoMapper<WarehouseCostItem,WarehouseCostItem,WarehouseCostItem,WarehouseCostItem> {
   private final ModelMapper mapper;

    @Override
    public WarehouseCostItem toEntity(WarehouseCostItem warehouseOutputItem) {
        return mapper.map(warehouseOutputItem, WarehouseCostItem.class);
    }

    @Override
    public WarehouseOutputResponseDto toResponseDto(WarehouseCostItem warehouse) {
        return mapper.map(warehouse, WarehouseCostItem.class);
    }

    @Override
    public void update(WarehouseCostItem updateDto, WarehouseCostItem warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseCostItem toCreateDto(WarehouseCostItem warehouse) {
        return mapper.map(warehouse, WarehouseCostItem.class);
    }
}
