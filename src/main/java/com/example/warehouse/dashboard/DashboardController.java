package com.example.warehouse.dashboard;

import com.example.warehouse.warehouseCostItem.dto.WarehouseCostItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService productService;

//    @GetMapping("/daily-incoming")
//    public ResponseEntity<List<WarehouseCostItemResponseDto>> getDailyIncomingProducts(LocalDate date) {
//        List<WarehouseCostItemResponseDto> dailyIncomingProducts = productService.getDailyIncomingProducts();
//
//        if (dailyIncomingProducts != null && !dailyIncomingProducts.isEmpty()) {
//            return ResponseEntity.ok(dailyIncomingProducts);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }




}
