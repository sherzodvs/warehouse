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
public class WarehouseCost extends AbsClass {

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taminotchi_id")
    private Taminotchi taminotchi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currancyType_id")
    private CurrancyType currancyType;


    @OneToMany(mappedBy = "warehouseCost", cascade = CascadeType.ALL)
    private List<WarehouseCostItem> warehouseCostItemList;

    private String costCode;
    private String invoiceNumber;




//    @ManyToMany
//    @JoinTable(
//            name = "warehouseCosts_warehouseCostItems",
//            joinColumns = @JoinColumn(name = "warehouseCosts_id"),
//            inverseJoinColumns = @JoinColumn(name = "warehouseCostItems_id")
//    )
//    private LinkStyle<WarehouseCostItem> warehouseCostItems = new ArrayList<>();

}
