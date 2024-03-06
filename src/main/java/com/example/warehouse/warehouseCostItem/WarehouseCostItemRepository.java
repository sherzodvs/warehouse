package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WarehouseCostItemRepository extends GenericSpecificationRepository<WarehouseCostItem, Long> {



    @Query(value = "SELECT SUM(count) FROM warehouse_cost_item WHERE expiry_date < CURRENT_DATE", nativeQuery = true)
    Double sumExpiredItemCount();


    @Query(value = "SELECT SUM(count * price) as total_price FROM warehouse_cost_item WHERE expiry_date >= CURRENT_DATE\n", nativeQuery = true)
   Double calculateDailyTotalPrice();


}
