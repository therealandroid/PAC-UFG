package com.ufg.br.pac.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 60)
    private String nome;

    @Column(length = 120)
    private String descricao;

    private boolean abandonado;

    private Date dataCriacao;

    private Date dataPrevistaRealizacao;

    public Integer getId() {
        return id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Andamento andamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Projeto projeto;

    public void setId(Integer id) {
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPrevistaRealizacao() {
        return dataPrevistaRealizacao;
    }

    public void setDataPrevistaRealizacao(Date dataPrevistaRealizacao) {
        this.dataPrevistaRealizacao = dataPrevistaRealizacao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Andamento getAndamento() {
        return andamento;
    }

    public void setAndamento(Andamento andamento) {
        this.andamento = andamento;
    }
}