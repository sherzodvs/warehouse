package com.example.warehouse.warehouseCost;

import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/warehouseCost")
@RequiredArgsConstructor
public class WarehouseCostController {
    private WarehouseCostService service;

    @PostMapping("/omborgaKirim")
    public WarehouseCost create(@RequestBody WarehouseCost requestDto) {
        LocalDate sana = requestDto.getDate();
        Warehouse omborId = requestDto.getWarehouse();
        Taminotchi taminotchiId = requestDto.getTaminotchi();
        List<WarehouseCostItem> mahsulotlar = (List<WarehouseCostItem>) requestDto.getWarehouseCostItems();

        return service.warehouseCost(sana, omborId.getId(), taminotchiId.getId(), mahsulotlar);
    }



}
