package com.example.warehouse.warehouseCost;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouse.dto.WarehouseCreateDto;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.dto.WarehouseUpdateDto;
import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseCostDtoMapper extends GenericDtoMapper<WarehouseCost, WarehouseCost, WarehouseCost, WarehouseCost> {

    private final ModelMapper mapper;

    @Override
    public WarehouseCost toEntity(WarehouseCost createDto) {
        return mapper.map(createDto, WarehouseCost.class);
    }

    @Override
    public WarehouseCost toResponseDto(WarehouseCost warehouse) {
        return mapper.map(warehouse, WarehouseCost.class);
    }

    @Override
    public void update(WarehouseCost updateDto, WarehouseCost warehouse) {
        mapper.map(updateDto, warehouse);
    }

    @Override
    public WarehouseCost toCreateDto(WarehouseCost warehouse) {
        return mapper.map(warehouse, WarehouseCost.class);
    }
}
