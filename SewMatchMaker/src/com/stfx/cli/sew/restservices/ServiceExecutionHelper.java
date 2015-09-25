package com.stfx.cli.sew.restservices;

import java.util.ArrayList;

import com.stfx.cli.sew.hpcdatamodels.Appointment;
import com.stfx.cli.sew.hpcdatamodels.Caregiver;
import com.stfx.cli.sew.hpcdatamodels.Consult;
import com.stfx.cli.sew.hpcdatamodels.DiscoverPatientServiceResponse;
import com.stfx.cli.sew.hpcdatamodels.Explanation;
import com.stfx.cli.sew.hpcdatamodels.Patient;
import com.stfx.cli.sew.hpcdatamodels.Physician;
import com.stfx.cli.sew.services.Ambrox;
import com.stfx.cli.sew.services.Ambrox_Service;
import com.stfx.cli.sew.services.Cef3;
import com.stfx.cli.sew.services.Cef3_Service;
import com.stfx.cli.sew.services.Gmax;
import com.stfx.cli.sew.services.Gmax_Service;
import com.stfx.cli.sew.services.InputModel;
import com.stfx.cli.sew.services.Napa;
import com.stfx.cli.sew.services.Napa_Service;
import com.stfx.cli.sew.services.OutputModel;
import com.stfx.cli.sew.services.QosInputModel;
import com.stfx.cli.sew.services.Serape;
import com.stfx.cli.sew.services.Serape_Service;

/**
 * 
 * @author Mostafijur Rahman
 * @since 9th April, 2015
 */
public class ServiceExecutionHelper {
	
	
	/*-----------Drug Discovery Service Execution Related Methods--------------*/
	/**
	 * 
	 * @return
	 */
	private static OutputModel ConsumeGmaxService(){
		
		InputModel inputModel = null;
		QosInputModel qosInputModel = null;
		OutputModel outputModel = null;
		
		try{
			Gmax_Service gmaxService = new Gmax_Service();
			if(gmaxService !=null){
				Gmax gmaxPort = gmaxService.getGmaxPort();
				if(gmaxPort !=null){
					
					inputModel = new InputModel();
					inputModel.setCondition("Critical");
					inputModel.setSymptom("Fever");
					
					qosInputModel = new QosInputModel();
					qosInputModel.setExecutionPrice("MediumExecutionPrice");
					qosInputModel.setReliability("LowReliability");
					qosInputModel.setResponseTime("MediumResponseTime");
					
					outputModel = gmaxPort.gmaxService(inputModel, qosInputModel);
					if(outputModel !=null){
						System.out.println("Gmax Service Output:");
						System.out.println("Napa: " + outputModel.getNapa());
						System.out.println("Serape: " + outputModel.getGmaxTablet());
						System.out.println("-------------------------------");
					}
					
				}
			}
		}
		catch(Exception ex){
			outputModel = null;
		}
		return outputModel;
		
	}
	
	/**
	 * 
	 * @return
	 */
	private static OutputModel ConsumeSerapeService(){
		
		InputModel inputModel = null;
		QosInputModel qosInputModel = null;
		OutputModel outputModel = null;
		
		try{
			Serape_Service cef3Service = new Serape_Service();
			if(cef3Service !=null){
				Serape serapePort = cef3Service.getSerapePort();
				if(serapePort !=null){
					
					inputModel = new InputModel();
					inputModel.setCondition("Critical");
					inputModel.setSymptom("Fever");
					
					qosInputModel = new QosInputModel();
					qosInputModel.setExecutionPrice("MediumExecutionPrice");
					qosInputModel.setReliability("LowReliability");
					qosInputModel.setResponseTime("MediumResponseTime");
					
					outputModel = serapePort.serapeService(inputModel, qosInputModel);
					if(outputModel !=null){
						System.out.println("Serape Service Output:");
						System.out.println("Napa: " + outputModel.getNapa());
						System.out.println("Serape: " + outputModel.getSerape());
						System.out.println("-------------------------------");
					}
					
				}
			}
		}
		catch(Exception ex){
			outputModel = null;
		}
		
		return outputModel;
	}
	
