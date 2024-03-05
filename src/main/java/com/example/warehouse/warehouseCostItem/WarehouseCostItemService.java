package com.example.warehouse.warehouseCostItem;

import com.example.warehouse.common.exception.CustomException;
import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.ProducteRepository;
import com.example.warehouse.warehouseCost.WarehouseCostRepository;
import com.example.warehouse.warehouseCost.dto.WarehouseCostCreateDto;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemCreateDto;
import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemResponseDto;
import com.example.warehouse.warehouseCostItem.entity.WarehouseCostItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class WarehouseCostItemService extends GenericCrudService<WarehouseCostItem, Long, WarehouseCostItemCreateDto, WarehouseCostItem, WarehouseCostItem, WarehouseCostItemResponseDto> {

    private final WarehouseCostItemRepository repository;
    private final WarehouseCostRepository costRepository;
    private final WarehouseCostItemDtoMapper mapper;
    private final Class<WarehouseCostItem> entityClass = WarehouseCostItem.class;
    private final ModelMapper modelMapper;
    private final ProducteRepository producteRepository;
    private final WarehouseCostRepository warehouseCostRepository;



    public List<WarehouseCostItem> saveWarehouseCostItems(WarehouseCostCreateDto itemsDto, WarehouseCost warehouseCost) {

        List<WarehouseCostItem> savedItems = new ArrayList<>();
        for (WarehouseCostItemCreateDto itemDto : itemsDto.getWarehouseCostItems()) {

            WarehouseCostItem warehouseCostItem = new WarehouseCostItem();
            warehouseCostItem.setProduct_id(producteRepository.findById(itemDto.getProductName())
                    .orElseThrow(() -> new CustomException("Product not found")));
            warehouseCostItem.setCount(itemDto.getCount());
            warehouseCostItem.setPrice(itemDto.getPrice());
            warehouseCostItem.setExpiryDate(itemDto.getExpiryDate());
              warehouseCostItem.setWarehouseCost(warehouseCost);

            savedItems.add(repository.save(warehouseCostItem));
        }

        return savedItems;
    }



    public double calculateTotalSumByDate(LocalDate date) {
        List<WarehouseCostItem> items = repository.findAllByCreatedAt(date);
        double totalSum = 0.0;

        for (WarehouseCostItem item : items) {
            totalSum += item.getPrice() * item.getCount();
        }
        return totalSum;
    }


//    public List<WarehouseCostItem> calculateTotalSumByDate(LocalDate date) {
//        // List<WarehouseCostItem> items = repository.findAllByCreatedAt(date);
////        double totalSum = 0.0;
////
////        for (WarehouseCostItem item : items) {
////            totalSum += item.getPrice() * item.getCount();
////        }
//        return  repository.findAllByCreatedAt(date);
//    }




    public long getCountOfProductsExpiringSoon() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDateThreshold = currentDate.plusDays(10);
        List<WarehouseCostItem> items = repository.findAllByExpiryDateBefore(expirationDateThreshold);
        return items.size();
    }







    @Override
    protected WarehouseCostItem save(WarehouseCostItemCreateDto warehouseCostItemCreateDto) {
        return null;
    }

    @Override
    protected WarehouseCostItem updateEntity(WarehouseCostItem warehouseCostItem, WarehouseCostItem warehouseCostItem2) {
        mapper.update(warehouseCostItem, warehouseCostItem2);
        return repository.save(warehouseCostItem);
    }




}
