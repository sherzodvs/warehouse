package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.currancyType.entity.CurrancyType;
import com.example.warehouse.warehouse.entity.Warehouse;
import com.example.warehouse.warehouseOutputItem.WarehouseOutputItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WarehouseOutput extends AbsClass {
    @Id
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;


    @ManyToOne
    @JoinColumn(name = "currancyType_id")
    private CurrancyType currancyType;


    private String invoiceNumber;

    private String costCode;

    @OneToMany(mappedBy = "warehouseOutput")
    private List<WarehouseOutputItem> warehouseOutputItems;











}
