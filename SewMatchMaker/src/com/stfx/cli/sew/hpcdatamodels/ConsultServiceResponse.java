package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ConsultServiceResponse extends ExecuteServiceBaseResponse implements Serializable{
	
	private Consult consult;
	public Consult getConsultationResult(){
		return this.consult;
	}
	public void setConsultationResult(Consult consult){
		this.consult = consult;
	}
}
