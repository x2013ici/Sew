package com.stfx.cli.sew.owl;

import java.net.URI;
import java.util.Map;

public interface OwlFactoryBase {

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
