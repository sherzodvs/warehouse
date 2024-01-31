package com.example.warehouse.currancyType.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.warehouseCost.WarehouseCost;
import com.example.warehouse.warehouseOutput.WarehouseOutput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CurrancyType extends AbsClass {

    private String name;
    private Boolean status;



}
