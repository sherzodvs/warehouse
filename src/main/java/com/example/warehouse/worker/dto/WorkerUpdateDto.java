package com.example.warehouse.worker.dto;

import com.example.warehouse.warehouse.entity.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerUpdateDto {

    private String name;
    private String surname;
    private String phoneNumber;
    private String userName;
    private String password;
    private Warehouse warehouse_id;


}
