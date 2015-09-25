package com.stfx.cli.sew.domain.impl;

import java.util.Set;

import org.semanticweb.owlapi.model.IRI;
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
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.examples.OwlEntityFactoryImpl;
import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;

public class QosNapaProfileParser {

	/**
	 * @param args
	 */
	static OWLOntology ontology = null;
	static OWLOntologyManager manager = null;
	static OWLDataFactory owlDataFactory = null;
	
	public static void main(String[] args) {
		//String ServiceURL = "http://test.biocomalert.com/docs/services/napa/NapaService.owl";
				//String ServiceURL = "http://test.biocomalert.com/docs/services/serape/SerapeService.owl";
				//String ServiceURL = "http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl";
				String ServiceURL = "http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl";
				//String ServiceURL = "http://test.biocomalert.com/docs/services/gmax/GmaxService.owl";
				
				
				try
				{
					//manager = OWLManager.createOWLOntologyManager();
					manager = OwlEntityFactoryImpl.createOntologyManager();
					if (manager != null){
						//ontology = manager.loadOntologyFromOntologyDocument(IRI.create(napaServiceURL));
						ontology = OwlEntityFactoryImpl.createOntology(manager, ServiceURL);
						if(ontology != null){
							
							//owlDataFactory = manager.getOWLDataFactory();
							owlDataFactory = OwlEntityFactoryImpl.createOwlDataFactory(manager);
							if (owlDataFactory != null){
								// getIndividualsInSignature: java.util.Set<OWLNamedIndividual>
								// getIndividualsInSignature()
								
								
								java.util.Set<OWLNamedIndividual> owlNamedIndividualList = ontology.getIndividualsInSignature();
								if (owlNamedIndividualList.size() > 0) 
								{
									System.out.println("Total Owl Named Individuals: "+ owlNamedIndividualList.size());
									System.out.println("-----------------------------------------------------");
									for (OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList) {
										
										getDataPropertyAssertions(ontology,owlDataFactory,owlNamedIndividual);
									}
								}
							}
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					manager.clearIRIMappers();
				}
			}

			
			

			// Get Owl Data Property
			// getDataPropertiesInSignature: java.util.Set<OWLDataProperty> getDataPropertiesInSignature()
			private static void getDataPropertyAssertions(OWLOntology ontology, OWLDataFactory owlDataFactory, OWLNamedIndividual owlNamedIndividual){
				
				java.util.Set<OWLDataProperty> owlDataPropertyList = ontology.getDataPropertiesInSignature(true);
				if(owlDataPropertyList.size() >0){
					//System.out.println("Total Data Property Number: " + owlDataPropertyList.size());
					for(OWLDataProperty owlDataProperty : owlDataPropertyList){
						
						IRI iri = IRI.create(owlDataProperty.getIRI().toString());
						System.out.println(iri.toString());
						
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
			
			// Get OWLDataObject Property
						// getObjectPropertiesInSignature: java.util.Set<OWLObjectProperty> getObjectPropertiesInSignature()
						private static void getObjectPropertyAssertions(OWLOntology ontology, OWLDataFactory owlDataFactory, 
								OWLNamedIndividual owlNamedIndividual){
							
							java.util.Set<OWLObjectProperty> owlObjectPropertyList = ontology.getObjectPropertiesInSignature(false);
							if(owlObjectPropertyList.size() >0){
								//System.out.println("Total Object Property Number: " + owlObjectPropertyList.size());
								for(OWLObjectProperty owlObjectProperty : owlObjectPropertyList){
									
									IRI iri = IRI.create(owlObjectProperty.getIRI().toString());
									/*if (iri.toString().contains("presents")){
										
									}*/
									
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

}
