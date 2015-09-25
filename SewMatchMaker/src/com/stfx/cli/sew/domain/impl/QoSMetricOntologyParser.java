package com.stfx.cli.sew.domain.impl;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import com.stfx.cli.sew.domain.QoSMetricOntology;

public class QoSMetricOntologyParser {

	
	public QoSMetricOntologyParser(){
		
	}
	/**
	 * 
	 */
	public static volatile QoSMetricOntologyParser qosMetricOntologyParser = null;
	public static QoSMetricOntologyParser createDrugOntologyManagerInstance(){
		if(qosMetricOntologyParser == null){
			synchronized(DrugOntologyParser.class){
				qosMetricOntologyParser = new QoSMetricOntologyParser();
			}
		}
		return qosMetricOntologyParser;
	}
	
	/**
	 * 
	 */
	public static volatile OWLOntologyManager qosMetricOntologyManager = null;
	public static OWLOntologyManager createOwlOntologyManager(){
		if(qosMetricOntologyManager == null){
			synchronized(OWLOntologyManager.class){
				qosMetricOntologyManager = OWLManager.createOWLOntologyManager();
			}
		}
		return qosMetricOntologyManager;
	}
	
	/**
	 * 
	 */
	public static volatile OWLOntology qosMetricOntology = null; 
	public static OWLOntology createOwlOntology(){
		
		OWLOntologyManager owlOntologyManager = null;
		if(qosMetricOntology == null){
			
			owlOntologyManager = createOwlOntologyManager();
			synchronized(OWLOntology.class){
				if (owlOntologyManager !=null){
					try {
						qosMetricOntology = owlOntologyManager.loadOntologyFromOntologyDocument(IRI.create(QoSMetricOntology.QoSMetricOntologyCoreUri));
					} catch (OWLOntologyCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return qosMetricOntology;
	}
	
	/**
	 * 
	 */
	public static volatile OWLDataFactory qosMetricDataFactory = null;
	public static OWLDataFactory createOwlDataFactory(){
		
		OWLOntologyManager owlOntologyManager = null;
		if(qosMetricDataFactory == null){
			owlOntologyManager = createOwlOntologyManager();
			synchronized(OWLDataFactory.class){
				qosMetricDataFactory = owlOntologyManager.getOWLDataFactory();
			}
		}
		return qosMetricDataFactory;
	}

}
