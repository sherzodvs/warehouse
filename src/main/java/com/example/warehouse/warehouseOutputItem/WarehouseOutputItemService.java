package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
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
    private final ProducteRepository producteRepository;



    @Override
    protected WarehouseOutputItem save(WarehouseOutputItem warehouseOutputItem) {
        WarehouseOutputItem warehouseOutputItem1 = new WarehouseOutputItem();
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());
        warehouseOutputItem1.setProduct_price(warehouseOutputItem.getProduct_price());
        warehouseOutputItem1.setCount(warehouseOutputItem.getCount());

        Product product = producteRepository.findById(warehouseOutputItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        warehouseOutputItem1.setProduct(product);
        return repository.save(warehouseOutputItem1);


    }

    @Override
    protected WarehouseOutputItem updateEntity(WarehouseOutputItem warehouseOutputItem, WarehouseOutputItem warehouseOutputItem2) {
        mapper.update(warehouseOutputItem, warehouseOutputItem2);
        return repository.save(warehouseOutputItem);


    }
    public List<WarehouseOutputItem> getWarehouseOutputItemsForDay(LocalDate date) {
        return outRepository.findByDate(date);
    }



}
