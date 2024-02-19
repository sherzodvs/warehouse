package com.example.warehouse.warehouseCost.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private CurrencyType currancyType;


    @OneToMany(mappedBy = "warehouseCost", cascade = CascadeType.ALL)
    private List<WarehouseCostItem> warehouseCostItemList = new ArrayList<>();

    @NotBlank
    private String costCode;

    @NotBlank
    private String invoiceNumber;


//    @ManyToMany
//    @JoinTable(
//            name = "warehouseCosts_warehouseCostItems",
//            joinColumns = @JoinColumn(name = "warehouseCosts_id"),
//            inverseJoinColumns = @JoinColumn(name = "warehouseCostItems_id")
//    )
//    private LinkStyle<WarehouseCostItem> warehouseCostItems = new ArrayList<>();

}
