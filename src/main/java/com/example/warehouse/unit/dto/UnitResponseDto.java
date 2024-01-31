package com.example.warehouse.unit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitResponseDto {

    private Long id;
    private String name;
    private Boolean status;

}
