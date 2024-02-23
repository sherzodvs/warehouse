package com.example.warehouse.warehouseCostItem.dto;

import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostItemCreateDto {
    private Long productId;

    private double count;

    private double price;

    private LocalDate expiryDate;


}
