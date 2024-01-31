package com.example.warehouse.currancyType;
import com.example.warehouse.common.service.GenericDtoMapper;
import com.example.warehouse.currancyType.dto.CurrancyTypeCreateDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeResponseDto;
import com.example.warehouse.currancyType.dto.CurrancyTypeUpdateDto;
import com.example.warehouse.currancyType.entity.CurrancyType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrancyTypeDtoMapper extends GenericDtoMapper<CurrancyType, CurrancyTypeCreateDto, CurrancyTypeUpdateDto, CurrancyTypeResponseDto> {

    private final ModelMapper mapper;

    @Override
    public CurrancyType toEntity(CurrancyTypeCreateDto createDto) {
        return mapper.map(createDto, CurrancyType.class);
    }

    @Override
    public CurrancyTypeResponseDto toResponseDto(CurrancyType currancyType) {
        return mapper.map(currancyType, CurrancyTypeResponseDto.class);
    }

    @Override
    public void update(CurrancyTypeUpdateDto updateDto, CurrancyType currancyType) {
        mapper.map(updateDto, currancyType);
    }

    @Override
    public CurrancyTypeCreateDto toCreateDto(CurrancyType currancyType) {
        return mapper.map(currancyType, CurrancyTypeCreateDto.class);
    }
}
