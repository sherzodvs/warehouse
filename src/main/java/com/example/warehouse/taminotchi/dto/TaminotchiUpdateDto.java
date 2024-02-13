package com.example.warehouse.taminotchi.dto;

import com.example.warehouse.categoty.entity.Category;
import com.example.warehouse.unit.entity.Unit;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaminotchiUpdateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;


}
