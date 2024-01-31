package com.example.warehouse.product;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.product.dto.ProductCreateDto;
import com.example.warehouse.product.dto.ProductPatchDto;
import com.example.warehouse.product.dto.ProductResponseDto;
import com.example.warehouse.product.dto.ProductUpdateDto;
import com.example.warehouse.product.entity.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class ProductService extends GenericCrudService<Product, Long, ProductCreateDto, ProductUpdateDto, ProductPatchDto, ProductResponseDto> {

    private final ProducteRepository repository;
    private final ProductDtoMapper mapper;
    private final Class<Product> entityClass = Product.class;
    private final ModelMapper modelMapper;


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






}

