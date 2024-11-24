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
    
    //DEPENDENCY INJECTION
    public FuncService(FuncRepository funcRepository) {
        this.funcRepository = funcRepository;
    }

    //Cria um novo funcionario
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
    //Procura o funcionario pelo id
    public  Optional<Func> getFuncById(String funcId){
        var func = funcRepository.findById(UUID.fromString(funcId));
        return func;
    }
    //Lista todos os funcionários
    public List<Func> listFunc(){
        return funcRepository.findAll();
    }
    //Aqui Esse Serviço atualiza a tupla no banco de dados
    public void updateFuncById(String funcId, UpdateFuncDto updateFuncDto){
        var id = UUID.fromString(funcId);
        var exist = funcRepository.findById(id);
        //Se existe no banco de dados ou não
        if(exist.isPresent()){
             var func  =  exist.get();
            //testa se nome é igual a null
             if(updateFuncDto.nome()!=null){
                func.setNome(updateFuncDto.nome());
             }
             //Testa se data é igual a null
             if(updateFuncDto.dt_nasc()!=null){
                func.setDt_nasc(updateFuncDto.dt_nasc());
             }
             //Testa se endereco é igual a null
             if(updateFuncDto.end()!=null){
                func.setEnd(updateFuncDto.end());
             }
             //atualiza o banco de dados com as alterações
             funcRepository.save(func);
        }

    }
    public void deleteById(String funcId){
        var id = UUID.fromString(funcId);
        
        var exist = funcRepository.existsById(id);
        //Se o id existir no banco de dados ele é deletado
        if(exist){
            funcRepository.deleteById(id);
        }
    }
}
