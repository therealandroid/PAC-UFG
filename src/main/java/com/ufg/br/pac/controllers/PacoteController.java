package com.ufg.br.pac.controllers;

import com.ufg.br.pac.entities.Pacote;
import com.ufg.br.pac.repository.PacoteRepository;
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

    @GetMapping("/create")
    public String create(Model model) {
        Pacote pacote = new Pacote();
        model.addAttribute("pacote", pacote);
        model.addAttribute("pacotes", pacoteRepository.findAll());
        return "criar_pacote";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Pacote pacote) {
        pacoteRepository.save(pacote);
        return "redirect:/create";
    }

}