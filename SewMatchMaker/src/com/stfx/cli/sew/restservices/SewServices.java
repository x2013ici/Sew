package com.stfx.cli.sew.restservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.stfx.cli.sew.datamodels.InputModel;
import com.stfx.cli.sew.datamodels.InputModelResponse;
import com.stfx.cli.sew.datamodels.OwlsServiceList;
import com.stfx.cli.sew.datamodels.Service;
import com.stfx.cli.sew.datamodels.ServiceExecutionResponse;
import com.stfx.cli.sew.datamodels.ServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.Appointment;
import com.stfx.cli.sew.hpcdatamodels.Caregiver;
import com.stfx.cli.sew.hpcdatamodels.Consult;
import com.stfx.cli.sew.hpcdatamodels.ConsultServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.DiscoverCareGiverServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.DiscoverPatientServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.DiscoverPhysicianServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.Explanation;
import com.stfx.cli.sew.hpcdatamodels.ExplanationServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.Patient;
import com.stfx.cli.sew.hpcdatamodels.Physician;
import com.stfx.cli.sew.hpcdatamodels.SetupAppointmentServiceResponse;
import com.stfx.cli.sew.repository.HpcServiceDisocoveryHelper;
import com.stfx.cli.sew.repository.RepositoryHelper;
import com.stfx.cli.sew.repository.ServiceDiscoveryHelper;
import com.stfx.cli.sew.repository.ServiceRepositoryManager;
import com.stfx.cli.sew.services.OutputModel;

@Path("/")
public class SewServices {
	
	
	/*-----------Hospice Palliative Care Workflow and Drug Discovery Related Service End Points--------------*/
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/display")
	@Produces(MediaType.APPLICATION_JSON)
	public String DisplayMessage(){
		return "There is a difference between knowing the path and walking in the path!!!";
	}
	
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/getowlsservices")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OwlsServiceList getOwlsServiceList(){
		
		OwlsServiceList hpcWorkflowServiceListResponse = null;
		try{
			hpcWorkflowServiceListResponse =  ServiceRepositoryManager.getHpcWorkflowServiceList();
		}
		catch(Exception ex){
			
		}
		
