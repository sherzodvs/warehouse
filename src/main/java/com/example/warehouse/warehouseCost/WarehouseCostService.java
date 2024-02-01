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
import com.example.warehouse.warehouseCostItem.WarehouseCostItem;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
@Getter
@RequiredArgsConstructor
public class WarehouseCostService extends GenericCrudService<WarehouseCost, Long, WarehouseCost, WarehouseCost, WarehouseCost, WarehouseCost> {

    private final WarehouseCostRepository repository;
    private final WarehouseCostDtoMapper mapper;
    private final Class<WarehouseCost> entityClass = WarehouseCost.class;
    private final ModelMapper modelMapper;
    private final WarehouseRepository omborRepository;
    private final TaminotchiRepository taminotchiRepository;
    private final ProducteRepository mahsulotRepository;
    private final UnitRepository olchovBirlikRepository;
    private final CurrancyTypeRepository valyutaTuriRepository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;
    private final WarehouseCostRepository warehouseCostRepository;



    public WarehouseCost warehouseCost(LocalDate date, Long omborId, Long taminotchiId,
                                      List<WarehouseCostItem> products) {
        Warehouse ombor = omborRepository.findById(omborId).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        Taminotchi taminotchi = taminotchiRepository.findById(taminotchiId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        WarehouseCost warehouseCost = new WarehouseCost();
        warehouseCost.setDate(date);
        warehouseCost.setWarehouse(ombor);
        warehouseCost.setTaminotchi(taminotchi);
        warehouseCost.setInvoiceNumber("INV" + System.currentTimeMillis()); // Invoice number

        for (WarehouseCostItem warehouseCostItem : products) {
            Product mahsulot = mahsulotRepository.findById(warehouseCostItem.getProduct_id().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));


            WarehouseCostItem warehouseCostItem1 = new WarehouseCostItem();
            warehouseCostItem1.setProduct_id(mahsulot);
            warehouseCostItem1.setProduct_price(warehouseCostItem.getProduct_price());
            warehouseCostItem1.setExpiry_date(warehouseCostItem.getExpiry_date());

            warehouseCostItemRepository.save(warehouseCostItem1);
        }


        return warehouseCostRepository.save(warehouseCost);
    }


    @Override
    protected WarehouseCost save(WarehouseCost createDto) {
        WarehouseCost entity = mapper.toEntity(createDto);
        return repository.save(entity);
    }



    @Override
    protected WarehouseCost updateEntity(WarehouseCost updateDto, WarehouseCost warehouse) {
        mapper.update(updateDto, warehouse);
        return repository.save(warehouse);
    }


}

