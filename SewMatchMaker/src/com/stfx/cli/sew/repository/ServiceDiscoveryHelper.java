package com.stfx.cli.sew.repository;

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
import com.stfx.cli.sew.datamodels.OwlsServiceFile;
import com.stfx.cli.sew.datamodels.OwlsServiceList;
import com.stfx.cli.sew.datamodels.Service;
import com.stfx.cli.sew.domain.Concepts;
import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.domain.impl.DrugOntologyParser;
import com.stfx.cli.sew.owls.parsers.ProfileParser;
import com.stfx.cli.sew.owls.parsers.QosProfileParser;
import com.stfx.cli.sew.owls.parsers.ServiceParser;
import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;

public class ServiceDiscoveryHelper {
	
		// Napa Service
		/*final static String serviceUrl = "http://test.biocomalert.com/docs/services/napa/NapaService.owl";
		final static String profileUrl = "http://test.biocomalert.com/docs/services/napa/NapaProfile.owl"; 
		final static String qosProfileUrl = "http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl";*/
		
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
		
		
		
		static String separator = ":";
		//static String inputString = "Critical:Fever";
		
		//static String outputString = "Serape:Etorix";
		//static String qosInputString = "ResponseTime:ExecutionPrice:Reliability";
		
		
		public static Service DiscoverSemanticWebService(String inputString, String outputString, String qosInputString){
			
			ArrayList<String> queryInputList = new ArrayList<String>();
			ArrayList<String> queryOutputList = new ArrayList<String>();
			
			//ArrayList<String> queryQoSInputList = new ArrayList<String>();
			Map<String, String> queryQosInputList = new HashMap<String, String>();
			Service matchedService = null;
			
			final String serviceUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl";
			final String profileUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl"; 
			final String qosProfileUrl = "http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl";
			
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
				matchedService = CallSewMatchMakingAlgorithm(queryInputList,queryQosInputList,queryOutputList,serviceUrl,profileUrl,qosProfileUrl);
			}
			/*else{
				System.out.println("Invalid Input/QosInput/Output List for Sew Semantic Matchmaking Algorithm");
			}*/
			
			return matchedService;
			
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
		
