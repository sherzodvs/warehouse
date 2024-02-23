package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputService {
    @Autowired
    private WarehouseOutputRepository repository;
    private final WarehouseOutItemRepository outItemRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseOutItemRepository warehouseOutItemRepository;
    private final CurrancyTypeRepository currancyTypeRepository;










    public WarehouseOutput saveCostWithItems(WarehouseOutputCreateDto createDto) {

        WarehouseOutputItem warehouseOutputItem = new WarehouseOutputItem();

        WarehouseOutput saved = save(createDto);


        for (WarehouseOutputItem costItem : saved.getWarehouseOutputItemList()) {

            costItem.setWarehouseOutput(saved);
            warehouseOutputItem.setCount(costItem.getCount());
            warehouseOutputItem.setProduct_price(costItem.getProduct_price());
            Product product = producteRepository.findById(costItem.getProduct().getId())
                    .orElseThrow(() -> new CustomException("product not fount"));

            warehouseOutputItem.setProduct(product);



            warehouseOutItemRepository.save(costItem);

        }

        return saved;
    }





    protected WarehouseOutput save(WarehouseOutputCreateDto omborChiqimDto) {
        WarehouseOutput omborChiqim = new WarehouseOutput();
        omborChiqim.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());

        Warehouse warehouse = warehouseRepository.findById(omborChiqimDto.getWarehouseId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        omborChiqim.setWarehouse(warehouse);

        CurrencyType currancyType = currancyTypeRepository.findById(omborChiqimDto.getCurrencyTypeId())
                .orElseThrow(() -> new CustomException("currancyType not found"));

        omborChiqim.setCurrancyType(currancyType);

        omborChiqim.setCostCode(omborChiqimDto.getCostCode());

        return repository.save(omborChiqim);
    }


    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }
}
