package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputRequestDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.dto.WarehouseOutputItemResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputService {
    private final WarehouseOutputRepository repository;
    private final WarehouseOutItemRepository outItemRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;


    public WarehouseOutput create(WarehouseOutputRequestDto omborChiqimDto) {
        WarehouseOutput omborChiqim = new WarehouseOutput();
        omborChiqim.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());

        Warehouse warehouse = warehouseRepository.findById(omborChiqimDto.getWarehouseId())
                .orElseThrow(() -> new CustomException("warehouse not fount"));
        omborChiqim.setWarehouse(warehouse);


        WarehouseOutputItemResponseDto chiqimProduct = new WarehouseOutputItemResponseDto();
        Long product = producteRepository.findById(chiqimProduct.getProductId())
                .orElseThrow(() -> new CustomException("product not found")).getId();

        chiqimProduct.setProductId(product);
        chiqimProduct.setProductPrice(chiqimProduct.getProductPrice());

       // omborChiqim.getWarehouseOutputItems().add(chiqimProduct);

        return repository.save(omborChiqim);
    }










    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }
}
