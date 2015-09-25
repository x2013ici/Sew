package com.stfx.cli.sew.hpcdatamodels;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Consult extends BaseModel implements Serializable{

	private boolean isConsulted;
	public boolean getIsConsulted(){
		return isConsulted;
	}
	public void setIsConsulted(boolean isConsulted){
		this.isConsulted = isConsulted;
	}
	
	private boolean isEligible;
	public boolean getIsEligble(){
		return this.isEligible;
	}
	public void setIsEligible(boolean isEligible){
		this.isEligible = isEligible;
	}
	
}
