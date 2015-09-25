package com.stfx.cli.sew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import com.stfx.cli.sew.datamodels.OwlsService;
import com.stfx.cli.sew.datamodels.OwlsServiceList;
import com.stfx.cli.sew.domain.Concepts;
import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.domain.impl.DrugOntologyParser;
import com.stfx.cli.sew.owls.parsers.ProfileParser;
import com.stfx.cli.sew.owls.parsers.QosProfileParser;
import com.stfx.cli.sew.owls.parsers.ServiceParser;
import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.repository.ServiceRepositoryManager;
import com.stfx.cli.sew.utilities.UriUtils;

public class ConceptPreferences {

	// Napa Service
	final static String serviceUrl = "http://test.biocomalert.com/docs/services/napa/NapaService.owl";
	final static String profileUrl = "http://test.biocomalert.com/docs/services/napa/NapaProfile.owl"; 
	final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl";
		
		// Serape Service
		/*final static String serviceUrl = "http://test.biocomalert.com/docs/services/serape/SerapeService.owl";
		final static String profileUrl = "http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl"; 
		final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/serape/SerapeQosProfile.owl";*/
		
		// Ambrox Service
		/*final static String serviceUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxService.owl";
		final static String profileUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl"; 
		final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl";*/
		
		// Gmax Service
		/*final static String serviceUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxService.owl";
		final static String profileUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl"; 
		final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl";*/
		
		/*final static String serviceUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl";
		final static String profileUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl"; 
		final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl";*/
		
		static String separator = ":";
		static String inputString = "Critical:Fever";
		
		static String outputString = "Serape:Napa:Etorix:Killbec";
		static String qosInputString = "ResponseTime:ExecutionPrice:Reliability";
	
	public static void main(String[] args) {
		ArrayList<String> queryInputList = new ArrayList<String>();
		ArrayList<String> queryOutputList = new ArrayList<String>();
		
		//ArrayList<String> queryQoSInputList = new ArrayList<String>();
		Map<String, String> queryQosInputList = new HashMap<String, String>();
		
		// Inputs
		if(!inputString.isEmpty()){
			queryInputList = UriUtils.getParsedList(inputString, separator);
			if(queryInputList.size() >0){
				System.out.println("Query Input Concepts:");
				for (String inputConcept : queryInputList){
					System.out.println(inputConcept);
				}
				System.out.println("-------------------------------------------");
			}
		}
		
		// Outputs
		if(!outputString.isEmpty()){
			queryOutputList = UriUtils.getParsedList(outputString, separator);
			if(queryOutputList.size()>0){
				System.out.println("Query Output Concepts:");
				for (String ouputConcept : queryOutputList){
					System.out.println(ouputConcept);
				}
				System.out.println("-------------------------------------------");
			}
			
			//DrugOntologyParser.getRankedOutputConcepts(queryOutputList);
		}
		 
		// QosInputs
		if(!qosInputString.isEmpty()){
			queryQosInputList = QosProfileParser.getParsedQosList(qosInputString, separator);
			if(queryQosInputList.size()>0){
				System.out.println("Query Qos Input List:");
				for(Map.Entry<String, String> entry : queryQosInputList.entrySet()){
					System.out.println(entry.getKey() + ": " + DrugOntology.drugOntologyURI + entry.getValue());
				}
				System.out.println("-----------------------------------------");
			}
		}
		
		
		
		// Populate Owls Service List. Enable this block later to check full functionality
		/*OwlsServiceList owlsServiceListResponse = PopulateOwlsServiceList();
		if (owlsServiceListResponse !=null){
			System.out.println("Owls Service Repository List loaded Successfully");
		}
		else{
			System.out.println("Failed to load Owls Service Repository");
		}*/
		
		// Call Matchmaking Algorithm
		if(queryInputList.size() >0 && queryOutputList.size() >0 && queryQosInputList.size()>0){
			CallSewMatchMakingAlgorithm(queryInputList,queryQosInputList,queryOutputList);
		}
		else{
			System.out.println("Invalid Input/QosInput/Output List for Sew Semantic Matchmaking Algorithm");
		}
	}
	
	
	
