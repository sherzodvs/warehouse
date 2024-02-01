package com.example.warehouse.warehouseCost.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrancyType;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import jakarta.persistence.*;
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
public class WarehouseCost extends AbsClass {

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne
    @JoinColumn(name = "taminotchi_id")
    private Taminotchi taminotchi;

    @ManyToOne
    @JoinColumn(name = "currancyType_id")
    private CurrancyType currancyType;


    private String costCode;
    private String invoiceNumber;

    @ManyToMany
    @JoinTable(
            name = "warehouseCosts_warehouseCostItems",
            joinColumns = @JoinColumn(name = "warehouseCosts_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouseCostItems_id")
    )
    private Set<WarehouseCostItem> warehouseCostItems = new HashSet<>();

}
