package com.stfx.cli.sew.domain;

import com.stfx.cli.sew.utilities.UriUtils;

/**
 * 
 * @author Mostafijur Rahman
 * @since 18th March, 2015
 */
public class QoSMetricOntology {

	public static String base = "http://test.biocomalert.com/docs/services/core/";
	public static String QoSMetricOntologyCoreUri = base + "QoSMetric.owl";
	public static String QoSMetricOntology = base + "QoSMetric.owl#";
	
	public static class Classes {
		
		public static String QoSProperty = "QoSProperty";
		
		public static String ExecutionPrice = "ExecutionPrice";
		public static String HighExecutionPrice = "HighExecutionPrice";
		public static String MediumExecutionPrice = "MediumExecutionPrice";
		public static String LowExecutionPrice = "LowExecutionPrice";
		
		
		public static String Reliability = "Reliability";
		public static String HighReliability = "HighReliability";
		public static String MediumReliability = "MediumReliability";
		public static String LowReliability = "LowReliability";
		
		public static String ResponseTime = "ResponseTime";
		public static String HighResponseTime = "HighResponseTime";
		public static String MediumResponseTime = "MediumResponseTime";
		public static String LowResponseTime = "LowResponseTime";
		
		static {
			
			QoSProperty = UriUtils.createURI(QoSMetricOntology + QoSProperty).toString();
			
			ExecutionPrice = UriUtils.createURI(QoSMetricOntology + ExecutionPrice).toString();
			HighExecutionPrice = UriUtils.createURI(QoSMetricOntology + HighExecutionPrice).toString();
			MediumExecutionPrice = UriUtils.createURI(QoSMetricOntology + MediumExecutionPrice).toString();
			LowExecutionPrice = UriUtils.createURI(QoSMetricOntology + LowExecutionPrice).toString();
			
			
			ResponseTime = UriUtils.createURI(QoSMetricOntology + ResponseTime).toString();
			HighResponseTime = UriUtils.createURI(QoSMetricOntology + HighResponseTime).toString();
			MediumResponseTime = UriUtils.createURI(QoSMetricOntology + MediumResponseTime).toString();
			LowResponseTime = UriUtils.createURI(QoSMetricOntology + LowResponseTime).toString();
			
			Reliability = UriUtils.createURI(QoSMetricOntology + Reliability).toString();
			HighReliability = UriUtils.createURI(QoSMetricOntology + HighReliability).toString();
			MediumReliability = UriUtils.createURI(QoSMetricOntology + MediumReliability).toString();
			LowReliability = UriUtils.createURI(QoSMetricOntology + LowReliability).toString();
		}
	}
	public static class DataProperties{
		
		public static String hasQoSCondition = "hasQoSCondition";
		public static String hasQoSName = "hasQoSName";
		public static String hasQoSUnit = "hasQoSUnit";
		public static String hasQoSValue = "hasQoSValue";
		public static String hasQoSWeight = "hasQoSWeight";
		
		public static String hasResponseTime = "hasResponseTime";
		public static String hasReliability = "hasReliability";
		public static String hasExecutionPrice = "hasExecutionPrice";
		
		static {
			
			hasQoSCondition = UriUtils.createURI(QoSMetricOntology + hasQoSCondition).toString();
			hasQoSName = UriUtils.createURI(QoSMetricOntology + hasQoSName).toString();
			hasQoSUnit = UriUtils.createURI(QoSMetricOntology + hasQoSUnit).toString();
			hasQoSValue = UriUtils.createURI(QoSMetricOntology + hasQoSValue).toString();
			hasQoSWeight = UriUtils.createURI(QoSMetricOntology + hasQoSWeight).toString();
			
			hasResponseTime = UriUtils.createURI(QoSMetricOntology + hasResponseTime).toString();
			hasReliability = UriUtils.createURI(QoSMetricOntology + hasReliability).toString();
			hasExecutionPrice = UriUtils.createURI(QoSMetricOntology + hasExecutionPrice).toString();
			

		}
	}
}
