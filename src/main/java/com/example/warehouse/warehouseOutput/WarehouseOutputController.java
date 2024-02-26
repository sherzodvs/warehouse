package com.example.warehouse.warehouseOutput;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputCreateDto;
import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;
import com.example.warehouse.warehouseOutput.entity.WarehouseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse-output")
public class WarehouseOutputController {

    @Autowired
    private WarehouseOutputService warehouseOutputService;


//    @GetMapping
//    public ResponseEntity<Page<WarehouseOutputResponseDto>> getAll(Pageable pageable, @RequestParam(required = false) String predicate) {
//        Page<WarehouseOutputResponseDto> all = warehouseOutputService.getAll(pageable, predicate);
//        return ResponseEntity.ok(all);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<WarehouseOutputResponseDto> getById(@PathVariable Long id) {
        WarehouseOutputResponseDto byId = warehouseOutputService.getById(id);
        // Agar WarehouseCost topilmagan bo'lsa 404 Not Found qaytaramiz
        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        // Agar WarehouseCost topilgan bo'lsa uni 200 OK bilan qaytaramiz
        return ResponseEntity.ok(byId);
    }
    @PostMapping("/create")
    public ResponseEntity<WarehouseOutput> createWarehouseOutput(@RequestBody WarehouseOutputCreateDto warehouseOutputDto) {

        WarehouseOutput createdWarehouseOutput = warehouseOutputService.saveCostWithItems(warehouseOutputDto);
        return new ResponseEntity<>(createdWarehouseOutput, HttpStatus.CREATED);

    }
}

