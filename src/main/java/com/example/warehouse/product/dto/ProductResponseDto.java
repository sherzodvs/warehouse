package com.example.warehouse.product.dto;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.unit.entity.Unit;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {


    private String name;
    private List<String> picture;
    private String accountingCode;

}
