package com.stfx.cli.sew.owl;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.util.Set;

import com.stfx.cli.sew.exceptions.OwlErrorHandler;

public interface OwlReader {
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	public OwlOntology read(URI uri);
	
	/**
	 * 
	 * @param in
	 * @param baseURI
	 * @return
	 */
	public OwlOntology read(Reader in, URI baseURI);

	/**
	 * 
	 * @param in
	 * @param baseURI
	 * @return
	 */
	public OwlOntology read(InputStream in, URI baseURI);

    /**
     * 
     * @param kb
     * @param uri
     * @return
     */
	public OwlOntology read(OwlKnowledgeBase kb, URI uri);

    /**
     * 
     * @param kb
     * @param in
     * @param uri
     * @return
     */
	public OwlOntology read(OwlKnowledgeBase kb, Reader in, URI uri);
	
	/**
	 * 
	 * @param kb
	 * @param in
	 * @param baseURI
	 * @return
	 */
	public OwlOntology read(OwlKnowledgeBase kb, InputStream in, URI baseURI);
	
	/**
	 * 
	 * @return
	 */
	public Set getIgnoredOntologies();
	
	/**
	 * 
	 * @param uri
	 */
	public void addIgnoredOntology(URI uri);	
	
	/**
	 * 
	 * @param errHandler
	 */
	public void setErrorHandler(OwlErrorHandler errHandler);
	
	/**
	 * 
	 * @param ignore
	 */
	public void setIgnoreFailedImport( boolean ignore );
	
	/**
	 * 
	 * @return
	 */
	public boolean getIgnoreFailedImport();

}
