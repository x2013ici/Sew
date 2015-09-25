package com.stfx.cli.sew.owls.Process;

import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlType;
import com.stfx.cli.sew.owl.OwlValue;
import com.stfx.cli.sew.owls.profile.Profile;
import com.stfx.cli.sew.owls.service.Service;

public interface Parameter extends OwlIndividual,Variable{
	
	/**
	 * Get the type of this parameter.
	 * 
	 * @return
	 */
	public OwlType getParamType();

	/**
	 * Set the type for this parameter 
	 * 
	 * @param type
	 */
	public void setParamType(OwlType type);

	
	/**
	 * Get the process object where this parameter occurs
	 * 
	 * @return
	 */
	public Process getProcess();
	
	/**
	 * Get the service object where this parameter occurs
	 * 
	 * @return
	 */
	public Service getService();
	
	/**
	 * Get the profile object where this parameter occurs
	 * 
	 * @return
	 */
	public Profile getProfile();
		
	/**
	 * Set the process for this parameter
	 * 
	 * @param process
	 */
	public void setProcess(Process process);
	
	/**
	 * 
	 * If the parameter has a constant value associated with it (specified
	 * with process:parameterValue property) return that value. There is no
	 * restriction as to the contents of the value. In general, it is supposed 
	 * to be an XMLLiteral
	 * 
	 * @return
	 */
	public OwlValue getConstantValue();
	
	/**
	 * 
	 * Set the constant value for this parameter. 
	 * 
	 * @param value
	 */
	public void setConstantValue(OwlValue value);

}
