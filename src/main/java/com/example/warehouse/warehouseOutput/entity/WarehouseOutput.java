package com.example.warehouse.warehouseOutput.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrancyType;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
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
public class WarehouseOutput extends AbsClass {

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne
    @JoinColumn(name = "currancyType_id")
    private CurrancyType currancyType;


    @ManyToMany
    @JoinTable(
            name = "warehouseOutputs_warehouseOutputItems",
            joinColumns = @JoinColumn(name = "warehouseOutputs_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouseOutputItems_id")
    )
    private Set<WarehouseOutputItem> warehouseOutputItems = new HashSet<>();


    private String invoiceNumber;

    private String costCode;











}
