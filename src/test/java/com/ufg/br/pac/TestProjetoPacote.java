package com.ufg.br.pac;

import com.ufg.br.pac.entities.*;
import com.ufg.br.pac.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProjetoPacote {

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    PacoteRepository pacoteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AndamentoRepository andamentoRepository;

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
    public void test_criar_pacote() {
        Projeto referenciaProjeto = projetoRepository.save(mock_projeto());
        Usuario referenciaUsuario = usuarioRepository.save(mock_usuario());

        UsuarioProjeto usuarioProjeto = mock_usuario_projeto();
        usuarioProjeto.setUsuario(referenciaUsuario);
        usuarioProjeto.setProjeto(referenciaProjeto);
        usuarioProjetoRepository.save(usuarioProjeto);

        Pacote pacote = new Pacote();
        pacote.setNome("Pacote test");
        pacote.setAbandonado(false);
        pacote.setDataCriacao(new Date());
        pacote.setDataPrevistaRealizacao(new Date());
        pacote.setDescricao("Projeto de test");
        pacote.setProjeto(referenciaProjeto);

        Andamento andamento = new Andamento();
        andamento.setDataModificacao(new Date());
        andamento.setDescricao("Pacote em andamento");
        andamento.setDataConclusao(new Date());

        andamentoRepository.save(andamento);

        pacote.setAndamento(andamento);

        Pacote pacoteRerence = pacoteRepository.save(pacote);

        Assert.assertEquals(pacoteRerence.getNome(), "Pacote test");
    }


}
