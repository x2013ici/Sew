package com.stfx.cli.sew.owls.parsers;

import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class GroundingParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OWLOntology ontology = null;
		try
		{
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			ontology = manager.loadOntologyFromOntologyDocument(IRI.create("http://test.biocomalert.com/docs/services/owl-s/1.2/Grounding.owl"));
			
			if(ontology != null){
				OWLDataFactory owlDataFactory = manager.getOWLDataFactory();
				
				//Get OWLClass
				java.util.Set<OWLClass> owlClassList = ontology.getClassesInSignature();
				if(owlClassList.size() >0){
					System.out.println("Total OWL Class Number: " + owlClassList.size());
					System.out.println("-----------------------------------------------------");
					for(OWLClass owlClass : owlClassList){
						IRI hasIRI = IRI.create(owlClass.getIRI().toString());
						if(hasIRI != null){
							
							if(owlDataFactory.getOWLClass(hasIRI) != null){
								System.out.println(owlDataFactory.getOWLClass(hasIRI).toString());
							}
						}
					}
					System.out.println("-----------------------------------------------------");
				}
				
				// getIndividualsInSignature: java.util.Set<OWLNamedIndividual>
				// getIndividualsInSignature()
				java.util.Set<OWLNamedIndividual> owlNamedIndividualList = ontology.getIndividualsInSignature();
				if (owlNamedIndividualList.size() > 0) 
				{
					System.out.println("Total Owl Named Individuals: "+ owlNamedIndividualList.size());
					System.out.println("-----------------------------------------------------");
					for (OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList) {
						System.out.println("Individual Name: "+ owlNamedIndividual.toString());
						
						// getTypes java.util.Set<OWLClassExpression>
						// getTypes(OWLOntology ontology)
						getParameterType(ontology,owlDataFactory, owlNamedIndividual);
						//System.out.println("-----------------------------------------------------\n");
						
						// Get Object Property Assertions
						getObjectPropertyAssertions(ontology,owlDataFactory, owlNamedIndividual);
						//System.out.println("-----------------------------------------------------\n");
						
						//Get Data Property Assertions
						getDataPropertyAssertions(ontology, owlDataFactory, owlNamedIndividual);
						System.out.println("-----------------------------------------------------");
					}
				}
			}
		}
		catch(OWLOntologyCreationException e){
			e.printStackTrace();
		}
	}

	// getTypes java.util.Set<OWLClassExpression>
	// getTypes(OWLOntology ontology)
	private static void getParameterType (OWLOntology ontology, OWLDataFactory owlDataFactory, 
			OWLNamedIndividual owlNamedIndividual){
		
		java.util.Set<OWLClassExpression> owlClassExPressionList = owlNamedIndividual.getTypes(ontology);
		for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
			System.out.println("Parameter Type: "+ owlClassExpression.toString());
		}
	}
	
	// Get OWLDataObject Property
	// getObjectPropertiesInSignature: java.util.Set<OWLObjectProperty> getObjectPropertiesInSignature()
	private static void getObjectPropertyAssertions(OWLOntology ontology, OWLDataFactory owlDataFactory, 
			OWLNamedIndividual owlNamedIndividual){
		
		java.util.Set<OWLObjectProperty> owlObjectPropertyList = ontology.getObjectPropertiesInSignature(false);
		if(owlObjectPropertyList.size() >0){
			//System.out.println("Total Object Property Number: " + owlObjectPropertyList.size());
			for(OWLObjectProperty owlObjectProperty : owlObjectPropertyList){
				
				IRI iri = IRI.create(owlObjectProperty.getIRI().toString());
				OWLObjectPropertyExpression owlObjectPropertyExpression = owlDataFactory.getOWLObjectProperty(iri);
				Set<OWLIndividual> owlIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression, ontology);
				if (owlIndividualList.size() > 0) {
					for (OWLIndividual owlIndividual : owlIndividualList) {
						System.out.println("Literal for: " + iri.toString() + " is " + owlIndividual.toString());
					}
				}
			}
			//System.out.println("-----------------------------------------------------\n");
		}
		else{
			System.out.println("No Object Property is available in this ontology");
		}
		
	}

	// Get Owl Data Property
	// getDataPropertiesInSignature: java.util.Set<OWLDataProperty> getDataPropertiesInSignature()
	private static void getDataPropertyAssertions(OWLOntology ontology, OWLDataFactory owlDataFactory, OWLNamedIndividual owlNamedIndividual){
		
		java.util.Set<OWLDataProperty> owlDataPropertyList = ontology.getDataPropertiesInSignature();
		if(owlDataPropertyList.size() >0){
			//System.out.println("Total Data Property Number: " + owlDataPropertyList.size());
			for(OWLDataProperty owlDataProperty : owlDataPropertyList){
				
				IRI iri = IRI.create(owlDataProperty.getIRI().toString());
				OWLDataPropertyExpression owlDataPropertyExpression = owlDataFactory.getOWLDataProperty(iri);
				java.util.Set<OWLLiteral> owlLiteralList = owlNamedIndividual.getDataPropertyValues(owlDataPropertyExpression, ontology);
				if (owlLiteralList.size() > 0) {
					for (OWLLiteral owldataLiteral : owlLiteralList) {
						System.out.println("Literal for: " + iri.toString()+ " is " + owldataLiteral.toString());
					}
				}
				//System.out.println (owlDataProperty.toString());
			}
			//System.out.println("-----------------------------------------------------\n");
		}
		else{
			System.out.println("No Owl Data Property is available in this ontology");
		}
		
	}

}
