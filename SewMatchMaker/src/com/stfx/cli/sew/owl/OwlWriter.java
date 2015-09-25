package com.stfx.cli.sew.owl;

import java.io.OutputStream;
import java.io.Writer;
import java.net.URI;

/**
 * 
 * @author Mostafijur Rahman
 *
 */

public interface OwlWriter {
	
	/**
	 * 
	 * @param ontology
	 * @param writer
	 */
	public void write(OwlModel ontology, Writer writer);

    /**
     * 
     * @param ontology
     * @param writer
     * @param baseURI
     */
	public void write(OwlModel ontology, Writer writer, URI baseURI);

    /**
     * 
     * @param ontology
     * @param out
     */
	public void write(OwlModel ontology, OutputStream out);

    /**
     * 
     * @param ontology
     * @param out
     * @param baseURI
     */
	public void write(OwlModel ontology, OutputStream out, URI baseURI);

    /**
     * 
     * @param prefix
     * @param uri
     */
	public void setNsPrefix(String prefix, String uri);

    /**
     * 
     * @param c
     */
	public void addPrettyType(OwlClass c);
    
    /**
     * 
     * @return
     */
	public boolean isShowXmlDeclaration();

    /**
     * 
     * @param showXmlDeclaration
     */
	public void setShowXmlDeclaration( boolean showXmlDeclaration );

}
