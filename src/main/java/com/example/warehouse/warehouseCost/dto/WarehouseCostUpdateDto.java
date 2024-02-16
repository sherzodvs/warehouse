package com.example.warehouse.warehouseCost.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostUpdateDto {

    private Long warehouseId;

    private String costCode;



}
