package com.ufg.br.pac.entities;

import javax.persistence.*;

@Entity
public class Transicao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer transicaoId;

    @Column(length = 120)
    private String descricao;

    private Boolean regra;


    public Integer getTransicaoId() {
        return transicaoId;
    }

    public void setTransicaoId(Integer transicaoId) {
        this.transicaoId = transicaoId;
    }

    public Boolean getRegra() {
        return regra;
    }

    public void setRegra(Boolean regra) {
        this.regra = regra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
