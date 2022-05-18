package com.desafiowl.DesafioWL.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.desafiowl.DesafioWL.entities.Colaborador;
import com.desafiowl.DesafioWL.entities.Lanche;

@Embeddable
public class PedidoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name = "lanche_id")
	private Lanche lanche;

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaborador == null) ? 0 : colaborador.hashCode());
		result = prime * result + ((lanche == null) ? 0 : lanche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoPK other = (PedidoPK) obj;
		if (colaborador == null) {
			if (other.colaborador != null)
				return false;
		} else if (!colaborador.equals(other.colaborador))
			return false;
		if (lanche == null) {
			if (other.lanche != null)
				return false;
		} else if (!lanche.equals(other.lanche))
			return false;
		return true;
	}
}
