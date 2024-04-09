package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.warehouseCost.dto.CostDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouseCost")
@RequiredArgsConstructor
public class WarehouseCostController {

    @Autowired
    private WarehouseCostService service;

    @PostMapping("/omborgaKirim")
    public ResponseEntity<WarehouseCost> create(@RequestBody @Valid WarehouseCostCreateDto createDto) {
        WarehouseCost warehouseCostResponseDto = service.saveCostWithItems(createDto);
        return ResponseEntity.ok(warehouseCostResponseDto);
    }


    @GetMapping("{costCode}")
    public ResponseEntity<CostDto> getWarehouseCostDtoByCostCode(@PathVariable String costCode) {
        try {
            CostDto costDto = service.getWarehouseCostDtoByInvoiceNumber(costCode);
            return new ResponseEntity<>(costDto, HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{invoiceNumber}")
    public ResponseEntity<CostDto> getWarehouseCostDtoByInvoiceNumber(@PathVariable String invoiceNumber) {
        try {
            CostDto costDto = service.getWarehouseCostDtoByInvoiceNumber(invoiceNumber);
            return new ResponseEntity<>(costDto, HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostDto> getById(@PathVariable Long id) {
        CostDto warehouseCostDto = service.getWarehouseCostDtoById(id);

        if (warehouseCostDto != null) {
            return new ResponseEntity<>(warehouseCostDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}