package com.example.warehouse.currancyType;

import com.example.warehouse.common.repository.GenericSpecificationRepository;
import com.example.warehouse.currancyType.entity.CurrancyType;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrancyTypeRepository extends GenericSpecificationRepository<CurrancyType, Long> {

}
