package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.unit.entity.Unit;
import com.example.warehouse.warehouseCost.WarehouseCostRepository;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.WarehouseOutputItemDtoMapper;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseCostItemService extends GenericCrudService<WarehouseCostItem,Long,WarehouseCostItem,WarehouseCostItem,WarehouseCostItem,WarehouseCostItem> {

    private final WarehouseCostItemRepository repository;
    private final WarehouseCostRepository costRepository;
    private final WarehouseCostItemDtoMapper mapper;
    private final Class<WarehouseCostItem> entityClass = WarehouseCostItem.class;
    private final ModelMapper modelMapper;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository warehouseCostRepository;





    @Override
    protected WarehouseCostItem save(WarehouseCostItem warehouseCostItem) {

        WarehouseCostItem warehouseCostItem1 = new WarehouseCostItem();
        warehouseCostItem1.setCount(warehouseCostItem.getCount());
        warehouseCostItem1.setPrice(warehouseCostItem.getPrice());
        warehouseCostItem1.setExpiryDate(warehouseCostItem.getExpiryDate());

        Product product = producteRepository.findById(warehouseCostItem.getProduct_id().getId())
                .orElseThrow(() -> new CustomException("Product not found"));
        warehouseCostItem1.setProduct_id(product);

        return repository.save(warehouseCostItem1);

          }




    @Override
    protected WarehouseCostItem updateEntity(WarehouseCostItem warehouseCostItem, WarehouseCostItem warehouseCostItem1) {
        mapper.update(warehouseCostItem, warehouseCostItem1);
        return repository.save(warehouseCostItem);    }

    public List<WarehouseCostItem> getWarehouseCostItemsForDay(LocalDate date) {
        return costRepository.findByDate(date);
    }

}
