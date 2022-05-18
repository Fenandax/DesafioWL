package com.desafiowl.DesafioWL.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafiowl.DesafioWL.entities.Pedido;
import com.desafiowl.DesafioWL.entities.pk.PedidoPK;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, PedidoPK> {

}