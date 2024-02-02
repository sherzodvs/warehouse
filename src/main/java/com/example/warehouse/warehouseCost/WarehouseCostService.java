package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.taminotchi.TaminotchiRepository;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.unit.UnitRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
@Getter
@RequiredArgsConstructor
public class WarehouseCostService {

    private final WarehouseCostRepository repository;
    private final Class<WarehouseCost> entityClass = WarehouseCost.class;

    private final WarehouseRepository warehouseRepository;
    private final TaminotchiRepository taminotchiRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;
    private final WarehouseCostRepository warehouseCostRepository;


    public WarehouseCost warehouseCost(LocalDate date, Long omborId, Long taminotchiId,
                                       List<WarehouseCostItem> products) {
        Warehouse ombor = warehouseRepository.findById(omborId).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        Taminotchi taminotchi = taminotchiRepository.findById(taminotchiId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        WarehouseCost warehouseCost = new WarehouseCost();
        warehouseCost.setDate(date);
        warehouseCost.setWarehouse(ombor);
        warehouseCost.setTaminotchi(taminotchi);
        warehouseCost.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber()); // Invoice number

        for (WarehouseCostItem warehouseCostItem : products) {
            Product product = producteRepository.findById(warehouseCostItem.getProduct_id().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));


            WarehouseCostItem warehouseCostItem1 = new WarehouseCostItem();
            warehouseCostItem1.setProduct_id(product);
            warehouseCostItem1.setProduct_price(warehouseCostItem.getProduct_price());
            warehouseCostItem1.setExpiry_date(warehouseCostItem.getExpiry_date());

            warehouseCostItemRepository.save(warehouseCostItem1);
            warehouseCost.getWarehouseCostItems().add(warehouseCostItem1);
        }

        return warehouseCostRepository.save(warehouseCost);


    }


    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        String invoiceNumber = currentDate + randomPart;
        return invoiceNumber;
    }


}

