package com.example.warehouse.warehouseCost;

import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @GetMapping("/{id}")
    public ResponseEntity<WarehouseCostResponseDto> getById(@PathVariable Long id) {
        WarehouseCostResponseDto byId = service.getById(id);

        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId);
    }




//    @GetMapping("/costCode")
//    public ResponseEntity<WarehouseCost> getByCostCode(@RequestParam String costCode) {
//        WarehouseCost byCostCode = service.getByCostCode(costCode);
//        return ResponseEntity.ok( byCostCode);
//    }
//
//
//
//
//    @GetMapping
//    public ResponseEntity<Page<WarehouseCostResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
//        Page<WarehouseCostResponseDto> all = service.getAll(pageable, predicate);
//        return ResponseEntity.ok(all);
//    }



}
