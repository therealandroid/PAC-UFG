package com.ufg.br.pac.mocks;

import com.ufg.br.pac.entities.Projeto;
import com.ufg.br.pac.entities.Usuario;
import com.ufg.br.pac.entities.UsuarioProjeto;

import java.util.Date;

public class Mocks {

    public static Projeto mock_projeto() {
        Projeto projeto = new Projeto();
        projeto.setId(1);
        projeto.setNome("Pac Arquitetura");
        projeto.setDescricao("ASDFG");
        projeto.setStakeholders("Juliano, João");
        projeto.setSigla("PA");
        projeto.setPatrocinador("Danilo");
        projeto.setDataInicio(new Date());
        projeto.setDataTermino(new Date());
        return projeto;
    }

    public static Usuario mock_usuario() {
        Usuario usuario = new Usuario();
        usuario.setId("201300681");
        usuario.setNome("Diogo Jayme");
        usuario.setSenha("BATATA");
        return usuario;
    }

    public static UsuarioProjeto mock_usuario_projeto() {
        UsuarioProjeto usuarioProjeto = new UsuarioProjeto();
        return usuarioProjeto;
    }


}
