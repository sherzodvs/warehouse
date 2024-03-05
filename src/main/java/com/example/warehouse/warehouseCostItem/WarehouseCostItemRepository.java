package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface WarehouseCostItemRepository extends GenericSpecificationRepository<WarehouseCostItem, Long> {

    @Query("SELECT pe FROM WarehouseCostItem pe WHERE pe.createdAt = :today")
    List<WarehouseCostItem> findByWarehouseCost_Date(@Param("today") LocalDate today);

}
