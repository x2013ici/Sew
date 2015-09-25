package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class QoSProfileNotAvailableException extends RuntimeException{
	
	public QoSProfileNotAvailableException(){
		super("QoS Property Not Available");
	}
	
	public QoSProfileNotAvailableException (String msg){
		super (msg);
	}

}
