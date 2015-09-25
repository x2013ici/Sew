package com.stfx.cli.sew.owl;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlClass extends OwlEntity, OwlType{
	
	
	public boolean isEquivalentTo(OwlClass c);
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean isSubClassOf(OwlClass c);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean isDisjoint(OwlClass c);

	/**
	 * 
	 * @return
	 */
	public Set getSubClasses();
	
	/**
	 * 
	 * @param direct
	 * @return
	 */
	public Set getSubClasses(boolean direct);

	/**
	 * 
	 * @return
	 */
	public Set getSuperClasses();

	/**
	 * 
	 * @param direct
	 * @return
	 */
	public Set getSuperClasses(boolean direct);

	/**
	 * 
	 * @return
	 */
	public Set getEquivalentClasses();
	
	/*
	 * 
	 */
	public boolean isEnumerated();
	
	/**
	 * 
	 * @return
	 */
	public OwlIndividualList getEnumerations();
	
	/**
	 * 
	 * @return
	 */
	public OwlIndividualList getInstances();    
	
	/**
	 * 
	 * @return
	 */
	public Map getProperties();
	
	/**
	 * 
	 * @return
	 */
	public List getDeclaredProperties();
	
	/**
	 * 
	 * @param direct
	 * @return
	 */
	public List getDeclaredProperties(boolean direct);

}
