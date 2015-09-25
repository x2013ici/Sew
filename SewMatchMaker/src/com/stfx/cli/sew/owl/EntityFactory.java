package com.stfx.cli.sew.owl;

import java.net.URI;
import com.stfx.cli.sew.owl.vocubulary.Owl;
/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public class EntityFactory {
	
	private static OwlOntology factory = OwlFactory.createOntology();

    /**
     * 
     * @return
     */
	public static OwlIndividual createIndividual() {
        return factory.createInstance(Owl.Thing);
    }
    
    /**
     * 
     * @param uri
     * @return
     */
	public static OwlIndividual createIndividual(URI uri) {
        return factory.createIndividual(uri);
    }
  
    /**
     * 
     * @param value
     * @return
     */
	public static OwlDataValue createDataValue(String value) {
        return factory.createDataValue(value);
    }

    /**
     * 
     * @param value
     * @param language
     * @return
     */
	public static OwlDataValue createDataValue(String value, String language) {
        return factory.createDataValue(value, language);
    }

    /**
     * 
     * @param value
     * @param datatypeURI
     * @return
     */
	public static OwlDataValue createDataValue(Object value, URI datatypeURI) {
        return factory.createDataValue(value, datatypeURI);
    }
    
    /**
     * 
     * @param value
     * @return
     */
	public static OwlDataValue createDataValue(Object value) {
        return factory.createDataValue(value);
    }

    /**
     * 
     * @param uri
     * @return
     */
	public static OwlClass createClass(URI uri) {
        return factory.createClass(uri);
    }

    /**
     * 
     * @param uri
     * @return
     */
	public static OwlObjectProperty createObjectProperty(URI uri) {
        return factory.createObjectProperty(uri);
    }

    /**
     * 
     * @param uri
     * @return
     */
	public static OwlDataProperty createDataProperty(URI uri) {
        return factory.createDataProperty(uri);
    }

}
