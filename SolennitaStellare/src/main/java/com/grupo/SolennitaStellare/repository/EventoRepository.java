package com.grupo.SolennitaStellare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.SolennitaStellare.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento,UUID>{

}
