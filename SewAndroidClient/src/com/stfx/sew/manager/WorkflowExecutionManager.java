package com.stfx.sew.manager;

import java.util.ArrayList;

import org.apache.http.Header;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.stfx.sew.datamodel.DiscoverServiceResponceModel;
import com.stfx.sew.datamodel.DiscoveredService;
import com.stfx.sew.datamodel.ServiceDiscoveryRequest;
import com.stfx.sew.datamodel.TaskSpecification;
import com.stfx.sew.util.AllUrls;
import com.stfx.sew.util.NetInfo;

public class WorkflowExecutionManager {

	public static final String LOW = "Low";
	public static final String MEDIUM = "Medium";
	public static final String HIGH = "High";
	
	public static final String ResponseTime = "ResponseTime";
	public static final String ExecutionPrice = "ExecutionPrice";
	public static final String Reliability = "Reliability";
	
	// Hospice Workflow Task Specific Business Logic
	public static String SelectedPatient = null;
	public static String SelectedPhysician = null;
	
	public static boolean IsSetupAppointment = false;
	public static boolean IsConsulted = false;
	public static boolean IsEligible = false;
	
	public static String SelectedCareGiver = null;
	public static boolean IsDeliveredCare = false;
	
	public static boolean IsExplained = false;
	//public static final String SelectedDrug = null;
	public static boolean IsPrescribedDrug = false;
	
	public static int SelectedBranchNumber = 0;
	
	public static final int TOP_RANKED_SERVICE_INDEX = 0;
	public static final int TOP_RANKED_DATA_INDEX = 0;
	
	public static final int FINISH_TASK_ID = 2;
	public static final String FINISH_TASK_NAME = "OutputCondition";
	
	static Gson gsonObject = null;
	public static ArrayList<DiscoveredService> taskSpecificDiscoveredServiceList = new ArrayList<DiscoveredService>();
	
	/**
	 * Return constructed Service Discovery Request
	 */
	public static ServiceDiscoveryRequest getConstructedServiceDiscoveryRequest(TaskSpecification taskSpecification){
		
		ServiceDiscoveryRequest serviceDiscoveryRequest = null;;
		try{
			
			serviceDiscoveryRequest = new ServiceDiscoveryRequest();
			
			String input = "";
			for(int i = 0; i< taskSpecification.getInputs().getInputconcepts().size(); i++){
				input = input + taskSpecification.getInputs().getInputconcepts().get(i);
				input = input + ":";
			}
			input = input.trim();
			if(input.endsWith(":")){
				input = input.substring(0, input.length() - 1);
			}
			
			serviceDiscoveryRequest.setInput(input);
			
			String responseTimeValue = taskSpecification.getQosinputs().getResponseTime();
			String executionPriceValue = taskSpecification.getQosinputs().getExecutionPrice();
			String reliabilityValue = taskSpecification.getQosinputs().getReliability();
			
			//String qosInput = getQoSInputInSequence(responseTimeValue,executionPriceValue,reliabilityValue);
			
			String qosInput = "ResponseTime:" + responseTimeValue + "-ExecutionPrice:" + executionPriceValue + "-Reliability:" + reliabilityValue;
			serviceDiscoveryRequest.setQos(qosInput);
			
			String outputs = "";
			for(int i = 0; i<taskSpecification.getOutputs().getOutputconcept().size(); i++){
				outputs = outputs + taskSpecification.getOutputs().getOutputconcept().get(i);
				outputs = outputs + ":";
			}
			outputs = outputs.trim();
			if(outputs.endsWith(":")){
				outputs = outputs.substring(0, outputs.length() - 1);
			}
			serviceDiscoveryRequest.setOutput(outputs);
			
		}
		catch(Exception ex){
			
		}
		
		return serviceDiscoveryRequest;
		
	}
	
