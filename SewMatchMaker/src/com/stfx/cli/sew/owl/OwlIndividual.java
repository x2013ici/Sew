package com.stfx.cli.sew.owl;

import java.util.Map;
import java.util.Set;

public interface OwlIndividual extends OwlEntity,OwlValue{
	
	/**
	 * 
	 * @param prop
	 * @return
	 */
    public boolean hasProperty(OwlProperty prop);

    /**
     * 
     * @param prop
     * @param value
     * @return
     */
    public boolean hasProperty(OwlProperty prop, OwlValue value);

    /**
     * 
     * @param prop
     * @return
     */
    public OwlIndividual getProperty(OwlObjectProperty prop);

    /**
     * 
     * @param prop
     * @return
     */
    public OwlIndividualList getProperties(OwlObjectProperty prop);

    /**
     * 
     * @param prop
     * @return
     */
    public OwlDataValue getProperty(OwlDataProperty prop);

    /**
     * 
     * @param prop
     * @param lang
     * @return
     */
    public OwlDataValue getProperty(OwlDataProperty prop, String lang);

    /**
     * 
     * @param prop
     * @return
     */
    public OwlDataValueList getProperties(OwlDataProperty prop);

    /**
     * 
     * @return
     */
    public Map getProperties();

    public OwlIndividual getIncomingProperty(OwlObjectProperty prop);

    /**
     * 
     * @param prop
     * @return
     */
    public OwlIndividualList getIncomingProperties(OwlObjectProperty prop);

    /**
     * 
     * @return
     */
    public OwlIndividualList getIncomingProperties();

   /**
    * 
    * @param prop
    * @param value
    */
    public void setProperty(OwlDataProperty prop, String value);

    /**
     * 
     * @param prop
     * @param value
     */
    public void setProperty(OwlDataProperty prop, Object value);

    /**
     * 
     * @param prop
     * @param value
     */
    public void setProperty(OwlDataProperty prop, OwlDataValue value);

    /**
     * 
     * @param prop
     * @param value
     */
    public void addProperty(OwlDataProperty prop, OwlDataValue value);

    /**
     * 
     * @param prop
     * @param value
     */
    public void addProperty(OwlDataProperty prop, String value);

    public void addProperty(OwlDataProperty prop, Object value);

    public void removeProperties(OwlProperty prop);

    public void removeProperty(OwlProperty theProp, OwlValue theValue);

    public void addProperty(OwlObjectProperty prop, OwlIndividual value);

    public void setProperty(OwlObjectProperty prop, OwlIndividual value);

    public void addType(OwlClass c);

    public void removeTypes();
        
    public void delete();

    public OwlClass getType();

    public Set getTypes();

    public boolean isType(OwlClass c);
    
    public OwlOntology getSourceOntology();
    
    public boolean isSameAs(OwlIndividual other);
    
    public OwlIndividualList getSameIndividuals();
    
    public boolean isDifferentFrom(OwlIndividual other);

    public OwlIndividualList getDifferentIndividuals();

}
