package com.agro.bsv.dao.exception;

public class IdPersonaEsNuloException extends RuntimeException {

	private static final long serialVersionUID = 47370882216811446L;
	

	   public IdPersonaEsNuloException() {
	      super("El Id no puede ser nulo.");
	   }
	   
}
