package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.warehouseOutput.WarehouseOutputRepository;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputItemService extends GenericCrudService<WarehouseOutputItem,Long,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem,WarehouseOutputItem> {

    private final WarehouseOutItemRepository repository;
    private final WarehouseOutputItemDtoMapper mapper;
    private final Class<WarehouseOutputItem> entityClass = WarehouseOutputItem.class;
    private final ModelMapper modelMapper;
    private final WarehouseOutputRepository outRepository;



    @Override
    protected WarehouseOutputItem save(WarehouseOutputItem warehouseOutputItem) {
        WarehouseOutputItem entity = mapper.toEntity(warehouseOutputItem);
        return repository.save(entity);    }

    @Override
    protected WarehouseOutputItem updateEntity(WarehouseOutputItem warehouseOutputItem, WarehouseOutputItem warehouseOutputItem2) {
        mapper.update(warehouseOutputItem, warehouseOutputItem2);
        return repository.save(warehouseOutputItem);


    }
    public List<WarehouseOutputItem> getWarehouseOutputItemsForDay(LocalDate date) {
        return outRepository.findByDate(date);
    }



}
