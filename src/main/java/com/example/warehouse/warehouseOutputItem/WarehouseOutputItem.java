package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseOutput.WarehouseOutput;
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
public class WarehouseOutputItem extends AbsClass {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double count;

    private double product_price;


    @ManyToOne
    @JoinColumn(name = "warehouseOutput_id")
    private WarehouseOutput warehouseOutput;

}
