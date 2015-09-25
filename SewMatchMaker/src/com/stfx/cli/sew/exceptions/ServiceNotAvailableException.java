package com.stfx.cli.sew.exceptions;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */


public class ServiceNotAvailableException extends RuntimeException {
	
	public ServiceNotAvailableException(){
		super("Service Not Available Exception");
	}
	
	public ServiceNotAvailableException (String msg) {
		super(msg);
	}
	
}
