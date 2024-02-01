package com.example.warehouse.product.entity;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.unit.entity.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product extends AbsClass {

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private List<String> picture;
    private String accountingCode;
    private String productNumber;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;


}
