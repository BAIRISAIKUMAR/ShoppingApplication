package com.shopping.exception;

public class CustomerDataInvalidException extends RuntimeException {
	
	private String exception;
	
	public CustomerDataInvalidException()
	{
		
	}

	public CustomerDataInvalidException(String exception) {
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}

	@Override
	public String toString() {
		return "CustomerDataInvalidException [exception=" + exception + "]";
	}
	
	
	
}