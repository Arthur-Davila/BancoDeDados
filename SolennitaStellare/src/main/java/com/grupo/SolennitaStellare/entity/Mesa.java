package com.grupo.SolennitaStellare.entity;


import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID MesaId;

    @Column(name = "Local da Mesa")
    private String local;

    @Column(name = "Reserva")
    private Boolean reserva;

    @Column(name = "Preço da Mesa")
    private Double preco;

    @Column(name = "Capacidade da Mesa")
    private Integer capacidade;

    @Column(name = "Status da Mesa")
    private String status;
      @CreationTimestamp
    private Instant creationTimeStamp;
    
    @UpdateTimestamp
    private Instant updatedTimeStamp;

    public Mesa() {
    }

    public Mesa(UUID MesaId, String local, Boolean reserva, Double preco, Integer capacidade,
            String status, Instant creationTimeStamp, Instant updatedTimeStamp) {
        this.MesaId = MesaId;
        this.local = local;
        this.reserva = reserva;
        this.preco = preco;
        this.capacidade = capacidade;
        this.status = status;
        this.creationTimeStamp = creationTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public UUID getMesaId() {
        return MesaId;
    }

    public void setMesaId(UUID MesaId) {
        this.MesaId = MesaId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Boolean isReserva() {
        return reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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