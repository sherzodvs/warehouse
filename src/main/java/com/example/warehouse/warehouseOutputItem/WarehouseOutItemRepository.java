package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseOutItemRepository extends GenericSpecificationRepository<WarehouseOutputItem, Long> {

   // List<WarehouseOutputItem> findByWarehouseOutputs_Date(LocalDate date);
//   List<WarehouseOutputItem> findByDate(LocalDate date);

//    long countByExpirationDateGreaterThan(LocalDate date);




}


