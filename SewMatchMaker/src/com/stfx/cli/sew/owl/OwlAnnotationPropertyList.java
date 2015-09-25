package com.stfx.cli.sew.owl;

import java.util.List;

public interface OwlAnnotationPropertyList extends List{
	
	OwlAnnotationProperty getValueAt (int index);
	OwlAnnotationPropertyList getAllValues();
	

}
