package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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



    EntityManager entityManager = null;


    @Transactional
    public default WarehouseCostItem save(WarehouseCostItem warehouseCostItem) {
        if (warehouseCostItem.getId() == null) {
            entityManager.persist(warehouseCostItem);
        } else {
            warehouseCostItem = entityManager.merge(warehouseCostItem);
        }
        return warehouseCostItem;
    }
}
