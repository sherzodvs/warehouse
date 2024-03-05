package com.example.warehouse.warehouseCost.dto;

import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CostDto {
    private String warehouseName;
    private String taminotchiName;
    private String currencyTypeName;
    private String costCode;
    private List<WarehouseCostItem> warehouseCostItemList;


}
