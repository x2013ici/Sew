package com.stfx.cli.sew.owl;

import java.net.URI;
import java.util.Map;

import com.stfx.cli.sew.owls.vocubulary.Owls;

/**
 * 
 * @author Mostafijur Rahman
 *
 */
public class OwlFactory{
	
	 	private static OwlKnowledgeBase kb;
	    private static OwlOntology owlsService; 
	    private static OwlOntology owlsProfile; 
	    
	    private static OwlOntology owlsGrounding;
	    private static OwlOntology owlsProcess; 
	        
	    public interface Interface {
	    	
	        public Map getReasoners();
	        
	        public Object getReasoner(String reasonerName);
	        
		    public OwlKnowledgeBase createKB();
		    
		    public OwlOntology createOntology();
		    
		    public OwlOntology createOntology(URI uri);
		    
		    public OwlReader createReader();
		    
		    public OwlWriter createWriter();

			public OwlDataValueList createDataValueList();

			public OwlIndividualList createIndividualList();
			
			public Map getDefaultConverters();
	    }
	    
	    /**
	     * 
	     */
	    private static OwlFactory.Interface factory = createFactory();
	    
	    /**
	     * 
	     * @return
	     */
	    private static OwlFactory.Interface createFactory() {
	    	
	    	try {
                Class impl = Class.forName("com.stfx.cli.sew.owl.impl.OwlFactoryImpl");
                factory = (OwlFactory.Interface) impl.newInstance();
            } catch(Exception e) {
                System.err.println("Cannot create OwlFactory!");
                e.printStackTrace();
            }
	    	
	        return factory;
	    }
	    
	    /**
	     * 
	     * @return
	     */
	    public static OwlKnowledgeBase createKB() {
	        return factory.createKB();
	    }

	    /**
	     * 
	     * @return
	     */
	    public static OwlOntology createOntology() {        
	        return createOntology(false);
	    }
	    
	    /**
	     * 
	     * @param uri
	     * @return
	     */
	    public static OwlOntology createOntology(URI uri) {
	        return createOntology(uri, false);
	    }

	    /**
	     * 
	     * @param importOwlS
	     * @return
	     */
	    public static OwlOntology createOntology( boolean importOwlS ) {        
	        OwlOntology ontology = factory.createOntology();
	        if(importOwlS)
	            addOwlsImports(ontology);
	        return ontology;
	    }
	    
	    /**
	     * 
	     * @param uri
	     * @param importOwlS
	     * @return
	     */
	    public static OwlOntology createOntology( URI uri, boolean importOwlS ) {
	        OwlOntology ontology = factory.createOntology(uri);
	        if( importOwlS )
	            addOwlsImports(ontology);
	        return ontology;
	    }
	    

	    /**
	     * 
	     * @param ontology
	     */
	    public static void addOwlsImports(OwlOntology ontology) {
	        
	    	loadOwlsOntologies();
	        
	        ontology.addImport(owlsService);
	        ontology.addImport(owlsProfile);
	        
	        ontology.addImport(owlsProcess);
	        ontology.addImport(owlsGrounding);
	    }
	        
	    /**
	     * 
	     */
	    private static void loadOwlsOntologies() {
	        if( kb == null ) {
	            kb = createKB();
	            
	            try {
	                owlsService = kb.read(Owls.Service.URI );
	                owlsProfile = kb.read(Owls.Profile.URI );
	                owlsProcess = kb.read(Owls.Process.URI );
	                owlsGrounding = kb.read(Owls.Grounding.URI );
	            }
	            catch( Exception e ) {
	                owlsService = kb.createOntology( URI.create(Owls.Service.URI ) ); 
	                owlsProfile = kb.createOntology( URI.create(Owls.Profile.URI ) ); 
	                owlsProcess = kb.createOntology( URI.create(Owls.Process.URI ) ); 
	                owlsGrounding = kb.createOntology( URI.create(Owls.Grounding.URI ) );     
	            }
	        }
	    }
	    
	    /**
	     * 
	     * @return
	     */
	    public static OwlReader createReader() {
	        return factory.createReader();
	    }

	    /**
	     * 
	     * @return
	     */
	    public static OwlWriter createWriter() {
	        return factory.createWriter();
	    }

	    /**
	     * 
	     * @return
	     */
	    public static OwlDataValueList createDataValueList() {
	        return factory.createDataValueList();
	    }

	    /**
	     * 
	     * @return
	     */
	    public static OwlIndividualList createIndividualList() {
	        return factory.createIndividualList();
	    }


	    /**
	     * 
	     * @return
	     */
	    public static Map getReasoners() {
	        return factory.getReasoners();
	    }
	    
	    /**
	     * 
	     * @param reasonerName
	     * @return
	     */
	    public static Object getReasoner(String reasonerName) {
	        return factory.getReasoner(reasonerName);
	    }
	    
	    /**
	     * 
	     * @return
	     */
	    public static Map getDefaultConverters() {
	        return factory.getDefaultConverters();
	    }

}
