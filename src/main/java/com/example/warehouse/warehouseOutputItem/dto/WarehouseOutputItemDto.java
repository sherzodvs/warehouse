package com.example.warehouse.warehouseOutputItem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputItemDto {


    private Long product_id;

    private double count;

    private double price;



}
