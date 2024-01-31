package com.example.warehouse.taminotchi.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.warehouseCost.WarehouseCost;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Taminotchi extends AbsClass {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;


}
