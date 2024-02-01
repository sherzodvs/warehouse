package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.warehouse.WarehouseDtoMapper;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputItemService extends GenericCrudService<WarehouseOutputItem,Long,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem> {

    private final WarehouseOutItemRepository repository;
    private final WarehouseOutputItemDtoMapper mapper;
    private final Class<WarehouseOutputItem> entityClass = WarehouseOutputItem.class;
    private final ModelMapper modelMapper;


    @Override
    protected WarehouseOutputItem save(WarehouseOutputItem warehouseOutputItem) {
        WarehouseOutputItem entity = mapper.toEntity(warehouseOutputItem);
        return repository.save(entity);    }

    @Override
    protected WarehouseOutputItem updateEntity(WarehouseOutputItem warehouseOutputItem, WarehouseOutputItem warehouseOutputItem2) {
        mapper.update(warehouseOutputItem, warehouseOutputItem2);
        return repository.save(warehouseOutputItem);    }
}
