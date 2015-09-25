package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ExplanationServiceResponse extends ExecuteServiceBaseResponse implements Serializable{
	
	private Explanation explanation;
	public Explanation getExplanation(){
		return explanation;
	}
	public void setExplanation(Explanation explanation){
		this.explanation = explanation;
	}
}