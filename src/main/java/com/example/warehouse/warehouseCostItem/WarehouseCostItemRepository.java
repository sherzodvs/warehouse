package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseCostItemRepository extends GenericSpecificationRepository<WarehouseCostItem, Long> {

//    //findByWarehouseIn_Sana
//    List<WarehouseCostItem> findByWarehouseCost_Date(LocalDate date);
//  long countByExpirationDateGreaterThan(LocalDate date);
  long countByExpiryDateBefore(LocalDate expiryDate);

//  List<WarehouseCostItem> findAllByCount(double count);
//
//  List<WarehouseOutputItem> findByWarehouseOutputs_Date(LocalDate date);

}
