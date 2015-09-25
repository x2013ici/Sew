package com.stfx.cli.sew.owls.parsers;

import java.util.HashMap;
import java.util.Map;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.datamodels.ExecutionPrice;
import com.stfx.cli.sew.datamodels.Reliability;
import com.stfx.cli.sew.datamodels.ResponseTime;
import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.owls.vocubulary.Owls;
import com.stfx.cli.sew.utilities.UriUtils;

/**
 * 
 * @author Mostafijur Rahman
 * The parser deals with instances of concepts as input/output parameters instead of concepts
 */
public class PalliativeCareParser {

		// Response Time
		public static final String ResponseTime = "ResponseTime";
		private static final String LowResponseTime = "Low";
		private static final String MediumResponseTime = "Medium";
		private static final String HighResponseTime = "High";
		private static final String FailResponseTime = "Fail";
		private static final String responseTimeUnit = "second";
			
		// Execution Price
		public static final String ExecutionPrice = "ExecutionPrice";
		private static final String LowExecutionPrice = "Low";
		private static final String MediumExecutionPrice = "Medium";
		private static final String HighExecutionPrice = "High";
		private static final String FailExecutionPrice = "Fail";
		private static final String executionPriceUnit = "$";
			
		// Reliability
		public static final String Reliability = "Reliability";
		private static final String LowReliability = "Low";
		private static final String MediumReliability = "Medium";
		private static final String HighReliability = "High";
		private static final String FailReliability = "Fail";
		private static final String reliabilityPriceUnit = "%";
			
		private static final int QosExcellent = 3;
		private static final int QosGood = 2;
		private static final int QosBad = 1;
		private static final int QosFail = 0;
			
		static Map<String, ExecutionPrice> executionPriceList = new HashMap<String, ExecutionPrice>();
		static Map<String, Reliability> reliabilityList = new HashMap<String, Reliability>();
		static Map<String, ResponseTime> responseTimeList = new HashMap<String, ResponseTime>();
			
		/**
		 * 
		 */
		public PalliativeCareParser(){
			
		}
		
		public static volatile PalliativeCareParser referralTaskParser = null;
		public static PalliativeCareParser createProfileParserInstance(){
			
			if (referralTaskParser ==null){
				synchronized(ProfileParser.class){
					referralTaskParser = new PalliativeCareParser();
				}
			}
			return referralTaskParser;
			
		}
		
		/**
		 * 
		 */
		private static volatile OWLOntologyManager owlsProfileOntologyManager = null;
		public static OWLOntologyManager createOwlsOntologyManager(){
			
			/*if(owlsProfileOntologyManager == null){
				synchronized(OWLOntologyManager.class){
					owlsProfileOntologyManager = OWLManager.createOWLOntologyManager();
				}
			}*/
			
			synchronized(OWLOntologyManager.class){
				owlsProfileOntologyManager = OWLManager.createOWLOntologyManager();
			}
			
			return owlsProfileOntologyManager;
		}
		
