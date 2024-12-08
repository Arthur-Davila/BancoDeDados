package com.grupo.SolennitaStellare.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo.SolennitaStellare.entity.Convidado;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado ,UUID>{
     long count();
}
