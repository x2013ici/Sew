package com.stfx.cli.sew.owl;

import java.util.List;

public interface OwlDataPropertyList extends List{
	
	OwlDataProperty getValueAt(int index);
	OwlDataPropertyList getAllValues();

}
