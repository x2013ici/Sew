package com.stfx.cli.sew.owl;

/**
 * 
 * @author Mosafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlDataType extends OwlDataRange, OwlType{
	
	public boolean isSubTypeOf(OwlDataType dataType);

}
