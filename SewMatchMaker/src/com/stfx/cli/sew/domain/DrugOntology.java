package com.stfx.cli.sew.domain;

import com.stfx.cli.sew.utilities.UriUtils;

/**
 * 
 * @author Mostafijur Rahman
 * @since 18th March, 2015
 */
public class DrugOntology {

	public static String base = "http://test.biocomalert.com/docs/services/core/";
	public static String drugOntologyCoreURI = base + "DrugOntology.owl";
	public static String drugOntologyURI = base + "DrugOntology.owl#";
	
	public static class ObjectProperties {
		
		public static String hasCondition = "hasCondition";
		public static String hasSymptom = "hasSymptom";
		
		static {
			hasCondition = UriUtils.createURI(drugOntologyURI + hasCondition).toString();
			hasSymptom = UriUtils.createURI(drugOntologyURI + hasSymptom).toString();
		}
	}
	
	public static class DataProperties{
		
		public static String hasAge = "hasAge";
		public static String hasPrice = "hasPrice";
		public static String hasWeight = "hasWeight";
		
		public static String hasResponseTime = "hasResponseTime";
		public static String hasReliability = "hasReliability";
		public static String hasExecutionPrice = "hasExecutionPrice";
		
		static {
			
			hasAge = UriUtils.createURI(drugOntologyURI + hasAge).toString();
			hasPrice = UriUtils.createURI(drugOntologyURI + hasPrice).toString();
			hasWeight = UriUtils.createURI(drugOntologyURI + hasWeight).toString(); 
			
			hasResponseTime = UriUtils.createURI(drugOntologyURI + hasResponseTime).toString(); 
			hasReliability = UriUtils.createURI(drugOntologyURI + hasReliability).toString(); 
			hasExecutionPrice = UriUtils.createURI(drugOntologyURI + hasExecutionPrice).toString(); 
		}
			
	}

}
