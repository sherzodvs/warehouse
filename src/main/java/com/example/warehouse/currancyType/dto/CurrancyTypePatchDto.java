package com.example.warehouse.currancyType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrancyTypePatchDto {
    @NotBlank
    private String name;

    private  Boolean status;

}
