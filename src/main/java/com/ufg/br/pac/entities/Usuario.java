package com.ufg.br.pac.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @Column(length = 60)
    private String id;

    @Column(length = 120)
    private String nome;

    @Column(length = 8)
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<UsuarioProjeto> usuarioProjetos;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<UsuarioProjeto> getUsuarioProjetos() {
        return usuarioProjetos;
    }

    public void setUsuarioProjetos(List<UsuarioProjeto> usuarioProjetos) {
        this.usuarioProjetos = usuarioProjetos;
    }
}
