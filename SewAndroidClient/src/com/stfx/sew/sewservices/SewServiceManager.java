package com.stfx.sew.sewservices;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.stfx.sew.datamodel.ServiceDiscoveryRequest;
import com.stfx.sew.responsemodel.Appointment;
import com.stfx.sew.responsemodel.Caregiver;
import com.stfx.sew.responsemodel.Consult;
import com.stfx.sew.responsemodel.ConsultServiceResponse;
import com.stfx.sew.responsemodel.DiscoverCareGiverServiceResponse;
import com.stfx.sew.responsemodel.DiscoverPatientServiceResponse;
import com.stfx.sew.responsemodel.DiscoverPhysicianServiceResponse;
import com.stfx.sew.responsemodel.Explanation;
import com.stfx.sew.responsemodel.ExplanationServiceResponse;
import com.stfx.sew.responsemodel.OwlsService;
import com.stfx.sew.responsemodel.OwlsServiceList;
import com.stfx.sew.responsemodel.Patient;
import com.stfx.sew.responsemodel.Physician;
import com.stfx.sew.responsemodel.Service;
import com.stfx.sew.responsemodel.ServiceResponse;
import com.stfx.sew.responsemodel.SetupAppointmentServiceResponse;
import com.stfx.sew.util.AllUrls;

/**
 * 
 * @author Mostafijur Rahman
 *
 */
public class SewServiceManager {
	
