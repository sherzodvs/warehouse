package com.example.warehouse.warehouseOutputItem.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(mappedBy = "warehouseOutputItems")
    private List<WarehouseOutput> warehouseOutputs = new ArrayList<>();

}
