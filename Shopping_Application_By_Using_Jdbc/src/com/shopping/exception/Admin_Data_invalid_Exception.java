package com.shopping.exception;

public class Admin_Data_invalid_Exception extends RuntimeException {
	
	String exception;
	public Admin_Data_invalid_Exception()
	{
		
	}
	public Admin_Data_invalid_Exception(String exception) {
		this.exception = exception;
	}
	public String getException() {
		return exception;
	}
	@Override
	public String toString() {
		return "Admin_Data_nvalid_Exception [exception=" + exception + "]";
	}
	
	
	
	

}
