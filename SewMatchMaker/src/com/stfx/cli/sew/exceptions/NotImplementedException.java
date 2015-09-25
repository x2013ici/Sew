package com.stfx.cli.sew.exceptions;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class NotImplementedException extends RuntimeException {

    /**
     * 
     */
    public NotImplementedException() {
        super("Not implemented yet!");
    }

    public NotImplementedException(String msg) {
        super(msg);
    }
}
