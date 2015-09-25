package com.stfx.cli.sew.domain;

import com.stfx.cli.sew.utilities.UriUtils;

public class Concepts {

	public static String base = "http://test.biocomalert.com/docs/services/core/";
	public static String conceptsOntologyCoreURI = base + "Concepts.owl";
	public static String conceptsOntologyURI = base + "Concepts.owl#";
	
	public static class ObjectProperties {
		
		public static String hasCondition = "hasCondition";
		public static String hasSymptom = "hasSymptom";
		
		static {
			hasCondition = UriUtils.createURI(conceptsOntologyURI + hasCondition).toString();
			hasSymptom = UriUtils.createURI(conceptsOntologyURI + hasSymptom).toString();
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
			
			hasAge = UriUtils.createURI(conceptsOntologyURI + hasAge).toString();
			hasPrice = UriUtils.createURI(conceptsOntologyURI + hasPrice).toString();
			hasWeight = UriUtils.createURI(conceptsOntologyURI + hasWeight).toString(); 
			
			hasResponseTime = UriUtils.createURI(conceptsOntologyURI + hasResponseTime).toString(); 
			hasReliability = UriUtils.createURI(conceptsOntologyURI + hasReliability).toString(); 
			hasExecutionPrice = UriUtils.createURI(conceptsOntologyURI + hasExecutionPrice).toString(); 
		}
			
	}
}
