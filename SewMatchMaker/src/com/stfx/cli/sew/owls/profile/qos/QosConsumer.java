package com.stfx.cli.sew.owls.profile.qos;

import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.QoSProperty;

public interface QosConsumer extends OwlIndividual, QoSProperty{
	
	public String getQoSValue();

}
