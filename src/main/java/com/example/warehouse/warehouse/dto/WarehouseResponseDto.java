package com.example.warehouse.warehouse.dto;

import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseResponseDto extends Warehouse {

    private Long id;
//    private String name;
//    private Boolean status;

}
