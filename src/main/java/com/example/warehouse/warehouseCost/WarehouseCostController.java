package com.example.warehouse.warehouseCost;

import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouseCost")
@RequiredArgsConstructor
@Validated
public class WarehouseCostController {
    private WarehouseCostService service;

    @PostMapping("/omborgaKirim")
    public ResponseEntity<WarehouseCost> create(@RequestBody @Valid WarehouseCostResponseDto requestDto) {
        WarehouseCost warehouseCostResponseDto = service.save(requestDto);
        return ResponseEntity.ok(warehouseCostResponseDto);
    }


}
