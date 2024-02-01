package com.example.warehouse.warehouse.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "warehouse")
public class Warehouse extends AbsClass {

    private String name;
    private Boolean status;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<Worker> workers;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<WarehouseCost> warehouseCosts;
//
//    @OneToMany(mappedBy = "warehouse")
//    private List<WarehouseOutput> warehouseOutputs;
//

}
