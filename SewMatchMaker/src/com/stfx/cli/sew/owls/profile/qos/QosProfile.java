package com.stfx.cli.sew.owls.profile.qos;

import com.stfx.cli.sew.owls.profile.Profile;

public interface QosProfile extends Profile{
	
	/**
	 * 
	 * @return
	 */
	public QosConsumer getQoSConsumer();
	
	/**
	 * 
	 * @return
	 */
	public QosProvider getQoSProvider();
	
	/**
	 * 
	 * @return
	 */
	public QosProperty getQoSProperty();
	
	/**
	 * 
	 * @return
	 */
	public QosMetric getQoSMetric();
	
}
