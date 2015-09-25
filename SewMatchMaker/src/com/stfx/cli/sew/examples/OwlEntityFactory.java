package com.stfx.cli.sew.examples;

import java.net.URI;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public interface OwlEntityFactory {
	
	public OWLOntologyManager createOntologyManager();
	
	public OWLOntology createOntology(OWLOntologyManager manager, String url);
	
	public OWLDataFactory createOwlDataFactory(OWLOntologyManager manager);
	
	public OWLIndividual createIndividual();
	
	public OWLIndividual createIndividual (URI uri);
	
	public OWLIndividual createIndividual (String url);
	
	public OWLClass createClass(OWLDataFactory owlDataFactory, URI uri);
	
	public OWLObjectProperty  createOWLObjectProperty (URI uri);
	
	public OWLObjectProperty createOWLObjectProperty(String url);
	
	public OWLDataProperty createOWLDataProperty(URI uri);
	
	public OWLDataProperty createOWLDataProperty (String url);
	

}
