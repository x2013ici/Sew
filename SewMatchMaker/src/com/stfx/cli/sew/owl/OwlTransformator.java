package com.stfx.cli.sew.owl;

public interface OwlTransformator {
	
	public OwlValue transformToOWL(Object object);
	
	public Object transformFromOWL(OwlValue ind);
	
	public OwlClass getOWLClass();

}
