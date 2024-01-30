package com.example.warehouse.warehouseCost.entity;

import com.example.warehouse.common.AbsClass;
import com.example.warehouse.currancyType.entity.CurrancyType;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseCost extends AbsClass {
    @Id
    private Long id;

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

    @OneToMany(mappedBy = "warehouseCost")
    private List<WarehouseCostItem> warehouseCostItems;


}
