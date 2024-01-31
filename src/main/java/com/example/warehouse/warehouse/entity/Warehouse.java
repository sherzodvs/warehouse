package com.example.warehouse.warehouse.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.warehouseCost.WarehouseCost;
import com.example.warehouse.warehouseOutput.WarehouseOutput;
import com.example.warehouse.worker.entity.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "warehouse")
public class Warehouse extends AbsClass {
    @Id
    private Long id;
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
