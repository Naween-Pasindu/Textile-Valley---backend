package com.textileValley.authentication.exception;

public class Registered_Customer_Exception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Registered_Customer_Exception(String message) {
		super(message);
	}
	
	public static String NotFoundException() {
		return "Registered Customered with not found!";
	}

	public static String NotFoundException2() {
		return "Registered Customeres with not found!";
	}
	
	public static String CustomerAlreadyExists() {
		return "Registered Customered with given name already exists";
	}

}
