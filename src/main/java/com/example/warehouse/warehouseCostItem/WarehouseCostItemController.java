package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/warehouseCostItem")
@RequiredArgsConstructor

public class WarehouseCostItemController {

    @Autowired
    private final WarehouseCostItemService warehouseCostItemService;


    @GetMapping
    public ResponseEntity<Page<WarehouseCostItemResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<WarehouseCostItemResponseDto> all = warehouseCostItemService.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }



    @GetMapping("/total-sum")
    public ResponseEntity<Double> getTotalSumByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        double totalSum = warehouseCostItemService.calculateTotalSumByDate(date);
        return ResponseEntity.ok(totalSum);
    }

}
