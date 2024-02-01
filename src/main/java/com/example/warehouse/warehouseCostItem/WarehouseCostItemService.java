package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.WarehouseOutputItemDtoMapper;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseCostItemService extends GenericCrudService<WarehouseCostItem,Long,WarehouseCostItem,WarehouseCostItem,WarehouseCostItem,WarehouseCostItem> {

    private final WarehouseCostItemRepository repository;
    private final WarehouseCostItemDtoMapper mapper;
    private final Class<WarehouseCostItem> entityClass = WarehouseCostItem.class;
    private final ModelMapper modelMapper;


    @Override
    protected WarehouseCostItem save(WarehouseCostItem warehouseCostItem) {
        WarehouseCostItem entity = mapper.toEntity(warehouseCostItem);
        return repository.save(entity);    }

    @Override
    protected WarehouseCostItem updateEntity(WarehouseCostItem warehouseCostItem, WarehouseCostItem warehouseCostItem1) {
        mapper.update(warehouseCostItem, warehouseCostItem1);
        return repository.save(warehouseCostItem);    }
}
