package com.stfx.cli.sew.owls.profile;

import java.net.URI;

import com.stfx.cli.sew.owl.OwlDataValueList;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlIndividualList;
import com.stfx.cli.sew.owl.OwlObjectProperty;
import com.stfx.cli.sew.owls.Process.Input;
import com.stfx.cli.sew.owls.Process.InputList;
import com.stfx.cli.sew.owls.Process.Output;
import com.stfx.cli.sew.owls.Process.OutputList;
import com.stfx.cli.sew.owls.service.Service;

public interface Profile extends OwlIndividual{

	
	/**
	 * 
	 * @return
	 */
	public Service getService();
	
	//public void setService(Service service);
	
	//public void removeService();
		
	/**
	 * 
	 * @return
	 */
	public Process getProcess();

	//public void setTextDescription(String desc);
	
	/**
	 * 
	 * @return
	 */
	public String getTextDescription();
	
	/**
	 * 
	 * @param lang
	 * @return
	 */
	public String getTextDescription(String lang);
	
	/**
	 * 
	 * @return
	 */
	public OwlDataValueList getTextDescriptions();
	
	/**
	 * 
	 * @return
	 */
	public String getServiceName();
	
	/**
	 * 
	 * @param lang
	 * @return
	 */
	public String getServiceName(String lang);
	
	/**
	 * 
	 * @return
	 */
	public OwlDataValueList getServiceNames();
	
	//public void setServiceName(String desc);
	
	//public void addInput(Input input);
	
	//public void addOutput(Output output);
	
	//public void addInputs(InputList inputs);
	
	//public void addOutputs(OutputList inputs);
	
	/**
	 * 
	 * @return
	 */
	public InputList getInputs();
	
	/**
	 * 
	 * @return
	 */
	public OutputList getOutputs();
	
}
