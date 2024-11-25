package com.grupo.SolennitaStellare.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.grupo.SolennitaStellare.controller.CreateConvidadoDto;
import com.grupo.SolennitaStellare.controller.UpdateConvidadoDto;
import com.grupo.SolennitaStellare.entity.Convidado;
import com.grupo.SolennitaStellare.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
    private ConvidadoRepository convidadoRepository;

    //DEPENDENCY INJECTION
    public ConvidadoService(ConvidadoRepository convidadoRepository) {
        this.convidadoRepository = convidadoRepository;
    }

    //Cria um novo convidado
    public UUID createConvidado(CreateConvidadoDto createConvidadoDto) {
        //DTO -> ENTITY
        var entity = new Convidado(UUID.randomUUID(),
                createConvidadoDto.nome(),
                createConvidadoDto.data_nascimento(),
                createConvidadoDto.celular(),
                Instant.now(),
                null
        );
        
        return convidadoRepository.save(entity).getConvidadoId();
    }

    //Procura o convidado pelo id
    public Optional<Convidado> getConvidadoById(String convidadoId) {
        var convidado = convidadoRepository.findById(UUID.fromString(convidadoId));
        return convidado;
    }

    //Lista todos os convidados
    public List<Convidado> listConvidado() {
        return convidadoRepository.findAll();
    }

    //Aqui esse serviço atualiza a tupla no banco de dados
    public void updateConvidadoById(String convidadoId, UpdateConvidadoDto updateConvidadoDto) {
        var id = UUID.fromString(convidadoId);
        var exist = convidadoRepository.findById(id);
        //Se existe no banco de dados ou não
        if (exist.isPresent()) {
            var convidado = exist.get();
            //Testa se nome é igual a null
            if (updateConvidadoDto.nome() != null) {
                convidado.setNome(updateConvidadoDto.nome());
            }
       
            if (updateConvidadoDto.data_nascimento() != null) {
                convidado.setData_nascimento(updateConvidadoDto.data_nascimento());
            }
            if (updateConvidadoDto.celular() != null) {
                convidado.setCelular(updateConvidadoDto.celular());
            }
            //Atualiza o banco de dados com as alterações
            convidadoRepository.save(convidado);
        }
    }

    public void deleteById(String convidadoId) {
        var id = UUID.fromString(convidadoId);
        var exist = convidadoRepository.existsById(id);
        //Se o id existir no banco de dados ele é deletado
        if (exist) {
            convidadoRepository.deleteById(id);
        }
    }
}
