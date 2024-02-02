package com.example.warehouse.warehouseOutput.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrancyType;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseOutput extends AbsClass {

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currancyType_id")
    private CurrancyType currancyType;


    @ManyToMany
    @JoinTable(
            name = "warehouseOutputs_warehouseOutputItems",
            joinColumns = @JoinColumn(name = "warehouseOutputs_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouseOutputItems_id")
    )
    private List<WarehouseOutputItem> warehouseOutputItems = new ArrayList<>();


    private String invoiceNumber;

    private String costCode;











}
