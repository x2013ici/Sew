package com.stfx.cli.sew.owl.vocubularylist;

import java.net.URI;

import com.stfx.cli.sew.owl.EntityFactory;
import com.stfx.cli.sew.owl.OwlClass;
import com.stfx.cli.sew.owl.OwlDataProperty;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlObjectProperty;
import com.stfx.cli.sew.utilities.UriUtils;

public class GenericListVocabulary implements ListVocabulary{

private OwlClass List;
    
    private OwlObjectProperty first;
    private OwlDataProperty firstD;
    private OwlObjectProperty rest;
    
    private OwlIndividual nil;
    
    private Class javaClass;

    public GenericListVocabulary(URI baseURI) {
		this.List = EntityFactory.createClass(UriUtils.createURI(baseURI, "List"));
		this.first = EntityFactory.createObjectProperty(UriUtils.createURI(baseURI, "first"));
		this.firstD = EntityFactory.createDataProperty(UriUtils.createURI(baseURI, "first"));
		this.rest = EntityFactory.createObjectProperty(UriUtils.createURI(baseURI, "rest"));
		this.nil = EntityFactory.createIndividual(UriUtils.createURI(baseURI, "nil"));
	}
    
    public GenericListVocabulary(URI List, URI first, URI rest, URI nil) {
		this.List = EntityFactory.createClass(List);
		this.first = EntityFactory.createObjectProperty(first);
		this.firstD = EntityFactory.createDataProperty(first);
		this.rest = EntityFactory.createObjectProperty(rest);
		this.nil = EntityFactory.createIndividual(nil);
	}

    public GenericListVocabulary(URI List, URI first, URI firstD, URI rest, URI nil) {
		this.List = EntityFactory.createClass(List);
		this.first = EntityFactory.createObjectProperty(first);
		this.firstD = EntityFactory.createDataProperty(firstD);
		this.rest = EntityFactory.createObjectProperty(rest);
		this.nil = EntityFactory.createIndividual(nil);
	}

    public GenericListVocabulary(OwlClass List, OwlObjectProperty first, OwlDataProperty firstD,
                                 OwlObjectProperty rest, OwlIndividual nil) {
        this.List = List;
        this.first = first;
        this.firstD = firstD;
        this.rest = rest;
        this.nil = nil;
    }
    
    public OwlClass List() {
        return List;
    }

    public OwlObjectProperty first() {
        return first;
    }

    public OwlDataProperty firstD() {
        return firstD;
    }    
    
    public OwlObjectProperty rest() {
        return rest;
    }

    public OwlIndividual nil() {
        return nil;
    }
    
    public Class getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(Class javaClass) {
        this.javaClass = javaClass;
    }
    
    public ListVocabulary specialize(OwlClass listType) {
        return  new GenericListVocabulary(listType, first, firstD, rest, nil);
    }
}
