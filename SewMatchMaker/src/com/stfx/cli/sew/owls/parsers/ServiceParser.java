package com.stfx.cli.sew.owls.parsers;

import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;


public class ServiceParser {

	/**
	 * 
	 */
	public ServiceParser(){
		
	}
	
	/**
	 * 
	 */
	public static volatile ServiceParser serviceParser = null;
	public static ServiceParser createServiceParser(){
		/*if(serviceParser == null){
			synchronized(ServiceParser.class){
				serviceParser = new ServiceParser();
			}
		}*/
		synchronized(ServiceParser.class){
			serviceParser = new ServiceParser();
		}
		return serviceParser;
	}
	
	/**
	 * 
	 */
	private static volatile OWLOntologyManager owlsServiceOntologyManager = null;
	public static OWLOntologyManager createOwlsOntologyManager(){
		/*if(owlsServiceOntologyManager == null){
			synchronized(OWLOntologyManager.class){
				owlsServiceOntologyManager = OWLManager.createOWLOntologyManager();
			}
		}*/
		
		synchronized(OWLOntologyManager.class){
			owlsServiceOntologyManager = OWLManager.createOWLOntologyManager();
		}
		return owlsServiceOntologyManager;
	}
	
	/**
	 * 
	 */
	private static volatile OWLOntology owlsServiceOntology = null; 
	public static OWLOntology createOwlsOntology(String Url){
		
		OWLOntologyManager owlOntologyManager = null;
		/*if(owlsServiceOntology == null){
			
			owlOntologyManager = createOwlsOntologyManager();
			synchronized(OWLOntology.class){
				if (owlOntologyManager !=null){
					try {
						owlsServiceOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(Url));
					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}*/
		owlOntologyManager = createOwlsOntologyManager();
		synchronized(OWLOntology.class){
			if (owlOntologyManager !=null){
				try {
					owlsServiceOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(Url));
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return owlsServiceOntology;
	}
	
	/**
	 * 
	 */
	private static volatile OWLDataFactory owlsServiceDataFactory = null;
	public static OWLDataFactory createOwlsDataFactory(){
		
		OWLOntologyManager owlsOntologyManager = null;
		/*if(owlsServiceDataFactory == null){
			owlsOntologyManager = createOwlsOntologyManager();
			synchronized(OWLDataFactory.class){
				owlsServiceDataFactory = owlsOntologyManager.getOWLDataFactory();
			}
		}*/
		
		owlsOntologyManager = createOwlsOntologyManager();
		synchronized(OWLDataFactory.class){
			owlsServiceDataFactory = owlsOntologyManager.getOWLDataFactory();
		}
		return owlsServiceDataFactory;
	}
	
	
	public static OWLNamedIndividual getOwlsServiceInstance(String url){
		
		boolean hasServiceInstance = false;
		OWLOntology owlsOntology = null;
		OWLOntologyManager owlsOntologyManager = null;
		OWLNamedIndividual owlsServiecInstance = null;
		//OWLDataFactory owlsDataFactory = null;
		
		try{
			
			owlsOntologyManager = createOwlsOntologyManager();
			if(owlsOntologyManager != null){
				owlsOntology = createOwlsOntology(url);
				//owlsDataFactory = owlsOntologyManager.getOWLDataFactory();
				
				if(owlsOntology !=null){
					java.util.Set<OWLNamedIndividual> owlNamedIndividualList = owlsOntology.getIndividualsInSignature();
					if(owlNamedIndividualList.size() >0){
						//System.out.println(Owls.Service.Service);
						for(OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList){
							//System.out.println(owlNamedIndividual.toString());
							hasServiceInstance = IsParameterType(owlNamedIndividual,url,Owls.Service.Service);
							if(hasServiceInstance){
								owlsServiecInstance = owlNamedIndividual;
								break;
							}
						}
					}
					
				}
			}
		}
		catch(Exception ex){
			return null;
		}
		
		return owlsServiecInstance;
	}
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static boolean hasOwlsServiceInstance(String url){
		
		boolean hasServiceInstance = false; 
		OWLOntology owlsOntology = null;
		OWLOntologyManager owlsOntologyManager = null;
		//OWLDataFactory owlsDataFactory = null;
		
		try{
			
			owlsOntologyManager = createOwlsOntologyManager();
			if(owlsOntologyManager != null){
				owlsOntology = createOwlsOntology(url);
				//owlsDataFactory = owlsOntologyManager.getOWLDataFactory();
				
				if(owlsOntology !=null){
					java.util.Set<OWLNamedIndividual> owlNamedIndividualList = owlsOntology.getIndividualsInSignature();
					if(owlNamedIndividualList.size() >0){
						//System.out.println(Owls.Service.Service);
						for(OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList){
							//System.out.println(owlNamedIndividual.toString());
							hasServiceInstance = IsParameterType(owlNamedIndividual,url,Owls.Service.Service);
							if(hasServiceInstance){
								break;
							}
						}
					}
					
				}
			}
		}
		catch(Exception ex){
			hasServiceInstance = false;
		}
		
		return hasServiceInstance;
	}
	
	public static boolean hasQosProfileInstance(String serviceUrl){
		
		boolean hasQosProfileInstance = false;
		OWLOntology owlsOntology = null;
		try{
			
			if(!serviceUrl.isEmpty()){
				owlsOntology = createOwlsOntology(serviceUrl);
				if(owlsOntology !=null){
					OWLObjectProperty owlObjectProperty = owlsOntology.getOWLOntologyManager()
								.getOWLDataFactory().getOWLObjectProperty(IRI.create(Owls.Service.provides));
					
					if(owlObjectProperty !=null)
						hasQosProfileInstance = true;
				}
			}
			
		}
		catch(Exception ex){
			return hasQosProfileInstance;
		}
		
		return hasQosProfileInstance;
	}
	/**
	 * 
	 * @return
	 */
	public static boolean hasOwlsProfileInstance(String serviceUrl){
		
		boolean hasOwlsProfileInstance = false;
		OWLOntology owlsOntology = null;
		try{
			
			if(!serviceUrl.isEmpty()){
				owlsOntology = createOwlsOntology(serviceUrl);
				if (owlsOntology != null){
					
					java.util.Set<OWLObjectProperty> OwlObjectPropertyList =  owlsOntology.getObjectPropertiesInSignature();
					if (OwlObjectPropertyList.size() >0){
						for(OWLObjectProperty owlObjectProperty: OwlObjectPropertyList){
							//System.out.println(owlObjectProperty.toString());
							
							String url = owlObjectProperty.getIRI().toString();
							if (UriUtils.relaxedMatch(url, Owls.Service.presents)){
								hasOwlsProfileInstance = true;
								break;
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			hasOwlsProfileInstance = false;
		}
		return hasOwlsProfileInstance;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static OWLNamedIndividual getOwlsProfileInstance(){
		return null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean hasOwlsProcessInstance(){
		return false;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean hasOwlsGroundingInstance(){
		return false;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isTypeOf(OWLClass owlClass){
		return false;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isSameIndividual(){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isDifferentIndividual(){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.util.Set<OWLClass> getTypesList(){
		return null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.util.Set<OWLObjectProperty> getObjectPropertyAssertionList(){
		return null;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static java.util.Set<OWLDataProperty> getDataPropertyAssertionList(){
		return null;
		
	}
	
	/**
	 * 
	 * @param owlNamedIndividual
	 * @param serviceUrl
	 * @param parameterTypeUrl
	 * @return
	 */
	public static boolean IsParameterType(OWLNamedIndividual owlNamedIndividual, String serviceUrl, String parameterTypeUrl){
		
		boolean hasParameterType = false;
		OWLOntology owlsOntology = null;
		try{
			
			if (!serviceUrl.isEmpty()){
				owlsOntology = createOwlsOntology(serviceUrl);
				if (owlsOntology != null){
					
					java.util.Set<OWLClassExpression> owlClassExPressionList = owlNamedIndividual.getTypes(owlsOntology);
					if (owlClassExPressionList.size() >0){
						
						for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
							//System.out.println(owlClassExpression.toString());
							if (UriUtils.relaxedMatch(UriUtils.getCoreUrl(owlClassExpression.toString()), parameterTypeUrl)){
								//System.out.println(owlClassExpression.toString());
								hasParameterType = true;
								break;
							}
							else{
								hasParameterType = false;
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			return hasParameterType;
		}
		return hasParameterType;
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		OWLOntology ontology = null;
		try
		{
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			ontology = manager.loadOntologyFromOntologyDocument(IRI.create("http://test.biocomalert.com/docs/services/napa/NapaService.owl"));
			
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
						//getObjectPropertyAssertions(ontology,owlDataFactory, owlNamedIndividual);
						//System.out.println("-----------------------------------------------------\n");
						
						//Get Data Property Assertions
						//getDataPropertyAssertions(ontology, owlDataFactory, owlNamedIndividual);
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
			
			OWLClass owlClass = owlClassExpression.asOWLClass();
			owlClass = (OWLClass) Owls1_2.Service.Service;
			java.util.Set<OWLIndividual> indList = owlClass.getIndividuals(ontology);
			if(indList.size() >0){
				for(OWLIndividual owlInd : indList){
					System.out.println(owlInd.toString());
				}
			}
			System.out.println("Parameter Type: "+ owlClass.toString());
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
*/
}
