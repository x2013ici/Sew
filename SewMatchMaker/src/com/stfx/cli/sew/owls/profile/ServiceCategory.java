package com.stfx.cli.sew.owls.profile;

import com.stfx.cli.sew.owl.OwlIndividual;

public interface ServiceCategory extends OwlIndividual{
	
	public String getName();
	public String getTaxonomy();
	
	public String getCode();
	public String getValue();

}
