package com.example.warehouse.worker.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.warehouse.entity.Warehouse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Worker extends AbsClass {

    private String name;
    private String surname;
    private String phoneNumber;
    private String userName;
    private String password;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;



}
