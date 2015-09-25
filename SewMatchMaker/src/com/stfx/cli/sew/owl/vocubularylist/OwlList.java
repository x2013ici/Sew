package com.stfx.cli.sew.owl.vocubularylist;

import java.util.Iterator;
import java.util.List;

import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlIndividualList;
import com.stfx.cli.sew.owl.OwlValue;

public interface OwlList extends OwlIndividual{
	
	public OwlValue getFirstValue();

    public void setFirst(OwlValue first);

    public OwlList getRest();

    public void setRest(OwlList rest);
        
    public ListVocabulary getVocabulary();

    public OwlIndividualList getAll();

    public List getAllValues();
    
    public OwlIndividual get(int index); 
    
    public OwlValue getValue(int index);
    
    public OwlList add(OwlValue item);
    
    public OwlList insert(OwlValue item);
    
    public OwlList insertAt(int index, OwlValue item);

    public void set(int index, OwlValue item);    
        
    public Iterator iterator();
    
    public int size();
    
    public boolean isEmpty(); 
    
    public OwlList remove(OwlValue value);
    
    public OwlList removeAt(int index);
    
    public OwlList remove();
        
    public OwlList removeAll();

}
