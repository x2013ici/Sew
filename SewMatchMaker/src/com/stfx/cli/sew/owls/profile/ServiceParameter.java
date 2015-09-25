package com.stfx.cli.sew.owls.profile;

import com.stfx.cli.sew.owl.OwlIndividual;

public interface ServiceParameter extends OwlIndividual{
	
	public String getName();
	public void setName(String name);
	
	public OwlIndividual getParameter();	
	public void setParameter(OwlIndividual value);

}
