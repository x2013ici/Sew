package com.stfx.cli.sew.owls.profile.qos;

import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.QoSProperty;

public interface QosMetric extends OwlIndividual, QoSProperty{
	
	public String getQoSValue();
	public String getQoSCondition();
	
	public String getQoSWeight();
	public String getQoSUnit();

}
