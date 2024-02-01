package com.example.warehouse.taminotchi.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Taminotchi extends AbsClass {

    private String name;
    private String phoneNumber;


}
