package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.CurrancyTypeRepository;
import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.warehouse.WarehouseRepository;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputPatchDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputUpdateDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.WarehouseOutputItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseOutputService extends GenericCrudService<WarehouseOutput,Long,WarehouseOutputCreateDto, WarehouseOutputUpdateDto, WarehouseOutputPatchDto, WarehouseOutputResponseDto> {
    @Autowired
    private WarehouseOutputRepository repository;
    private final Class<WarehouseOutput> entityClass = WarehouseOutput.class;
    private final WarehouseOutItemRepository outItemRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProducteRepository producteRepository;
    private final WarehouseOutItemRepository warehouseOutItemRepository;
    private final CurrancyTypeRepository currancyTypeRepository;
    private final WarehouseOutputItemService warehouseOutputItemService;
   private final WarehouseOutputDtoMapper mapper;

    public WarehouseOutput saveCostWithItems(WarehouseOutputCreateDto output) {
        WarehouseOutput saved = save(output);
        warehouseOutputItemService.saveWarehouseOutputItems(output,saved);
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

    @Override
    protected WarehouseOutput updateEntity(WarehouseOutputUpdateDto updateDto, WarehouseOutput warehouseOutput) {
        mapper.update(updateDto, warehouseOutput);
        return repository.save(warehouseOutput);    }



    public static String generateInvoiceNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("Mdd");
        String currentDate = dateFormat.format(new Date());
        int randomPart = new Random().nextInt(900) + 100;
        return currentDate + randomPart;
    }
}
