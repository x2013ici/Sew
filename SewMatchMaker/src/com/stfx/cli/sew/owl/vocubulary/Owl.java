package com.stfx.cli.sew.owl.vocubulary;

import java.net.URI;

import com.stfx.cli.sew.owl.EntityFactory;
import com.stfx.cli.sew.owl.OwlClass;
import com.stfx.cli.sew.utilities.UriUtils;

/**
 * 
 * @author Mostafijur Rahman
 *
 */
public class Owl {
	
	public final static String ns = "http://www.w3.org/2002/07/owl#";

	public final static URI getURI() { return URI.create(ns); } 
	
	public final static OwlClass Thing   = 
	    EntityFactory.createClass(UriUtils.createURI(ns + "Thing"));
	public final static OwlClass Nothing = 
	    EntityFactory.createClass(UriUtils.createURI(ns + "Nothing"));
 
	
	public final static URI versionInfo   = URI.create(ns + "versionInfo");
	public final static URI backwardCompatibleWith   = URI.create(ns + "backwardCompatibleWith");
	
	public final static URI priorVersion   = URI.create(ns + "priorVersion");
	public final static URI incompatibleWith   = URI.create(ns + "incompatibleWith");
	
	public final static URI sameAs   		= URI.create(ns + "sameAs");
	public final static URI differentFrom   = URI.create(ns + "differentFrom");
	
	public final static URI bottomDataProperty = URI.create(ns + "BottomDataProperty");
	public final static URI bottomObjectProperty = URI.create(ns + "BottomObjectProperty");
	
	public final static URI topDataProperty = URI.create(ns + "TopDataProperty");
	public final static URI topObjectProperty = URI.create(ns + "owl:TopObjectProperty");
	
	public final static OwlClass Ontology = 
			EntityFactory.createClass(UriUtils.createURI(ns + "Ontology"));	
		
	public final static URI imports       = URI.create(ns + "imports");	
	public final static URI inverseOf       = URI.create(ns + "inverseOf");
}
