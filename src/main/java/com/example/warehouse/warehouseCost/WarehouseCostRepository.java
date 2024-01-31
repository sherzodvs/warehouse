package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.repository.GenericSpecificationRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseCostRepository extends GenericSpecificationRepository<WarehouseCost,Long> {

}
