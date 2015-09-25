package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class ProfileNotAvailableException extends RuntimeException{
	
	public ProfileNotAvailableException(){
		super("Profile Not Available Exception");
	}

	public ProfileNotAvailableException(String msg){
		super(msg);
	}
}
