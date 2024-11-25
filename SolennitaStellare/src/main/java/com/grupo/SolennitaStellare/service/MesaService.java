package com.grupo.SolennitaStellare.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.grupo.SolennitaStellare.controller.CreateMesaDto;
import com.grupo.SolennitaStellare.controller.UpdateMesaDto;
import com.grupo.SolennitaStellare.entity.Mesa;
import com.grupo.SolennitaStellare.repository.MesaRepository;

@Service
public class MesaService {
    private MesaRepository mesaRepository;

    // DEPENDENCY INJECTION
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    // Cria uma nova mesa
    public UUID createMesa(CreateMesaDto createMesaDto) {
        // DTO -> ENTITY
        var entity = new Mesa(UUID.randomUUID(),
                createMesaDto.local(),
                createMesaDto.reserva(),
                createMesaDto.preco(),
                createMesaDto.capacidade(),
                createMesaDto.status(),
                Instant.now(),
                null
        );

        return mesaRepository.save(entity).getMesaId();
    }

    // Procura a mesa pelo id
    public Optional<Mesa> getMesaById(String mesaId) {
        var mesa = mesaRepository.findById(UUID.fromString(mesaId));
        return mesa;
    }

    // Lista todas as mesas
    public List<Mesa> listMesa() {
        return mesaRepository.findAll();
    }

    // Aqui esse serviço atualiza a tupla no banco de dados
    public void updateMesaById(String mesaId, UpdateMesaDto updateMesaDto) {
        var id = UUID.fromString(mesaId);
        var exist = mesaRepository.findById(id);
        // Se existe no banco de dados ou não
        if (exist.isPresent()) {
            var mesa = exist.get();
            // Testa se nome é igual a null
            if (updateMesaDto.local() != null) {
                mesa.setLocal(updateMesaDto.local());
            }

            if (updateMesaDto.reserva() != null) {
                mesa.setReserva(updateMesaDto.reserva());
            }

            if (updateMesaDto.preco() != null) {
                mesa.setPreco(updateMesaDto.preco());
            }

            if (updateMesaDto.capacidade() != null) {
                mesa.setCapacidade(updateMesaDto.capacidade());
            }
            
            if (updateMesaDto.status() != null) {
                mesa.setStatus(updateMesaDto.status());
            }
            // Atualiza o banco de dados com as alterações
            mesaRepository.save(mesa);
        }
    }

    public void deleteById(String mesaId) {
        var id = UUID.fromString(mesaId);
        var exist = mesaRepository.existsById(id);
        // Se o id existir no banco de dados ele é deletado
        if (exist) {
            mesaRepository.deleteById(id);
        }
    }
}
