package com.grupo.SolennitaStellare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo.SolennitaStellare.entity.Convidado;
import com.grupo.SolennitaStellare.service.ConvidadoService;

// "/convidado" é o que vai ter na URL para acessar o controlador
// http://localhost:8080/convidado
@RestController
@RequestMapping("/convidado")
public class ConvidadoController {
    private ConvidadoService convidadoService;

    public ConvidadoController(ConvidadoService convidadoService) {
        this.convidadoService = convidadoService;
    }

    @PostMapping
    public ResponseEntity<Convidado> createConvidado(@RequestBody CreateConvidadoDto createConvidadoDto) {
        var convidadoId = convidadoService.createConvidado(createConvidadoDto);
        return ResponseEntity.created(URI.create("/convidado/" + convidadoId.toString())).build();
    }

    @GetMapping("/{convidadoId}")
    public ResponseEntity<Convidado> getConvidadoById(@PathVariable("convidadoId") String convidadoId) {
        var convidado = convidadoService.getConvidadoById(convidadoId);
        if (convidado.isPresent()) {
            return ResponseEntity.ok(convidado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Convidado>> listConvidado() {
        var list = convidadoService.listConvidado();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{convidadoId}")
    public ResponseEntity<Void> updateConvidadoById(@PathVariable("convidadoId") String convidadoId,
                                                    @RequestBody UpdateConvidadoDto updateConvidadoDto) {
        convidadoService.updateConvidadoById(convidadoId, updateConvidadoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{convidadoId}")
    public ResponseEntity<Void> deleteById(@PathVariable("convidadoId") String convidadoId) {
        convidadoService.deleteById(convidadoId);
        return ResponseEntity.noContent().build();
    }
}
