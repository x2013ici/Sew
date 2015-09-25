package com.stfx.cli.sew.owl;

import java.net.URI;
import java.util.Set;

public interface OwlOntology extends OwlModel{
	
	/**
	 * 
	 * @return
	 */
	public URI getURI();
	
    /**
     * 
     * @param uri
     */
	public void setURI(URI uri);

    /**
     * 
     * @return
     */
	public URI getFileURI();
    
	/**
	 * 
	 * @param uri
	 */
	public void setFileURI(URI uri);

    public OwlKnowledgeBase getKB();

    /**
     * 
     * @return
     */
	public Set getImports();
    
    
    /**
     * 
     * @param direct
     * @return
     */
	public Set getImports(boolean direct);
    
	/**
	 * 
	 * @param ontology
	 */
	public void addImport(OwlOntology ontology);

    /**
     * 
     * @return
     */
	public OwlOntology getTranslationSource();

    /**
     * 
     * @param ontology
     * @return
     */
    public OwlOntology union( OwlOntology ontology);

    /**
     * 
     * @param ontology
     */
    public void add( OwlOntology ontology);

}
