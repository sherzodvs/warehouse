package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.taminotchi.TaminotchiRepository;
import com.example.warehouse.unit.UnitRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputService {
    private final WarehouseOutputRepository repository;
    private final WarehouseRepository omborRepository;
    private final TaminotchiRepository taminotchiRepository;
    private final ProducteRepository mahsulotRepository;
    private final UnitRepository olchovBirlikRepository;
    private final CurrancyTypeRepository valyutaTuriRepository;
    private final WarehouseOutItemRepository warehouseCostItemRepository;
    private final WarehouseOutputRepository warehouseCostRepository;


    public WarehouseOutput create(WarehouseOutput omborChiqimDto) {
        WarehouseOutput omborChiqim = new WarehouseOutput();
        omborChiqim.setDate(omborChiqimDto.getDate());
        omborChiqim.setInvoiceNumber("Generated Invoice Number: " + generateInvoiceNumber());

        Warehouse warehouse = omborRepository.findById(omborChiqimDto.getWarehouse().getId())
                .orElseThrow(() -> new RuntimeException("warehouse not fount"));
        omborChiqim.setWarehouse(warehouse);


        WarehouseOutputItem chiqimProduct = new WarehouseOutputItem();
        Product product = mahsulotRepository.findById(chiqimProduct.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Mahsulot topilmadi"));

        chiqimProduct.setProduct(product);
        chiqimProduct.setProduct_price(chiqimProduct.getProduct_price());

        omborChiqim.getWarehouseOutputItems().add(chiqimProduct);

        return repository.save(omborChiqim);
    }





    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        String invoiceNumber = currentDate + randomPart;
        return invoiceNumber;
    }
}
