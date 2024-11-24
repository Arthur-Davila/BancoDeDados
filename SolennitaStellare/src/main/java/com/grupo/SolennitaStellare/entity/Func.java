package com.grupo.SolennitaStellare.entity;
import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_func")
public class Func {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID funcId;

    @Column(name= "Nome")
    private String  nome;

    @Column(name="Data de nascimento")
    private Date dt_nasc;

    @Column(name = "Endereço")
    private String end;
    @CreationTimestamp
    private Instant creationTimeStamp;
    
    @UpdateTimestamp
    private Instant updatedTimeStamp;
    
    public Func() {
    }

  
    public Func(UUID funcId, String nome, Date dt_nasc, String end, Instant creationTimeStamp,
            Instant updatedTimeStamp) {
        this.funcId = funcId;
        this.nome = nome;
        this.dt_nasc = dt_nasc;
        this.end = end;
        this.creationTimeStamp = creationTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }


    public UUID getFuncId() {
        return funcId;
    }

    public void setFuncId(UUID funcId) {
        this.funcId = funcId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    
}
