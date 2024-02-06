package com.example.warehouse.warehouse;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.unit.entity.Unit;
import com.example.warehouse.warehouse.entity.Warehouse;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarehouseRepository extends GenericSpecificationRepository<Warehouse, Long> {

    List<Warehouse> findByStatusTrue();
}
