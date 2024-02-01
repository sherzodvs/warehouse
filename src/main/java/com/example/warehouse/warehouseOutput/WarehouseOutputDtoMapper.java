package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class WarehouseOutputDtoMapper extends GenericDtoMapper<WarehouseOutput, WarehouseOutput,WarehouseOutput,WarehouseOutput> {

    private final ModelMapper mapper;

    @Override
    public WarehouseOutput toEntity(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutput.class);    }

    @Override
    public WarehouseOutput toResponseDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutput.class);    }

    @Override
    public void update(WarehouseOutput warehouseOutput, WarehouseOutput warehouseOutput2) {
        mapper.map(warehouseOutput, warehouseOutput2);
    }

    @Override
    public WarehouseOutput toCreateDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutput.class);    }
}
