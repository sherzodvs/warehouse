package com.example.warehouse.worker.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import com.example.warehouse.warehouse.dto.WarehouseResponseDto;
import com.example.warehouse.warehouse.entity.Warehouse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Worker extends AbsClass {

    @NotBlank
    @Column(nullable = false, unique = true)

    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;



    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;



}
