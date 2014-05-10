package com.codeforindia.emrgncyres.exception;

public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3752464911523375633L;

	public InvalidInputException()
    {
        super();
    }

    public InvalidInputException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidInputException(String message)
    {
        super(message);
    }

    public InvalidInputException(Throwable cause)
    {
        super(cause);
    }
}
