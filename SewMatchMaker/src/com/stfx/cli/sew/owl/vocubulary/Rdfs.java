
package com.stfx.cli.sew.owl.vocubulary;

import java.net.URI;

/**
 * @author Mostafijur Rahman
 *
 */
public class Rdfs {
	public final static String ns = "http://www.w3.org/2000/01/rdf-schema#";

	public final static URI getURI() { 
		return URI.create(ns); 
	} 
	
	public final static URI Class = URI.create(ns + "Class");
	public final static URI Datatype = URI.create(ns + "Datatype");
	public final static URI Literal = URI.create(ns + "Literal");
	
	public final static URI subClassOf = URI.create(ns + "subClassOf");
	public final static URI subPropertyOf = URI.create(ns + "subPropertyOf");
	public final static URI domain = URI.create(ns + "domain");
	public final static URI range = URI.create(ns + "range");
	
	public final static URI label       = URI.create(ns + "label");
	public final static URI comment     = URI.create(ns + "comment");
	public final static URI seeAlso     = URI.create(ns + "seeAlso");
	public final static URI isDefinedBy = URI.create(ns + "isDefinedBy");
	public final static URI versionInfo = URI.create(ns + "versionInfo");
		
}