		/**
		 * 
		 */
		private static volatile OWLOntology owlsProfileOntology = null; 
		public static OWLOntology createOwlsOntology(String Url, boolean isNewService){
			
			OWLOntologyManager owlOntologyManager = null;
			
			if(!isNewService){
				if(owlsProfileOntology !=null){
					return owlsProfileOntology;
				}
			}
			
			owlOntologyManager = createOwlsOntologyManager();
			synchronized(OWLOntology.class){
				if (owlOntologyManager !=null){
					try {
						owlsProfileOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(Url));
					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			/*if(owlsProfileOntology == null){
				
				owlOntologyManager = createOwlsOntologyManager();
				synchronized(OWLOntology.class){
					if (owlOntologyManager !=null){
						try {
							owlsProfileOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(Url));
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}*/
			
			return owlsProfileOntology;
		}
		
		/**
		 * 
		 */
		private static volatile OWLDataFactory owlsProfileDataFactory = null;
		public static OWLDataFactory createOwlsDataFactory(){
			
			OWLOntologyManager owlsOntologyManager = null;
			/*if(owlsProfileDataFactory == null){
				owlsOntologyManager = createOwlsOntologyManager();
				synchronized(OWLDataFactory.class){
					owlsProfileDataFactory = owlsOntologyManager.getOWLDataFactory();
				}
			}*/
			
			owlsOntologyManager = createOwlsOntologyManager();
			synchronized(OWLDataFactory.class){
				owlsProfileDataFactory = owlsOntologyManager.getOWLDataFactory();
			}
			
			return owlsProfileDataFactory;
		}
		
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param profileUrl
		 * @return
		 */
		public static java.util.Set<OWLIndividual> getSerivceOutputList(OWLNamedIndividual owlNamedIndividual, String profileUrl){
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> owlsOutputIndividualList = null;
			
			try{
				
				if(!profileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(profileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.Profile.hasOutput);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.Profile.hasOutput));
						if (owlObjectPropertyExpression != null){
							owlsOutputIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
								
						}
					}
				}
			}
			catch(Exception ex){
				return owlsOutputIndividualList;
			}
			return owlsOutputIndividualList;
		}
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param profileUrl
		 * @return
		 */
		public static java.util.Set<OWLIndividual> getServiceInputList(OWLNamedIndividual owlNamedIndividual, String profileUrl){
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> owlsInputIndividualList = null;
			
			try{
				
				if(!profileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(profileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.Profile.hasInput);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.Profile.hasInput));
						if (owlObjectPropertyExpression != null){
							owlsInputIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
								
						}
					}
				}
			}
			catch(Exception ex){
				return owlsInputIndividualList;
			}
			return owlsInputIndividualList;
		}
		/**
		 * 
		 * @param profileUrl
		 * @return
		 */
		public static java.util.Set<OWLNamedIndividual> getOwlNamedIndividualList(String profileUrl){
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLNamedIndividual> owlNamedIndividualList = null;
			
			try{
			
				if(!profileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if(owlsOntologyManager!=null){
						owlsOntology = createOwlsOntology(profileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						if (owlsOntology !=null){
							owlNamedIndividualList = owlsOntology.getIndividualsInSignature();
						}
					}
				}
			}
			catch(Exception ex){
				return owlNamedIndividualList;
			}
			return owlNamedIndividualList;
			
		}
		
		public static boolean IsParameterType(OWLNamedIndividual owlNamedIndividual, String serviceUrl, String parameterTypeUrl){
			
			boolean hasParameterType = false;
			OWLOntology owlsOntology = null;
			try{
				
				if (!serviceUrl.isEmpty()){
					owlsOntology = createOwlsOntology(serviceUrl,false);
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
		
		/**
		 * 
		 * @param queryQoSList
		 * @param serviceQosList
		 * @return
		 */
		public static int CalculateTotalQosPropertyMatchingScore(Map<String, String> queryQosList, Map<String,String> serviceQosList){
			
			int totalQosMatchingScore=0;
			int responseTimeMatchingScore=0;
			
			int executionPriceMatchingScore=0;
			int reliabilityMatchingScore=0;
			
			int queryResponseTimePosition =0;
			int queryExecutionPricePosition=0;
			int queryReliabilityPosition=0;
			
			int serviceResponseTimePosition = 0;
			int serviceExecutionPricePosition=0;
			int serviceReliabilityPosition=0;
			
			ResponseTime queryResponseTime = null;
			ResponseTime serviceResponseTime = null;
			
			ExecutionPrice queryExecutionPrice = null;
			ExecutionPrice serviceExecutionPrice = null;
			
			Reliability queryReliability = null;
			Reliability serviceReliability = null;
			
			try{
				
				//Initialize Mappers
				initializeExecutionPriceMapper();
				initializeResponseTimeMapper();
				initializeReliabilityMapper();
				
				if(queryQosList.size() >0 && serviceQosList.size()>0){
					
					/*if(serviceQosList.size()>0){
						
						 * for (Map.Entry<String, String> entry : map.entrySet())
							{
							    System.out.println(entry.getKey() + "/" + entry.getValue());
							}
						 
						System.out.println("\nService Qos Input List:");
						for(Map.Entry<String, String> entry : serviceQosList.entrySet()){
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
					}
					
					if(queryQosList.size()>0){
						System.out.println("\nQuery Qos Input List:");
						for(Map.Entry<String, String> entry : queryQosList.entrySet()){
							System.out.println(entry.getKey() + ": " + entry.getValue());
						}
					}*/
					
					
					// Process ResponseTime
					if(responseTimeList.size() >0){
						
						// Process Query Input
						queryResponseTime = responseTimeList.get(queryQosList.get(ResponseTime));
						if (queryResponseTime != null){
							queryResponseTimePosition = queryResponseTime.getPosition();
						}
								
						// Process Service Input
						serviceResponseTime = responseTimeList.get(serviceQosList.get(ResponseTime));
						if(serviceResponseTime!=null){
							serviceResponseTimePosition = serviceResponseTime.getPosition();
						}
						
						//Calculate Matching Score
						if(queryResponseTimePosition >0 && serviceResponseTimePosition  >0){
							responseTimeMatchingScore = getQosMatchingScore(queryResponseTimePosition,serviceResponseTimePosition);
							if(responseTimeMatchingScore >0){
								totalQosMatchingScore = totalQosMatchingScore + responseTimeMatchingScore;
							}
						}
					}
					
					// Process ExecutionPrice
					if(executionPriceList.size() >0){
						
						// Process Query Input
						queryExecutionPrice = executionPriceList.get(queryQosList.get(ExecutionPrice));
						if (queryExecutionPrice != null){
							queryExecutionPricePosition = queryExecutionPrice.getPosition();
						}
								
						// Process Service Input
						serviceExecutionPrice = executionPriceList.get(serviceQosList.get(ExecutionPrice));
						if(serviceExecutionPrice!=null){
							serviceExecutionPricePosition = serviceExecutionPrice.getPosition();
						}
						
						//Calculate Matching Score
						if(queryExecutionPricePosition >0 && serviceExecutionPricePosition  >0){
							executionPriceMatchingScore = getQosMatchingScore(queryExecutionPricePosition,serviceExecutionPricePosition);
							if(executionPriceMatchingScore >0){
								totalQosMatchingScore = totalQosMatchingScore + executionPriceMatchingScore;
							}
						}
					}
					
					// Process Reliability
					if(reliabilityList.size() >0){
						
						// Process Query Input
						queryReliability = reliabilityList.get(queryQosList.get(Reliability));
						if (queryReliability != null){
							queryReliabilityPosition = queryReliability.getPosition();
						}
								
						// Process Service Input
						serviceReliability = reliabilityList.get(serviceQosList.get(Reliability));
						if(serviceReliability!=null){
							serviceReliabilityPosition = serviceReliability.getPosition();
						}
						
						//Calculate Matching Score
						if(queryReliabilityPosition >0 && serviceReliabilityPosition  >0){
							reliabilityMatchingScore = getQosMatchingScore(queryReliabilityPosition,serviceReliabilityPosition);
							if(reliabilityMatchingScore >0){
								totalQosMatchingScore = totalQosMatchingScore + reliabilityMatchingScore;
							}
						}
					}
				}
			}
			catch(Exception ex){
				
			}
			return totalQosMatchingScore;
		}
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param qosProfileUrl
		 * @return
		 */
		public static OWLIndividual getQosProviderProfileInstance(OWLNamedIndividual owlNamedIndividual, String qosProfileUrl){
			
			boolean isQosProviderProfileType = false;
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLIndividual owlQosProviderProfileInstance = null;
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> qosProviderProfileIndividualList = null;
			
			try{
				if(!qosProfileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(qosProfileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.QosProfile.hasQoSProviderProfile);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.QosProfile.hasQoSProviderProfile));
						if (owlObjectPropertyExpression != null){
							qosProviderProfileIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
							
							if (qosProviderProfileIndividualList.size()>0){
								for(OWLIndividual owlQosIndividual : qosProviderProfileIndividualList){
									
									OWLNamedIndividual owlQosNamedIndividual = owlQosIndividual.asOWLNamedIndividual();
									if(owlQosNamedIndividual !=null){
										isQosProviderProfileType = IsParameterType(owlQosNamedIndividual, qosProfileUrl, Owls.QosProfile.QoSProviderProfile);
										if(isQosProviderProfileType){
											owlQosProviderProfileInstance = owlQosIndividual;
											break;
										}
									}
									
								}
							}
						}
					}
				}
			}
			catch(Exception ex){
				owlQosProviderProfileInstance = null;
			}
			return owlQosProviderProfileInstance;
		}
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param qosProfileUrl
		 * @return
		 */
		public static boolean hasQosProviderProfile(OWLNamedIndividual owlNamedIndividual, String qosProfileUrl){
			
			boolean hasQosProviderProfile = false;
			boolean isQosProviderProfileType = false;
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> qosProviderProfileIndividualList = null;
			
			try{
				if(!qosProfileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(qosProfileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.QosProfile.hasQoSProviderProfile);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.QosProfile.hasQoSProviderProfile));
						if (owlObjectPropertyExpression != null){
							qosProviderProfileIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
							
							if (qosProviderProfileIndividualList.size()>0){
								for(OWLIndividual owlQosIndividual : qosProviderProfileIndividualList){
									
									OWLNamedIndividual owlQosNamedIndividual = owlQosIndividual.asOWLNamedIndividual();
									if(owlQosNamedIndividual !=null){
										isQosProviderProfileType = IsParameterType(owlQosNamedIndividual, qosProfileUrl, Owls.QosProfile.QoSProviderProfile);
										if(isQosProviderProfileType){
											hasQosProviderProfile = true;
											break;
										}
									}
									
								}
							}
						}
					}
				}
			}
			catch(Exception ex){
				hasQosProviderProfile = false;
			}
			return hasQosProviderProfile;
			
		}
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param qosProfileUrl
		 * @return
		 */
		public static OWLIndividual getQosPropertyInstance(OWLNamedIndividual owlNamedIndividual, String qosProfileUrl){
			
			boolean isQosPropertyType = false;
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLIndividual owlQosPropertyInstance = null;
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> qosProviderProfileIndividualList = null;
			
			try{
				if(!qosProfileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(qosProfileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.QosProfile.hasQoSProperty);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.QosProfile.hasQoSProperty));
						if (owlObjectPropertyExpression != null){
							qosProviderProfileIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
							
							if (qosProviderProfileIndividualList.size()>0){
								for(OWLIndividual owlQosIndividual : qosProviderProfileIndividualList){
									
									OWLNamedIndividual owlQosNamedIndividual = owlQosIndividual.asOWLNamedIndividual();
									if(owlQosNamedIndividual !=null){
										isQosPropertyType = IsParameterType(owlQosNamedIndividual, qosProfileUrl, Owls.QosProfile.QoSProperty);
										if(isQosPropertyType){
											owlQosPropertyInstance = owlQosIndividual;
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			catch(Exception ex){
				owlQosPropertyInstance = null;
			}
			return owlQosPropertyInstance;
		}
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param qosProfileUrl
		 * @return
		 */
		public static boolean hasQosProperty(OWLNamedIndividual owlNamedIndividual, String qosProfileUrl){
			
			boolean hasQosProperty = false;
			boolean isQosPropertyType = false;
			
			OWLOntology owlsOntology = null;
			OWLOntologyManager owlsOntologyManager = null;
			
			OWLDataFactory owlsDataFactory = null;
			java.util.Set<OWLIndividual> qosProviderProfileIndividualList = null;
			
			try{
				if(!qosProfileUrl.isEmpty()){
					owlsOntologyManager = createOwlsOntologyManager();
					if (owlsOntologyManager !=null){
						owlsOntology = createOwlsOntology(qosProfileUrl,false);
						owlsDataFactory = createOwlsDataFactory();
						
						//System.out.println(Owls.QosProfile.hasQoSProperty);
						OWLObjectPropertyExpression owlObjectPropertyExpression = owlsDataFactory.getOWLObjectProperty(IRI.create(Owls.QosProfile.hasQoSProperty));
						if (owlObjectPropertyExpression != null){
							qosProviderProfileIndividualList = owlNamedIndividual.getObjectPropertyValues(owlObjectPropertyExpression,owlsOntology);
							
							if (qosProviderProfileIndividualList.size()>0){
								for(OWLIndividual owlQosIndividual : qosProviderProfileIndividualList){
									
									OWLNamedIndividual owlQosNamedIndividual = owlQosIndividual.asOWLNamedIndividual();
									if(owlQosNamedIndividual !=null){
										isQosPropertyType = IsParameterType(owlQosNamedIndividual, qosProfileUrl, Owls.QosProfile.QoSProperty);
										if(isQosPropertyType){
											hasQosProperty = true;
											break;
										}
									}
									
								}
							}
						}
					}
				}
			}
			catch(Exception ex){
				hasQosProperty = false;
			}
			return hasQosProperty;
		}
		
		/**
		 * 
		 * @param owlNamedIndividual
		 * @param qosProfileUrl
		 * @param iri
		 * @return
		 */
		public static java.util.Set<OWLLiteral> getDataPropertyValueList(OWLNamedIndividual owlNamedIndividual,String qosProfileUrl, IRI iri){
			
			OWLOntology qosProfileOntology = null;
			java.util.Set<OWLLiteral> owlLiteralList = null;
			try{
				
				if(!qosProfileUrl.isEmpty()){
					qosProfileOntology = createOwlsOntology(qosProfileUrl,false);
					if(qosProfileOntology !=null){
						OWLDataPropertyExpression owlDataPropertyExpression = qosProfileOntology.getOWLOntologyManager().getOWLDataFactory().getOWLDataProperty(iri);
						owlLiteralList = owlNamedIndividual.getDataPropertyValues(owlDataPropertyExpression, qosProfileOntology);
						/*if (owlLiteralList.size() > 0) {
							for (OWLLiteral owldataLiteral : owlLiteralList) {
								System.out.println("Literal Value: " + owldataLiteral.toString());
							}
						}*/
					}
				}
			}
			catch(Exception ex){
				owlLiteralList = null;
			}
			return owlLiteralList;
		}
		
		
		/**
		 * 
		 * @return
		 */
		public static Map<String, ExecutionPrice> initializeExecutionPriceMapper(){
			
			
			try{
				// Low Execution Price
				ExecutionPrice lowExecutionPrice = new ExecutionPrice();
				lowExecutionPrice.setValue(DrugOntology.drugOntologyURI + "LowExecutionPrice");
				lowExecutionPrice.setCondition("ExecutionPrice and hasExecutionPrice some integer[<= 25]");
				lowExecutionPrice.setWeight(3);
				lowExecutionPrice.setUnit(executionPriceUnit);
				lowExecutionPrice.setPosition(1);
				executionPriceList.put(lowExecutionPrice.getValue(), lowExecutionPrice);
				
				// Medium Execution Price
				ExecutionPrice mediumExecutionPrice = new ExecutionPrice();
				mediumExecutionPrice.setValue(DrugOntology.drugOntologyURI + "MediumExecutionPrice");
				mediumExecutionPrice.setCondition("ExecutionPrice and hasExecutionPrice some integer[> 25] and integer[<=50]");
				mediumExecutionPrice.setWeight(2);
				mediumExecutionPrice.setUnit(executionPriceUnit);
				mediumExecutionPrice.setPosition(2);
				executionPriceList.put(mediumExecutionPrice.getValue(),mediumExecutionPrice);
				
				// High Execution Price
				ExecutionPrice highExecutionPrice = new ExecutionPrice();
				highExecutionPrice.setValue(DrugOntology.drugOntologyURI + "HighExecutionPrice");
				highExecutionPrice.setCondition("ExecutionPrice and hasExecutionPrice some integer[> 25] and integer[<=50]");
				highExecutionPrice.setWeight(1);
				highExecutionPrice.setUnit(executionPriceUnit);
				highExecutionPrice.setPosition(3);
				executionPriceList.put(highExecutionPrice.getValue(), highExecutionPrice);
			}
			catch(Exception ex){
				
			}
			
			return executionPriceList;
			
		}
		
		/**
		 * 
		 * @return
		 */
		public static Map<String, ResponseTime> initializeResponseTimeMapper(){
			
			
			try{
				
				// Low Response Time
				ResponseTime lowResponseTime = new ResponseTime();
				lowResponseTime.setValue(DrugOntology.drugOntologyURI + "LowResponseTime");
				lowResponseTime.setCondition("ResponseTime and hasResponseTime some integer[<= 5]");
				lowResponseTime.setWeight(3);
				lowResponseTime.setUnit(responseTimeUnit);
				lowResponseTime.setPosition(1);
				responseTimeList.put(lowResponseTime.getValue(), lowResponseTime);
				
				// Medium Response Time
				ResponseTime mediumResponseTime = new ResponseTime();
				mediumResponseTime.setValue(DrugOntology.drugOntologyURI + "MediumResponseTime");
				mediumResponseTime.setCondition("ResponseTime and hasResponseTime some integer[> 5] and integer[<= 15]");
				mediumResponseTime.setWeight(2);
				mediumResponseTime.setUnit(responseTimeUnit);
				mediumResponseTime.setPosition(2);
				responseTimeList.put(mediumResponseTime.getValue(), mediumResponseTime);
				
				// High Response Time 
				ResponseTime highResponseTime = new ResponseTime();
				highResponseTime.setValue(DrugOntology.drugOntologyURI + "HighResponseTime");
				highResponseTime.setCondition("ResponseTime and hasResponseTime some integer[> 5] and integer[<= 15]");
				highResponseTime.setWeight(2);
				highResponseTime.setUnit(responseTimeUnit);
				highResponseTime.setPosition(3);
				responseTimeList.put(highResponseTime.getValue(), highResponseTime);
			}
			catch(Exception ex){
				
			}
			return responseTimeList;
		}
		
		/**
		 * 
		 * @return
		 */
		public static Map<String, Reliability> initializeReliabilityMapper(){
			
			
			
			try{
			
				// Low Reliability
				Reliability lowReliability = new Reliability();
				lowReliability.setValue(DrugOntology.drugOntologyURI + "LowReliability");
				lowReliability.setCondition("Reliability and hasReliability some integer[>70] and integer[<= 80]");
				lowReliability.setWeight(1);
				lowReliability.setUnit(reliabilityPriceUnit);
				lowReliability.setPosition(1);
				reliabilityList.put(lowReliability.getValue(),lowReliability);
				
				// Medium Reliability
				Reliability mediumReliability = new Reliability();
				mediumReliability.setValue(DrugOntology.drugOntologyURI + "MediumReliability");
				mediumReliability.setCondition("Reliability and hasReliability some integer[>80] and integer[<= 90]");
				mediumReliability.setWeight(2);
				mediumReliability.setUnit(reliabilityPriceUnit);
				mediumReliability.setPosition(2);
				reliabilityList.put(mediumReliability.getValue(), mediumReliability);
				
				// High Reliability
				Reliability highReliability = new Reliability();
				highReliability.setValue(DrugOntology.drugOntologyURI + "HighReliability");
				highReliability.setCondition("Reliability and hasReliability some integer[>90]");
				highReliability.setWeight(3);
				highReliability.setUnit(reliabilityPriceUnit);
				highReliability.setPosition(3);
				reliabilityList.put(highReliability.getValue(), highReliability);
			}
			catch(Exception ex){
				
			}
			return reliabilityList;
		}
		
		public static String getResponseTimeByWeight(int weight){
			
			String responseTimeValue = null;
			
			try{
				
				if (weight >0){
					switch(weight){
						case 1:
							responseTimeValue = HighResponseTime;
							break;
						case 2:
							responseTimeValue = MediumResponseTime;
							break;
						case 3:
							responseTimeValue = LowResponseTime;
							break;
						default:
							responseTimeValue = FailResponseTime;
					}
				}
				else{
					responseTimeValue = FailResponseTime;
				}
			}
			catch(Exception ex){
				responseTimeValue = FailResponseTime;
			}
			
			return responseTimeValue;	
		}
		
		/**
		 * 
		 * @param condition
		 * @return
		 */
		public static String getResponseTimeByCondition(String condition){
			
			String responseTimeValue = null;
			try{
				
				if (!condition.isEmpty()){
					
					if(condition.equals("ResponseTime and hasResponseTime some integer[<= 5]")){
						responseTimeValue = LowResponseTime;
					}
					else if(condition.equals("ResponseTime and hasResponseTime some integer[> 5] and integer[<= 15]")){
						responseTimeValue = MediumResponseTime;
					}
					else if (condition.equals("ResponseTime and hasResponseTime some integer[> 15] and integer[<=60]")){
						responseTimeValue = HighResponseTime;
					}
					else{
						responseTimeValue = FailResponseTime;
					}
						
				}
			}
			catch(Exception ex){
				responseTimeValue = FailResponseTime;
			}
			return responseTimeValue;
		}
		
		public static String getExecutionPriceByWeight(int weight){
			
			String executionPriceValue = null;
			
			try{
				
				if(weight >0){
					switch(weight){
						case 1:
							executionPriceValue = HighExecutionPrice;
							break;
						case 2:
							executionPriceValue = MediumExecutionPrice;
							break;
						case 3:
							executionPriceValue = LowExecutionPrice;
							break;
						default:
							executionPriceValue = FailExecutionPrice;
					}
				}
				else{
					executionPriceValue = FailExecutionPrice;
				}
			}
			catch(Exception ex){
				executionPriceValue = FailExecutionPrice;
			}
			
			return executionPriceValue;
		}
		/**
		 * 
		 * @param condition
		 * @return
		 */
		public static String getExecutionPriceByCondition(String condition){
			
			String executionPriceValue = null;
			try{
				
				if(!condition.isEmpty()){
					
					if(condition.equals("ExecutionPrice and hasExecutionPrice some integer[<= 25]")){
						executionPriceValue = LowExecutionPrice;
					}
					else if(condition.equals("ExecutionPrice and hasExecutionPrice some integer[> 25] and integer[<=50]")){
						executionPriceValue = MediumExecutionPrice;
					}
					else if(condition.equals("ExecutionPrice and hasExecutionPrice some integer[> 50] and integer[<=100]")){
						executionPriceValue = HighExecutionPrice;
					}
					else{
						executionPriceValue = FailExecutionPrice;
					}
				}
			}
			catch(Exception ex){
				executionPriceValue = FailExecutionPrice;
			}
			return executionPriceValue;
		}
		
		public static String getReliabilityByWeight(int weight){
			
			String reliabilityValue = null;
			
			try{
				
				if (weight >0){
					
					switch(weight){
					case 1:
						reliabilityValue = LowReliability;
						break;
					case 2:
						reliabilityValue = MediumReliability;
						break;
					case 3:
						reliabilityValue = HighReliability;
						break;
					default:
						reliabilityValue = FailReliability;
						break;
					}
				}
				else{
					reliabilityValue = FailReliability;
				}
			}
			catch(Exception ex){
				reliabilityValue = FailReliability;
			}
			
			return reliabilityValue;
		}
		public static String getReliabilityByCondition(String condition){
			
			String reliabilityValue = null;
			
			try{
				
				if(!condition.isEmpty()){
					
					if(condition.equals("Reliability and hasReliability some integer[>70] and integer[<= 80]")){
						reliabilityValue = LowReliability;
					}
					else if(condition.equals("Reliability and hasReliability some integer[>80] and integer[<= 90]")){
						reliabilityValue = MediumReliability;
					}
					else if(condition.equals("Reliability and hasReliability some integer[>90]")){
						reliabilityValue = HighReliability;
					}
					else{
						reliabilityValue = FailReliability;
					}
				}
			}
			catch(Exception ex){
				reliabilityValue = FailReliability;
			}
			
			return reliabilityValue;
		}
		
		public static Map<String, String> getParsedQosList(String input, String separator){
	    	
	    	String[] splittedList;
	    	//String processedItem;
	    	
	    	int positionSpecificWeight=3;
	    	String qosValue = null;
	    	
	    	String qosType = null;
	    	
	    	//ArrayList<String> processedList = new ArrayList<String>();
	    	Map<String, String> qosInputList = new HashMap<String, String>();
	    	
	    	try{
	    	
	    		if(!input.isEmpty()){
	    			splittedList = input.split(separator);
	    			if(splittedList.length >0){
	    				for(int index=0;index<splittedList.length;index++){
	    					
	    					String value = splittedList[index];
	    					
	    					if(!value.isEmpty()){
	    						String[] splittedString = value.split(":");
	    						qosType = splittedString[0];
	    						qosValue = splittedString[1];
	    						
	    						if(qosType.equals(ResponseTime)){
	    							qosInputList.put(ResponseTime, qosValue + ResponseTime);
	    						}
	    					
	    						if(qosType.equals(ExecutionPrice)){
		    						qosInputList.put(ExecutionPrice, qosValue + ExecutionPrice);
		    					}
	    						
	    						if(qosType.equals(Reliability)){
		    						qosInputList.put(Reliability, qosValue + Reliability);
		    					}
	    					}
	    					
	    					/*if(value.equals(ResponseTime)){
	    						qosValue = getResponseTimeByWeight(positionSpecificWeight);
	    						qosInputList.put(ResponseTime, qosValue + ResponseTime);
	    					}
	    					
	    					if(value.equals(ExecutionPrice)){
	    						qosValue = getExecutionPriceByWeight(positionSpecificWeight);
	    						qosInputList.put(ExecutionPrice, qosValue + ExecutionPrice);
	    					}
	    					
	    					if(value.equals(Reliability)){
	    						qosValue = getReliabilityByWeight(positionSpecificWeight);
	    						qosInputList.put(Reliability, qosValue + Reliability);
	    					}
	    					positionSpecificWeight = positionSpecificWeight-1;*/
	    					
	    					
	    					//System.out.println(value);
	    					
	    					//processedItem = DrugOntology.drugOntologyURI + splittedList[index];
	    					//processedList.add(processedItem);
	    				}
	    			}
	    		}
	    	}
	    	catch(Exception ex){
	    		qosInputList = null;
	    	}
	    	return qosInputList;
	    }
		
		private static int getQosMatchingScore(int queryResponseTimePosition,int serviceResponseTimePosition) {
			
			int matchingScore = 0;
			try{
				
				if (serviceResponseTimePosition - queryResponseTimePosition == 0){
					matchingScore = QosExcellent;
				}
				else if(Math.abs(serviceResponseTimePosition - queryResponseTimePosition) == 1){
					matchingScore = QosGood; 
				}
				else if(Math.abs(serviceResponseTimePosition - queryResponseTimePosition) == 2){
					matchingScore = QosBad;
				}
				else{
					matchingScore = QosFail;
				}
				
			}
			catch(Exception ex){
				matchingScore = 0;
			}
			
			return matchingScore;
		}
}
