package com.example.warehouse.currancyType.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CurrancyType extends AbsClass {

    private String name;
    private Boolean status;



}
