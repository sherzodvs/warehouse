package com.example.warehouse.currancyType.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrancyTypeUpdateDto {

    private String name;

    private  Boolean status;


}
