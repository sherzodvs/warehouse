package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputRequestDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemRequestDto;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseOutputDtoMapper extends GenericDtoMapper<WarehouseOutput, WarehouseOutputRequestDto,WarehouseOutputRequestDto, WarehouseOutputResponseDto> {

    private final ModelMapper mapper;


    @Override
    public WarehouseOutput toEntity(WarehouseOutputRequestDto warehouseOutputRequestDto) {
        return mapper.map(warehouseOutputRequestDto, WarehouseOutput.class);    }

    @Override
    public WarehouseOutputResponseDto toResponseDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutputResponseDto.class);    }

    @Override
    public void update(WarehouseOutputRequestDto warehouseOutput, WarehouseOutput warehouseOutput2) {
        mapper.map(warehouseOutput, warehouseOutput2);
    }

    @Override
    public WarehouseOutputRequestDto toCreateDto(WarehouseOutput warehouseOutput) {
        return mapper.map(warehouseOutput, WarehouseOutputRequestDto.class);    }
}
