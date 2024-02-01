package com.example.warehouse.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {


//    private final WarehouseCostItemRepository warehouseCostItemRepository;
//
//    private final WarehouseOutItemRepository warehouseOutItemRepository;
//
//
//    // muddati yetib qolgan maxsulotlar soni
//    public List<WarehouseCostItem> getExpiredProducts(LocalDate today) {
//        return warehouseCostItemRepository.findByExpiry_dateBeforeAndWarehouseCost_Date(today);
//    }
//
//
//    // Kunlik kirim bo’lgan mahsulotlar (qiymati, umumiy summasi)
//    public List<WarehouseCostItem> getDailyInProducts(LocalDate sana) {
//        return warehouseCostItemRepository.findByWarehouseCost_Date(sana);
//    }
//
//    public Double calculateTotalDailyInAmount(List<WarehouseCostItem> dailyInProducts) {
//        double totalAmount = 0.0;
//        for (WarehouseCostItem inProduct : dailyInProducts) {
//            totalAmount += inProduct.getProduct_price();
//        }
//        return totalAmount;
//    }
//
//    public List<WarehouseOutputItem> getDailyOutProducts(LocalDate sana) {
//        return warehouseOutItemRepository.findByWarehouseOutput_Date(sana);
//    }
//
//
//    public WarehouseOutputItem findMostSoldProduct(List<WarehouseOutputItem> dailyOutProducts) {
//        Map<Long, Long> productCountMap = dailyOutProducts.stream()
//                .collect(Collectors.groupingBy(WarehouseOutputItem::getId, Collectors.counting()));
//
//        //eng ko'p sotilgan
//        Long mostSoldProductId = productCountMap.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//
//        // Eng ko'p sotilgan mahsulotni qaytarish
//        return dailyOutProducts.stream()
//                .filter(product -> product.getId().equals(mostSoldProductId))
//                .findFirst()
//                .orElse(null);
//    }
//

}

