package com.example.warehouse.warehouseOutputItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarehouseOutItemRepository extends GenericSpecificationRepository<WarehouseOutputItem, Long> {
//    @Query("SELECT woi, wo FROM WarehouseOutputItem woi JOIN woi.warehouseOutput wo WHERE woi.createdAt = :createdAt")
//    List<WarehouseOutputItem> findByCreatedAt(@Param("someCriteria") String someCriteria);


}


