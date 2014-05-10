package com.codeforindia.emrgncyres.exception;

public class CompulsoryFieldException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6429172261308011341L;

	public CompulsoryFieldException()
    {
        super();
    }

    public CompulsoryFieldException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CompulsoryFieldException(String message)
    {
        super(message);
    }

    public CompulsoryFieldException(Throwable cause)
    {
        super(cause);
    }
}
