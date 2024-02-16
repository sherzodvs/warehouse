package com.example.warehouse.common.service;

import com.example.warehouse.warehouseOutput.dto.WarehouseOutputResponseDto;

public abstract class GenericDtoMapper<ENTITY, CREATE_DTO, UPDATE_DTO, RESPONSE_DTO>
{
    public abstract ENTITY toEntity( CREATE_DTO createDto );

    public abstract RESPONSE_DTO toResponseDto(ENTITY entity );

    public abstract void update( UPDATE_DTO updateDto, ENTITY entity );
    public abstract CREATE_DTO toCreateDto(ENTITY entity);
}
