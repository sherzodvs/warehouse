package com.example.warehouse.warehouseCost;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemDto;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseCostRepository extends GenericSpecificationRepository<WarehouseCost,Long> {


    Optional<?> findByCostCode(String costCode);

    Optional<?> findByInvoiceNumber(String invoiceNumber);

}
