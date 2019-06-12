package com.ufg.br.pac.controllers;

import com.ufg.br.pac.Constants;
import com.ufg.br.pac.domain.PacoteValidacao;
import com.ufg.br.pac.entities.*;
import com.ufg.br.pac.mocks.Mocks;
import com.ufg.br.pac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class PacoteController {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AndamentoRepository andamentoRepository;

    @Autowired
    UsuarioProjetoRepository usuarioProjetoRepository;

    @GetMapping("/criarPacote")
    public String criarPacote(Model model) {
        Pacote pacote = new Pacote();
        model.addAttribute(pacote);
        return Constants.Rotas.REDIRECT_CRIAR_PACOTE;
    }

    /**
     * A1 - Criar pacote
     */
    @PostMapping("/addPacote")
    public String criarPacote(@ModelAttribute Pacote pacote, Model model) {
        PacoteValidacao pacoteValidacao = new PacoteValidacao();

        if (!pacoteValidacao.pacoteValido(pacote)) {
            model.addAttribute(Constants.Parametros.PACOTE_RESPOSTA, Constants.MensagensDeErros.MENSAGEM_ENTRADA_INCORRETA);
            return Constants.Rotas.REDIRECT_CRIAR_PACOTE;
        } else {
            //Pre requisito
            Projeto referenciaProjeto = projetoRepository.save(Mocks.mock_projeto());
            Usuario referenciaUsuario = usuarioRepository.save(Mocks.mock_usuario());

            UsuarioProjeto usuarioProjeto = Mocks.mock_usuario_projeto();
            usuarioProjeto.setUsuario(referenciaUsuario);
            usuarioProjeto.setProjeto(referenciaProjeto);
            usuarioProjetoRepository.save(usuarioProjeto);

            Andamento andamento = new Andamento();
            andamento.setDataModificacao(new Date());
            andamento.setDescricao("Pacote em andamento");
            andamento.setDataConclusao(new Date());
            //Fim Pre requisito

            pacote.setProjeto(referenciaProjeto);      //Projeto já precisa estar criado
            pacote.setAndamento(andamento);
            Andamento andamentoReference = andamentoRepository.save(andamento); //cria um novo andamento em relação ao pacote
            Pacote pacoteReference = pacoteRepository.save(pacote);

            String resposta = String.format(Constants.MensagensDeSucessso.MENSAGEM_PACOTE_CRIADO_SUCESSO, pacoteReference.getNome(), pacoteReference.getDescricao());

            model.addAttribute(Constants.Parametros.PACOTE_RESPOSTA, resposta);

            return Constants.Rotas.REDIRECT_CRIAR_PACOTE;
        }
    }

}