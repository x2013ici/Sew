package com.stfx.cli.sew.owl;

import java.net.URI;
import java.util.Set;

/**
 * 
 * @author Mostafijur Rahman
 *
 */
public interface OwlModel {

	public Object getImplementation();
	
	public void refresh();
	
	public boolean isConsistent();
	
	/**
     * Prepare the reasoner associated with this model.
     */
	public void prepare();
	
	/**
     * Tell the reasoner to compute the subclass relations between all the named classes and find
     * the instances of each class. The results will be cached and subsequent calls to query the
     * model will use the cache. This call has no effect if reasoner does not support
     * classification.
     */
    public void classify();

    /**
     * Returns true if the model is classified.
     */
    public boolean isClassified();
    
    public void setReasoner(String reasonerName);
    
    public Object getReasoner();
    
    public OwlOntology getBaseOntology();
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlClass createClass(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlObjectProperty createObjectProperty(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlDataProperty createDataProperty(URI uri);
    
    /**
     *
     * @param uri
     * @return
     */
    public OwlIndividual createIndividual(URI uri);
    
    /**
     * 
     * @param c
     * @return
     */
    public OwlIndividual createInstance(OwlClass c);
    
    /**
     * 
     * @param c
     * @param uri
     * @return
     */
    public OwlIndividual createInstance(OwlClass c, URI uri);
    
    /**
     * @param value
     * @return
     */
    public OwlDataValue createDataValue(String value);
    
    /**
     * 
     * @param value
     * @param language
     * @return
     */
    public OwlDataValue createDataValue(String value, String language);
    
    /**
     * 
     * @param value
     * @param datatypeURI
     * @return
     */
    public OwlDataValue createDataValue(Object value, URI datatypeURI);
    
    /**
     * 
     * @param value
     * @return
     */
    public OwlDataValue createDataValue(Object value);

    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlClass getClass(URI uri);
    
    /**
     * 
     * @return
     */
    public Set getClasses();
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlIndividual getIndividual(URI uri);

    /**
     * 
     * @return
     */
    public OwlIndividualList getIndividuals();

    /**
     * 
     * @param uri
     * @return
     */
    public OwlProperty getProperty(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlObjectProperty getObjectProperty(URI uri);
    
    /**
     * @param uri
     * @return
     */
    public OwlDataProperty getDataProperty(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlDataType getDataType(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlType getType(URI uri);
    
    /**
     * 
     * @param uri
     * @return
     */
    public OwlEntity getEntity(URI uri);
}
