package com.example.warehouse.currancyType.entity;

import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CurrancyType {
    @Id
    private Long id;
    private String name;
    private Boolean status;

    @OneToMany(mappedBy = "currancyType")
    private List<WarehouseCost> warehouseCosts;


    @OneToMany(mappedBy = "currancyType")
    private List<WarehouseOutput> warehouseOutputs;



}
