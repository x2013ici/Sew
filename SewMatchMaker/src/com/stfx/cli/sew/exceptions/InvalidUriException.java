package com.stfx.cli.sew.exceptions;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class InvalidUriException extends RuntimeException {

    /**
     * 
     */
    public InvalidUriException() {
        super();
    }

    /**
     * @param message
     */
    public InvalidUriException(String message) {
        super(message);
    }
}
