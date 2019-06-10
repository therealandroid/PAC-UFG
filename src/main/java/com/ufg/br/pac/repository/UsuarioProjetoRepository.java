package com.ufg.br.pac.repository;

import com.ufg.br.pac.entities.Projeto;
import com.ufg.br.pac.entities.UsuarioProjeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioProjetoRepository extends CrudRepository<UsuarioProjeto, Integer> {


}
