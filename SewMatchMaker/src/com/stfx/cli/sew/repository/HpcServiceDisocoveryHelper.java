package com.stfx.cli.sew.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

import com.stfx.cli.sew.datamodels.OwlsService;
import com.stfx.cli.sew.datamodels.OwlsServiceFile;
import com.stfx.cli.sew.datamodels.OwlsServiceList;
import com.stfx.cli.sew.datamodels.Service;
import com.stfx.cli.sew.datamodels.ServiceResponse;
import com.stfx.cli.sew.domain.Concepts;
import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.domain.impl.DrugOntologyParser;
import com.stfx.cli.sew.owls.parsers.PalliativeCareParser;
import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;

public class HpcServiceDisocoveryHelper {
	
	public static ServiceResponse DiscoverSemanticWebServiceList(String inputString, String outputString, String qosInputString){
		
		//String separator = ":";
		String separator = "-";
		
		boolean isValidInput = false;
		boolean isValidOutput = false;
		boolean isValidQoSInput = false;
		
		String serviceUrl = null;
		String profileUrl = null;
		
		ArrayList<String> queryInputInstanceList = new ArrayList<String>();
		ArrayList<String> queryInputConceptList = new ArrayList<String>();
		
		ArrayList<String> queryOutputInstanceList = new ArrayList<String>();
		ArrayList<String> queryOutputConceptList = new ArrayList<String>();
		
		Map<String, String> queryQosInputInstanceList = new HashMap<String, String>();
		Map<String, String> queryQosInputConceptList = new HashMap<String, String>();
		
		ServiceResponse serviceResponse = new ServiceResponse();
		Service semanticWebService = null;
		ArrayList<Service> semanticWebServiceList = new ArrayList<Service>();
		ArrayList<Service> rankedSemanticWebServiceList = new ArrayList<Service>();
		
		try{
			
			if(!inputString.isEmpty() && !qosInputString.isEmpty() && !outputString.isEmpty()){
				
				// Inputs
				if(!inputString.isEmpty()){
					queryInputInstanceList = UriUtils.getParsedList(inputString, separator);
					if(queryInputInstanceList.size() >0){
						System.out.println("Query Input Concepts:");
						for (String inputConcept : queryInputInstanceList){
							
							// Get Type of each instance
							java.util.Set<OWLClassExpression> owlClassExPressionList = DrugOntologyParser.getOwlIndividualType(inputConcept,true);
							if(owlClassExPressionList.size()>0){
								for(OWLClassExpression owlClassExpression : owlClassExPressionList){
									System.out.println(UriUtils.getCoreUrl(owlClassExpression.toString()));
									queryInputConceptList.add(UriUtils.getCoreUrl(owlClassExpression.toString()));
									isValidInput = true;
								}
							}
							//System.out.println(inputConcept);
						}
						System.out.println("-------------------------------------------");
					}
				}
				
				// Outputs
				if(!outputString.isEmpty()){
					queryOutputInstanceList = UriUtils.getParsedList(outputString, separator);
					if(queryOutputInstanceList.size()>0){
						System.out.println("Query Output Concepts:");
						for (String ouputConcept : queryOutputInstanceList){
							
							// Get Type of Each Instance
							java.util.Set<OWLClassExpression> owlClassExPressionList = DrugOntologyParser.getOwlIndividualType(ouputConcept,true);
							if(owlClassExPressionList.size()>0){
								for(OWLClassExpression owlClassExpression : owlClassExPressionList){
									System.out.println(UriUtils.getCoreUrl(owlClassExpression.toString()));
									queryOutputConceptList.add(UriUtils.getCoreUrl(owlClassExpression.toString()));
									isValidOutput = true;
								}
							}
						}
						System.out.println("-------------------------------------------");
					}
				}
				 
				// QosInputs
				if(!qosInputString.isEmpty()){
					queryQosInputInstanceList = PalliativeCareParser.getParsedQosList(qosInputString, separator);
					if(queryQosInputInstanceList.size()>0){
						System.out.println("Query Qos Input List:");
						for(Map.Entry<String, String> entry : queryQosInputInstanceList.entrySet()){
							
							// Get Type of Each Instance
							java.util.Set<OWLClassExpression> owlClassExPressionList = DrugOntologyParser.getOwlIndividualType(entry.getValue(),false);
							if(owlClassExPressionList.size()>0){
								for(OWLClassExpression owlClassExpression : owlClassExPressionList){
									System.out.println(entry.getKey() + ": " + UriUtils.getCoreUrl(owlClassExpression.toString()));
									queryQosInputConceptList.put(entry.getKey(), UriUtils.getCoreUrl(owlClassExpression.toString()));
									isValidQoSInput = true;
								}
							}
							
							//System.out.println(entry.getKey() + ": " + DrugOntology.drugOntologyURI + entry.getValue());
						}
						System.out.println("-----------------------------------------");
					}
				}
				
				// Populate Owls Service List. Enable this block later to check full functionality
				OwlsServiceList hpcWorkflowServiceListResponse =  ServiceRepositoryManager.getHpcWorkflowServiceList();
				if(hpcWorkflowServiceListResponse.getOwlsServiceList().size()>0){
					for(OwlsService owlsService : hpcWorkflowServiceListResponse.getOwlsServiceList()){
						// Parse owlsService object
						System.out.println("----------------" + "Started Execution of: " + owlsService.getServiceName() + "-------------------------");
						System.out.println("Service Name: " + owlsService.getServiceName());
						System.out.println("Service Provider: " + owlsService.getServiceProvider());
						System.out.println("Service Description: " + owlsService.getServiceDescription());
						
						if(owlsService.getOwlsServiceList().size()>0){
							for(OwlsServiceFile owlsServiceFile : owlsService.getOwlsServiceList()){
								if(owlsServiceFile.getServiceFileType() == ServiceRepositoryManager.Service){
									serviceUrl = owlsServiceFile.getWebUrl();
									System.out.println("\nService Url: " + serviceUrl);
								}
								if(owlsServiceFile.getServiceFileType() == ServiceRepositoryManager.Profile){
									profileUrl = owlsServiceFile.getWebUrl();
									System.out.println("Profile Url: " + profileUrl);
								}
							}
							System.out.println("-----------------------------------------");
						}
								
						// Call Matchmaking Algorithm
						if(isValidInput && isValidOutput && isValidQoSInput){
							if(!serviceUrl.isEmpty() && !profileUrl.isEmpty()){
								
								semanticWebService = CallSewMatchMakingAlgorithm(queryInputInstanceList, queryOutputConceptList,queryQosInputConceptList, serviceUrl,profileUrl);
								
								if(semanticWebService !=null){
									semanticWebService.setId(owlsService.getId());
									semanticWebService.setServiceName(owlsService.getServiceName());
									semanticWebService.setServiceProvider(owlsService.getServiceProvider());
									semanticWebServiceList.add(semanticWebService);
								}
								System.out.println("----------------" + "Finished Execution of: " + owlsService.getServiceName() + "----------");
								System.out.println("----------------------------------------------------------------");
								
							}
							else{
								System.out.println("Invalid Input/QosInput/Output List for Sew Semantic Matchmaking Algorithm");
							}
						}
						else{
							System.out.println("Provided Input or Output or QoSInput instance(s) are not valid.");
						}
					}
				}
				else{
					System.out.println("Failed to load Owl-s service list from Owl-S Repository");
				}
				
				/**
				 * Rank Web Service List
				 */
				if(semanticWebServiceList.size()>0){
					rankedSemanticWebServiceList = HpcServiceDisocoveryHelper.RankSemanticWebService(semanticWebServiceList);
				}
				
				if(semanticWebServiceList.size() >0){
					serviceResponse.setIsOperationSuccessfull(true);
					serviceResponse.setIsResult(true);
					serviceResponse.setSerivceList(rankedSemanticWebServiceList);
				}
				else{
					serviceResponse.setIsOperationSuccessfull(true);
					serviceResponse.setIsResult(false);
					serviceResponse.setSerivceList(null);
				}
			}
			else{
				serviceResponse.setIsResult(false);
				serviceResponse.setIsOperationSuccessfull(true);
				serviceResponse.setSerivceList(null);
			}
		}
		catch(Exception ex){
			serviceResponse.setIsResult(false);
			serviceResponse.setIsOperationSuccessfull(true);
			serviceResponse.setSerivceList(null);
		}
		return serviceResponse;
	}
	
