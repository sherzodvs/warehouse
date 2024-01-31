package com.example.warehouse.worker;

import com.example.warehouse.common.service.GenericCrudService;
import com.example.warehouse.worker.dto.WorkerCreateDto;
import com.example.warehouse.worker.dto.WorkerPatchDto;
import com.example.warehouse.worker.dto.WorkerResponseDto;
import com.example.warehouse.worker.dto.WorkerUpdateDto;
import com.example.warehouse.worker.entity.Worker;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Getter
@RequiredArgsConstructor
public class WorkerService extends GenericCrudService<Worker, Long, WorkerCreateDto, WorkerUpdateDto, WorkerPatchDto, WorkerResponseDto> {

    private final WorkerRepository repository;
    private final WorkerDtoMapper mapper;
    private final Class<Worker> entityClass = Worker.class;
    private final ModelMapper modelMapper;


    @Override
    protected Worker save(WorkerCreateDto createDto) {
        Worker entity = mapper.toEntity(createDto);
        return repository.save(entity);
    }


    @Override
    protected Worker updateEntity(WorkerUpdateDto updateDto, Worker worker) {
        mapper.update(updateDto, worker);
        return repository.save(worker);
    }






}

