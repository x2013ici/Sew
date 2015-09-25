package com.stfx.cli.sew.owl;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */
public interface OwlObject {
	
	public OwlObject getNextView();
    
    public void setNextView(OwlObject nextView);

    public OwlObject castTo(Class javaClass);
    
    public boolean canCastTo(Class javaClass);
    
	public String getName();
	
	public Object getImplementation();

}
