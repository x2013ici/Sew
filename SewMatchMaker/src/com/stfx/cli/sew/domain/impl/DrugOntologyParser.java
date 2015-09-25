package com.stfx.cli.sew.domain.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLOntologyCreationIOException;
import org.semanticweb.owlapi.io.UnparsableOntologyException;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.Node;

import com.clarkparsia.owlapiv3.OWL;
import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.utilities.Constants;

/**
 * 
 * @author Mostafijur Rahman
 * @since 18th March, 2015
 */

public class DrugOntologyParser {

	
	
	private static boolean isSubClassOf = false;
	private static boolean isPlugin = false;
	private static boolean subsumeMatch = false;
	/**
	 * 
	 */
	public DrugOntologyParser(){
		
	}
	
	public static String getOntologyIRI(){
		return null;
		
	}
	
	public static String getOntologyURI(){
		return null;
		
	}
	
	/**
	 * 
	 */
	public static volatile DrugOntologyParser drugOntologyParser = null;
	public static DrugOntologyParser createDrugOntologyManagerInstance(){
		if(drugOntologyParser == null){
			synchronized(DrugOntologyParser.class){
				drugOntologyParser = new DrugOntologyParser();
			}
		}
		return drugOntologyParser;
	}
	
	/**
	 * 
	 */
	public static volatile OWLOntologyManager owlOntologyManager = null;
	public static OWLOntologyManager createOwlOntologyManager(){
		if(owlOntologyManager == null){
			synchronized(OWLOntologyManager.class){
				owlOntologyManager = OWLManager.createOWLOntologyManager();
			}
		}
		return owlOntologyManager;
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
						owlOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(DrugOntology.drugOntologyCoreURI));
					} 
					catch (OWLOntologyCreationException e) {
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
	 * 
	 * @return
	 */
	public static PelletReasoner createPelletReasoner(){
		
		PelletReasoner reasoner = null;
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		try{
			if(owlOntologyManager == null){
				owlOntologyManager = createOwlOntologyManager();
				if(owlOntologyManager !=null){
					owlOntology = createOwlOntology();
					reasoner = PelletReasonerFactory.getInstance().createNonBufferingReasoner(owlOntology);
					
					if (reasoner !=null){
						System.out.println("Reasoner Name: " + reasoner.getReasonerName());
						System.out.println("Reasoner Version: " + reasoner.getReasonerVersion());
						
						reasoner.getKB().realize();
						reasoner.getKB().printClassTree();
						reasoner.precomputeInferences();
						
					}
				}
			}
		}
		catch(Exception ex){
			reasoner = null;
		}
		
		return reasoner;
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isConsistentDrugOntology(){
		
		boolean isConsistent = false;
		PelletReasoner reasoner = null;
		try{
			
			reasoner = createPelletReasoner();
			if(reasoner !=null){
				
				isConsistent = reasoner.isConsistent();
			}
		}
		catch(Exception ex){
			
		}
		
		finally{
			reasoner.dispose();
		}
		return isConsistent;
	}
	
	public static java.util.Set<OWLClass> getUnsatisfiableClassList(){
		
		PelletReasoner reasoner = null;
		
		Node<OWLClass> bottomNode = null;
		java.util.Set<OWLClass> unSatisfiableClassList = null;
		
		try{
			
			reasoner = createPelletReasoner();
			if(reasoner !=null){
				bottomNode = reasoner.getUnsatisfiableClasses();
				if(bottomNode !=null){
					unSatisfiableClassList = bottomNode.getEntitiesMinusBottom();
					/*if (!unsatisfiable.isEmpty()) {
						hasUnsatisfiableClasses = true;
					}*/ 				
				}
			}
		}
		catch(Exception ex){
			
		}
		return unSatisfiableClassList;
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
public static java.util.Set<OWLClassExpression> getOwlIndividualType(String instanceName, boolean isFullURL){
		
		OWLOntology owlOntology = null;
		OWLOntologyManager owlOntologyManager = null;
		
		OWLNamedIndividual owlNamedIndividual = null;
		java.util.Set<OWLClassExpression> owlClassExPressionList = null;
		
		try{
			
			owlOntologyManager = createOwlOntologyManager();
			if(owlOntologyManager != null){
				owlOntology = createOwlOntology();
				if(owlOntology !=null){
					
					if(isFullURL){
						owlNamedIndividual = owlOntologyManager.getOWLDataFactory()
								.getOWLNamedIndividual(IRI.create(instanceName));
					}
					else{
						owlNamedIndividual = owlOntologyManager.getOWLDataFactory()
								.getOWLNamedIndividual(IRI.create(DrugOntology.drugOntologyURI + instanceName));
					}
					
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
						OWLClass owlClass1 = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(DrugOntology.drugOntologyURI + firstClassName));
						OWLClass owlClass2 = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(DrugOntology.drugOntologyURI + secondClassName));
						
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
	private static boolean SearchNextLevelChildRecursively(OWLOntology owlOntology, OWLClass parentClass, OWLClass childClass){
		
		//boolean isSubClassOf = false;
		
		java.util.Set<OWLClassExpression> owlChildClassExPressionList = null;
		
		try{
			
			// Breaking Condition
			if(parentClass.equals(OWL.Nothing) || parentClass == null)
				return false;
			
			if(childClass.equals(OWL.Nothing) || childClass == null)
				return false;
			
			if(isPlugin)
				return true;
			
			
			if(parentClass != null && childClass != null){
				
				// Get Subclasses of given parent class
				owlChildClassExPressionList = parentClass.getSubClasses(owlOntology);
				if(owlChildClassExPressionList.size() >0){
					
					for (OWLClassExpression owlClassExpression : owlChildClassExPressionList) {
						OWLClass nextLevelChildClass = owlClassExpression.asOWLClass();
						if (childClass.equals(nextLevelChildClass)){
							isPlugin = true;
							break;
						}
						else{
							isPlugin = SearchNextLevelChildRecursively(owlOntology,nextLevelChildClass, childClass);
							if(isPlugin)
								break;
						}
					}
				}
				//
			}
			
			return isPlugin;
		}
		catch(Exception ex){
			return isPlugin;
		}
	}
	/**
	 * 
	 * @param parentClassName
	 * @param childClassName
	 * @return
	 */
	public static boolean isSubClassOf(String parentClassName, String childClassName){
		
		//boolean isSubClassOf = false;
		
		OWLClass parentClass = null;
		OWLClass givenChildClass = null;
		
		java.util.Set<OWLClassExpression> owlChildClassExPressionList = null;
		
		try{
			if(!parentClassName.isEmpty() && !childClassName.isEmpty()){
				owlOntologyManager = createOwlOntologyManager();
				if(owlOntologyManager != null){
					owlOntology = createOwlOntology();
					if(owlOntology !=null){
						
						parentClass = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(parentClassName));
						givenChildClass = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(childClassName));
						
						// Breaking Condition
						if(parentClass.equals(OWL.Nothing) || parentClass == null)
							return false;
						
						if(givenChildClass.equals(OWL.Nothing) || givenChildClass == null)
							return false;
						
						if(parentClass != null && givenChildClass != null){
							
							// Get Subclasses of given parent class
							owlChildClassExPressionList = parentClass.getSubClasses(owlOntology);
							if(owlChildClassExPressionList.size() >0){
								
								for (OWLClassExpression owlClassExpression : owlChildClassExPressionList) {
									OWLClass childClass = owlClassExpression.asOWLClass();
									if (givenChildClass.equals(childClass)){
										isSubClassOf = true;
										break;
									}
									/*else{
										isSubClassOf = isNextLevelSubClassOf(owlOntology, childClass,givenChildClass);
										if(isSubClassOf)
											break;
									}*/
								}
							}
							//
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
	
	public static boolean isPluginMatch(String parentClassName, String childClassName){
		
		//boolean isSubClassOf = false;
		
		OWLClass parentClass = null;
		OWLClass givenChildClass = null;
				
		java.util.Set<OWLClassExpression> owlChildClassExPressionList = null;
				
		try{
			if(!parentClassName.isEmpty() && !childClassName.isEmpty()){
				owlOntologyManager = createOwlOntologyManager();
				if(owlOntologyManager != null){
					owlOntology = createOwlOntology();
					if(owlOntology !=null){
								
							parentClass = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(parentClassName));
							givenChildClass = owlOntologyManager.getOWLDataFactory().getOWLClass(IRI.create(childClassName));
								
							// Breaking Condition
							if(parentClass.equals(OWL.Nothing) || parentClass == null)
								return false;
								
							if(givenChildClass.equals(OWL.Nothing) || givenChildClass == null)
								return false;
								
							if(parentClass != null && givenChildClass != null){
									
								// Get Subclasses of given parent class
								owlChildClassExPressionList = parentClass.getSubClasses(owlOntology);
								if(owlChildClassExPressionList.size() >0){
										
									for (OWLClassExpression owlClassExpression : owlChildClassExPressionList) {
										OWLClass childClass = owlClassExpression.asOWLClass();
										
										isPlugin = SearchNextLevelChildRecursively(owlOntology, childClass,givenChildClass);
										if(isPlugin)
											break;
										
										/*if (givenChildClass.equals(childClass)){
											isSubClassOf = true;
											break;
										}
										else{
											isSubClassOf = isNextLevelSubClassOf(owlOntology, childClass,givenChildClass);
											if(isSubClassOf)
												break;
										}*/
									}
								}
									//
							}
						}
					}
				}
				return isPlugin;
			}
			catch(Exception ex){
				return isPlugin;
			}
	}
	
	public static HashMap<String, Integer> getRankedOutputConcepts(ArrayList<String> queryOutputConceptList){
		
		Integer hightestRank = 0;
		HashMap<String, Integer> rankedOutputConceptList = new HashMap<String, Integer>(); 
		
		try{
			
			if(queryOutputConceptList.size()>0){
				hightestRank = queryOutputConceptList.size();
				for(String queryOutputConcept : queryOutputConceptList){
					rankedOutputConceptList.put(queryOutputConcept, hightestRank);
					hightestRank = hightestRank - 1;
				}
			}
			
			/*if(rankedOutputConceptList.size() >0){
				for(Map.Entry<String, Integer> entry : rankedOutputConceptList.entrySet()){
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}
			}*/
		}
		catch(Exception ex){
			rankedOutputConceptList = null;
		}
		return rankedOutputConceptList;
	}
	/**
	 * 
	 * @param queryInputList
	 * @param serviceInputList
	 * @return totalInputMatchingScore
	 */
	public static int CalculateTotalInputMatchingScore(ArrayList<String> queryConceptList, ArrayList<String> serviceConceptList){
		
		int totalInputMatchingScore=0;
		boolean isEquivalentClass = false;
		
		boolean isSubClassOf = false;
		boolean isInputParameterAvailableForEachServiceParameter;
		
		try{
			
			if(queryConceptList.size() >0 && serviceConceptList.size()>0){
				
				isInputParameterAvailableForEachServiceParameter = true;
				for(String serviceConcept  : serviceConceptList){
					
					/**
					 * For every input parameter in Advertisement, there is one input parameter in Query.
					 */
					if(isInputParameterAvailableForEachServiceParameter){
						
						for(String  queryConcept: queryConceptList){
							
							// Check Equivalence Relation
							isEquivalentClass =  isEquivalentClass(serviceConcept,queryConcept);
							if(isEquivalentClass){
								totalInputMatchingScore = totalInputMatchingScore + Constants.InputOutputMatchingDegree.Exact;
							}
						
							// Check SubClassOf Relation
							if(!isEquivalentClass){
								isSubClassOf = isSubClassOf(serviceConcept, queryConcept);
								if(isSubClassOf){
									totalInputMatchingScore = totalInputMatchingScore + Constants.InputOutputMatchingDegree.Approximate;
								}
							}
						}
						if(!isEquivalentClass && !isSubClassOf){
							isInputParameterAvailableForEachServiceParameter = false;
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		return totalInputMatchingScore;
	}
	
	/**
	 * 
	 * @param queryOutputList
	 * @param serviceOutputList
	 * @return
	 */
	public static int CalculateTotalOutputMatchingScore(ArrayList<String> queryOutputList, ArrayList<String> serviceOutputList){
		
		
		
		//int totalOutputMatchingScore=0;
		Integer rankedScore = 0;
		Integer rankedOutputMatchingScore=0;
		
		boolean isSubClassOf = false;
		boolean isPluginMatch = false;
		boolean isEquivalentClass = false;
		
		boolean isOutputParamAvailableForEachQueryOutput;
		
		HashMap<String, Integer> rankedOutputList = null;
		
		try{
			if(queryOutputList.size() >0 && serviceOutputList.size()>0){
				
				// Call Ranked Output Concept List
				rankedOutputList = getRankedOutputConcepts(queryOutputList);
				
				/**
				 * For every output parameter in Query, there is one output parameter in Advertisement/Service.
				 */
				isOutputParamAvailableForEachQueryOutput = true;
				for(String queryConcept : queryOutputList){
					
					if(isOutputParamAvailableForEachQueryOutput){
						for(String serviceConcept : serviceOutputList){
							
							// Check Equivalence Relation
							isEquivalentClass =  isEquivalentClass(queryConcept,serviceConcept);
							if(isEquivalentClass){
								
								//totalOutputMatchingScore = totalOutputMatchingScore + Constants.InputOutputMatchingDegree.Exact;
								rankedScore = rankedOutputList.get(queryConcept);
								System.out.println("Rank for: " + queryConcept + " is: " + rankedScore);
								if (rankedScore >0){
									rankedOutputMatchingScore = rankedOutputMatchingScore + (rankedScore * Constants.InputOutputMatchingDegree.Exact);
								}
								else{
									rankedOutputMatchingScore = rankedOutputMatchingScore + Constants.InputOutputMatchingDegree.Exact;
								}
							}
						
							// Do SubClassOf Match
							if(!isEquivalentClass){
								isSubClassOf = isSubClassOf(serviceConcept, queryConcept);
								if(isSubClassOf){
									//totalOutputMatchingScore = totalOutputMatchingScore + Constants.InputOutputMatchingDegree.Approximate;
									//Get ranked score of the concept and multiply it with matching score
									rankedScore = rankedOutputList.get(queryConcept);
									if (rankedScore >0){
										rankedOutputMatchingScore = rankedOutputMatchingScore + (rankedScore * Constants.InputOutputMatchingDegree.Approximate);
									}
									else{
										rankedOutputMatchingScore = rankedOutputMatchingScore + Constants.InputOutputMatchingDegree.Approximate;
									}
									DrugOntologyParser.isSubClassOf = false;
								}
								else{
									// Do Plugin Match
									isPluginMatch = isPluginMatch(serviceConcept, queryConcept);
									if(isPluginMatch){
										rankedScore = rankedOutputList.get(queryConcept);
										if (rankedScore >0){
											rankedOutputMatchingScore = rankedOutputMatchingScore + (rankedScore * Constants.InputOutputMatchingDegree.Plugin);
										}
										else{
											rankedOutputMatchingScore = rankedOutputMatchingScore + Constants.InputOutputMatchingDegree.Plugin;
										}
										DrugOntologyParser.isPlugin = false;
									}
									else{
										// Do Subsumes match
										subsumeMatch = isPluginMatch(queryConcept,serviceConcept);
										if(subsumeMatch){
											rankedScore = rankedOutputList.get(queryConcept);
											if (rankedScore >0){
												rankedOutputMatchingScore = rankedOutputMatchingScore + (rankedScore * Constants.InputOutputMatchingDegree.Subsumes);
											}
											else{
												rankedOutputMatchingScore = rankedOutputMatchingScore + Constants.InputOutputMatchingDegree.Subsumes;
											}
											DrugOntologyParser.subsumeMatch = false;
										}
									}
								}
								
							}
						}
						
						//
						if(!isEquivalentClass && !isSubClassOf && !isPluginMatch){
							isOutputParamAvailableForEachQueryOutput = false;
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		return rankedOutputMatchingScore;
		
	}
	
	
}
