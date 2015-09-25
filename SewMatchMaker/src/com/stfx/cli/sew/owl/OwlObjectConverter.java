package com.stfx.cli.sew.owl;

public interface OwlObjectConverter {
	
	public boolean canCast(OwlObject object);
	public OwlObject cast(OwlObject object);
}
