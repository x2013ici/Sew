package com.stfx.cli.sew.exceptions;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public interface OwlErrorHandler {
	
	public void warning(String msg);
	public void error(String msg);

}
