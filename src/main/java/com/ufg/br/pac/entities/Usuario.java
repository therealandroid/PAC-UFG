package com.ufg.br.pac.entities;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @Column(length = 60)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column(length = 120)
    private String nome;

    @Column(length = 8)
    private String senha;

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
}