	/**
	 * 
	 * @return
	 */
	private static OutputModel ConsumeCef3Service(){
		
		InputModel inputModel = null;
		QosInputModel qosInputModel = null;
		OutputModel outputModel = null;
		
		try{
			Cef3_Service cef3Service = new Cef3_Service();
			if(cef3Service !=null){
				Cef3 cef3Port = cef3Service.getCef3Port();
				if(cef3Port !=null){
					
					inputModel = new InputModel();
					inputModel.setCondition("Critical");
					inputModel.setSymptom("Fever");
					
					qosInputModel = new QosInputModel();
					qosInputModel.setExecutionPrice("HighExecutionPrice");
					qosInputModel.setReliability("LowReliability");
					qosInputModel.setResponseTime("HighResponseTime");
					
					outputModel = cef3Port.cef3Service(inputModel, qosInputModel);
					if(outputModel !=null){
						System.out.println("Cef3 Service Output:");
						System.out.println("Napa: " + outputModel.getNapa());
						System.out.println("Cef3 Serape: " + outputModel.getCef3Serape());
						System.out.println("-------------------------------");
					}
					
				}
			}
		}
		catch(Exception ex){
			outputModel = null;
		}
		return outputModel;
	}
	
	/**
	 * 
	 * @return
	 */
	private static OutputModel ConsumeAmbroxService(){
		
		InputModel inputModel = null;
		QosInputModel qosInputModel = null;
		OutputModel outputModel = null;
		
		try{
			Ambrox_Service ambroxService = new Ambrox_Service();
			if(ambroxService !=null){
				Ambrox ambroxPort = ambroxService.getAmbroxPort();
				if(ambroxPort !=null){
					
					inputModel = new InputModel();
					inputModel.setCondition("Critical");
					inputModel.setSymptom("Fever");
					
					qosInputModel = new QosInputModel();
					qosInputModel.setExecutionPrice("LowExecutionPrice");
					qosInputModel.setReliability("HighReliability");
					qosInputModel.setResponseTime("MediumResponseTime");
					
					outputModel = ambroxPort.ambroxService(inputModel, qosInputModel);
					if(outputModel !=null){
						System.out.println("Ambrox Service Output:");
						System.out.println("Ambrox: " + outputModel.getAmbrox());
						System.out.println("-------------------------------");
					}
					
				}
			}
		}
		catch(Exception ex){
			outputModel = null;
		}
		return outputModel;
	}
	
	/**
	 * 
	 * @return
	 */
	private static OutputModel ConsumeNapaService(){
		InputModel inputModel = null;
		QosInputModel qosInputModel = null;
		OutputModel outputModel = null;
		
		try{
			
			Napa_Service napaService = new Napa_Service();
			if(napaService !=null){
				Napa napaPort = napaService.getNapaPort();
				if(napaPort !=null){
					inputModel = new InputModel();
					inputModel.setCondition("Critical");
					inputModel.setSymptom("Fever");
					
					qosInputModel = new QosInputModel();
					qosInputModel.setExecutionPrice("MediumExecutionPrice");
					qosInputModel.setReliability("LowReliability");
					qosInputModel.setResponseTime("HighResponseTime");
					
					outputModel = napaPort.napaService(inputModel, qosInputModel);
					if(outputModel !=null){
						System.out.println("Napa Service Output:");
						System.out.println("Napa: " + outputModel.getNapa());
						System.out.println("-------------------------------");
						//System.out.println("Serape: " + outputModel.getSerape());
					}
				}
			}
			
			
		}
		catch(Exception ex){
			outputModel = null;
		}
		return outputModel;
	}
	
