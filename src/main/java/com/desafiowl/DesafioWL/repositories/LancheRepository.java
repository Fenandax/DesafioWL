package com.desafiowl.DesafioWL.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiowl.DesafioWL.entities.Lanche;

@Repository
public interface LancheRepository extends CrudRepository<Lanche, Long> {

}
