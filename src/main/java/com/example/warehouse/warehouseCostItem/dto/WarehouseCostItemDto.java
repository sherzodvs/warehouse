package com.example.warehouse.warehouseCostItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostItemDto {

    private Long product_id;

    private double count;

    private double price;

    private LocalDate expiryDate;



}
