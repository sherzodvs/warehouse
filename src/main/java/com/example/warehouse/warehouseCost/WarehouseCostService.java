package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.dto.ResponseDto;
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
public class WarehouseCostService extends GenericCrudService<WarehouseCost, Long, WarehouseCostResponseDto, WarehouseCostResponseDto, WarehouseCostResponseDto, WarehouseCostResponseDto> {

    private final Class<WarehouseCost> entityClass = WarehouseCost.class;
    private final WarehouseCostDtoMapper mapper;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository repository;


    @Override
    protected WarehouseCost save(WarehouseCostResponseDto warehouseCostResponseDto) {
        WarehouseCost warehouseCost = new WarehouseCost();
        warehouseCost.setDate(warehouseCostResponseDto.getDate());
        warehouseCost.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());

        Warehouse warehouse = warehouseRepository.findById(warehouseCostResponseDto.getWarehouse().getId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        warehouseCost.setWarehouse(warehouse);


        WarehouseCostItem warehouseCostItem = new WarehouseCostItem();

        warehouseCostItem.setPrice(warehouseCostItem.getPrice());

       warehouseCost.getWarehouseCostItemList().add(warehouseCostItem);

        return repository.save(warehouseCost);
    }


    @Override
    protected WarehouseCost updateEntity(WarehouseCostResponseDto warehouseCostResponseDto, WarehouseCost warehouseCostResponseDto2) {
        return null;
    }


    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }

}

