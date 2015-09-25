package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class GroundingNotAvailableException extends RuntimeException{
	
	public GroundingNotAvailableException(){
		super ("Grounding Not Available");
	}
	
	public GroundingNotAvailableException(String msg){
		super(msg);
	}

}
