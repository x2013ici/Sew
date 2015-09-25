package com.stfx.cli.sew.owl;

import java.net.URI;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlEntity extends OwlObject{
	
	/**
	 * 
	 * @return
	 */
	public OwlOntology getOntology();
	
	/**
	 * 
	 * @return
	 */
	public OwlKnowledgeBase getKB();
	
	/**
	 * 
	 * @return
	 */
	public OwlDataValueList getOwlDataValueList();
	
	/**
	 * 
	 * @return
	 */
	public OwlDataPropertyList getOwlDataPropertyList();
	
	/**
	 * 
	 * @return
	 */
	public OwlObjectPropertyList getOwlObjectPropertyList();
	
	/**
	 * 
	 * @return
	 */
	public OwlAnnotationPropertyList getOwlAnnotationPropertyList();
	
	/**
	 * 
	 * @return
	 */
	//public OwlIndividualList getOwlInvidIndividualList();
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	public OwlDataValue getAnnotation(URI prop);
	
	/**
	 * 
	 * @param prop
	 * @param lang
	 * @return
	 */
	public OwlDataValue getAnnotation(URI prop, String lang);
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
	public OwlDataValueList getAnnotations(URI prop);
	
	/**
	 * 
	 * @return
	 */
	public boolean isAnonymous();
		
	/**
	 * 
	 * @return
	 */
	public URI getURI();
	
	/**
	 * 
	 * @return
	 */
	public String getLocalName();
	
	/**
	 * 
	 * @return
	 */
	public String getNamespace();
	
	/**
	 * 
	 * @return
	 */
	public Object getAnonymousId();
	
	/**
	 * 
	 * @return
	 */
	public String getLabel();
	
	/**
	 * 
	 * @param lang
	 * @return
	 */
	public String getLabel(String lang);
	
	
	/**
	 * 
	 * @param label
	 */
	public void setLabel(String label);	
	
	/**
	 * 
	 * @param label
	 * @param lang
	 */
	public void setLabel(String label, String lang);	
	
	
	
	/**
	 * 
	 * @param property
	 * @param value
	 */
	public void addAnnotation(URI property, OwlDataValue value);
	
	/**
	 * 
	 * @param property
	 * @param value
	 */
	public void addAnnotation(URI property, String value);
	
	/**
	 * 
	 * @param property
	 * @param value
	 * @param lang
	 */
	public void addAnnotation(URI property, String value, String lang);
	
	/**
	 * 
	 * @param property
	 * @param value
	 */
	public void setAnnotation(URI property, OwlDataValue value);
	
	/**
	 * 
	 * @param property
	 * @param value
	 */
	public void setAnnotation(URI property, String value);
	
	/**
	 * 
	 * @param property
	 * @param value
	 * @param lang
	 */
	public void setAnnotation(URI property, String value, String lang);
	
	/**
	 * 
	 * @param property
	 */
	public void removeAnnotations(URI property);
	
	/**
	 * 
	 * @return
	 */
	public String toPrettyString();

}
