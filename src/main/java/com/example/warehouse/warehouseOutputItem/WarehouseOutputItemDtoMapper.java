package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouse.dto.WarehouseCreateDto;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.dto.WarehouseUpdateDto;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseOutputItemDtoMapper extends GenericDtoMapper<WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem> {
   private final ModelMapper mapper;

    @Override
    public WarehouseOutputItem toEntity(WarehouseOutputItem warehouseOutputItem) {
        return mapper.map(warehouseOutputItem, WarehouseOutputItem.class);
    }

    @Override
    public WarehouseOutputItem toResponseDto(WarehouseOutputItem warehouse) {
        return mapper.map(warehouse, WarehouseOutputItem.class);
    }

    @Override
    public void update(WarehouseOutputItem updateDto, WarehouseOutputItem warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseOutputItem toCreateDto(WarehouseOutputItem warehouse) {
        return mapper.map(warehouse, WarehouseOutputItem.class);
    }
}
