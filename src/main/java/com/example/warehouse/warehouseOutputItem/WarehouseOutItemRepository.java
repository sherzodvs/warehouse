package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseOutItemRepository  extends GenericSpecificationRepository<WarehouseOutputItem,Long> {
  // long countByExpirationDateGreaterThan(LocalDate date);


    //findByWarehouseOut_Sana
   // List<WarehouseOutputItem> findByWarehouseOutput_Date(LocalDate date);


}
