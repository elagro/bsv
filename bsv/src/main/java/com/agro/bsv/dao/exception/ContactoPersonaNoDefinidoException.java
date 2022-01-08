package com.agro.bsv.dao.exception;

public class ContactoPersonaNoDefinidoException extends RuntimeException {

	private static final long serialVersionUID = 47370881916811446L;
	
	
	   public ContactoPersonaNoDefinidoException(String e) {
	      super(e);
	   }
	   
	   public ContactoPersonaNoDefinidoException() {
		      super("Se debe definir al menos un medio de contacto.");
		   }
	   
}
