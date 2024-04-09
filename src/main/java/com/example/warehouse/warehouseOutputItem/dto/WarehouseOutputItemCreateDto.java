package com.example.warehouse.warehouseOutputItem.dto;

import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseOutputItemCreateDto {

    private Long product;

    private double count;

    private double product_price;

}