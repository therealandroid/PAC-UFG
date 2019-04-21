package com.ufg.br.pac.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membro {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
