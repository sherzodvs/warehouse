package com.example.warehouse.warehouseCost;

import com.example.warehouse.warehouseCost.dto.WarehouseCostResponseDto;
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
    public ResponseEntity<WarehouseCostResponseDto> create(@RequestBody @Valid WarehouseCostResponseDto requestDto) {
        WarehouseCostResponseDto warehouseCostResponseDto = service.create(requestDto);
        return ResponseEntity.ok(warehouseCostResponseDto);
    }


}
