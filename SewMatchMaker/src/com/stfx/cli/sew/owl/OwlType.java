package com.stfx.cli.sew.owl;

import java.net.URI;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlType extends OwlObject{
	
	public URI getURI();
    
    public boolean isDataType();
    
    public boolean isClass();
    
    public boolean isSubTypeOf(OwlType type);

    public boolean isEquivalent(OwlType type);

}
