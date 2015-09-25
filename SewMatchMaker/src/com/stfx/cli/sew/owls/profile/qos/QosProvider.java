package com.stfx.cli.sew.owls.profile.qos;

import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.QoSProperty;

public interface QosProvider extends OwlIndividual,QoSProperty{

	public String getQoSCondition();
	
}