	/**
	 * Step by Step Algorithm Implementation
	 * Get list of Owl-s services as input
	 * Go over each of the services and do the followings:
	 * * Take x_Service.owl (NapaService.owl) as input
	 * * Fetch the list of Named Individuals. Check each of them to see any of these individuals have type Service
	 * * If result is yes, check presents Object Property of the service file
	 * * If available, open x_Profile (NapaProfile.owl) file to do the followings
	 * * * Get the list of named Individuals, check any of them have Profile class type
	 * * * If yes, get the list of Individuals have hasInput and hasOutput Object Properties 
	 */
	private static void CallSewMatchMakingAlgorithm(ArrayList<String> queryInputList, Map<String,String> queryQoSInputList, ArrayList<String> queryOutputList){
		
		boolean hasOwlsServiceInstance = false;
		boolean hasOwlsProfileInstance = false;
		
		boolean isProfileType = false;
		
		int totalInputScore=0;
		int totalOutputScore=0;
		
		int totalQoSScore=0;
		int totalMatchingScore=0;
		
		String concept = null;
		String conceptUrl = null;
		OWLOntology owlsProfileOntology = null;
		java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
		
		java.util.Set<OWLIndividual> owlInputIndividualList = null;
		java.util.Set<OWLIndividual> owlOutputIndividualList = null;
		
		// Service Input/Output List
		ArrayList<String> serviceInputList = new ArrayList<String>();
		//ArrayList<String> serviceQoSInputList = new ArrayList<String>();
		ArrayList<String> serviceOutputList = new ArrayList<String>();
		Map<String,String> serviceQosInputList = new HashMap<String, String>();

		try{
			
			hasOwlsServiceInstance = ServiceParser.hasOwlsServiceInstance(serviceUrl);
			if(hasOwlsServiceInstance){
				
				//System.out.println("Provided Owl-s service has service Instance!\n");
				
				// Parse Input/Output Concept List
				hasOwlsProfileInstance = ServiceParser.hasOwlsProfileInstance(serviceUrl);
				if (hasOwlsProfileInstance){
					//System.out.println("Provided Owl-s service has profile Instance!\n");
					// Fetch x_Profile (i.e. NapaProfile.owl service)
					owlsProfileOntology = ProfileParser.createOwlsOntology(profileUrl);
					
					if(owlsProfileOntology != null){
						owlNamedIndividualList = ProfileParser.getOwlNamedIndividualList(profileUrl);
						if(owlNamedIndividualList.size() >0){
							for (OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList) {
								isProfileType = ProfileParser.IsParameterType(owlNamedIndividual, profileUrl, Owls.Profile.Profile);
								if(isProfileType){
									
									// Get Input List
									owlInputIndividualList = ProfileParser.getServiceInputList(owlNamedIndividual,profileUrl);
									if (owlInputIndividualList.size() >0){
										for(OWLIndividual owlInputIndividual : owlInputIndividualList){
											concept = UriUtils.getConcept(UriUtils.getCoreUrl(owlInputIndividual.toString()));
											
											if(!concept.isEmpty()){
												
												conceptUrl = DrugOntology.drugOntologyURI + concept;
												//System.out.println(conceptUrl);
												serviceInputList.add(conceptUrl);
												//System.out.println("Owl-s Input: " + conceptUrl);
											}
											
										}
										//Print Service Input List
										if(serviceInputList.size() >0){
											System.out.println("Service Input Concepts:");
											for (String inputConcept : serviceInputList){
												System.out.println(inputConcept);
											}
											System.out.println("-------------------------------------------");
										}
										
									}
									
									// Get Output List
									//System.out.println("--------------------------------------------------------------------");
									owlOutputIndividualList = ProfileParser.getSerivceOutputList(owlNamedIndividual,profileUrl);
									if (owlOutputIndividualList.size() >0){
										for(OWLIndividual owlOutputIndividual : owlOutputIndividualList){
											
											//serviceOutputList.add(UriUtils.getCoreUrl(owlOutputIndividual.toString()));
											concept = UriUtils.getConcept(UriUtils.getCoreUrl(owlOutputIndividual.toString()));
											
											if(!concept.isEmpty()){
												conceptUrl = DrugOntology.drugOntologyURI + concept;
												//System.out.println(conceptUrl);
												serviceOutputList.add(conceptUrl);
												//System.out.println("Owl-s Output: " + conceptUrl);
											}
											//System.out.println("Owl-s Output: " + owlOutputIndividual.toString());
										}
										//Print Service Input List
										if(serviceOutputList.size() >0){
											System.out.println("Service Output Concepts:");
											for (String inputConcept : serviceOutputList){
												System.out.println(inputConcept);
											}
											System.out.println("-------------------------------------------");
										}
									}
								//Exit from current loop
								break;
								}
							}
						}
					}
				}
				else{
					System.out.println("Provided service does have any Profile Instance");
				}
				
				/**
				 * Parse Qos Property List (ExecutionPrice, ResponseTime and Reliability)
				 * Check if it has Qos Profile Instance first
				 */
				serviceQosInputList = getQosPropertyList(serviceUrl, qosProfileUrl);
				if(serviceQosInputList.size()>0){
					System.out.println("Service Qos Input List:");
					for(Map.Entry<String, String> entry : serviceQosInputList.entrySet()){
						System.out.println(entry.getKey() + ": " + DrugOntology.drugOntologyURI + entry.getValue());
					}
					System.out.println("-------------------------------------------------");
				}
			}
			else{
				System.out.println("Provided service does have any Service Instance");
			}
			
			/**
			 * Use Consumer Agent's Input and output list
			 * Use parsed Input and Output list from Owl-s service 
			 * Pass both sets of inputs and outputs to DrugOntologyParser to check Subsumption relationship
			 */
			
			// Call Input Matching Function
			totalInputScore = DrugOntologyParser.CalculateTotalInputMatchingScore(queryInputList, serviceInputList);
			System.out.println("Total Input Score: " + totalInputScore);
			
			// Call Output Matching Function
			totalOutputScore =  DrugOntologyParser.CalculateTotalOutputMatchingScore(queryOutputList, serviceOutputList);
			System.out.println("Total Output Score: " + totalOutputScore);
			
			// Call QoS Matching Function
			totalQoSScore = QosProfileParser.CalculateTotalQosPropertyMatchingScore(queryQoSInputList, serviceQosInputList);
			System.out.println("Total Qos Score: " + totalQoSScore);
			
			totalMatchingScore = totalInputScore + totalOutputScore + totalQoSScore;
			System.out.println("------------------------------------------------------");
			System.out.println("Total Matching Score for Input+QosInput+Output is: " + totalMatchingScore);
			System.out.println("------------------------------------------------------");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private static Map<String,String> getQosPropertyList(String serviceUrl, String qosProfileUrl){
		
		boolean hasQosProfileInstance = false;
		boolean hasQosProviderProfile = false;
		
		boolean hasQosProperty = false;		
		boolean isQosProfileType = false;
		
		String executionPriceValue = null;
		String responseTimeValue = null;
		String reliabilityValue = null;
		
		OWLOntology qosProfileOntology = null;
		
		OWLDataPropertyExpression owlDataPropertyExpression = null;
		java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
		Map<String, String> qosPropertyList = new HashMap<String, String>();
		
		java.util.Set<OWLLiteral> owlhasExecutionPriceLiteralList = null;
		java.util.Set<OWLLiteral> owlhasResponseTimeLiteralList = null;
		
		java.util.Set<OWLLiteral> owlhasReliabilityLiteralList = null;
		
		try{
			
			hasQosProfileInstance = ServiceParser.hasQosProfileInstance(serviceUrl);
			if(hasQosProfileInstance){
				
				qosProfileOntology = QosProfileParser.createOwlsOntology(qosProfileUrl);
				if(qosProfileOntology !=null){
					
					owlNamedIndividualList = QosProfileParser.getOwlNamedIndividualList(qosProfileUrl);
					if(owlNamedIndividualList.size() >0){
						for (OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList) {
							
							isQosProfileType = QosProfileParser.IsParameterType(owlNamedIndividual, qosProfileUrl, Owls.QosProfile.QoSProfile);
							if(isQosProfileType){
								//System.out.println("Qos Profile type exists");
								
								// Check hasQoSProviderProfile
								hasQosProviderProfile = QosProfileParser.hasQosProviderProfile(owlNamedIndividual,qosProfileUrl);
								if(hasQosProviderProfile){
									//System.out.println("QoS Provider Profile exisits");
									
									// Get QosProviderProfile Instance
									OWLIndividual QosProviderProfileInstance = QosProfileParser.getQosProviderProfileInstance(owlNamedIndividual, qosProfileUrl);
									if(QosProviderProfileInstance != null){
										
										// Check hasQoSProperty
										OWLNamedIndividual qosNamedProviderProfileInstance = QosProviderProfileInstance.asOWLNamedIndividual();
										if (qosNamedProviderProfileInstance !=null){
											hasQosProperty = QosProfileParser.hasQosProperty(qosNamedProviderProfileInstance, qosProfileUrl);
											if(hasQosProperty){
												
												// Get QosProperty Instance
												OWLIndividual owlQosPropertyInstance = QosProfileParser.getQosPropertyInstance(qosNamedProviderProfileInstance, qosProfileUrl);
												if (owlQosPropertyInstance !=null){
													//System.out.println("Qos Property Instance Exists!!!\n");
													
													OWLNamedIndividual owlNamedQosPropertyInstance = owlQosPropertyInstance.asOWLNamedIndividual();
													
													java.util.Set<OWLDataProperty> owlDataPropertyList = qosProfileOntology.getDataPropertiesInSignature(true);
													if(owlDataPropertyList.size() >0){
														//System.out.println("Total Data Property Number: " + owlDataPropertyList.size());
														for(OWLDataProperty owlDataProperty : owlDataPropertyList){
															
															IRI iri = IRI.create(owlDataProperty.getIRI().toString());
															//System.out.println(iri.toString());
															
															//hasExecutionPrice
															String hasExecutionPrice = Concepts.DataProperties.hasExecutionPrice;
															if(UriUtils.relaxedMatch(iri.toString(), hasExecutionPrice)){
																
																owlDataPropertyExpression = qosProfileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
																owlhasExecutionPriceLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, qosProfileOntology);
																
																//owlhasExecutionPriceLiteralList = QoSProfileParser.getDataPropertyValueList(owlNamedIndividual, qosProfileUrl, iri);
																if (owlhasExecutionPriceLiteralList.size() > 0) {
																	for (OWLLiteral owldataLiteral : owlhasExecutionPriceLiteralList) {
																		executionPriceValue = QosProfileParser.getExecutionPriceByCondition(owldataLiteral.getLiteral().toString());
																		qosPropertyList.put(QosProfileParser.ExecutionPrice, executionPriceValue);
																		//System.out.println(owldataLiteral.getLiteral() + " equals to ExecutionPrice: " + executionPriceValue);
																		
																	}
																}
															}
															
															//hasResponseTime
															String hasResponseTime = Concepts.DataProperties.hasResponseTime; 
															if(UriUtils.relaxedMatch(iri.toString(), hasResponseTime)){
																
																owlDataPropertyExpression = qosProfileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
																owlhasResponseTimeLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, qosProfileOntology);
																
																if (owlhasResponseTimeLiteralList.size() > 0) {
																	for (OWLLiteral owldataLiteral : owlhasResponseTimeLiteralList) {
																		responseTimeValue = QosProfileParser.getResponseTimeByCondition(owldataLiteral.getLiteral().toString());
																		qosPropertyList.put(QosProfileParser.ResponseTime, responseTimeValue);
																		//System.out.println(owldataLiteral.getLiteral() + " equals to ResponseTime: " + responseTimeValue);
																	}
																}
															}
															
															//hasReliability
															String hasReliability = Concepts.DataProperties.hasReliability; 
															if(UriUtils.relaxedMatch(iri.toString(), hasReliability)){
																
																owlDataPropertyExpression = qosProfileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
																owlhasReliabilityLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, qosProfileOntology);
																
																if (owlhasReliabilityLiteralList.size() > 0) {
																	for (OWLLiteral owlLiteral : owlhasReliabilityLiteralList) {
																		reliabilityValue = QosProfileParser.getReliabilityByCondition(owlLiteral.getLiteral().toString());
																		qosPropertyList.put(QosProfileParser.Reliability, reliabilityValue);
																		//System.out.println(owldataLiteral.getLiteral() + " equals to Reliability: " + reliabilityValue);
																	}
																}
															}
														}
													}
												}
											}
											
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		return qosPropertyList;
	}
	
	private static OwlsServiceList PopulateOwlsServiceList(){
		
		ArrayList<OwlsService> owlsServiceList = new ArrayList<OwlsService>();
		OwlsServiceList owlsServiceListResponse = new OwlsServiceList();
		
		try
		{
			/**
			 * Cer3 Service
			 */
			OwlsService owlsCef3Service = ServiceRepositoryManager.getCef3Service();
			if(owlsCef3Service !=null){
				owlsServiceList.add(owlsCef3Service);
			}
			
			/**
			 * Ambrox Service
			 */
			OwlsService owlsAmbroxService = ServiceRepositoryManager.getAmbroxService();
			if(owlsAmbroxService !=null){
				owlsServiceList.add(owlsAmbroxService);
			}
			
			/**
			 * Gmax Service
			 */
			OwlsService owlsGmaxService = ServiceRepositoryManager.getGmaxService();
			if(owlsGmaxService != null){
				owlsServiceList.add(owlsGmaxService);
			}
			
			/**
			 * Napa Service
			 */
			OwlsService owlsNapaService = ServiceRepositoryManager.getNapaService();
			if(owlsNapaService != null){
				owlsServiceList.add(owlsNapaService);
			}
			
			
			/**
			 * Serape Service
			 */
			OwlsService owlsSerapeService = ServiceRepositoryManager.getSerapeService();
			if(owlsSerapeService !=null){
				owlsServiceList.add(owlsSerapeService);
			}
			
			owlsServiceListResponse.setIsResult(1);
			owlsServiceListResponse.setIsOperationSuccessfull(1);
			owlsServiceListResponse.setOwlsServiceList(owlsServiceList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsServiceListResponse;
	}
}
