/**
 * 
 */
package com.stfx.sew.util;

import java.util.Vector;

import com.stfx.sew.datamodel.ServiceDiscoveryRequest;

/**
 * @author Mostafijur Rahman
 *
 */
public class AllUrls {

	public static final String GET_DRUG_DISCOVERY_SERVICE_URL = "getservicelist";
	public static final String EXECUTE_SERVICE_URL = "executeservice";
	
	public static final String GET_ALL_OWLS_SERVICES = "getowlsservices";
	public static final String GET_HPC_SERVICE_DISCOVERY_URL = "gethpcservicelist";
	
	public static final String GET_EXECUTE_DISCOVER_PATIENT_SERVICE_URL = "executediscoverpatientservice";
	public static final String GET_EXECUTE_DISCOVER_PHYSICIAN_SERVICE_URL = "executediscoverphysicianservice"; 
	public static final String GET_EXECUTE_SETUP_APPOINTMENT_SERVICE_URL = "executesetupappointmentservice";
	public static final String GET_EXECUTE_CONSULT_SERVICE_URL = "executeconsultservice";
	
	public static final String GET_EXECUTE_DISCOVERCAREGIVER_SERVICE_URL = "executediscovercaregiverservice";
	public static final String GET_EXECUTE_EXPLANATION_SERVICE_URL = "executeexplanationservice";
	
	public static final String BASE_URL = "http://54.200.112.228:8080/SewMatchMaker/";
	
	/**
	 * 
	 * @return
	 */
	public static String getAllOwlsServiceUrl(){
		return BASE_URL + GET_ALL_OWLS_SERVICES;
	}
	
	public static String getExecuteDiscoverPatientServiceUrl(int serviceId){
		
		//serviceid=6&careprogram=palliative&distance=low&pps=high
		return BASE_URL + GET_EXECUTE_DISCOVER_PATIENT_SERVICE_URL + "?serviceid=" + serviceId + "&careprogram=palliative&distance=low&pps=high";
	}
	
	public static String getExecuteDiscoverPhysicianServiceUrl(int serviceId){
		
		//serviceid=7&careprogram=palliative&availability=high
		return BASE_URL + GET_EXECUTE_DISCOVER_PHYSICIAN_SERVICE_URL + "?serviceid=" + serviceId + "&careprogram=palliative&availability=high";
	}
	
	public static String getExecuteSetupAppointmentServiceUrl(int serviceId){
		
		//serviceid=8&patient=martin&physician=wendy
		return BASE_URL + GET_EXECUTE_SETUP_APPOINTMENT_SERVICE_URL + "?serviceid=" + serviceId + "&patient=martin&physician=wendy";
	}
	
	public static String getExecuteConsultServiceUrl(int serviceId){
		
		//appointment=appointment&serviceid=9
		return BASE_URL + GET_EXECUTE_CONSULT_SERVICE_URL + "?serviceid=" + serviceId + "&appointment=appointment";
	}
	
	public static String getExecuteDiscoverCaregiverServiceUrl(int serviceId){
		
		// serviceid=10&careprogram=palliative&availability=high
		return BASE_URL + GET_EXECUTE_DISCOVERCAREGIVER_SERVICE_URL + "?serviceid=" + serviceId + "&careprogram=palliative&availability=high";
	}
	
	public static String getExecuteExplanationServiceUrl(int serviceId){
		
		// serviceid=8&patient=martin&physician=wendy
		return BASE_URL + GET_EXECUTE_EXPLANATION_SERVICE_URL + "?serviceid=" + serviceId + "&patient=martin&physician=wendy";
	}
	
	/**
	 * 
	 * @param action
	 * @param params
	 * @return
	 */
	private static String getcommonUrlWithParamAndAction(String action, Vector<KeyValue> params) {

		if (params == null || params.size() == 0) {
			return BASE_URL + action;
		} else {
			String pString = "";

			for (final KeyValue obj : params) {

				pString += obj.getKey().trim() + "=" + obj.getValue().trim() + "&";
			}

			if (pString.endsWith("&")) {
				pString = pString.subSequence(0, pString.length() - 1).toString();
			}

			return BASE_URL + action + "?" + UrlUtils.encode(pString);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String getDrugDiscoveryServiceUrl(ServiceDiscoveryRequest input){
		
		Vector<KeyValue> keyValuePair = new Vector<KeyValue>();
		keyValuePair.add(new KeyValue("input", input.getInput()));
		keyValuePair.add(new KeyValue("output", input.getOutput()));
		keyValuePair.add(new KeyValue("qos", input.getQos()));
		
		return getcommonUrlWithParamAndAction(GET_DRUG_DISCOVERY_SERVICE_URL, keyValuePair);
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String getHpcServiceDiscoveryUrl(ServiceDiscoveryRequest input){
		
		Vector<KeyValue> keyValuePair = new Vector<KeyValue>();
		keyValuePair.add(new KeyValue("input", input.getInput()));
		keyValuePair.add(new KeyValue("output", input.getOutput()));
		keyValuePair.add(new KeyValue("qos", input.getQos()));
		
		return getcommonUrlWithParamAndAction(GET_HPC_SERVICE_DISCOVERY_URL, keyValuePair);
		
	}
	
	/**
	 * 
	 * @param serviceId
	 * @return
	 */
	public static String getExecuteServiceUrl(String serviceId){
		
		Vector<KeyValue> temp = new Vector<KeyValue>();
		temp.add(new KeyValue("serviceid", serviceId));
		
		return getcommonUrlWithParamAndAction(EXECUTE_SERVICE_URL, temp);
	}
}
