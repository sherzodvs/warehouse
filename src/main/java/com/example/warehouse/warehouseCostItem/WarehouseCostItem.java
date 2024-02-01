package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseCostItem extends AbsClass {


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;

    private double count;

    private double product_price;


    private LocalDate expiry_date;

    @ManyToMany(mappedBy = "warehouseCostItems")
    private Set<WarehouseCost> warehouseCosts = new HashSet<>();


}
