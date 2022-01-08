package com.agro.bsv.dao.exception;

public class NoExistePersonaException extends RuntimeException {

	private static final long serialVersionUID = 47370882216811446L;
	

	   public NoExistePersonaException(Long id) {
	      super("El Id "+ id +" no existe. No se puede actualizar un Id inexistente.");
	   }
	   
}
