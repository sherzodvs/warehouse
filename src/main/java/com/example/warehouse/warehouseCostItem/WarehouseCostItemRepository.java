package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseCostItemRepository extends GenericSpecificationRepository<WarehouseCostItem, Long> {
//  //  List<WarehouseCostItem> findByExpiry_dateBeforeAndWarehouseCost_Date(LocalDate date);
//
//    long countByExpiry_dateBeforeAndWarehouseCost_Date(LocalDate date);
//
//    //findByWarehouseIn_Sana
//    List<WarehouseCostItem> findByWarehouseCost_Date(LocalDate date);

}
