package com.desafiowl.DesafioWL.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_lanche")
public class Lanche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String lanche;

	@JsonIgnore
	@OneToMany(mappedBy = "lanche")
	private List<Colaborador> colaboradores = new ArrayList<>();

	public Lanche() {

	}

	public Lanche(Long id, String lanche) {
		super();
		this.id = id;
		this.lanche = lanche;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanche() {
		return lanche;
	}

	public void setLanche(String lanche) {
		this.lanche = lanche;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lanche);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lanche other = (Lanche) obj;
		return Objects.equals(id, other.id) && Objects.equals(lanche, other.lanche);
	}

}
