package com.stfx.cli.sew.examples;

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

import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;

public class OwlsParser {

	/**
	 * @param args
	 */
	static OWLOntology ontology = null;
	static OWLOntologyManager manager = null;
	static OWLDataFactory owlDataFactory = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String ServiceURL = "http://test.biocomalert.com/docs/services/napa/NapaService.owl";
		//String ServiceURL = "http://test.biocomalert.com/docs/services/serape/SerapeService.owl";
		//String ServiceURL = "http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl";
		String ServiceURL = "http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl";
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
								//System.out.println("Individual Name: "+ owlNamedIndividual.toString());
								
								if(isServiceTypeOf(ontology,owlDataFactory, owlNamedIndividual)){
									
									// Get Object Property Assertions
									//getObjectPropertyAssertions(ontology,owlDataFactory, owlNamedIndividual);
									String profileURL = getProfileURL(ontology,owlDataFactory, owlNamedIndividual);
									//System.out.println("Profile URL: " + profileURL);
									
									// Parse Profile URL
									ParseProfileURL(profileURL);
								}
								
								//Get Data Property Assertions
								//getDataPropertyAssertions(ontology, owlDataFactory, owlNamedIndividual);
								//System.out.println("-----------------------------------------------------");
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

	private static void ParseProfileURL (String url){
		
		boolean isFound = false;
		try{
			
			manager = OwlEntityFactoryImpl.createOntologyManager();
			if(manager != null){
				ontology = OwlEntityFactoryImpl.createOntology(manager, url);
				if (ontology !=null){
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
								
								
								// getTypes java.util.Set<OWLClassExpression>
								// getTypes(OWLOntology ontology)
								//getParameterType(ontology,owlDataFactory, owlNamedIndividual);
								if (isParameterType(ontology, owlDataFactory, owlNamedIndividual, Owls.Profile.Profile)) {
									System.out.println("Individual Name: "+ owlNamedIndividual.toString());
									System.out.println("-----------------------------------------------------");
									// Get Object Property Assertions
									//getObjectPropertyAssertions(ontology,owlDataFactory, owlNamedIndividual);
									//isFound = true;
									
									// get Input List
									System.out.println(Owls.Profile.hasInput);
									OWLObjectPropertyExpression owlObjectPropertyExpression = owlDataFactory.getOWLObjectProperty(IRI.create(Owls.Profile.hasInput));
									if (owlObjectPropertyExpression != null){
											Set<OWLIndividual> owlObjPropertyList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,ontology);
												if (owlObjPropertyList.size() >0){
													for(OWLIndividual objIndividual : owlObjPropertyList){
														System.out.println(objIndividual.toString());
													}
												}
									}
									System.out.println("-----------------------------------------------------");
									// get Output List
									System.out.println(Owls.Profile.hasOutput);
									owlObjectPropertyExpression = owlDataFactory.getOWLObjectProperty(IRI.create(Owls.Profile.hasOutput));
									if (owlObjectPropertyExpression != null){
										Set<OWLIndividual> owlObjPropertyList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,ontology);
												if (owlObjPropertyList.size() >0){
													for(OWLIndividual objIndividual : owlObjPropertyList){
														System.out.println(objIndividual.toString());
													}
												}
									}
								}
								
								//Get Data Property Assertions
								//getDataPropertyAssertions(ontology, owlDataFactory, owlNamedIndividual);
								//System.out.println("-----------------------------------------------------");
								/*if(isFound)
									break;*/
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static String getProfileURL(OWLOntology ontology, OWLDataFactory owlDataFactory, 
			OWLNamedIndividual owlNamedIndividual){
		
		boolean hasProfile = false;
		String profileURL = null;
		java.util.Set<OWLObjectProperty> owlObjectPropertyList = ontology.getObjectPropertiesInSignature(false);
		if(owlObjectPropertyList.size() >0){
			//System.out.println("Total Object Property Number: " + owlObjectPropertyList.size());
			for(OWLObjectProperty owlObjectProperty : owlObjectPropertyList){
				
				IRI iri = IRI.create(owlObjectProperty.getIRI().toString());
				String url = owlObjectProperty.getIRI().toString();
				
				if (UriUtils.relaxedMatch(url, Owls.Service.presents)){
					hasProfile = true;
					//break;
					
					OWLObjectPropertyExpression owlObjectPropertyExpression = owlDataFactory.getOWLObjectProperty(iri);
					Set<OWLIndividual> owlIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression, ontology);
					if (owlIndividualList.size() > 0) {
						for (OWLIndividual owlIndividual : owlIndividualList) {
							
							profileURL = UriUtils.getBaseUrl(UriUtils.getCoreUrl(owlIndividual.toString()));
							break;
							
							//System.out.println("Literal for: " + iri.toString() + " is " + UriUtils.getCoreURI(owlIndividual.toString()));
							//System.out.println("Base Url: " + UriUtils.getBaseURL(UriUtils.getCoreURI(owlIndividual.toString())));
							
							
							//getObjectPropertyAssertions(ontology,owlDataFactory,owlIndividual);
						}
					}
				}
			}
		}
		return profileURL;
		
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

	// Get Owl Data Property
	// getDataPropertiesInSignature: java.util.Set<OWLDataProperty> getDataPropertiesInSignature()
	private static void getDataPropertyAssertions(OWLOntology ontology, OWLDataFactory owlDataFactory, OWLNamedIndividual owlNamedIndividual){
		
		java.util.Set<OWLDataProperty> owlDataPropertyList = ontology.getDataPropertiesInSignature(true);
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
	
	// getTypes java.util.Set<OWLClassExpression>
		// getTypes(OWLOntology ontology)
		private static void getParameterType (OWLOntology ontology, OWLDataFactory owlDataFactory, 
				OWLNamedIndividual owlNamedIndividual){
			
			java.util.Set<OWLClassExpression> owlClassExPressionList = owlNamedIndividual.getTypes(ontology);
			for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
				System.out.println("Parameter Type: "+ owlClassExpression.toString());
			}
		}
		
		private static boolean isParameterType (OWLOntology ontology, OWLDataFactory owlDataFactory, 
				OWLNamedIndividual owlNamedIndividual, String parameterType){
			
			boolean isMatched = false;
			java.util.Set<OWLClassExpression> owlClassExPressionList = owlNamedIndividual.getTypes(ontology);
			for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
				
				if (UriUtils.relaxedMatch(UriUtils.getCoreUrl(owlClassExpression.toString()), parameterType)){
					System.out.println(owlClassExpression.toString());
					isMatched = true;
					break;
				}
				else{
					isMatched = false;
				}
				
				
				//System.out.println("Parameter Type: "+ owlClassExpression.toString());
			}
			return isMatched;
		}
		
		private static boolean isServiceTypeOf (OWLOntology ontology, OWLDataFactory owlDataFactory, 
				OWLNamedIndividual owlNamedIndividual) {
			
			boolean isServiceType = false;
			java.util.Set<OWLClassExpression> owlClassExPressionList = owlNamedIndividual.getTypes(ontology);
			for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
				if (!isServiceType){
					//String url = owlClassExpression.toString().substring(1, owlClassExpression.toString().length()-1);
					String url = UriUtils.getCoreUrl(owlClassExpression.toString());
					if (UriUtils.relaxedMatch(url, Owls.Service.Service)){
						isServiceType = true;
						break;
					}
				}
				//System.out.println("Parameter Type: "+ owlClassExpression.toString());
			}
			return isServiceType;
		}
	
}


