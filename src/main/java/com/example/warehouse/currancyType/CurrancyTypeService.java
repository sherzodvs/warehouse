package com.example.warehouse.currancyType;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.currancyType.dto.CurrancyTypeCreateDto;
import com.example.warehouse.currancyType.dto.CurrancyTypePatchDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeResponseDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeUpdateDto;
import com.example.warehouse.currancyType.entity.CurrancyType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class CurrancyTypeService extends GenericCrudService<CurrancyType, Long, CurrancyTypeCreateDto, CurrancyTypeUpdateDto, CurrancyTypePatchDto, CurrancyTypeResponseDto> {

    private final CurrancyTypeRepository repository;
    private final CurrancyTypeDtoMapper mapper;
    private final Class<CurrancyType> entityClass = CurrancyType.class;
    private final ModelMapper modelMapper;


    @Override
    protected CurrancyType save(CurrancyTypeCreateDto createDto) {
        CurrancyType currancyType = mapper.toEntity(createDto);
        return repository.save(currancyType);
    }

    @Override
    protected CurrancyType updateEntity(CurrancyTypeUpdateDto updateDto, CurrancyType currancyType) {
        mapper.update(updateDto, currancyType);
        return repository.save(currancyType);
    }






}

