package com.stfx.cli.sew.owl.vocubularylist;

import com.stfx.cli.sew.owl.OwlClass;
import com.stfx.cli.sew.owl.OwlDataProperty;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlObjectProperty;

public interface ListVocabulary {
	
	public OwlClass List();
    public OwlObjectProperty first();
    public OwlDataProperty firstD();
    
    public OwlObjectProperty rest();
    public OwlIndividual nil();
    
    public ListVocabulary specialize(OwlClass listType);

}
