package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.WarehouseCostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseOutItemRepository  extends GenericSpecificationRepository<WarehouseOutputItem,Long> {
   // List<WarehouseOutputItem> findByWarehouseOutput_Date(LocalDate date);

}
