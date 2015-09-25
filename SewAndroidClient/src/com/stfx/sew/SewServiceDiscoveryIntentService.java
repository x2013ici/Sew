package com.stfx.sew;

import java.util.ArrayList;

import com.stfx.sew.AutoWorkflowExecutionActivity.SewServiceDiscoveryResultReceiver;
import com.stfx.sew.BlockingQueueActivity.SewWebRequestReceiver;
import com.stfx.sew.datamodel.ConfiguredTask;
import com.stfx.sew.datamodel.NovaTask;
import com.stfx.sew.datamodel.ServiceDiscoveryRequest;
import com.stfx.sew.datamodel.TaskSpecification;
import com.stfx.sew.manager.AppManager;
import com.stfx.sew.manager.WorkflowExecutionManager;
import com.stfx.sew.responsemodel.Caregiver;
import com.stfx.sew.responsemodel.Consult;
import com.stfx.sew.responsemodel.ConsultServiceResponse;
import com.stfx.sew.responsemodel.DiscoverCareGiverServiceResponse;
import com.stfx.sew.responsemodel.DiscoverPatientServiceResponse;
import com.stfx.sew.responsemodel.DiscoverPhysicianServiceResponse;
import com.stfx.sew.responsemodel.ExplanationServiceResponse;
import com.stfx.sew.responsemodel.OwlsServiceList;
import com.stfx.sew.responsemodel.Patient;
import com.stfx.sew.responsemodel.Physician;
import com.stfx.sew.responsemodel.Service;
import com.stfx.sew.responsemodel.ServiceResponse;
import com.stfx.sew.responsemodel.SetupAppointmentServiceResponse;
import com.stfx.sew.sewservices.SewServiceManager;

import android.app.IntentService;
import android.content.Intent;
import android.text.format.DateFormat;

public class SewServiceDiscoveryIntentService extends IntentService{

	
	/*public static final String REQUEST_STRING = "myRequest";
    public static final String RESPONSE_STRING = "myResponse";
    public static final String RESPONSE_MESSAGE = "myResponseMessage";*/
    
    /* Broadcasted Elements */
	public static final String SELECTED_PATIENT_NAME = "selectedpatientname";
	public static final String SELECTED_PHYSICIAN_NAME = "selectedphysicianname";
	public static final String IS_APPOINTMENT_SETUP = "isappointmentsetup";
	public static final String IS_CONSULTED = "isconsulted";
	public static final String IS_ELIGIBLE = "iseligible";
	
	public static final String SELECTED_CARE_GIVER = "selectedcaregiver";
	public static final String IS_DELIVERED_CARE = "isdeliveredcare";
	public static final String IS_EXPLAINED = "isexplained";
	public static final String IS_DRUG_PRESCRIBED = "isdrugprescribed";
	
	public static final String REQUESTED_TASK_ID = "requestedtaskid";
    public static final String REQUESTED_TASK_NAME = "requestedtaskname";
    
    public static final String RESPONSE_TASK_NAME = "responsetaskname";
    public static final String RESPONSE_TASK_ID = "responsetaskid";
    public static final String RESPONSE_TASK_EXECUTION_TIME = "responsetimeexecutiontime";
 
    private String SERVICE_URL = null;
    private static final int REGISTRATION_TIMEOUT = 3 * 1000;
    private static final int WAIT_TIMEOUT = 30 * 1000;
	
	public SewServiceDiscoveryIntentService(){
		super("SewServiceDiscoveryIntentService");
	}
	
	public SewServiceDiscoveryIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		int defaultValue = 0;
		int requestedTaskId = 0;
		String requestedTaskName = null;
		
		Service topRankedService = null;
		ServiceResponse serviceResponse = null;
		TaskSpecification taskSpecification = null;
		
		
		NovaTask novaTask = null;
		ConfiguredTask configuredTask = null;
		
		boolean isEligibleTasktoExecute = false;
		ServiceDiscoveryRequest serviceDiscoveryRequest = null;
		
