package com.ufg.br.pac.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 60)
    private String nome;

    @Column(length = 20)
    private String sigla;

    @Column(length = 120)
    private String descricao;

    @Column(length = 120)
    private String patrocinador;

    @Column(length = 120)
    private String stakeholders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<UsuarioProjeto> usuarioProjetos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Pacote> pacotes;

    private Date dataInicio;

    private Date dataTermino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<UsuarioProjeto> getUsuarioProjetos() {
        return usuarioProjetos;
    }

    public void setUsuarioProjetos(List<UsuarioProjeto> usuarioProjetos) {
        this.usuarioProjetos = usuarioProjetos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(String stakeholders) {
        this.stakeholders = stakeholders;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }
}
