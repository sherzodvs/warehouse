package com.example.warehouse.warehouseCost;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseCostDtoMapper extends GenericDtoMapper<WarehouseCost, WarehouseCostResponseDto, WarehouseCostResponseDto,WarehouseCostResponseDto> {

    private final ModelMapper mapper;

    @Override
    public WarehouseCost toEntity(WarehouseCostResponseDto createDto) {
        return mapper.map(createDto, WarehouseCost.class);
    }

    @Override
    public WarehouseOutputResponseDto toResponseDto(WarehouseCost warehouseCost) {
        return mapper.map(warehouseCost, WarehouseCostResponseDto.class);
    }

    @Override
    public void update(WarehouseCostResponseDto updateDto, WarehouseCost warehouseCost) {
        mapper.map(updateDto, warehouseCost);
    }

    @Override
    public WarehouseCostResponseDto toCreateDto(WarehouseCost warehouseCost) {
        return mapper.map(warehouseCost, WarehouseCostResponseDto.class);
    }
}
