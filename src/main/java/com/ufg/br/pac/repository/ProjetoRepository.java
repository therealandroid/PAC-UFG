package com.ufg.br.pac.repository;

import com.ufg.br.pac.entities.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjetoRepository extends CrudRepository<Projeto, Integer> {

    @Query(value = "SELECT * FROM projeto p " +
            "INNER JOIN usuario_projeto up " +
            "INNER JOIN usuario u " +
            "WHERE up.usuario_id = u.id", nativeQuery = true)
    List<Projeto> findAllProjects();

}
