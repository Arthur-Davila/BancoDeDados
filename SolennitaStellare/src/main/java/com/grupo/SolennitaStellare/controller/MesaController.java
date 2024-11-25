package com.grupo.SolennitaStellare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo.SolennitaStellare.entity.Mesa;
import com.grupo.SolennitaStellare.service.MesaService;

// "/mesa" é o que vai ter na URL para acessar o controlador
// http://localhost:8080/mesa
@RestController
@RequestMapping("/mesa")
public class MesaController {
    private MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody CreateMesaDto createMesaDto) {
        var mesaId = mesaService.createMesa(createMesaDto);
        return ResponseEntity.created(URI.create("/mesa/" + mesaId.toString())).build();
    }

    @GetMapping("/{mesaId}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable("mesaId") String mesaId) {
        var mesa = mesaService.getMesaById(mesaId);
        if (mesa.isPresent()) {
            return ResponseEntity.ok(mesa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Mesa>> listMesa() {
        var list = mesaService.listMesa();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{mesaId}")
    public ResponseEntity<Void> updateMesaById(@PathVariable("mesaId") String mesaId,
                                               @RequestBody UpdateMesaDto updateMesaDto) {
        mesaService.updateMesaById(mesaId, updateMesaDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{mesaId}")
    public ResponseEntity<Void> deleteById(@PathVariable("mesaId") String mesaId) {
        mesaService.deleteById(mesaId);
        return ResponseEntity.noContent().build();
    }
}
