package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemCreateDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseOutputItemDtoMapper extends GenericDtoMapper<WarehouseOutputItem, WarehouseOutputItemCreateDto,WarehouseOutputItem, WarehouseOutputItemResponseDto> {
   private final ModelMapper mapper;

    @Override
    public WarehouseOutputItem toEntity(WarehouseOutputItemCreateDto warehouseOutputItem) {
        return mapper.map(warehouseOutputItem, WarehouseOutputItem.class);
    }

    @Override
    public WarehouseOutputItemResponseDto toResponseDto(WarehouseOutputItem warehouseOutputItem) {
        return mapper.map(warehouseOutputItem, WarehouseOutputItemResponseDto.class);
    }


    @Override
    public void update(WarehouseOutputItem updateDto, WarehouseOutputItem warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseOutputItemCreateDto toCreateDto(WarehouseOutputItem warehouse) {
        return mapper.map(warehouse, WarehouseOutputItemCreateDto.class);
    }
}
