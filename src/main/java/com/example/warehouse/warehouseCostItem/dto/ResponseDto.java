package com.example.warehouse.warehouseCostItem.dto;

import com.example.warehouse.common.abstractClass.AbsClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto extends AbsClass {
    private double count;

    private double price;


}