		try{
			
			requestedTaskId = intent.getIntExtra(REQUESTED_TASK_ID, defaultValue);
			requestedTaskName = intent.getStringExtra(REQUESTED_TASK_NAME);
			
			if(requestedTaskId >0){
				
				novaTask = AppManager.hpcOverallWorkflowTaskList.get(requestedTaskId);
				
				if(novaTask !=null){
					if(novaTask.getNovaBranchOrder() !=null){
						if(WorkflowExecutionManager.IsConsulted && WorkflowExecutionManager.IsEligible){
							if(WorkflowExecutionManager.SelectedBranchNumber >0){
								if(WorkflowExecutionManager.SelectedBranchNumber == novaTask.getNovaBranchOrder().getBranchOrderId()){
									isEligibleTasktoExecute = true;
								}
								else{
									isEligibleTasktoExecute = false;
								}
							}
						}
						else{
							isEligibleTasktoExecute = true;
						}
					}
					else{
						isEligibleTasktoExecute = true;
					}
				}
				else{
					isEligibleTasktoExecute = false;
				}
			}
			
			if(isEligibleTasktoExecute){
				
				if(!requestedTaskName.isEmpty()){
					
					configuredTask = AppManager.workflowSpecificConfiguredTaskList.get(requestedTaskName);
					
					if(configuredTask !=null){
						
						taskSpecification = configuredTask.getTaskSpecification();
						if(taskSpecification !=null){
							
							/* Disabled Temporarily*/
							/*serviceDiscoveryRequest = WorkflowExecutionManager.getConstructedServiceDiscoveryRequest(taskSpecification);
							serviceResponse = SewServiceManager.getHpcServicesByServiceDiscoveryRequest(serviceDiscoveryRequest);
							if(serviceResponse !=null){
								
								if(serviceResponse.getServiceList().size() >0){
									*//**
									 * Pick the top ranked service from the list and execute the selected service
									 * Fetch Task Behavior of current task and use the service execution result accordingly
									 *//*
									topRankedService = serviceResponse.getServiceList().get(WorkflowExecutionManager.TOP_RANKED_SERVICE_INDEX);
									
									if(requestedTaskId >0){
										ProcessHpcOverallWorkflowTasks(topRankedService, requestedTaskId,requestedTaskName);
									}
								}
							}*/
							
							/* End of Core Service Discovery and Execution Task */
							
							/* Code for Functional Prototype */
							serviceDiscoveryRequest = WorkflowExecutionManager.getConstructedServiceDiscoveryRequest(taskSpecification);
							SewServiceManager.getHpcServicesByServiceDiscoveryRequest(serviceDiscoveryRequest);
							
							if(requestedTaskId >0){
								ProcessHpcOverallWorkflowTasks(topRankedService, requestedTaskId,requestedTaskName);
							}
							
							// Do not use Async thread within Intent Service
							/*if(serviceDiscoveryRequest !=null){
								WorkflowExecutionManager.DiscoverHpcSemanticWebServices(serviceDiscoveryRequest);
							}*/
							
							// Test Service call using default http client 
							/*OwlsServiceList owlsServiceInstance = SewServiceManager.getAllOwlsServices();
							if(owlsServiceInstance !=null){
								
							}*/
						}
					}
				}
			}
			
			/* Workflow Execution Ends with this task*/
			if(requestedTaskName.equals(WorkflowExecutionManager.FINISH_TASK_NAME)){
				ProcessHpcOverallWorkflowTasks(null, requestedTaskId,requestedTaskName);
			}
			
		}
		
