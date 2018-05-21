package fr.mb.biblio.models.exception;

public class FunctionalException extends Exception {
	
	 public FunctionalException(String pMessage) {
	        super(pMessage);
	    }


	    public FunctionalException(String pMessage, Throwable pCause) {
	        super(pMessage, pCause);
	    }
}
