package com.example.warehouse.taminotchi.entity;

import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.worker.entity.Worker;
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
public class Taminotchi {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "taminotchi")
    private List<WarehouseCost> warehouseCosts;

}
