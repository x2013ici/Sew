package com.stfx.cli.sew.domain.impl;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.domain.Concepts;


public class ConceptsParser {
	
	public ConceptsParser(){
		
	}
	
	/**
	 * 
	 */
	public static volatile ConceptsParser conceptsOntologyParser = null;
	public static ConceptsParser createDrugOntologyManagerInstance(){
		if(conceptsOntologyParser == null){
			synchronized(DrugOntologyParser.class){
				conceptsOntologyParser = new ConceptsParser();
			}
		}
		return conceptsOntologyParser;
	}
	
	/**
	 * 
	 */
	public static volatile OWLOntologyManager conceptsOntologyManager = null;
	public static OWLOntologyManager createOwlOntologyManager(){
		if(conceptsOntologyManager == null){
			synchronized(OWLOntologyManager.class){
				conceptsOntologyManager = OWLManager.createOWLOntologyManager();
			}
		}
		return conceptsOntologyManager;
	}
	
	/**
	 * 
	 */
	public static volatile OWLOntology owlOntology = null; 
	public static OWLOntology createOwlOntology(){
		
		OWLOntologyManager owlOntologyManager = null;
		if(owlOntology == null){
			
			owlOntologyManager = createOwlOntologyManager();
			synchronized(OWLOntology.class){
				if (owlOntologyManager !=null){
					try {
						owlOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(Concepts.conceptsOntologyCoreURI));
					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return owlOntology;
	}
	
	/**
	 * 
	 */
	public static volatile OWLDataFactory owlDataFactory = null;
	public static OWLDataFactory createOwlDataFactory(){
		
		OWLOntologyManager owlOntologyManager = null;
		if(owlDataFactory == null){
			owlOntologyManager = createOwlOntologyManager();
			synchronized(OWLDataFactory.class){
				owlDataFactory = owlOntologyManager.getOWLDataFactory();
			}
		}
		return owlDataFactory;
	}
	
	/**
	 * Get OWLClass List
	 * @return
	 */
	public static java.util.Set<OWLClass> getOwlClassList(){
		
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		java.util.Set<OWLClass> owlClassList = null;
		
		try{
			
			owlOntologyManager = createOwlOntologyManager();
			if(owlOntologyManager != null){
				owlOntology = createOwlOntology();
				if(owlOntology !=null){
					owlClassList = owlOntology.getClassesInSignature();
				}
			}
			return owlClassList;
		}
		catch(Exception ex){
			return owlClassList;
		}
	}
	
	/**
	 * Get OWLNamedIndividual List
	 * @return
	 */
	public static java.util.Set<OWLNamedIndividual> getNamedIndividualList(){
		
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
		
		try{
			owlOntologyManager = createOwlOntologyManager();
			if(owlOntologyManager != null){
				owlOntology = createOwlOntology();
				if(owlOntology !=null){
					owlNamedIndividualList = owlOntology.getIndividualsInSignature();
				}
			}
			return owlNamedIndividualList;
		}
		catch(Exception ex){
			return owlNamedIndividualList;
		}
		
	}
	
	/**
	 * 
	 * @param individualName
	 * @return
	 */
	public static java.util.Set<OWLClassExpression> getOwlIndividualType(String individualName){
		
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		java.util.Set<OWLClassExpression> owlClassExPressionList = null;
		try{
			
			owlOntologyManager = createOwlOntologyManager();
			if(owlOntologyManager != null){
				owlOntology = createOwlOntology();
				if(owlOntology !=null){
					OWLNamedIndividual owlNamedIndividual = owlOntologyManager.getOWLDataFactory()
							.getOWLNamedIndividual(IRI.create(Concepts.conceptsOntologyURI + individualName));
					
					if(owlNamedIndividual!=null){
						//System.out.println(owlNamedIndividual.toString());
						owlClassExPressionList = owlNamedIndividual.getTypes(owlOntology);
					}
				}
			}
			return owlClassExPressionList;
		}
		catch(Exception ex){
			return owlClassExPressionList;
		}
	}
	
	/**
	 * 
	 * @param firstClassName
	 * @param secondClassName
	 * @return
	 */
	public static boolean isEquivalentClass(String firstClassName, String secondClassName){
		
		boolean isEquivalentClass  = false;
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		
		try{
			
			if(!firstClassName.isEmpty() && !secondClassName.isEmpty()){
				owlOntologyManager = createOwlOntologyManager();
				if(owlOntologyManager != null){
					owlOntology = createOwlOntology();
					if(owlOntology !=null){
						OWLClass owlClass1 = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(Concepts.conceptsOntologyURI + firstClassName));
						OWLClass owlClass2 = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(Concepts.conceptsOntologyURI + secondClassName));
						
						if(owlClass1 != null && owlClass2 != null){
							isEquivalentClass = owlClass1.equals(owlClass2);
						}
					}
				}
			}
			return isEquivalentClass;
		}
		catch(Exception ex){
			return isEquivalentClass;
		}
	}
	
	/**
	 * 
	 * @param parentClassName
	 * @param childClassName
	 * @return
	 */
	public static boolean isSubClassOf(String parentClassName, String childClassName){
		
		boolean isSubClassOf = false;
		java.util.Set<OWLClassExpression> owlClassExPressionList = null;
		
		try{
			if(!parentClassName.isEmpty() && !childClassName.isEmpty()){
				conceptsOntologyManager = createOwlOntologyManager();
				if(conceptsOntologyManager != null){
					owlOntology = createOwlOntology();
					if(owlOntology !=null){
						OWLClass parentClass = conceptsOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(Concepts.conceptsOntologyURI + parentClassName));
						
						if(parentClass != null){
							owlClassExPressionList = parentClass.getSubClasses(owlOntology);
							if(owlClassExPressionList.size() >0){
								OWLClass givenChildClass = conceptsOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(Concepts.conceptsOntologyURI + childClassName));
								for (OWLClassExpression owlClassExpression : owlClassExPressionList) {
									OWLClass childClass = owlClassExpression.asOWLClass();
									if (givenChildClass.equals(childClass)){
										isSubClassOf = true;
										break;
									}
								}
							}
						}
					}
				}
			}
			return isSubClassOf;
		}
		catch(Exception ex){
			return isSubClassOf;
		}
	}

}
