package com.stfx.cli.sew.owls.profile;

import java.net.URL;

import com.stfx.cli.sew.owl.OwlIndividual;

public interface Actor extends OwlIndividual{
	
	public String getName();
	public String getTitle();
	public String getPhone();
	
	public String getFax();
	public String getEMail();	
	
	public String getAddress();	
	public URL getURL();

}
