package com.ufg.br.pac.controllers;

import com.ufg.br.pac.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("/listar_projetos")
    public String listarProjetos(Model model) {
        model.addAttribute("projetos", projetoRepository.findAllProjects());
        return "projetos";
    }

}
