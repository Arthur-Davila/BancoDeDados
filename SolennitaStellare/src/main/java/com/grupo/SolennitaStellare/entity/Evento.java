package com.grupo.SolennitaStellare.entity;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID eventoId;

    @Column(name= "Nome Evento")
    private String  nomeEvento;

    @Column(name="Custo do Evento")
    private Double custoEvento;

    @Column(name = "Inicio")
    private Date inicio;
    @Column(name = "Fim")
    private Date fim;

    @CreationTimestamp
    private Instant creationTimeStamp;
    
    @UpdateTimestamp
    private Instant updatedTimeStamp;

    public Evento() {
    }
    
    public Evento(UUID eventoId, String nomeEvento, Double custoEvento, Date inicio, Date fim,
            Instant creationTimeStamp, Instant updatedTimeStamp) {
        this.eventoId = eventoId;
        this.nomeEvento = nomeEvento;
        this.custoEvento = custoEvento;
        this.inicio = inicio;
        this.fim = fim;
        this.creationTimeStamp = creationTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public UUID getEventoId() {
        return eventoId;
    }

    public void setEventoId(UUID idEvento) {
        this.eventoId = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Double getCustoEvento() {
        return custoEvento;
    }

    public void setCustoEvento(double custoEvento) {
        this.custoEvento = custoEvento;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Instant updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }
    
}