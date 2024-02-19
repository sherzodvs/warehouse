package com.example.warehouse.warehouseOutput.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputCreateDto {
    private LocalDate date;
    private Long warehouseId;

   // private Long warehouseCostItemId;
    private Long currencyTypeId;
    private String costCode;



}
