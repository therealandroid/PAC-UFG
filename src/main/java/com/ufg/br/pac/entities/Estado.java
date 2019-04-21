package com.ufg.br.pac.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Estado {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;
    private boolean estadoFinal;
    private String descricao;
    private String permiteDelegacao;

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

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPermiteDelegacao() {
        return permiteDelegacao;
    }

    public void setPermiteDelegacao(String permiteDelegacao) {
        this.permiteDelegacao = permiteDelegacao;
    }
}
