package com.grupo.SolennitaStellare.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_mesa") // Nome da tabela ajustado para snake_case
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    @Column(name = "id_mesa")// Nome da coluna ajustado
    private UUID mesaId;

    @Column(name = "local", nullable = false) // Nome da coluna ajustado
    private String local;

    @Column(name = "reserva", nullable = false)
    private Boolean reserva;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "capacidade", nullable = false)
    private Integer capacidade;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_timestamp", updatable = false)
    private Instant creationTimestamp;

    @UpdateTimestamp
    @Column(name = "updated_timestamp")
    private Instant updatedTimestamp;

    public Mesa() {
    }

    public Mesa(UUID mesaId, String local, Boolean reserva, Double preco, Integer capacidade,
                String status, Instant creationTimestamp, Instant updatedTimestamp) {
        this.mesaId = mesaId;
        this.local = local;
        this.reserva = reserva;
        this.preco = preco;
        this.capacidade = capacidade;
        this.status = status;
        this.creationTimestamp = creationTimestamp;
        this.updatedTimestamp = updatedTimestamp;
    }

    public UUID getMesaId() {
        return mesaId;
    }

    public void setMesaId(UUID mesaId) {
        this.mesaId = mesaId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Boolean getReserva() {
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

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