		catch(Exception ex){
			
		}
	}
	
	/**
	 * 
	 * @param topRankedService
	 * @param taskId
	 * @param requestedTaskName
	 */
	private  void ProcessHpcOverallWorkflowTasks(Service topRankedService, int taskId, String requestedTaskName){
		
		int selectedServiceId = 0;
		String requestedTaskExecutionTime = "";
		try{
			
			// Initiate Broadcast
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction(SewServiceDiscoveryResultReceiver.PROCESS_RESPONSE);
			broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
				        
			switch(taskId){
				case 1:
					// Start: InputCondition
					// InputCondition type of task will not be passed to Background thread
					break;
				case 2:
					// OutputCondition: OutputCondition
					// OutputCondition type of task will not be passed to Background thread
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					sendBroadcast(broadcastIntent);
					break;
				case 3:
					// Discover_Select_Patient: UncompensableTask
					DiscoverPatientServiceResponse discoverPatientServiceResponse = SewServiceManager.ExecuteDiscoverPatientService(6);
					if(discoverPatientServiceResponse !=null){
						ArrayList<Patient> patientList = discoverPatientServiceResponse.getPatientList();
						if(patientList.size()>0){
							//WorkflowExecutionManager.SelectedPatient = "Martin Crow";
							WorkflowExecutionManager.SelectedPatient = patientList.get(WorkflowExecutionManager.TOP_RANKED_DATA_INDEX).getPatientName();
						}
						else{
							WorkflowExecutionManager.SelectedPatient = "";
						}
					}
					
					
					if(topRankedService !=null){
						
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
						
							/**
							 * Execute the service having the serviceId
							 * Get list of referred patient list
							 * Choose top ranked patient from the list
							 * Save this value to WorkflowExecutionManager.SelectedPatient variable
							 */
						}
					}
					
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(SELECTED_PATIENT_NAME,WorkflowExecutionManager.SelectedPatient);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
					
				case 4:
					// Discover_Select_Physician: UncompensableTask
					DiscoverPhysicianServiceResponse discoverPhysicianServiceResponse = SewServiceManager.ExecuteDiscoverPhysicianService(7);
					if(discoverPhysicianServiceResponse !=null){
						ArrayList<Physician> physicianList = discoverPhysicianServiceResponse.getPhysicianList();
						if(physicianList.size()>0){
							WorkflowExecutionManager.SelectedPhysician = physicianList.get(WorkflowExecutionManager.TOP_RANKED_DATA_INDEX).getPhysicianName();
						}
						else{
							WorkflowExecutionManager.SelectedPhysician = "";
						}
					}
					//WorkflowExecutionManager.SelectedPhysician = "Man Lin";
					
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service having the serviceId
							 * Get list of Referred Physicians
							 * Choose top ranked physician from the list
							 * Save this value to WorkflowExecutionManager.SelectedPhysician variable
							 */
						}
					}
					
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(SELECTED_PHYSICIAN_NAME,WorkflowExecutionManager.SelectedPhysician);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
					
				case 5:
					// Setup_Appointment: UncompensableTask
					SetupAppointmentServiceResponse setupAppointmentService = SewServiceManager.ExecuteSetupAppointmentService(8);
					if(setupAppointmentService !=null){
						WorkflowExecutionManager.IsSetupAppointment = setupAppointmentService.getAppointment().getIsAppointmentSetup();
					}
					else{
						WorkflowExecutionManager.IsSetupAppointment = false;
					}
					
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service having the serviceId
							 * Upon successful execution, the service will return Appointment object
							 * if Appointment != null set WorkflowExecutionManager.IsSetupAppointment to true 
							 * Otherwise set WorkflowExecutionManager.IsSetupAppointment to false
							 */
						}
					}
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(IS_APPOINTMENT_SETUP,WorkflowExecutionManager.IsSetupAppointment);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
					
				case 6:
					// Consult: UncompensableTask
					ConsultServiceResponse consultServiceResponse = SewServiceManager.ExecuteConsultService(9);
					if(consultServiceResponse !=null){
						Consult consult = consultServiceResponse.getConsultationResult();
						if(consult !=null){
							WorkflowExecutionManager.IsConsulted = consult.getIsConsulted();
							WorkflowExecutionManager.IsEligible = consult.getIsEligble();
							WorkflowExecutionManager.SelectedBranchNumber = 1;
						}
						else{
							WorkflowExecutionManager.IsConsulted = true;
							WorkflowExecutionManager.IsEligible = false;
							WorkflowExecutionManager.SelectedBranchNumber = 2;
						}
					}
										
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service having the serviceId
							 * Upon successful execution, the service will return Consult object
							 * if Consult != null set WorkflowExecutionManager.IsConsulted to true 
							 * Otherwise set WorkflowExecutionManager.IsConsulted to false
							 * Get Consult.IsEligible property and set it to WorkflowExecutionManager.IsEligible property
							 */
							
							// Handle Patient_Valid: XorSplitTask business logic here
							/**
							 * Check WorkflowExecutionManager.IsEligible property
							 * If WorkflowExecutionManager.IsEligible == true, set WorkflowExecutionManager.SelectedBranchNumber == 1
							 * Else set WorkflowExecutionManager.SelectedBranchNumber == 2  
							 */
						}
					}
					
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(IS_CONSULTED,WorkflowExecutionManager.IsConsulted);
					broadcastIntent.putExtra(IS_ELIGIBLE,WorkflowExecutionManager.IsEligible);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
				case 7:
					// Patient_Valid: XorSplitTask
					/**
					 * Patient_Valid task will not be passed to Background thread. This is just a ControlConstruct
					 */
					break;
				case 8:
					// Discover_Select_Caregiver: UncompensableTask
					DiscoverCareGiverServiceResponse discoverCaregiverServiceResponse = SewServiceManager.ExecuteDiscoverCaregiverService(10);
					if(discoverCaregiverServiceResponse !=null){
						ArrayList<Caregiver> caregiverList = discoverCaregiverServiceResponse.getCareGiver();
						if(caregiverList.size()>0){
							WorkflowExecutionManager.SelectedCareGiver = caregiverList.get(WorkflowExecutionManager.TOP_RANKED_DATA_INDEX).getCareGiverName();
						}
						else{
							WorkflowExecutionManager.SelectedCareGiver = "";
						}
					}
					//WorkflowExecutionManager.SelectedCareGiver = "Wendy MacCaull";
					
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service by passing the serviceId
							 * Get list of Caregivers
							 * Choose top ranked Caregiver from the list
							 * Save this value to WorkflowExecutionManager.SelectedCareGiver variable
							 */
						}
					}
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(SELECTED_CARE_GIVER,WorkflowExecutionManager.SelectedCareGiver);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
					
				case 9:
					// Explanation: UncompensableTask
					ExplanationServiceResponse explanationServiceResponse = SewServiceManager.ExecuteExplanationService(11);
					if(explanationServiceResponse !=null){
						if(explanationServiceResponse.getExplanation() !=null){
							WorkflowExecutionManager.IsExplained = explanationServiceResponse.getExplanation().getIsExplained();
						}
						else{
							WorkflowExecutionManager.IsExplained = false;
						}
					}
					else{
						WorkflowExecutionManager.IsExplained = true;
					}
					
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service by passing the serviceId
							 * Upon successful execution, the service will return Explanation object
							 * if Explanation != null set WorkflowExecutionManager.IsExplained to true 
							 * Otherwise set WorkflowExecutionManager.IsExplained to false
							 */
						}
					}
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(IS_EXPLAINED,WorkflowExecutionManager.IsExplained);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
				case 10:
					// Finished: XorJoinTask
					/**
					 * Finished task will not be passed to Background thread. This is just a ControlConstruct
					 */
					break;
				case 11:
					// Deliver_Care: UncompensableTask
					WorkflowExecutionManager.IsDeliveredCare = true;
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service by passing the serviceId
							 * Upon successful execution, the service will return DeliverCare object
							 * if DeliverCare != null set WorkflowExecutionManager.IsDeliveredCare to true 
							 * Otherwise set WorkflowExecutionManager.IsDeliveredCare to false
							 */
						}
					}
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(IS_DELIVERED_CARE,WorkflowExecutionManager.IsDeliveredCare);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					
					break;
				case 12:
					// Prescribe_Drugs: UncompensableTask
					WorkflowExecutionManager.IsPrescribedDrug = true;
					if(topRankedService !=null){
						selectedServiceId = topRankedService.getId();
						if(selectedServiceId >0){
							
							/**
							 * Execute the service by passing the serviceId
							 * Upon successful execution, the service will return PrescribedDrug object
							 * if PrescribedDrug != null set WorkflowExecutionManager.IsPrescribedDrug to true 
							 * Otherwise set WorkflowExecutionManager.IsPrescribedDrug to false
							 */
						}
					}
					requestedTaskExecutionTime = requestedTaskName + " executed at:" + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
					broadcastIntent.putExtra(RESPONSE_TASK_ID, taskId);
					broadcastIntent.putExtra(IS_DRUG_PRESCRIBED,WorkflowExecutionManager.IsPrescribedDrug);
					broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
					sendBroadcast(broadcastIntent);
					break;
				default:
					break;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param taskId
	 */
	/*private  void ProcessHpcSequencialWorkflowTasks(Service topRankedService, int taskId,String requestedTaskName){
		
		try{
			
			switch(taskId){
				case 1:
					// Start: InputCondition
					// InputCondition type of task will not be passed to Background thread
					break;
				case 2:
					// OutputCondition: OutputCondition
					// OutputCondition type of task will not be passed to Background thread
					break;
				case 3:
					// ReceiveReferral: UncompensableTask
					break;
				case 4:
					// Appoinment: UncompensableTask
					break;
				case 5:
					// Consult: UncompensableTask
					break;
				default:
					break;
			}
			
			//  Broadcast Result
			String requestedTaskExecutionTime = requestedTaskName + " " + DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
	        Intent broadcastIntent = new Intent();
	        broadcastIntent.setAction(SewServiceDiscoveryResultReceiver.PROCESS_RESPONSE);
	        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
	        
	        broadcastIntent.putExtra(RESPONSE_TASK_NAME, requestedTaskName);
	        broadcastIntent.putExtra(RESPONSE_TASK_EXECUTION_TIME, requestedTaskExecutionTime);
	        sendBroadcast(broadcastIntent);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
}
