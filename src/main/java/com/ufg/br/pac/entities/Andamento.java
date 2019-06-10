package com.ufg.br.pac.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Andamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dataModificacao;
    private Date dataConclusao;
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "andamento", cascade = CascadeType.ALL)
    private List<Pacote> pacotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }
}
