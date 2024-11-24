package com.grupo.SolennitaStellare.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.grupo.SolennitaStellare.controller.CreateFuncDto;
import com.grupo.SolennitaStellare.controller.UpdateFuncDto;
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
    public  Optional<Func> getFuncById(String funcId){
        var func = funcRepository.findById(UUID.fromString(funcId));
        return func;
    }

    public List<Func> listFunc(){
        return funcRepository.findAll();
    }
    public void updateFuncById(String funcId, UpdateFuncDto updateFuncDto){
        var id = UUID.fromString(funcId);
        var exist = funcRepository.findById(id);

        if(exist.isPresent()){
             var func  =  exist.get();

             if(updateFuncDto.nome()!=null){
                func.setNome(updateFuncDto.nome());
             }
             if(updateFuncDto.dt_nasc()!=null){
                func.setDt_nasc(updateFuncDto.dt_nasc());
             }
             if(updateFuncDto.end()!=null){
                func.setEnd(updateFuncDto.end());
             }
             funcRepository.save(func);
        }

    }
    public void deleteById(String funcId){
        var id = UUID.fromString(funcId);

        var exist = funcRepository.existsById(id);
    
        if(exist){
            funcRepository.deleteById(id);
        }
    }
}
