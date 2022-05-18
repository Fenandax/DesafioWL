package com.desafiowl.DesafioWL.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.desafiowl.DesafioWL.entities.pk.PedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@EmbeddedId
	private PedidoPK id = new PedidoPK();

	public Pedido() {
		
	}
	
	public Pedido(Colaborador colaborador, Lanche lanche) {
		super();
		id.setColaborador(colaborador);
		id.setLanche(lanche);
	}
	
	@JsonIgnore
	public Colaborador getColaborador() {
		return id.getColaborador();
	}
	
	public void setColaborador(Colaborador colaborador) {
		id.setColaborador(colaborador);
	}
	
	public Lanche getLanche() {
		return id.getLanche();
	}
	
	public void setLanche(Lanche lanche) {
		id.setLanche(lanche);
	}
}