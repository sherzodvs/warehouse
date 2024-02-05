package com.example.warehouse.warehouseOutput;

import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCost.WarehouseCostService;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/warehouse-output")
public class WarehouseOutputController {


    private WarehouseOutputService warehouseOutputService;

    @PostMapping("/create")
    public ResponseEntity<WarehouseOutput> createWarehouseOutput(@RequestBody WarehouseOutput warehouseOutputDto) {
        try {
            WarehouseOutput createdWarehouseOutput = warehouseOutputService.create(warehouseOutputDto);
            return new ResponseEntity<>(createdWarehouseOutput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