		return hpcWorkflowServiceListResponse;
	}
	
	/**
	 * 
	 * @param input
	 * @param qos
	 * @param output
	 * @return
	 */
	@GET
	@Path("/gethpcservicelist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getHpcServiceList(
			@QueryParam("input") String input,
			@QueryParam("qos") String qos,
    		@QueryParam("output") String output)
    {
		
		InputModel result = null;
		ServiceResponse serviceResponse = new ServiceResponse();
		//ArrayList<Service> semanticWebServiceList = new ArrayList<Service>();
		ArrayList<Service> rankedSemanticWebServiceList = new ArrayList<Service>();
		
		try{
			
			if(!input.isEmpty() && !qos.isEmpty() && !output.isEmpty()){
				
				result = new InputModel();
				result.setInput(input);
				result.setQos(qos);
				result.setOutput(output);
				serviceResponse.setInputModel(result);
				
				serviceResponse = HpcServiceDisocoveryHelper.DiscoverSemanticWebServiceList(input, output, qos);
				
				/*if(serviceResponse != null && serviceResponse.getServiceList().size()>0){
					rankedSemanticWebServiceList = ServiceDiscoveryHelper.RankSemanticWebService(semanticWebServiceList);
				}*/
				
				if(serviceResponse.getServiceList().size()>0){
					serviceResponse.setIsOperationSuccessfull(true);
					serviceResponse.setIsResult(true);
					serviceResponse.setInputModel(result);
					serviceResponse.setSerivceList(serviceResponse.getServiceList());
				}
				else{
					serviceResponse.setIsOperationSuccessfull(true);
					serviceResponse.setIsResult(false);
					serviceResponse.setInputModel(result);
					serviceResponse.setSerivceList(null);
				}
			}
			else{
				serviceResponse.setIsResult(false);
				serviceResponse.setIsOperationSuccessfull(true);
				serviceResponse.setInputModel(result);
				serviceResponse.setSerivceList(null);
			}
		}
		catch(Exception ex){
			serviceResponse.setIsResult(false);
			serviceResponse.setIsOperationSuccessfull(true);
			serviceResponse.setInputModel(result);
			serviceResponse.setSerivceList(null);
		}
		return serviceResponse;
    }
	
	/**
	 * 
	 * @param input
	 * @param qos
	 * @param output
	 * @return
	 */
	@GET
	@Path("/getservicelist")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getServiceList(
			@QueryParam("input") String input,
			@QueryParam("qos") String qos,
    		@QueryParam("output") String output)
    {
		
		ServiceResponse serviceResponse = new ServiceResponse();
		ArrayList<Service> semanticWebServiceList = new ArrayList<Service>();
		ArrayList<Service> rankedSemanticWebServiceList = new ArrayList<Service>();
		
		try{
			
			if(!input.isEmpty() && !qos.isEmpty() && !output.isEmpty()){
				
				InputModel result = new InputModel();
				result.setInput(input);
				result.setQos(qos);
				result.setOutput(output);
				serviceResponse.setInputModel(result);
				
				// Owl-s Service Discovery Part
				/*matchedService = ServiceDiscoveryHelper.DiscoverSemanticWebService(input, output, qos);
				if(matchedService !=null){
					serviceList.add(matchedService);
				}*/
				
				semanticWebServiceList = ServiceDiscoveryHelper.DiscoverSemanticWebServiceList(input, output, qos);
				
				// Rank Web Service List
				rankedSemanticWebServiceList = ServiceDiscoveryHelper.RankSemanticWebService(semanticWebServiceList);
				
				//serviceList = RepositoryHelper.getServiceList();
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
	
	/**
	 * 
	 * @param inputModel
	 * @return
	 */
	@POST
	@Path("/getservices")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceResponse getService(InputModel inputModel){
		
		String input = null;
		String qos = null;
		String output = null;
		
		ServiceResponse serviceResponse = new ServiceResponse();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		
		try{
			
			if (inputModel !=null){
				input = inputModel.getInput();
				qos = inputModel.getQos();
				output = inputModel.getOutput();
				
				InputModel result = new InputModel();
				result.setInput(input);
				result.setQos(qos);
				result.setOutput(output);
				serviceResponse.setInputModel(result);
			}
			else{
				serviceResponse.setInputModel(null);
			}
			
			serviceList = RepositoryHelper.getServiceList();
			if(serviceList.size() >0){
				serviceResponse.setIsOperationSuccessfull(true);
				serviceResponse.setIsResult(true);
				serviceResponse.setSerivceList(serviceList);
			}
			else{
				serviceResponse.setIsOperationSuccessfull(true);
				serviceResponse.setIsResult(false);
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
	
	/**
	 * 
	 * @param inputModel
	 * @return
	 */
	@POST
	@Path("/getresponsemodel")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public InputModelResponse getResponseModel(InputModel inputModel){
		
		String input = null;
		String qos = null;
		String output = null;
		
		InputModelResponse inputModelResponse = new InputModelResponse();
		try{
			
			if (inputModel !=null){
				input = inputModel.getInput();
				qos = inputModel.getQos();
				output = inputModel.getOutput();
				
				InputModel result = new InputModel();
				result.setInput(input);
				result.setQos(qos);
				result.setOutput(output);
				
				inputModelResponse.setIsOperationSuccessfull(true);
				inputModelResponse.setIsResult(true);
				inputModelResponse.setInputModel(inputModel);
			}
			else{
				inputModelResponse.setIsResult(false);
				inputModelResponse.setIsOperationSuccessfull(false);
				inputModelResponse.setInputModel(null);
			}
		}
		catch(Exception ex){
			inputModelResponse.setIsResult(false);
			inputModelResponse.setIsOperationSuccessfull(true);
			inputModelResponse.setInputModel(null);
		}
		
		return inputModelResponse;
	}
	
	/*-----------Hospice Palliative Care Workflow and Drug Discovery Related Service Points End Here--------------*/
	/*-------------------------------------------------------------------------------------------------------------*/
	
	/* -----Hospice Palliative Care Workflow and Drug Discovery Service Execution Related End Points---------------*/
	/**/
	
	
	
	/**
	 * 
	 * Execute Drug Discovery Related Service
	 * @param serviceid
	 * @return
	 */
	@GET
	@Path("/executeservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceExecutionResponse ExecuteService(@QueryParam("serviceid") int serviceid){
		
		OutputModel outputModel = null;
		ServiceExecutionResponse executionServiceResponse = null;
		try{
			
			if(serviceid >0){
				
				outputModel = ServiceExecutionHelper.ExecuteServiceById(serviceid);
				if(outputModel!=null){
					executionServiceResponse = new ServiceExecutionResponse();
					executionServiceResponse.setIsResult(true);
					executionServiceResponse.setIsOperationSuccessfull(true);
					executionServiceResponse.setOutputModel(outputModel);
					executionServiceResponse.setMessage("Serivce Executed Successfully!!!");
				}
				else{
					executionServiceResponse = new ServiceExecutionResponse();
					executionServiceResponse.setIsResult(false);
					executionServiceResponse.setIsOperationSuccessfull(true);
					executionServiceResponse.setOutputModel(null);
					executionServiceResponse.setMessage("Failed to Execute Selected Service!!!");
				}
			}
			else{
				executionServiceResponse = new ServiceExecutionResponse();
				executionServiceResponse.setIsResult(false);
				executionServiceResponse.setIsOperationSuccessfull(false);
				executionServiceResponse.setOutputModel(null);
				executionServiceResponse.setMessage("Failed to Execute Selected Service!!!");
			}
		}
		catch(Exception ex){
			
		}
		return executionServiceResponse;
	}
	
	/**
	 * Discover Patient Service
	 * Service Id: 6
	 * @param serviceid
	 * @return
	 */
	@GET
	@Path("/executediscoverpatientservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DiscoverPatientServiceResponse ExecuteDiscoverPatientService(@QueryParam("serviceid") int serviceid,
						@QueryParam("careprogram") String careprogram,
						@QueryParam("distance") String distance,
						@QueryParam("pps") String pps){
		
		ArrayList<Patient> patientList = null;
		DiscoverPatientServiceResponse discoverPatientServiceResponse = null;
		
		try{
			
			if(!careprogram.isEmpty() &&  serviceid >0
					&& !distance.isEmpty() && !pps.isEmpty()){
				
				patientList = ServiceExecutionHelper.getReferredPatientList();
				if(patientList.size() >0){
					
					discoverPatientServiceResponse = new DiscoverPatientServiceResponse();
					discoverPatientServiceResponse.setIsOperationSuccessfull(true);
					discoverPatientServiceResponse.setIsResult(true);
					discoverPatientServiceResponse.setMessage("Service Executed Successfully!");
					discoverPatientServiceResponse.setPatientList(patientList);
				}
				else{
					discoverPatientServiceResponse = new DiscoverPatientServiceResponse();
					discoverPatientServiceResponse.setIsOperationSuccessfull(true);
					discoverPatientServiceResponse.setIsResult(false);
					discoverPatientServiceResponse.setMessage("Failed to get Patient list from the ontology");
					discoverPatientServiceResponse.setPatientList(null);
				}
			}
			else{
				discoverPatientServiceResponse = new DiscoverPatientServiceResponse();
				discoverPatientServiceResponse.setIsOperationSuccessfull(false);
				discoverPatientServiceResponse.setIsResult(false);
				discoverPatientServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
				discoverPatientServiceResponse.setPatientList(null);
			}
		}
		catch(Exception ex){
			
		}
		return discoverPatientServiceResponse;
	}
	
	/**
	 * Execute Discover Physician Service
	 * Service Id: 7
	 */
	
	@GET
	@Path("/executediscoverphysicianservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DiscoverPhysicianServiceResponse ExecuteDiscoverPhysicianService(@QueryParam("serviceid") int serviceid,
						@QueryParam("careprogram") String careprogram,
						@QueryParam("availability") String availability){
		
		ArrayList<Physician> physicianList = null;
		DiscoverPhysicianServiceResponse discoverPhysicianServiceResponse = null;
		
		try{
			
			if(!careprogram.isEmpty() && !availability.isEmpty() &&  serviceid > 0){
				physicianList = ServiceExecutionHelper.getPhysicianList();
				if(physicianList.size()>0){
					
					discoverPhysicianServiceResponse = new DiscoverPhysicianServiceResponse();
					discoverPhysicianServiceResponse.setIsOperationSuccessfull(true);
					discoverPhysicianServiceResponse.setIsResult(true);
					discoverPhysicianServiceResponse.setMessage("Service Executed Successfully!");
					discoverPhysicianServiceResponse.setPhysicianList(physicianList);
				}
				else{
					discoverPhysicianServiceResponse = new DiscoverPhysicianServiceResponse();
					discoverPhysicianServiceResponse.setIsOperationSuccessfull(true);
					discoverPhysicianServiceResponse.setIsResult(false);
					discoverPhysicianServiceResponse.setMessage("Failed to get Physician list from the Sew ontology");
					discoverPhysicianServiceResponse.setPhysicianList(null);
				}
			}
			else{
				
				discoverPhysicianServiceResponse = new DiscoverPhysicianServiceResponse();
				discoverPhysicianServiceResponse.setIsOperationSuccessfull(false);
				discoverPhysicianServiceResponse.setIsResult(false);
				discoverPhysicianServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
				discoverPhysicianServiceResponse.setPhysicianList(null);
				
			}
		}
		catch(Exception ex){
			
		}
		return discoverPhysicianServiceResponse;
		
	}
	
	/**
	 * Setup Appointment Service
	 * Service Id: 8
	 * @param patient
	 * @param physician
	 * @param serviceid
	 * @return
	 */
	@GET
	@Path("/executesetupappointmentservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SetupAppointmentServiceResponse ExecuteSetupAppointmentService(@QueryParam("patient") String patient,
							@QueryParam("physician") String physician,@QueryParam("serviceid") int serviceid){
								
		Appointment appointment = null;
		SetupAppointmentServiceResponse setupAppointmentServiceResponse = null;
		
		try{
			
			if(!patient.isEmpty() && !physician.isEmpty()){
				
				appointment = ServiceExecutionHelper.getSetupAppointment(patient,physician);
				if(appointment !=null){
					
					setupAppointmentServiceResponse = new SetupAppointmentServiceResponse();
					setupAppointmentServiceResponse.setIsOperationSuccessfull(true);
					setupAppointmentServiceResponse.setIsResult(true);
					setupAppointmentServiceResponse.setMessage("Service Executed Sucessfully");
					setupAppointmentServiceResponse.setAppointment(appointment);
					
				}
				else{
					setupAppointmentServiceResponse = new SetupAppointmentServiceResponse();
					setupAppointmentServiceResponse.setIsOperationSuccessfull(true);
					setupAppointmentServiceResponse.setIsResult(false);
					setupAppointmentServiceResponse.setMessage("Failed to get Appointment details for the patient");
					setupAppointmentServiceResponse.setAppointment(null);
				}
			}
			else{
				
				setupAppointmentServiceResponse = new SetupAppointmentServiceResponse();
				setupAppointmentServiceResponse.setIsOperationSuccessfull(true);
				setupAppointmentServiceResponse.setIsResult(false);
				setupAppointmentServiceResponse.setMessage("Failed to execute the service. Patient and Physician instances can not be nullable");
				setupAppointmentServiceResponse.setAppointment(null);
			}
			
		}
		catch(Exception ex){
			
		}
		
		return setupAppointmentServiceResponse;
	}
	
	
	
	/**
	 * Execute Consult Service
	 * Service Id: 9
	 * @param appointment
	 * @param serviceid
	 * @return
	 */
	@GET
	@Path("/executeconsultservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultServiceResponse ExecuteConsultService(@QueryParam("appointment") String appointment,
								@QueryParam("serviceid") int serviceid){
									
		Consult consult = null;
		ConsultServiceResponse consultServiceResponse = null;
		
		try{
			if(appointment !=null && serviceid >0){
				
				consult = ServiceExecutionHelper.getConsultationResult();
				if(consult !=null){
					
					consultServiceResponse = new ConsultServiceResponse();
					consultServiceResponse.setIsOperationSuccessfull(true);
					consultServiceResponse.setIsResult(true);
					consultServiceResponse.setMessage("Service Executed Successfully");
					consultServiceResponse.setConsultationResult(consult);
				}
				else{
					
					consultServiceResponse = new ConsultServiceResponse();
					consultServiceResponse.setIsOperationSuccessfull(false);
					consultServiceResponse.setIsResult(false);
					consultServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
					consultServiceResponse.setConsultationResult(null);
				}
				
			}
			else{
				consultServiceResponse = new ConsultServiceResponse();
				consultServiceResponse.setIsOperationSuccessfull(false);
				consultServiceResponse.setIsResult(false);
				consultServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
				consultServiceResponse.setConsultationResult(null);
			}
		}
		catch(Exception ex){
			
		}
		return consultServiceResponse;
	}
	
	@GET
	@Path("/executeexplanationservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ExplanationServiceResponse ExecuteExplanationService(@QueryParam("patient") String patient,
			@QueryParam("physician") String physician,@QueryParam("serviceid") int serviceid){
				
		Explanation explanation = null;
		ExplanationServiceResponse explanationServiceResponse = null;
		
		try{
			
			if(!patient.isEmpty() && !physician.isEmpty() && serviceid >0){
				
				explanation = ServiceExecutionHelper.getExplanation();
				if(explanation !=null){
					explanationServiceResponse = new ExplanationServiceResponse();
					explanationServiceResponse.setIsOperationSuccessfull(true);
					explanationServiceResponse.setIsResult(true);
					explanationServiceResponse.setMessage("Service Executed Successfully!");
					explanationServiceResponse.setExplanation(explanation);
				}
				else{
					explanationServiceResponse = new ExplanationServiceResponse();
					explanationServiceResponse.setIsOperationSuccessfull(true);
					explanationServiceResponse.setIsResult(false);
					explanationServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero!");
					explanationServiceResponse.setExplanation(null);
				}
				
			}
			else{
				explanationServiceResponse = new ExplanationServiceResponse();
				explanationServiceResponse.setIsOperationSuccessfull(false);
				explanationServiceResponse.setIsResult(false);
				explanationServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
				explanationServiceResponse.setExplanation(null);
			}
		}
		catch(Exception ex){
			
		}
		
		return explanationServiceResponse;
		
		
	}
	/**
	 * Execute Discover Caregiver Service
	 * @param careprogram
	 * @param serviceid
	 * @return
	 */
	@GET
	@Path("/executediscovercaregiverservice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DiscoverCareGiverServiceResponse ExecuteDiscoverCaregiverServiceResponse(
								@QueryParam("careprogram") String careprogram,
								@QueryParam("availability") String availability,
								@QueryParam("serviceid") int serviceid){
									
		
		ArrayList<Caregiver> careGiverList = new ArrayList<Caregiver>();
		DiscoverCareGiverServiceResponse discoverCareGiverServiceResponse = null;
		
		try{
			
			if(!careprogram.isEmpty() && !availability.isEmpty() && serviceid >0){
				
				careGiverList = ServiceExecutionHelper.getCaregiverList();
				if(careGiverList.size() >0){
					
					discoverCareGiverServiceResponse = new DiscoverCareGiverServiceResponse();
					discoverCareGiverServiceResponse.setIsOperationSuccessfull(true);
					discoverCareGiverServiceResponse.setIsResult(true);
					discoverCareGiverServiceResponse.setMessage("Service Executed Successfully!");
					discoverCareGiverServiceResponse.setCareGiver(careGiverList);
				}
				else{
					discoverCareGiverServiceResponse = new DiscoverCareGiverServiceResponse();
					discoverCareGiverServiceResponse.setIsOperationSuccessfull(true);
					discoverCareGiverServiceResponse.setIsResult(false);
					discoverCareGiverServiceResponse.setMessage("Service Executed Successfully!");
					discoverCareGiverServiceResponse.setCareGiver(null);
				}
			}
			else{
				discoverCareGiverServiceResponse = new DiscoverCareGiverServiceResponse();
				discoverCareGiverServiceResponse.setIsOperationSuccessfull(false);
				discoverCareGiverServiceResponse.setIsResult(false);
				discoverCareGiverServiceResponse.setMessage("Failed to execute the service. Service id should be greater than zero");
				discoverCareGiverServiceResponse.setCareGiver(null);
			}
		}
		catch(Exception ex){
			
		}
		return discoverCareGiverServiceResponse;
		
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------*/
	
	/**
	 * Unused service code
	 */
	/*@GET
    @Path("/getnapa/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudentlist(
    		@QueryParam("input") String input,
    		@QueryParam("output") String output) {
    		
    	try{
    		ArrayList<Student> studentList = new ArrayList<Student>();
    		studentList.add(new Student(input, output,19,20));
    		studentList.add(new Student(input,output,4,5));
    		
    		return studentList;
    	}
    	catch(Exception ex){
    		return null;
    	}
    }*/
}
