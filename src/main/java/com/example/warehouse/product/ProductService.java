package com.example.warehouse.product;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.dto.ProductCreateDto;
import com.example.warehouse.product.dto.ProductPatchDto;
import com.example.warehouse.product.dto.ProductResponseDto;
import com.example.warehouse.product.dto.ProductUpdateDto;
import com.example.warehouse.product.entity.Product;
import com.example.warehouse.warehouseCost.entity.WarehouseCost;
import com.example.warehouse.warehouseCostItem.WarehouseCostItemRepository;
import com.example.warehouse.warehouseOutput.WarehouseOutputRepository;
import com.example.warehouse.warehouseOutputItem.WarehouseOutItemRepository;
import com.example.warehouse.warehouseOutputItem.entity.WarehouseOutputItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@Service
@Getter
@RequiredArgsConstructor
public class ProductService extends GenericCrudService<Product, Long, ProductCreateDto, ProductUpdateDto, ProductPatchDto, ProductResponseDto> {

    private final ProducteRepository repository;
    private final ProductDtoMapper mapper;
    private final Class<Product> entityClass = Product.class;
    private final ModelMapper modelMapper;
    private final WarehouseOutItemRepository warehouseOutProductRepository;
    private final WarehouseCostItemRepository warehouseCostItemRepository;


    @Override
    protected Product save(ProductCreateDto createDto) {
        Product product = mapper.toEntity(createDto);
        return repository.save(product);
    }

    @Override
    protected Product updateEntity(ProductUpdateDto updateDto, Product product) {
        mapper.update(updateDto, product);
        return repository.save(product);
    }


    // Kunlik eng ko'p chiqim qilingan mahsulotlar
    public List<Product> getDailyOutProducts(LocalDate sana) {
        List<WarehouseOutputItem> all = warehouseOutProductRepository.findAll();

        Map<Product, Integer> countProduct = new HashMap<>();
        for (WarehouseOutputItem chiqim : all) {
            Product mahsulot = chiqim.getProduct();
            int soni = (int) chiqim.getCount();
            countProduct.put(mahsulot, countProduct.getOrDefault(mahsulot, 0) + soni);
        }
        List<Product> maxProduct = new ArrayList<>(countProduct.keySet());
        maxProduct.sort(Comparator.comparingInt(countProduct::get).reversed());

        return maxProduct;
    }



//    public long getYaroqlilikMuddatiYetibQolganMahsulotlarSoni(LocalDate date) {
//                return warehouseCostItemRepository.countByExpiry_dateGreaterThan(date);
//
//    }





}

