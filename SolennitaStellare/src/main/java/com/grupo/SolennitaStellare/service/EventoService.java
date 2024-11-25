package com.grupo.SolennitaStellare.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.grupo.SolennitaStellare.controller.CreateEventoDto;
import com.grupo.SolennitaStellare.controller.UpdateEventoDto;
import com.grupo.SolennitaStellare.entity.Evento;
import com.grupo.SolennitaStellare.repository.EventoRepository;

@Service
public class EventoService {
    private EventoRepository eventoRepository;
    
    //DEPENDENCY INJECTION
    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    //Cria um novo evento
    public UUID createEvento(CreateEventoDto createEventoDto) {
        //DTO -> ENTITY
        var entity = new Evento(UUID.randomUUID(),
                createEventoDto.nomeEvento(),
                createEventoDto.custoEvento(),
                createEventoDto.inicio(),
                createEventoDto.fim(),
                Instant.now(),
                null
        );
        
        return eventoRepository.save(entity).getEventoId();
    }   

    //Procura o evento pelo id
    public Optional<Evento> getEventoById(String eventoId) {
        var evento = eventoRepository.findById(UUID.fromString(eventoId));
        return evento;
    }

    //Lista todos os eventos
    public List<Evento> listEvento() {
        return eventoRepository.findAll();
    }

    //Aqui esse serviço atualiza a tupla no banco de dados
    public void updateEventoById(String eventoId, UpdateEventoDto updateEventoDto) {
        var id = UUID.fromString(eventoId);
        var exist = eventoRepository.findById(id);
        //Se existe no banco de dados ou não
        if (exist.isPresent()) {
            var evento = exist.get();
            //Testa se nome é igual a null
            if (updateEventoDto.nomeEvento() != null) {
                evento.setNomeEvento(updateEventoDto.nomeEvento());
            }
       
            if (updateEventoDto.custoEvento() != null) {
                evento.setCustoEvento(updateEventoDto.custoEvento());
            }
            if (updateEventoDto.inicio() != null) {
                evento.setInicio(updateEventoDto.inicio());
            }
            if (updateEventoDto.fim() != null) {
                evento.setFim(updateEventoDto.fim());
            }
            //Atualiza o banco de dados com as alterações
            eventoRepository.save(evento);
        }
    }

    public void deleteById(String eventoId) {
        var id = UUID.fromString(eventoId);
        var exist = eventoRepository.existsById(id);
        //Se o id existir no banco de dados ele é deletado
        if (exist) {
            eventoRepository.deleteById(id);
        }
    }
}