	/**
	 * 
	 * @return
	 */
	public static OwlsServiceList getAllOwlsServices(){
		
		String constructedServiceUrl = null;
		OwlsService owlsService = null;
		OwlsServiceList owlsServiceListInstance = null;
		ArrayList<OwlsService> owlsServices = new ArrayList<OwlsService>();
		
		
		try{
			
			constructedServiceUrl = AllUrls.getAllOwlsServiceUrl();
			if(!constructedServiceUrl.isEmpty()){
				
				SewHttpConnectionManager conManager = new SewHttpConnectionManager();
				JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
				
				if(response !=null){
					
					
					owlsServiceListInstance = new OwlsServiceList();
					int isOperationSuccessfull = response.getInt("isOperationSuccessfull");
					if(isOperationSuccessfull == 1){
						
						owlsServiceListInstance.setIsOperationSuccessfull(isOperationSuccessfull);
						int isResult = response.getInt("isResult");
						
						if(isResult == 1){
							
							owlsServiceListInstance.setIsResult(isResult);
							JSONArray resultSet = response.getJSONArray("owlsServiceList");
							if(resultSet.length() >0){
								
								for(int i=0;i <resultSet.length();i++){
									
									owlsService = new OwlsService();
									JSONObject tempObj =	resultSet.getJSONObject(i);
									
									if(tempObj.getString("id") !=null){
										owlsService.setId(Integer.parseInt(tempObj.getString("id")));
										
									}
									
									if(tempObj.getString("rootServiceUrl")!=null){
										owlsService.setRootServiceUrl(tempObj.get("rootServiceUrl").toString());
									}
									
									if(tempObj.getString("serviceDescription") !=null){
										owlsService.setServiceDescription(tempObj.getString("serviceDescription").toString());
									}
									
									if(tempObj.getString("serviceName") !=null){
										owlsService.setServiceName(tempObj.getString("serviceName"));
									}
									
									if(tempObj.getString("serviceProvider") !=null){
										owlsService.setServiceProvider(tempObj.getString("serviceProvider"));
									}
									
									owlsServices.add(owlsService);
								}
								owlsServiceListInstance.setOwlsServiceList(owlsServices);
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsServiceListInstance;
	}

	/**
	 * 
	 * @param serviceDiscoveryRequest
	 * @return
	 */
	public static ServiceResponse getHpcServicesByServiceDiscoveryRequest(ServiceDiscoveryRequest serviceDiscoveryRequest){
		
		Service service = null;
		ArrayList<Service> matchedServiceList = null;
		
		ServiceResponse serviceResponse = null;
		String constructedServiceUrl = null;
		
		try{
		
			if(serviceDiscoveryRequest !=null){
				
				constructedServiceUrl = AllUrls.getHpcServiceDiscoveryUrl(serviceDiscoveryRequest);
				
				if(constructedServiceUrl !=null){
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								
								JSONArray resultSet = response.getJSONArray("serviceList");
								if(resultSet.length() >0){
									matchedServiceList = new ArrayList<Service>();
									for(int i=0;i <resultSet.length();i++){
										
										service = new Service();
										JSONObject tempObj =	resultSet.getJSONObject(i);
										
										if(tempObj.getString("id")!=null){
											service.setId(Integer.parseInt(tempObj.getString("id")));
										}
											
										if(tempObj.getString("inputOutputScore")!=null){
											service.setInputOutputScore(Integer.parseInt(tempObj.getString("inputOutputScore")));
										}
										
										if(tempObj.getString("qosScore")!=null){
											service.setQosScore(Integer.parseInt(tempObj.getString("qosScore")));
										}
										
										if(tempObj.getString("serviceName")!=null){
											service.setServiceName(tempObj.getString("serviceName"));
										}
										
										if(tempObj.getString("serviceProvider")!=null){
											service.setServiceProvider(tempObj.getString("serviceProvider"));
										}
										
										if(tempObj.getString("totalScore")!=null){
											service.setTotalScore(Integer.parseInt(tempObj.getString("inputOutputScore")), Integer.parseInt(tempObj.getString("qosScore")));
										}
										matchedServiceList.add(service);
									}
								}
							
							   // Populate ServiceResponse object
								serviceResponse = new ServiceResponse();
								serviceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
								serviceResponse.setIsResult(isResult);
								serviceResponse.setSerivceList(matchedServiceList);
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return serviceResponse;
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static DiscoverPatientServiceResponse ExecuteDiscoverPatientService(int serviceId){
		
		Patient patient = null;
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		DiscoverPatientServiceResponse discoverPatientServiceResponse = null;
		
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteDiscoverPatientServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							
							discoverPatientServiceResponse = new DiscoverPatientServiceResponse();
							discoverPatientServiceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								
								discoverPatientServiceResponse.setIsResult(isResult);
								JSONArray resultSet = response.getJSONArray("patientList");
								if(resultSet.length() >0){
									for(int i=0;i <resultSet.length();i++){
										patient = new Patient();
										JSONObject jsonObject = resultSet.getJSONObject(i);
										
										if(jsonObject !=null){
											
											// conceptType
											if(jsonObject.getString("conceptType") !=null){
												patient.setConceptType(jsonObject.getString("conceptType"));
											}
											
											// ontologyIRI
											if(jsonObject.getString("ontologyIRI") !=null){
												patient.setOntologyIRI(jsonObject.getString("ontologyIRI"));
											}
											
											// patientName
											if(jsonObject.getString("patientName") !=null){
												patient.setPaitentName(jsonObject.getString("patientName"));
											}
										}
										patientList.add(patient);
									}
									discoverPatientServiceResponse.setPatientList(patientList);
								}
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		return discoverPatientServiceResponse;
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static DiscoverPhysicianServiceResponse ExecuteDiscoverPhysicianService(int serviceId){
		
		Physician physician = null;
		ArrayList<Physician>  physicianList = new ArrayList<Physician>();
		
		DiscoverPhysicianServiceResponse discoverPhysicianServiceResponse = null;
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteDiscoverPhysicianServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							discoverPhysicianServiceResponse = new DiscoverPhysicianServiceResponse();
							discoverPhysicianServiceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
							
							boolean isResult = response.getBoolean("isResult");
							if(isResult){
								discoverPhysicianServiceResponse.setIsResult(isResult);
								
								JSONArray resultSet = response.getJSONArray("physicianList");
								if(resultSet.length() >0){
									for(int i=0;i <resultSet.length();i++){
										physician = new Physician();
										JSONObject jsonObject = resultSet.getJSONObject(i);
										
										if(jsonObject !=null){
											
											// conceptType
											if(jsonObject.getString("conceptType") !=null){
												physician.setConceptType(jsonObject.getString("conceptType"));
											}
											
											// ontologyIRI
											if(jsonObject.getString("ontologyIRI") !=null){
												physician.setOntologyIRI(jsonObject.getString("ontologyIRI"));
											}
											
											// physicianName
											if(jsonObject.getString("physicianName") !=null){
												physician.setPhysicianName(jsonObject.getString("physicianName"));
											}
										}
										physicianList.add(physician);
									}
									discoverPhysicianServiceResponse.setPhysicianList(physicianList);
								}
								
							}
						}
					}
				}
			}
		}
		catch(Exception ex){
			
		}
		return discoverPhysicianServiceResponse;
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static SetupAppointmentServiceResponse ExecuteSetupAppointmentService(int serviceId){
		
		Appointment appointment = null;
		SetupAppointmentServiceResponse setupAppointmentServiceResponse = null;
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteSetupAppointmentServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							setupAppointmentServiceResponse = new SetupAppointmentServiceResponse();
							setupAppointmentServiceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
							
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								
								appointment = new Appointment();
								setupAppointmentServiceResponse.setIsResult(isResult);
								JSONObject jsonObject = response.getJSONObject("appointment");
								
								if(jsonObject !=null){
									
									// conceptType
									if(jsonObject.getString("appointmentName") !=null){
										appointment.setAppointmentName(jsonObject.getString("appointmentName"));
									}
									
									// ontologyIRI
									if(jsonObject.getString("isAppointmentSetup") !=null){
										appointment.setIsAppointmentSetup(jsonObject.getBoolean("isAppointmentSetup"));
									}
								}
								
								setupAppointmentServiceResponse.setAppointment(appointment);
							}
						}
					}
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return setupAppointmentServiceResponse;
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static ConsultServiceResponse ExecuteConsultService(int serviceId){
		
		Consult consult = null;
		ConsultServiceResponse consultServiceResponse = null;
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteConsultServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							
							consult = new Consult();
							consultServiceResponse = new ConsultServiceResponse();
							consultServiceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								
								consultServiceResponse.setIsResult(isResult);
								JSONObject jsonObject = response.getJSONObject("consultationResult");
								
									if(jsonObject !=null){
										
										// conceptType
										if(jsonObject.getString("conceptType") !=null){
											consult.setConceptType(jsonObject.getString("conceptType"));
										}
										
										// isConsulted
										if(jsonObject.getString("isConsulted") !=null){
											consult.setIsConsulted(jsonObject.getBoolean("isConsulted"));
										}
										
										// isEligible
										if(jsonObject.getString("isEligble") !=null){
											consult.setIsEligible(jsonObject.getBoolean("isEligble"));
										}
									}
									consultServiceResponse.setConsultationResult(consult);
								
							}
						}
					}
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return consultServiceResponse;
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static DiscoverCareGiverServiceResponse ExecuteDiscoverCaregiverService(int serviceId){
		
		Caregiver caregiver = null;
		ArrayList<Caregiver> caregiverList = new ArrayList<Caregiver>();
		
		DiscoverCareGiverServiceResponse discoverCaregiverServiceResponse = null;
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteDiscoverCaregiverServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							discoverCaregiverServiceResponse = new DiscoverCareGiverServiceResponse();
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								discoverCaregiverServiceResponse.setIsResult(isResult);
								
								JSONArray resultSet = response.getJSONArray("careGiver");
								if(resultSet.length() >0){
									for(int i=0;i <resultSet.length();i++){
										caregiver = new Caregiver();
										JSONObject jsonObject = resultSet.getJSONObject(i);
										
										if(jsonObject !=null){
											
											// conceptType
											if(jsonObject.getString("conceptType") !=null){
												caregiver.setConceptType(jsonObject.getString("conceptType"));
											}
											
											// ontologyIRI
											if(jsonObject.getString("ontologyIRI") !=null){
												caregiver.setOntologyIRI(jsonObject.getString("ontologyIRI"));
											}
											
											// careGiverName
											if(jsonObject.getString("careGiverName") !=null){
												caregiver.setCaregiverName(jsonObject.getString("careGiverName"));
											}
										}
										caregiverList.add(caregiver);
									}
									discoverCaregiverServiceResponse.setCareGiver(caregiverList);
								}
							}
						}
					}
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return discoverCaregiverServiceResponse;
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static ExplanationServiceResponse ExecuteExplanationService(int serviceId){
		
		Explanation explanation = null;
		ExplanationServiceResponse explanationServiceResponse = null;
		String constructedServiceUrl = null;
		
		try{
			
			if(serviceId >0){
				constructedServiceUrl = AllUrls.getExecuteExplanationServiceUrl(serviceId);
				if(constructedServiceUrl !=null){
					
					SewHttpConnectionManager conManager = new SewHttpConnectionManager();
					JSONObject response = conManager.httpGetConnection2(constructedServiceUrl);
					
					if(response !=null){
						boolean isOperationSuccessfull = response.getBoolean("isOperationSuccessfull");
						if(isOperationSuccessfull){
							
							explanationServiceResponse = new ExplanationServiceResponse();
							explanationServiceResponse.setIsOperationSuccessfull(isOperationSuccessfull);
							
							boolean isResult = response.getBoolean("isResult");
							
							if(isResult){
								
								explanation = new Explanation();
								JSONObject jsonObject = response.getJSONObject("explanation");
								
								if(jsonObject !=null){
									if(jsonObject !=null){
										
										// conceptType
										if(jsonObject.getString("conceptType") !=null){
											explanation.setConceptType(jsonObject.getString("conceptType"));
										}
										
										// Description
										if(jsonObject.getString("description") !=null){
											explanation.setDescription(jsonObject.getString("description"));
										}
										
										// isConsulted
										if(jsonObject.getString("isExplained") !=null){
											explanation.setIsExplained(jsonObject.getBoolean("isExplained"));
										}
										
										// Description
										if(jsonObject.getString("ontologyIRI") !=null){
											explanation.setOntologyIRI(jsonObject.getString("ontologyIRI"));
										}
									}
									
									explanationServiceResponse.setExplanation(explanation);
								}
							}
						}
					}
				}
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return explanationServiceResponse;
		
	}
}
