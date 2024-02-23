package com.example.warehouse.warehouseOutput.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrencyType;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
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
public class WarehouseOutput extends AbsClass {

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currancyType_id")
    private CurrencyType currancyType;



    @OneToMany(mappedBy = "warehouseOutput", cascade = CascadeType.ALL)
    private List<WarehouseOutputItem> warehouseOutputItemList= new ArrayList<>();


//    @ManyToMany
//    @JoinTable(
//            name = "warehouseOutputs_warehouseOutputItems",
//            joinColumns = @JoinColumn(name = "warehouseOutputs_id"),
//            inverseJoinColumns = @JoinColumn(name = "warehouseOutputItems_id")
//    )
//    private List<WarehouseOutputItem> warehouseOutputItems = new ArrayList<>();


    @NotBlank
    private String invoiceNumber;

    @NotBlank
    private String costCode;











}
