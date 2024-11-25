package com.grupo.SolennitaStellare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo.SolennitaStellare.entity.Evento;
import com.grupo.SolennitaStellare.service.EventoService;

//"/evento" é o que vai ter na URL para acessar o controlador
// http://localhost:8080/evento
@RestController
@RequestMapping("/evento")
public class EventoController {
    private EventoService eventoService;
    
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Evento> createdEvento(@RequestBody CreateEventoDto createEventoDto) {
        var eventoId = eventoService.createEvento(createEventoDto);
        return ResponseEntity.created(URI.create("/evento/" + eventoId.toString())).build();
    }

    @GetMapping("/{eventoId}")
    public ResponseEntity<Evento> getEventoById(@PathVariable("eventoId") String eventoId) {
        var evento = eventoService.getEventoById(eventoId);
        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listEvento() {
        var list = eventoService.listEvento();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{eventoId}")
    public ResponseEntity<Void> updateEventoById(@PathVariable("eventoId") String eventoId,
                                                 @RequestBody UpdateEventoDto updateEventoDto) {
        eventoService.updateEventoById(eventoId, updateEventoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{eventoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("eventoId") String eventoId) {
        eventoService.deleteById(eventoId);
        return ResponseEntity.noContent().build();
    }
}
