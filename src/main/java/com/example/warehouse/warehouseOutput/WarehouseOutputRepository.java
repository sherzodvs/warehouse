package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOutputRepository extends GenericSpecificationRepository<WarehouseOutput,Long> {

}