	/**
	 * Return constructed QoS inputs in sequence
	 */
	public static  String getQoSInputInSequence(String responseTimeValue,
			String executionPriceValue, String reliabilityValue) {
		
		// TODO Auto-generated method stub
		String qoSInput = "";
		try{
			
			if(!responseTimeValue.isEmpty() && !executionPriceValue.isEmpty() && !reliabilityValue.isEmpty()){
				
				//High
				if(responseTimeValue.equals(WorkflowExecutionManager.HIGH))
					qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
				
				else if(executionPriceValue.equals(WorkflowExecutionManager.HIGH))
					qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
				
				else if(reliabilityValue.equals(WorkflowExecutionManager.HIGH))
					qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
				
				
				//Medium
				qoSInput = qoSInput + ":";
				
				if(responseTimeValue.equals(WorkflowExecutionManager.MEDIUM))
					qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
				
				else if(executionPriceValue.equals(WorkflowExecutionManager.MEDIUM))
					qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
				
				else if(reliabilityValue.equals(WorkflowExecutionManager.MEDIUM))
					qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
				
				//Low
				qoSInput = qoSInput + ":";
				
				if(responseTimeValue.equals(WorkflowExecutionManager.LOW))
					qoSInput = qoSInput + WorkflowExecutionManager.ResponseTime;
				
				else if(executionPriceValue.equals(WorkflowExecutionManager.LOW))
					qoSInput = qoSInput + WorkflowExecutionManager.ExecutionPrice;
				
				else if(reliabilityValue.equals(WorkflowExecutionManager.LOW))
					qoSInput = qoSInput + WorkflowExecutionManager.Reliability;
			}
		}
		catch(Exception ex){
			
		}
		return qoSInput;
	}
	
	/**
	 * Discover Semantic Web Services based on Service Discovery Request
	 */
	public static void DiscoverHpcSemanticWebServices(ServiceDiscoveryRequest serviceInput) {
		
		String constructedServiceUrl = null;
		try{
			
			constructedServiceUrl = AllUrls.getHpcServiceDiscoveryUrl(serviceInput);
			
			if(!constructedServiceUrl.isEmpty()){
				AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
				asyncHttpClient.setTimeout(120000);
				asyncHttpClient.get(constructedServiceUrl, new AsyncHttpResponseHandler() {

					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] response) {
						// TODO Auto-generated method stub
						
						gsonObject = new Gson();
						String responseString = new String(response);
						DiscoverServiceResponceModel discoveryServiceResponseModel = gsonObject.fromJson(responseString, DiscoverServiceResponceModel.class);
						System.out.println(discoveryServiceResponseModel.getInputModel());
						if(discoveryServiceResponseModel.isOperationSuccessfull() && discoveryServiceResponseModel.isResult()){
							
							taskSpecificDiscoveredServiceList = discoveryServiceResponseModel.getServiceList();
						}
						else{
							
						}
					}

					@Override
					public void onFailure(int statusCode, Header[] headers, byte[] responce, Throwable th) {
						// TODO Auto-generated method stub
						
						taskSpecificDiscoveredServiceList = null;
						
						//progressDialog.dismiss();
						//Toast.makeText(context, "Error occured while discovering semantic web services... " + th, Toast.LENGTH_SHORT).show();
					}
				});
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/*public static ServiceDiscoveryRequest getConstructServiceRequest() {
	
	ServiceDiscoveryRequest serviceInput = null;
	try{
	
		serviceInput = new ServiceDiscoveryRequest();
		StringBuilder inputStr = new StringBuilder();
		
		if(!AppManager.getInstance().getSelectedConditionName().isEmpty()){
			inputStr.append(AppManager.getInstance().getSelectedConditionName());
			inputStr.append(":");
		}
		
		if(!AppManager.getInstance().getSelectedSymptomName().isEmpty()){
			inputStr.append(AppManager.getInstance().getSelectedSymptomName());
			serviceInput.setInput(inputStr.toString());
		}
		
		if(AppManager.getInstance().getQosValues().length >0){
			inputStr = new StringBuilder();
			String[] qos = AppManager.getInstance().getQosValues();
			
			for (int i = 0; i < qos.length; i++) {
				inputStr.append(qos[i]);
				if (i < qos.length - 1) {
					inputStr.append(":");
				}
			}
			serviceInput.setQos(inputStr.toString());
		}

		if(AppManager.getInstance().getOutputsValue().length >0){
			inputStr = new StringBuilder();
			String[] outputs = AppManager.getInstance().getOutputsValue();
			for (int i = 0; i < outputs.length; i++) {
				inputStr.append(outputs[i]);
				if (i < outputs.length - 1) {
					inputStr.append(":");
				}
			}
			serviceInput.setOutput(inputStr.toString());
		}
	}
	catch(Exception ex){
		
	}
	
	return serviceInput;
	}*/
}
