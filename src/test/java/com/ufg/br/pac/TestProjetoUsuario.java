package com.ufg.br.pac;

import com.ufg.br.pac.entities.Projeto;
import com.ufg.br.pac.entities.Usuario;
import com.ufg.br.pac.entities.UsuarioProjeto;
import com.ufg.br.pac.repository.PacoteRepository;
import com.ufg.br.pac.repository.ProjetoRepository;
import com.ufg.br.pac.repository.UsuarioProjetoRepository;
import com.ufg.br.pac.repository.UsuarioRepository;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transaction;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProjetoUsuario {

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    PacoteRepository pacoteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioProjetoRepository usuarioProjetoRepository;

    public Projeto mock_projeto() {
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

    public Usuario mock_usuario() {
        Usuario usuario = new Usuario();
        usuario.setId("201300681");
        usuario.setNome("Diogo Jayme");
        usuario.setSenha("BATATA");
        return usuario;
    }

    public UsuarioProjeto mock_usuario_projeto() {
        UsuarioProjeto usuarioProjeto = new UsuarioProjeto();
        return usuarioProjeto;
    }

    @Test
    public void test_insert_usuario_projeto() {
        Projeto referenciaProjeto = projetoRepository.save(mock_projeto());
        Usuario referenciaUsuario = usuarioRepository.save(mock_usuario());

        UsuarioProjeto usuarioProjeto = mock_usuario_projeto();
        usuarioProjeto.setUsuario(referenciaUsuario);
        usuarioProjeto.setProjeto(referenciaProjeto);
        usuarioProjetoRepository.save(usuarioProjeto);
    }

    @Test
    public void test_listar_projetos() {
        List<Projeto> projetos = projetoRepository.findAllProjects();
        Assert.assertNotNull(projetos);
    }


}
