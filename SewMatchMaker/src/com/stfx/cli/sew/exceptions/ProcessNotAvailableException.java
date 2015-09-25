package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class ProcessNotAvailableException extends RuntimeException{
	
	public ProcessNotAvailableException(){
		super("Process Not Available Exception");
	}
	
	public ProcessNotAvailableException(String msg){
		super(msg);
	}

}
