package com.ufg.br.pac.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transicao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String descricao;
    private String regra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }
}
