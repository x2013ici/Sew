package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SetupAppointmentServiceResponse extends ExecuteServiceBaseResponse
							implements Serializable{

	private Appointment appointent;
	public Appointment getAppointment(){
		return appointent;
	}
	public void setAppointment(Appointment appointment){
		this.appointent = appointment;
	}
	
	
}
