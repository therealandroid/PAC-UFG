package com.ufg.br.pac.controllers;

import com.ufg.br.pac.entities.Projeto;
import com.ufg.br.pac.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @PostMapping("/projeto/criar")
    public String criarProjeto(@ModelAttribute Projeto projeto) {
        Projeto reference = projetoRepository.save(projeto);

        if (reference != null) {
            return "redirect:sucesso"; //TODO Integrar com front-end
        } else {
            return "erro";
        }
    }

    @GetMapping("/projeto/listar")
    public String listarProjetos(Model model) {
        model.addAttribute("projetos", projetoRepository.findAllProjects());
        return "projetos";
    }

}
