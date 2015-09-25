package com.stfx.cli.sew.owls.Process;

import java.net.URI;

import com.stfx.cli.sew.owl.OwlIndividualList;

public interface ParameterList extends OwlIndividualList{

	public Parameter parameterAt(int index);	
	
	public Parameter getParameter(URI parameterURI);
	
	public Parameter getParameter(String localName);
}
