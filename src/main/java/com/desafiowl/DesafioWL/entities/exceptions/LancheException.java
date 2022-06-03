package com.desafiowl.DesafioWL.entities.exceptions;

public class LancheException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LancheException() {
		super("O lanche já foi escolhido por outra pessoa");
	}
}