	private static Service CallSewMatchMakingAlgorithm(ArrayList<String> queryInputConceptList,ArrayList<String> queryOutputConceptList, Map<String, String> queryQosInputInstanceList, String serviceUrl, String profileUrl){
		
		//boolean hasOwlsServiceInstance = false;
		//boolean hasOwlsProfileInstance = false;
		
		boolean isProfileType = false;
		boolean isProfilePropertiesProcessed = false;
		
		boolean isQosProfileType = false;
		boolean isQosProfilePropertiesProcessed = false;
		
		int totalInputScore=0;
		int totalOutputScore=0;
		
		int totalQoSScore=0;
		int totalMatchingScore=0;
		
		String concept = null;
		String conceptUrl = null;
		
		String instance = null;
		String instanceUrl = null;
		
		Service matchedService = null;
		
		OWLOntology owlsProfileOntology = null;
		java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
		
		java.util.Set<OWLClassExpression> owlClassExpressionList = null; 
		
		
		java.util.Set<OWLIndividual> owlInputIndividualList = null;
		java.util.Set<OWLIndividual> owlOutputIndividualList = null;
		
		// Service Input/Output List
		ArrayList<String> serviceInputList = new ArrayList<String>();
		//ArrayList<String> serviceQoSInputList = new ArrayList<String>();
		ArrayList<String> serviceOutputList = new ArrayList<String>();
		Map<String,String> serviceQosInputList = new HashMap<String, String>();

		try{
			
			owlsProfileOntology = PalliativeCareParser.createOwlsOntology(profileUrl,true);
			if(owlsProfileOntology != null){
				owlNamedIndividualList = PalliativeCareParser.getOwlNamedIndividualList(profileUrl);
				
				for(OWLNamedIndividual owlInd : owlNamedIndividualList){
					System.out.println("Individual Name: " + owlInd.toString());
				}
				System.out.println("-------------------------------------------------");
				
				if(owlNamedIndividualList.size() >0){
					for (OWLNamedIndividual owlNamedIndividual : owlNamedIndividualList) {
						
						// Check Profile TYpe
						isProfileType = PalliativeCareParser.IsParameterType(owlNamedIndividual, profileUrl, Owls.Profile.Profile);
						if(isProfileType){
							
							isProfilePropertiesProcessed = true;
							// Get Input List
							owlInputIndividualList = PalliativeCareParser.getServiceInputList(owlNamedIndividual,profileUrl);
							if (owlInputIndividualList.size() >0){
								for(OWLIndividual owlInputIndividual : owlInputIndividualList){
									instance = UriUtils.getConcept(UriUtils.getCoreUrl(owlInputIndividual.toString()));
									
									if(!instance.isEmpty()){
										
										//instanceUrl = DrugOntology.drugOntologyURI + instance;
										
										// Get Type of this Instance
										owlClassExpressionList = DrugOntologyParser.getOwlIndividualType(instance,false);
										if(owlClassExpressionList.size()>0){
											for(OWLClassExpression owlClassExpression : owlClassExpressionList){
												//System.out.println(UriUtils.getCoreUrl(owlClassExpression.toString()));
												serviceInputList.add(UriUtils.getCoreUrl(owlClassExpression.toString()));
											}
										}
										
										//System.out.println(conceptUrl);
										//serviceInputList.add(conceptUrl);
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
							owlOutputIndividualList = PalliativeCareParser.getSerivceOutputList(owlNamedIndividual,profileUrl);
							if (owlOutputIndividualList.size() >0){
								for(OWLIndividual owlOutputIndividual : owlOutputIndividualList){
									
									//serviceOutputList.add(UriUtils.getCoreUrl(owlOutputIndividual.toString()));
									instance = UriUtils.getConcept(UriUtils.getCoreUrl(owlOutputIndividual.toString()));
									
									if(!instance.isEmpty()){
										
										//instanceUrl = DrugOntology.drugOntologyURI + concept;
										
										owlClassExpressionList = DrugOntologyParser.getOwlIndividualType(instance,false);
										if(owlClassExpressionList.size()>0){
											for(OWLClassExpression owlClassExpression : owlClassExpressionList){
												//System.out.println(UriUtils.getCoreUrl(owlClassExpression.toString()));
												serviceOutputList.add(UriUtils.getCoreUrl(owlClassExpression.toString()));
											}
										}
										
										//System.out.println(conceptUrl);
										//serviceOutputList.add(conceptUrl);
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
						}
					
						// Check QoSProfile TYpe
						/**
						 * Parse Qos Property List (ExecutionPrice, ResponseTime and Reliability)
						 * Check if it has Qos Profile Instance first
						 */
						
						isQosProfileType = PalliativeCareParser.IsParameterType(owlNamedIndividual, profileUrl, Owls.QosProfile.QoSProfile);
						if(isQosProfileType){
							
							isQosProfilePropertiesProcessed = true;
							serviceQosInputList = getQosPropertyList(owlsProfileOntology,owlNamedIndividual,profileUrl);
							if(serviceQosInputList.size()>0){
								System.out.println("Service Qos Input List:");
								for(Map.Entry<String, String> entry : serviceQosInputList.entrySet()){
									System.out.println(entry.getKey() + ": " + entry.getValue());
								}
								System.out.println("-------------------------------------------------");
							}
						}
						
						//Exit current Loop
						if(isProfilePropertiesProcessed && isQosProfilePropertiesProcessed)
							break;
					}
				}
			}
			
			/**
			 * Use Consumer Agent's Input and output list
			 * Use parsed Input and Output list from Owl-s service 
			 * Pass both sets of inputs and outputs to DrugOntologyParser to check Subsumption relationship
			 */
			
			// Call Output Matching Function
			totalOutputScore =  DrugOntologyParser.CalculateTotalOutputMatchingScore(queryOutputConceptList, serviceOutputList);
			System.out.println("Total Output Score: " + totalOutputScore);
						
			// Call Input Matching Function
			totalInputScore = DrugOntologyParser.CalculateTotalInputMatchingScore(queryInputConceptList, serviceInputList);
			System.out.println("Total Input Score: " + totalInputScore);
			
			// Call QoS Matching Function
			totalQoSScore = PalliativeCareParser.CalculateTotalQosPropertyMatchingScore(queryQosInputInstanceList, serviceQosInputList);
			System.out.println("Total Qos Score: " + totalQoSScore);
			
			totalMatchingScore = totalInputScore + totalOutputScore + totalQoSScore;
			System.out.println("------------------------------------------------------");
			System.out.println("Total Matching Score for Input+QosInput+Output is: " + totalMatchingScore);
			System.out.println("------------------------------------------------------");
			
			if(totalMatchingScore >0){
				//Add matched service to the list
				matchedService = new Service();
				matchedService.setInputOutputScore(totalInputScore + totalOutputScore);
				matchedService.setQosScore(totalQoSScore);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return matchedService;
	}

	private static Map<String,String> getQosPropertyList(OWLOntology profileOntology,OWLNamedIndividual owlNamedIndividual,String profileUrl){
		
		String executionPriceValue = null;
		String responseTimeValue = null;
		String reliabilityValue = null;
		
		//OWLOntology profileOntology = null;
		
		OWLDataPropertyExpression owlDataPropertyExpression = null;
		//java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
		Map<String, String> qosPropertyList = new HashMap<String, String>();
		
		java.util.Set<OWLLiteral> owlhasExecutionPriceLiteralList = null;
		java.util.Set<OWLLiteral> owlhasResponseTimeLiteralList = null;
		
		java.util.Set<OWLLiteral> owlhasReliabilityLiteralList = null;
		
		try{
			
			// Get QosProviderProfile Instance
			if(owlNamedIndividual !=null){
				OWLIndividual QosProviderProfileInstance = PalliativeCareParser.getQosProviderProfileInstance(owlNamedIndividual, profileUrl);
				if(QosProviderProfileInstance != null){
					
					// Check hasQoSProperty
					OWLNamedIndividual qosNamedProviderProfileInstance = QosProviderProfileInstance.asOWLNamedIndividual();
					if (qosNamedProviderProfileInstance !=null){
						
						// Get QosProperty Instance
						OWLIndividual owlQosPropertyInstance = PalliativeCareParser.getQosPropertyInstance(qosNamedProviderProfileInstance, profileUrl);
						if (owlQosPropertyInstance !=null){
							//System.out.println("Qos Property Instance Exists!!!\n");
							
							OWLNamedIndividual owlNamedQosPropertyInstance = owlQosPropertyInstance.asOWLNamedIndividual();
							
							java.util.Set<OWLDataProperty> owlDataPropertyList = profileOntology.getDataPropertiesInSignature(false);
							if(owlDataPropertyList.size() >0){
								//System.out.println("Total Data Property Number: " + owlDataPropertyList.size());
								for(OWLDataProperty owlDataProperty : owlDataPropertyList){
									
									IRI iri = IRI.create(owlDataProperty.getIRI().toString());
									//System.out.println(iri.toString());
									
									//hasExecutionPrice
									String hasExecutionPrice = Concepts.DataProperties.hasExecutionPrice;
									if(UriUtils.relaxedMatch(iri.toString(), hasExecutionPrice)){
										
										owlDataPropertyExpression = profileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
										owlhasExecutionPriceLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, profileOntology);
										
										//owlhasExecutionPriceLiteralList = QoSProfileParser.getDataPropertyValueList(owlNamedIndividual, qosProfileUrl, iri);
										if (owlhasExecutionPriceLiteralList.size() > 0) {
											for (OWLLiteral owldataLiteral : owlhasExecutionPriceLiteralList) {
												executionPriceValue = PalliativeCareParser.getExecutionPriceByCondition(owldataLiteral.getLiteral().toString());
												qosPropertyList.put(PalliativeCareParser.ExecutionPrice, DrugOntology.drugOntologyURI + executionPriceValue + PalliativeCareParser.ExecutionPrice);
												//System.out.println(owldataLiteral.getLiteral() + " equals to ExecutionPrice: " + executionPriceValue);
												
											}
										}
									}
									
									//hasResponseTime
									String hasResponseTime = Concepts.DataProperties.hasResponseTime; 
									if(UriUtils.relaxedMatch(iri.toString(), hasResponseTime)){
										
										owlDataPropertyExpression = profileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
										owlhasResponseTimeLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, profileOntology);
										
										if (owlhasResponseTimeLiteralList.size() > 0) {
											for (OWLLiteral owldataLiteral : owlhasResponseTimeLiteralList) {
												responseTimeValue = PalliativeCareParser.getResponseTimeByCondition(owldataLiteral.getLiteral().toString());
												qosPropertyList.put(PalliativeCareParser.ResponseTime, DrugOntology.drugOntologyURI + responseTimeValue + PalliativeCareParser.ResponseTime);
												//System.out.println(owldataLiteral.getLiteral() + " equals to ResponseTime: " + responseTimeValue);
											}
										}
									}
									
									//hasReliability
									String hasReliability = Concepts.DataProperties.hasReliability; 
									if(UriUtils.relaxedMatch(iri.toString(), hasReliability)){
										
										owlDataPropertyExpression = profileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
										owlhasReliabilityLiteralList = owlNamedQosPropertyInstance.getDataPropertyValues(owlDataPropertyExpression, profileOntology);
										
										if (owlhasReliabilityLiteralList.size() > 0) {
											for (OWLLiteral owlLiteral : owlhasReliabilityLiteralList) {
												reliabilityValue = PalliativeCareParser.getReliabilityByCondition(owlLiteral.getLiteral().toString());
												qosPropertyList.put(PalliativeCareParser.Reliability, DrugOntology.drugOntologyURI + reliabilityValue + PalliativeCareParser.Reliability);
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
		catch(Exception ex){
			
		}
		return qosPropertyList;
	}

	public static ArrayList<Service> RankSemanticWebService(ArrayList<Service> rankedSemanticWebServiceList){
		
		boolean swapped = true;
		int length = 0;
		Service IntSemanticWebService = new Service();
		
		try{
			
			/**
			 * procedure bubbleSort( A : list of sortable items )
			    n = length(A)
			    repeat
			       swapped = false
			       for i = 1 to n-1 inclusive do
			          if A[i-1] > A[i] then
			             swap(A[i-1], A[i])
			             swapped = true
			          end if
			       end for
			       n = n - 1
			    until not swapped
			 end procedure
			 */
			if(rankedSemanticWebServiceList.size() >0){
				
				length = rankedSemanticWebServiceList.size();
				Service currentService = new Service();
				Service previousService = new Service();
				while(swapped){
					
					swapped = false;
					for(int position = 1;position <=length-1;position++){
						
						previousService = rankedSemanticWebServiceList.get(position-1);
						currentService = rankedSemanticWebServiceList.get(position);
						
						if(previousService.getInputOutputScore() < currentService.getInputOutputScore()){
							IntSemanticWebService = previousService;
							rankedSemanticWebServiceList.set(position-1, currentService);
							rankedSemanticWebServiceList.set(position, IntSemanticWebService);
							
							swapped = true;
						}
						
						else if(previousService.getInputOutputScore() == currentService.getInputOutputScore()
								 &&  previousService.getQosScore()< currentService.getQosScore() ){
							
							IntSemanticWebService = previousService;
							rankedSemanticWebServiceList.set(position-1, currentService);
							rankedSemanticWebServiceList.set(position, IntSemanticWebService);
							
							swapped = true;
						}
					}
					length = length -1;
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return rankedSemanticWebServiceList;
	}

}
