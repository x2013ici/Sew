package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class UnboundVariableException extends RuntimeException {
	
	public UnboundVariableException(){
		super("Unbound Variable Exception");
	}
	
	public UnboundVariableException(String msg){
		super (msg);
	}
}
