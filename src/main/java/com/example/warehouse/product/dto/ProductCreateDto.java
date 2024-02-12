package com.example.warehouse.product.dto;

import com.example.warehouse.categoty.dto.CategoryResponseDto;
import com.example.warehouse.unit.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDto {
    private Long id;
    private String name;
    private CategoryResponseDto category_id;
    private List<String> picture;
    private String productNumber;
    private Unit unit_id;


}
