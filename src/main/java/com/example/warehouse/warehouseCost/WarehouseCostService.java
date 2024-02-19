package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.dto.*;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@Service
@Getter
@RequiredArgsConstructor
public class WarehouseCostService extends GenericCrudService<WarehouseCost, Long, WarehouseCostCreateDto, WarehouseCostUpdateDto, WarehouseCostPatchDto, WarehouseCostResponseDto> {

    private final Class<WarehouseCost> entityClass = WarehouseCost.class;
    private final WarehouseCostDtoMapper mapper;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository repository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;


    @Override
    protected WarehouseCost save(WarehouseCostCreateDto warehouseCostCreateDto) {
        WarehouseCost warehouseCost = new WarehouseCost();
        warehouseCost.setDate(warehouseCostCreateDto.getDate());
        warehouseCost.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());

        Warehouse warehouse = warehouseRepository.getByIdAndStatusTrue(warehouseCostCreateDto.getWarehouseId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        warehouseCost.setWarehouse(warehouse);

        WarehouseCostItem warehouseCostItem = warehouseCostItemRepository.findById(warehouseCostCreateDto.getWarehouseCostItemId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        warehouseCost.setWarehouse(warehouse);

        warehouseCost.getWarehouseCostItemList().add(warehouseCostItem);

        return repository.save(warehouseCost);
    }


    @Override
    protected WarehouseCost updateEntity(WarehouseCostUpdateDto updateDto, WarehouseCost warehouseCost) {
        mapper.update(updateDto, warehouseCost);
        return repository.save(warehouseCost);
    }


    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }

}

