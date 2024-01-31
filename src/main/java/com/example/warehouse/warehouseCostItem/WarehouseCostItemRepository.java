package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WarehouseCostItemRepository extends GenericSpecificationRepository<WarehouseCostItem, Long> {
//  //  List<WarehouseCostItem> findByExpiry_dateBeforeAndWarehouseCost_Date(LocalDate date);
//
//    long countByExpiry_dateBeforeAndWarehouseCost_Date(LocalDate date);
//
//    //findByWarehouseIn_Sana
//    List<WarehouseCostItem> findByWarehouseCost_Date(LocalDate date);

}
