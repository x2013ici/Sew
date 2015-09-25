package com.stfx.cli.sew.examples;

import java.net.URI;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.utilities.UriUtils;


public class OwlEntityFactoryImpl{

	
	public static OWLOntologyManager createOntologyManager() {
		// TODO Auto-generated method stub
		OWLOntologyManager manager = null;
		try{
			manager = OWLManager.createOWLOntologyManager();
		}
		catch(Exception ex){
			return null;
		}
		return manager;
	}

	public static OWLOntology createOntology(OWLOntologyManager manager, String url) {
		// TODO Auto-generated method stub
		OWLOntology owlOntology = null;
		try{
			if (manager != null && url.length() >0){
				URI uri = UriUtils.createURI(url);
				owlOntology = manager.loadOntologyFromOntologyDocument(IRI.create(uri));
			}
			else{
				return null;
			}
		}
		catch(OWLOntologyCreationException e){
			return null;
		}
		return owlOntology;
		
	}

	public static OWLDataFactory createOwlDataFactory(OWLOntologyManager manager) {
		// TODO Auto-generated method stub
		OWLDataFactory owlDataFactory = null;
		try{
			if (manager != null){
				owlDataFactory = manager.getOWLDataFactory();
			}
			else{
				return null;
			}
		}
		catch(Exception ex){
			return null;
		}
		return owlDataFactory;
	}

	public static OWLIndividual createIndividual() {
		// TODO Auto-generated method stub
		return null;
	}

	public static OWLIndividual createIndividual(URI uri) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static OWLIndividual createIndividual(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public static OWLClass createClass(OWLDataFactory owlDataFactory, URI uri) {
		// TODO Auto-generated method stub
		OWLClass owlClass = null;
		try{
			if (owlDataFactory !=null){
				owlClass = owlDataFactory.getOWLClass(IRI.create(uri));
			}
			else{
				return null;
			}
		}
		catch(Exception ex){
			return null;
		}
		return owlClass;
	}

	public static OWLObjectProperty createOWLObjectProperty(URI uri) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static OWLObjectProperty createOWLObjectProperty(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public static OWLDataProperty createOWLDataProperty(URI uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public static OWLDataProperty createOWLDataProperty(String url) {
		// TODO Auto-generated method stub
		return null;
	}

}
