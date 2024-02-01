package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.taminotchi.TaminotchiRepository;
import com.example.warehouse.unit.UnitRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputService extends GenericCrudService<WarehouseOutput,Long,WarehouseOutput,WarehouseOutput,WarehouseOutput,WarehouseOutput> {

    private final WarehouseOutputRepository repository;
    private final WarehouseOutputDtoMapper mapper;
    private final Class<WarehouseOutput> entityClass = WarehouseOutput.class;
    private final ModelMapper modelMapper;
    private final WarehouseRepository omborRepository;
    private final TaminotchiRepository taminotchiRepository;
    private final ProducteRepository mahsulotRepository;
    private final UnitRepository olchovBirlikRepository;
    private final CurrancyTypeRepository valyutaTuriRepository;
    private final WarehouseOutItemRepository warehouseCostItemRepository;
    private final WarehouseOutputRepository warehouseCostRepository;







    @Override
    protected WarehouseOutput save(WarehouseOutput warehouseOutput) {
        WarehouseOutput entity = mapper.toEntity(warehouseOutput);

        return repository.save(entity);
    }

    @Override
    protected WarehouseOutput updateEntity(WarehouseOutput warehouseOutput, WarehouseOutput warehouseOutput2) {
        mapper.update(warehouseOutput, warehouseOutput2);
        return repository.save(warehouseOutput);    }
}
