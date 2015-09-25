package com.stfx.sew.manager;

import java.util.ArrayList;
import java.util.Hashtable;

import com.stfx.sew.datamodel.InputOutputInstance;
import com.stfx.sew.datamodel.QoSInstance;
import com.stfx.sew.datamodel.TaskBehavior;

public class SewOntologyManager {
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<TaskBehavior> getAllTaskBehavior(){
		
		TaskBehavior taskBehavior = null;
		ArrayList<TaskBehavior> taskBehaviorList = new ArrayList<TaskBehavior>();
		
		try{
			
			taskBehavior = new TaskBehavior(1, "Create");
			taskBehaviorList.add(taskBehavior);
			
			taskBehavior = new TaskBehavior(1, "Update");
			taskBehaviorList.add(taskBehavior);
			
			taskBehavior = new TaskBehavior(1, "Delete");
			taskBehaviorList.add(taskBehavior);
			
			taskBehavior = new TaskBehavior(1, "Select");
			taskBehaviorList.add(taskBehavior);
			
			taskBehavior = new TaskBehavior(1, "Not Applicable");
			taskBehaviorList.add(taskBehavior);
			
		}
		catch(Exception ex){
			taskBehaviorList = null;
		}
		return taskBehaviorList;
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<QoSInstance> getAllQoSInstanceList(){
		
		QoSInstance qosInstance = null;
		ArrayList<QoSInstance> qosInstanceList = new ArrayList<QoSInstance>();
		
		try{
			qosInstance = new QoSInstance(1,"Execution Price");
			qosInstanceList.add(qosInstance);
			
			qosInstance = new QoSInstance(2, "Response Time");
			qosInstanceList.add(qosInstance);
			
			qosInstance = new QoSInstance(3,"Reliability");
			qosInstanceList.add(qosInstance);
		}
		catch(Exception ex){
			qosInstanceList = null;
		}
		
		return qosInstanceList;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ArrayList<InputOutputInstance> getAllInputOutputInstanceList(){
		
		InputOutputInstance inputOutputInstance = null;
		ArrayList<InputOutputInstance> inputOutputInstanceList = new ArrayList<InputOutputInstance>();
		
		try{

			inputOutputInstance = new InputOutputInstance("Appointment","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Appointment");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("Clinic","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Clinic");
			inputOutputInstanceList.add(inputOutputInstance);
				
			inputOutputInstance = new InputOutputInstance("Consult","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Consult");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("PalliativeCareClinic","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#PalliativeCareClinic");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("Patient","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Patient");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("Physician","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Physician");
			inputOutputInstanceList.add(inputOutputInstance);
				
			inputOutputInstance = new InputOutputInstance("Referral","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#Referral");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("appointment","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#appointment");
			inputOutputInstanceList.add(inputOutputInstance);
				
			inputOutputInstance = new InputOutputInstance("careGiver","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#careGiver");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("careGiverList","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#careGiverList");
			inputOutputInstanceList.add(inputOutputInstance);
				
			inputOutputInstance = new InputOutputInstance("careProgram","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#careProgram");
			inputOutputInstanceList.add(inputOutputInstance);
				
			inputOutputInstance = new InputOutputInstance("clinic","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#clinic");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("communityCareProgram","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#communityCareProgram");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("consult","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#consult");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("dentist","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#dentist");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("distance","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#distance");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("earSpecialist","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#earSpecialist");
			inputOutputInstanceList.add(inputOutputInstance);
					
			inputOutputInstance = new InputOutputInstance("explanation","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#explanation");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("eyeSpecialist","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#eyeSpecialist");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("formalCareGiver","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#formalCareGiver");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("healthCentre","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#healthCentre");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("heartSpecialist","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#heartSpecialist");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("highAvaiability","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#highAvaiability");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("highPpsValue","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#highPpsValue");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("hospital","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#hospital");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("informalCareGiver","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#informalCareGiver");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("longDistance","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#longDistance");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("lowAvaiability","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#lowAvaiability");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("lowPpsValue","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#lowPpsValue");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("mediumAvaiability","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#mediumAvaiability");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("mediumPpsValue","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#mediumPpsValue");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("palliativeCareProgram","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#palliativeCareProgram");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("patient","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#patient");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("patientList","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#patientList");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("physician","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#physician");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("physicianList","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#physicianList");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("ppsValue","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#ppsValue");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("receptionist","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#receptionist");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("referredPatientList","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#referredPatientList");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("respiteCareProgram","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#respiteCareProgram");
			inputOutputInstanceList.add(inputOutputInstance);
			
			inputOutputInstance = new InputOutputInstance("shortDistance","http://test.biocomalert.com/docs/services/core/DrugOntology.owl#shortDistance");
			inputOutputInstanceList.add(inputOutputInstance);
			
		}
		catch(Exception ex){
			inputOutputInstanceList = null;
		}
		
		return inputOutputInstanceList;
	}

}
