package com.example.warehouse.product.dto;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.unit.entity.Unit;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductPatchDto {

    private Long id;

    @NotBlank
    private String name;

    private Category category_id;

    private List<String> picture;

    @NotBlank
    private String accountingCode;

    @NotBlank
    private String productNumber;

    private Unit unit_id;

}
