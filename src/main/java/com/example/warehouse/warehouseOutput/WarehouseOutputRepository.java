package com.example.warehouse.warehouseOutput;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOutputRepository extends GenericSpecificationRepository<WarehouseOutput,Long> {


}
