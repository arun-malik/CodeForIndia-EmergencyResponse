package com.codeforindia.emrgncyres.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 5848084375345331116L;

	public UserNotFoundException()
    {
        super();
    }

    public UserNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserNotFoundException(String message)
    {
        super(message);
    }

    public UserNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
