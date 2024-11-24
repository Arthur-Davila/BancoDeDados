package com.grupo.SolennitaStellare.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.grupo.SolennitaStellare.controller.CreateFuncDto;
import com.grupo.SolennitaStellare.entity.Func;
import com.grupo.SolennitaStellare.repository.FuncRepository;

@Service
public class FuncService {
    private FuncRepository funcRepository;
    

    public FuncService(FuncRepository funcRepository) {
        this.funcRepository = funcRepository;
    }


    public UUID createFunc(CreateFuncDto createFuncDto){
        //DTO -> ENTITY
        var entity = new Func(UUID.randomUUID(),
                createFuncDto.nome(),
                createFuncDto.dt_nasc(),
                createFuncDto.end(),
                Instant.now(),
                null
                );
        
             return  funcRepository.save(entity).getFuncId();

}
}