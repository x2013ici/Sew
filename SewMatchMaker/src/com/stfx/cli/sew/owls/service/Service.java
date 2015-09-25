package com.stfx.cli.sew.owls.service;

import com.stfx.cli.sew.owl.OwlDataValueList;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owls.profile.Profile;

/**
 * 
 * @author Mostafijur Rahman
 *
 */
public interface Service extends OwlIndividual{
	
	
	/**
	 * 
	 * @return
	 */
	public Profile getProfile();
	
	
	/**
	 * 
	 */
	public String getName();
	
	
	/**
	 * 
	 * @param lang
	 * @return
	 */
	public String getName(String lang);
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name);
	
	
	/**
	 * 
	 * @return
	 */
	public OwlDataValueList getNames();

}
