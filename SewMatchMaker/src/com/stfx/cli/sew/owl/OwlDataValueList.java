package com.stfx.cli.sew.owl;

import java.util.List;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlDataValueList extends List{
	
	OwlDataValue valueAt(int index);
	OwlDataValueList getAllValues();
}
