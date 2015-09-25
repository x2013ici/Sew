package com.stfx.cli.sew.owls.Process;

import java.net.URI;

public interface OutputList extends ParameterList{
	
	public Output outputAt(int index);
	public Output getOutput(URI outputURI);

}
