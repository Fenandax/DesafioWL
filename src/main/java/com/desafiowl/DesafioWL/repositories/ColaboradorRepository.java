package com.desafiowl.DesafioWL.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiowl.DesafioWL.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {

}