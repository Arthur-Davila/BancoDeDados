package com.grupo.SolennitaStellare.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Convidado")
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID convidadoId;

    @Column(name = "Nome do Convidado", nullable = false)
    private String nome;

    @Column(name = "Data de Nascimento", nullable = false)
    private Date data_nascimento;

    @Column(name = "Contato do Convidado", nullable = false)
    private String celular;

    @Column(name = "Desconto do Convidado", precision = 5, scale = 2, nullable = false)
    private BigDecimal desconto;

    @CreationTimestamp
    private Instant creationTimeStamp;

    @UpdateTimestamp
    private Instant updatedTimeStamp;

    public Convidado() {
    }

    public Convidado(UUID convidadoId, String nome, Date data_nascimento, String celular, BigDecimal desconto,
                     Instant creationTimeStamp, Instant updatedTimeStamp) {
        this.convidadoId = convidadoId;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.celular = celular;
        this.desconto = desconto;
        this.creationTimeStamp = creationTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public UUID getConvidadoId() {
        return convidadoId;
    }

    public void setConvidadoId(UUID convidadoId) {
        this.convidadoId = convidadoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
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
