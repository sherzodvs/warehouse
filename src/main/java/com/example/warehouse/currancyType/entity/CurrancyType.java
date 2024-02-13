package com.example.warehouse.currancyType.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CurrancyType extends AbsClass {
    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @Column( nullable = false)
    private Boolean status;



}
