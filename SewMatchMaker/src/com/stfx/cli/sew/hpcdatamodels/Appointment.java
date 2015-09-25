package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Appointment extends BaseModel implements Serializable{
	
	private String appointmentName;
	public String getAppointmentName(){
		return this.appointmentName;
	}
	public void setAppointmentName(String appointmentName){
		this.appointmentName = appointmentName;
	}
	
	private boolean isAppointmentSetup;
	public boolean getIsAppointmentSetup(){
		return this.isAppointmentSetup;
	}
	public void setIsAppointmentSetup(boolean isAppointentSetup){
		this.isAppointmentSetup = isAppointentSetup;
	}
	
	private Patient selectedPatient;
	public Patient getSelectedPatient(){
		return this.selectedPatient;
	}
	public void setSelectedPatient(Patient selectedPatient){
		this.selectedPatient = selectedPatient;
	}
	
	private Physician selectedPhysician;
	public Physician getSelectedPhysician(){
		return this.selectedPhysician;
	}
	public void setSelectedPhysician(Physician selectedPhysician){
		this.selectedPhysician = selectedPhysician;
	}
}
