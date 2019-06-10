package com.ufg.br.pac.controllers;

import com.ufg.br.pac.entities.Andamento;
import com.ufg.br.pac.entities.Pacote;
import com.ufg.br.pac.entities.Projeto;
import com.ufg.br.pac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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


    /**
     * A1 - Criar pacote
     *
     * @param model
     * @param projeto
     */
    @GetMapping("/pacote/criar")
    public String create(Model model, Projeto projeto, Andamento andamento) {
        Pacote pacote = new Pacote();
        pacote.setProjeto(projeto);      //Projeto já precisa estar criado
        pacote.setAndamento(andamento);

        andamentoRepository.save(andamento); //cria um novo andamento em relação ao pacote
        Pacote reference = pacoteRepository.save(pacote);

        model.addAttribute("pacote", pacote);
        model.addAttribute("pacotes", pacoteRepository.findAll());
        model.addAttribute("retorno", "Criação de pacote " + reference.getNome() + " " + reference.getDescricao() + "realizada com sucesso!");

        return "criar_pacote";  //Redireciona para a pagina
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Pacote pacote) {
        pacoteRepository.save(pacote);
        return "redirect:/create";
    }

}