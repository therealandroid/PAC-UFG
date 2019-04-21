package com.ufg.br.pac.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private boolean abandonado;
    private Date dataPrevisaoRealizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAbandonado() {
        return abandonado;
    }

    public void setAbandonado(boolean abandonado) {
        this.abandonado = abandonado;
    }

    public Date getDataPrevisaoRealizacao() {
        return dataPrevisaoRealizacao;
    }

    public void setDataPrevisaoRealizacao(Date dataPrevisaoRealizacao) {
        this.dataPrevisaoRealizacao = dataPrevisaoRealizacao;
    }
}