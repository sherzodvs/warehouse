package com.example.warehouse.warehouseCost.dto;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.taminotchi.entity.Taminotchi;
import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseCostResponseDto extends AbsClass {
    private LocalDate date;
    private Warehouse warehouse;
    private Taminotchi taminotchi;


}
