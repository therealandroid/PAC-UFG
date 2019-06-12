package com.ufg.br.pac.controllers;

import com.ufg.br.pac.entities.Usuario;
import com.ufg.br.pac.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/createAccount")
    public String criarUsuario(@ModelAttribute Usuario usuario) {
        Usuario usuarioReferencia = usuarioRepository.save(usuario);

        if (usuarioReferencia != null) {
            return "Usuario " + usuarioReferencia.getNome() + " criado com sucesso";
        } else {
            return "erro";
        }
    }

}
