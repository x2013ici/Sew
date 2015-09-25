package com.stfx.cli.sew.owl;

import java.net.URI;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public interface OwlDataValue extends OwlValue{
	
	public URI getDatatypeURI();
    public String getLanguage();
    
    public Object getValue();
    public String getLexicalValue();
    

}