	/**
	 * Cef3 --> 1
	 * Ambrox --> 2
	 * Gmax --> 3
	 * Napa --> 4
	 * Serape --> 5
	 * @param serviceId
	 * @return
	 */
	public static OutputModel ExecuteServiceById(int serviceId){
		
		OutputModel outputModel = null;
		try{
			
			if(serviceId>0){
				if(serviceId == 1) {
					outputModel = ConsumeCef3Service();
				}
				else if(serviceId ==2){
					outputModel = ConsumeAmbroxService();
				}
				else if(serviceId ==3){
					outputModel = ConsumeGmaxService();
				}
				else if(serviceId ==4){
					outputModel = ConsumeNapaService();
				}
				else if(serviceId ==5){
					outputModel = ConsumeSerapeService();
				}
				else{
					outputModel = null;
				}
			}
		}
		catch(Exception ex){
			outputModel = null;
		}
		return outputModel;
	}
	
	/*-----------Drug Discovery Service Execution Related Methods End here--------------*/
	
	/*-----------Hospice Workflow Task related Service Execution Related Methods--------------*/
	
	
	public static ArrayList<Patient> getReferredPatientList(){
		
		Patient patient = null;
		ArrayList<Patient> referredPatientList = new ArrayList<Patient>();
		try{
			
			// Patient #1: Martin
			patient = new Patient();
			patient.setPaitentName("martin");
			patient.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#martin");
			patient.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Patient");
			referredPatientList.add(patient);
			
			// Patient #2: Iker
			patient = new Patient();
			patient.setPaitentName("iker");
			patient.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#iker");
			patient.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Patient");
			referredPatientList.add(patient);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return referredPatientList;
	}
	
	public static ArrayList<Physician> getPhysicianList(){
		
		Physician physician = null;
		ArrayList<Physician> physicianList = new ArrayList<Physician>();
		
		try{
			
			// Patient #1: Martin
			physician = new Physician();
			physician.setPhysicianName("laurence");
			physician.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#laurence");
			physician.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Physician");
			physicianList.add(physician);
						
			// Patient #2: Iker
			physician = new Physician();
			physician.setPhysicianName("lin");
			physician.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#lin");
			physician.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Physician");
			physicianList.add(physician);		
			
		}
		catch(Exception ex){
			
		}
		
		return physicianList;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Appointment getSetupAppointment(String patientName, String PhysicianName){
		
		Appointment appointment = null;
		try{
			
			appointment = new Appointment();
			appointment.setAppointmentName("Hpc Appointment");
			appointment.setIsAppointmentSetup(true);
		
			// Set Patient
			Patient patientInstance = new Patient();
			patientInstance.setPaitentName(patientName);
			appointment.setSelectedPatient(patientInstance);
			
			// Set Physician
			Physician physicianInstance = new Physician();
			physicianInstance.setPhysicianName(PhysicianName);
			
			appointment.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#appointment");
			appointment.setAppointmentName("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Appointment");
		}
		catch(Exception ex){
			
		}
		return appointment;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Consult getConsultationResult(){
		
		Consult consult = null;
		try{
			consult = new Consult();
			consult.setIsConsulted(true);
			consult.setIsEligible(true);
			consult.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#consult");
			consult.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Consult");
			
		}
		catch(Exception ex){
			
		}
		return consult;
	}
	
	public static Explanation getExplanation(){
		
		Explanation explanation = null;
		try{
			explanation = new Explanation();
			explanation.setDescription("Patient is eligible for this program");
			explanation.setIsExplained(true);
			explanation.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#explanation");
			explanation.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Explanation");
		}
		catch(Exception ex){
			
		}
		return explanation;
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Caregiver> getCaregiverList(){
		
		Caregiver careGiver = null;
		ArrayList<Caregiver> careGiverList = new ArrayList<Caregiver>();
		try{
			
			// Patient #1: Wendy
			careGiver = new Caregiver();
			careGiver.setCaregiverName("wendy");
			careGiver.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#wendy");
			careGiver.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#CareGiver");
			careGiverList.add(careGiver);
									
			// Patient #2: Emilly
			careGiver = new Caregiver();
			careGiver.setCaregiverName("emilly");
			careGiver.setOntologyIRI("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#emilly");
			careGiver.setConceptType("http://test.biocomalert.com/docs/services/core/DrugOntology.owl#CareGiver");
			careGiverList.add(careGiver);	
			
		}
		catch(Exception ex){
			ex.getMessage();
			ex.printStackTrace();
		}
		
		return careGiverList;
	}
}
