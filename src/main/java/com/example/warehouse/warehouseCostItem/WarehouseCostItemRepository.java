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

//    @Query("SELECT pe FROM WarehouseCostItem pe WHERE pe.createdAt = :today")
//    List<WarehouseCostItemDto> findByWarehouseCost_Date(@Param("today") LocalDate today);
//List<WarehouseCostItem> findByDate(@Param("date") LocalDate date);









    @Query(value = "SELECT\n" +
            "    wci.product_id,\n" +
            "    p.name AS product_name,\n" +
            "    wci.count,\n" +
            "    wci.price,\n" +
            "    wci.expiry_date,\n" +
            "    wci.created_at,\n" +
            "    wci.price * wci.count AS total_price\n" +
            "FROM\n" +
            "    warehouse_cost_item wci\n" +
            "JOIN\n" +
            "    product p ON wci.product_id = p.id\n" +
            "WHERE\n" +
            "    DATE(wci.created_at) = '2024-03-05';", nativeQuery = true)
    List<WarehouseCostItem> findAllByCreatedAt(@Param("date") LocalDate date);











    List<WarehouseCostItem> findAllByExpiryDateBefore(LocalDate expirationDateThreshold);

}
