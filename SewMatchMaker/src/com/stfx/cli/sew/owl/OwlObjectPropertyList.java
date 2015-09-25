package com.stfx.cli.sew.owl;

import java.util.List;

public interface OwlObjectPropertyList extends List{

	OwlObjectProperty getValueAt(int index);
	OwlObjectPropertyList getAllValues();
}
