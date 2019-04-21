package com.ufg.br.pac.controllers;

import com.ufg.br.pac.entities.Pacote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PacoteController {

    //In memory list
    private List<Pacote> pacotesCriados = new ArrayList<>();

    @GetMapping("/create")
    public String create(Model model) {
        Pacote pacote = new Pacote();
        model.addAttribute("pacote", pacote);
        model.addAttribute("pacotes", pacotesCriados);
        return "criar_pacote";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Pacote pacote) {

        pacotesCriados.add(0, pacote);

        return "redirect:/create";
    }

}