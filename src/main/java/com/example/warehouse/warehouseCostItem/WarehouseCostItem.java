package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.WarehouseCost;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "warehouseCost_id")
    private WarehouseCost warehouseCost;


}