		private static Service CallSewMatchMakingAlgorithm(ArrayList<String> queryInputList, Map<String,String> queryQoSInputList, ArrayList<String> queryOutputList,
				String serviceUrl,String profileUrl,String qosProfileUrl){
			
			boolean hasOwlsServiceInstance = false;
			boolean hasOwlsProfileInstance = false;
			
			boolean isProfileType = false;
			
			int totalInputScore=0;
			int totalOutputScore=0;
			
			int totalQoSScore=0;
			int totalMatchingScore=0;
			
			String concept = null;
			String conceptUrl = null;
			
			Service matchedService = null;
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
				
				/**
				 * Use Consumer Agent's Input and output list
				 * Use parsed Input and Output list from Owl-s service 
				 * Pass both sets of inputs and outputs to DrugOntologyParser to check Subsumption relationship
				 */
				
				// Call Output Matching Function
				totalOutputScore =  DrugOntologyParser.CalculateTotalOutputMatchingScore(queryOutputList, serviceOutputList);
				System.out.println("Total Output Score: " + totalOutputScore);
				
				// Call Input Matching Function
				totalInputScore = DrugOntologyParser.CalculateTotalInputMatchingScore(queryInputList, serviceInputList);
				System.out.println("Total Input Score: " + totalInputScore);
				
				// Call QoS Matching Function
				totalQoSScore = QosProfileParser.CalculateTotalQosPropertyMatchingScore(queryQoSInputList, serviceQosInputList);
				System.out.println("Total Qos Score: " + totalQoSScore);
				
				
				totalMatchingScore =  totalOutputScore + totalInputScore + totalQoSScore;
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
		
		/*private static Service CallSewMatchMakingAlgorithm(ArrayList<String> queryInputList, Map<String,String> queryQoSInputList, ArrayList<String> queryOutputList,
				String serviceUrl,String profileUrl,String qosProfileUrl){
			
			boolean hasOwlsServiceInstance = false;
			boolean hasOwlsProfileInstance = false;
			
			boolean isProfileType = false;
			
			int totalInputScore=0;
			int totalOutputScore=0;
			
			int totalQoSScore=0;
			int totalMatchingScore=0;
			
			String concept = null;
			String conceptUrl = null;
			
			Service matchedService = null;
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
					
					*//**
					 * Parse Qos Property List (ExecutionPrice, ResponseTime and Reliability)
					 * Check if it has Qos Profile Instance first
					 *//*
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
				
				*//**
				 * Use Consumer Agent's Input and output list
				 * Use parsed Input and Output list from Owl-s service 
				 * Pass both sets of inputs and outputs to DrugOntologyParser to check Subsumption relationship
				 *//*
				
				// Call Output Matching Function
				totalOutputScore =  DrugOntologyParser.CalculateTotalOutputMatchingScore(queryOutputList, serviceOutputList);
				System.out.println("Total Output Score: " + totalOutputScore);
				
				// Call Input Matching Function
				totalInputScore = DrugOntologyParser.CalculateTotalInputMatchingScore(queryInputList, serviceInputList);
				System.out.println("Total Input Score: " + totalInputScore);
				
				// Call QoS Matching Function
				totalQoSScore = QosProfileParser.CalculateTotalQosPropertyMatchingScore(queryQoSInputList, serviceQosInputList);
				System.out.println("Total Qos Score: " + totalQoSScore);
				
				
				totalMatchingScore =  totalOutputScore + totalInputScore + totalQoSScore;
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
		}*/
		
		public static ArrayList<Service> DiscoverSemanticWebServiceList(String inputString, String outputString, String qosInputString){
			
			String serviceUrl = null;
			String profileUrl = null; 
			String qosProfileUrl = null;
			
			ArrayList<String> queryInputList = new ArrayList<String>();
			ArrayList<String> queryOutputList = new ArrayList<String>();
			
			//ArrayList<String> queryQoSInputList = new ArrayList<String>();
			Map<String, String> queryQosInputList = new HashMap<String, String>();
			
			Service semanticWebService = null;
			ArrayList<Service> semanticWebServiceList = new ArrayList<Service>();
			
			try{
				
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
				OwlsServiceList owlsServiceListResponse = ServiceRepositoryManager.PopulateOwlsServiceList();
				if(owlsServiceListResponse.getOwlsServiceList().size()>0){
					for(OwlsService owlsService : owlsServiceListResponse.getOwlsServiceList()){
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
								if(owlsServiceFile.getServiceFileType() == ServiceRepositoryManager.QosProfile){
									qosProfileUrl = owlsServiceFile.getWebUrl();
									System.out.println("Qos Profile Url: " + qosProfileUrl);
								}
							}
						}
						
						// Call Matchmaking Algorithm
						if(!serviceUrl.isEmpty() && !profileUrl.isEmpty() && !qosProfileUrl.isEmpty()){
							//matchedService = CallSewMatchMakingAlgorithm(queryInputList,queryQosInputList,queryOutputList);
							semanticWebService = CallSewMatchMakingAlgorithm(queryInputList,queryQosInputList,queryOutputList,serviceUrl,profileUrl,qosProfileUrl);
							if(semanticWebService !=null){
								semanticWebService.setId(owlsService.getId());
								semanticWebService.setServiceName(owlsService.getServiceName());
								semanticWebService.setServiceProvider(owlsService.getServiceProvider());
								semanticWebServiceList.add(semanticWebService);
							}
							System.out.println("----------------" + "Finished Execution of: " + owlsService.getServiceName() + "----------");
							System.out.println("----------------------------------------------------------------");
						}
						/*else{
							System.out.println("Invalid Input/QosInput/Output Url for Sew Semantic Matchmaking Algorithm");
						}*/
					}
				}
				/*else{
					System.out.println("Failed to load Owl-s service list from Owl-S Repository");
				}*/
				
			}
			
			catch(Exception ex){
				semanticWebServiceList = null;
			}
			return semanticWebServiceList;
		}
		
		/**
		 * 
		 * @param serviceUrl
		 * @param qosProfileUrl
		 * @return
		 */
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

		/*private static Map<String,String> getQosPropertyList(String serviceUrl, String qosProfileUrl){
			
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
		}*/

}
