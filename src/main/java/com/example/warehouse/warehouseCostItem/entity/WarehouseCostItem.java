package com.example.warehouse.warehouseCostItem.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseCostItem extends AbsClass {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Column (nullable = false)
    private double count;

    @Column (nullable = false)
    private double price;

    private LocalDate expiryDate;

//    @Transient
//    private Long warehouseCostId;  // Transient deb qo'shilgan

    @ManyToOne
    @JoinColumn(name = "warehouse_cost_id", nullable = false)
    private WarehouseCost warehouseCost;



}
