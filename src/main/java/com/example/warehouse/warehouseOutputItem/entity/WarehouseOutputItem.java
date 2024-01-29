package com.example.warehouse.warehouseOutputItem.entity;

import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseOutputItem {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double count;

    private double product_price;


    @ManyToOne
    @JoinColumn(name = "warehouseOutput_id")
    private WarehouseOutput warehouseOutput;

}
