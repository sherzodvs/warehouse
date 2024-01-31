package com.example.warehouse.product.dto;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.unit.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductUpdateDto {
    private String name;
    private Category category_id;
    private List<String> picture;
    private String accountingCode;
    private String productNumber;
    private Unit unit_id;

}
