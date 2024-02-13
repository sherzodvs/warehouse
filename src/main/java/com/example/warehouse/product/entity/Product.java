package com.example.warehouse.product.entity;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.unit.entity.Unit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product extends AbsClass {

    @NotBlank
    @Column(name = "product_name",unique = true,nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private List<String> picture;

    @NotBlank
    private String accountingCode;

    @NotBlank
    private String productNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;


}
