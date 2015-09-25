package com.stfx.cli.sew.owl;

import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import com.stfx.cli.sew.exceptions.FileNotFoundException;
import com.stfx.cli.sew.owls.service.Service;

public interface OwlKnowledgeBase extends OwlModel{
	
	public Set getOntologies();

	public Set getOntologies(boolean all);
	
	public OwlOntology getOntology(URI uri);
	
	public OwlOntology getBaseOntology();
	
	public OwlOntology createOntology();
	
	public OwlOntology createOntology(URI uri);
	
	public OwlOntology createOntology(URI uri, URI fileURI);
	
	public OwlOntology load(OwlOntology ontology);
	
	public OwlOntology load(OwlOntology ontology, boolean withImports);
	
	public void unload(OwlOntology ontology);
	
	public void unload(URI uri); 
	
	public OwlReader getReader();
	
	public void setReader(OwlReader reader);
	
	public OwlOntology read(String uri);
	
	public OwlOntology read(URI uri);	
	
	public OwlOntology read(Reader in, URI baseURI);
	
	public OwlOntology read(InputStream in, URI baseURI);
	
	public boolean getAutoConsistency();
	
	public void setAutoConsistency(boolean auto);
	
	public boolean getAutoTranslate();
	
    public void setAutoTranslate(boolean auto);
    
    public OwlKnowledgeBase getTranslationSource();
    
    public Service readService(String uri);
	public Service readService(URI uri);
	
	public Service readService(Reader in, URI baseURI);
	public Service readService(InputStream in, URI baseURI);
	
	public List readAllServices(String uri);
	public List readAllServices(URI uri);
	
	public List readAllServices(Reader in, URI baseURI);
	public List readAllServices(InputStream in, URI baseURI);
    
	
	
	
}
