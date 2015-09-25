package com.stfx.cli.sew.examples;

import java.util.Set;

import javax.xml.soap.Node;

import org.mindswap.pellet.KnowledgeBase;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;

import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;


public class AssociatePelletReasoner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLOntology ontology = null;
        
        int axioms =0;
        int totalAxioms = 0;
        
		try {
			//ontology = manager.loadOntologyFromOntologyDocument(IRI.create("http://test.biocomalert.com/docs/owl/DrugOntology.owl"));
			ontology = manager.loadOntologyFromOntologyDocument(IRI.create("http://test.biocomalert.com/docs/services/core/Profile.owl"));
			if(ontology != null)
			{
				totalAxioms = ontology.getAxiomCount();
				System.out.println("Ontology Loaded...");
                System.out.println("Ontology : " + ontology.getOntologyID());
                System.out.println("Format      : " + manager.getOntologyFormat(ontology));
				System.out.println("Total Axioms: " + totalAxioms + "\n");
				
				// getImports API
				/*java.util.Set<OWLOntology> importedOntologyList = ontology.getImports();
				if (importedOntologyList.size() >0){
					for(OWLOntology owlOntology : importedOntologyList){
						axioms = owlOntology.getAxiomCount();
						System.out.println("Ontology Loaded...");
		                System.out.println("Ontology : " + owlOntology.getOntologyID());
		                System.out.println("Format      : " + manager.getOntologyFormat(owlOntology));
						System.out.println("Total Axioms: " + axioms + "\n");
					}
				}*/
				
				// getImportsClousure API
				/*java.util.Set<OWLOntology> importedOntologyList = ontology.getImportsClosure();
				if (importedOntologyList.size() >0){
					for(OWLOntology owlOntology : importedOntologyList){
						axioms = owlOntology.getAxiomCount();
						System.out.println("Ontology Loaded...");
		                System.out.println("Ontology : " + owlOntology.getOntologyID());
		                System.out.println("Format      : " + manager.getOntologyFormat(owlOntology));
						System.out.println("Total Axioms: " + axioms + "\n");
					}
				}*/
				
				// getSortedImportsClosure API
				/*java.util.Set<OWLOntology> importedOntologyList = ontology.getImportsClosure();
				if (importedOntologyList.size() >0){
					for(OWLOntology owlOntology : importedOntologyList){
						axioms = owlOntology.getAxiomCount();
						System.out.println("Ontology Loaded...");
		                System.out.println("Ontology : " + owlOntology.getOntologyID());
		                System.out.println("Format      : " + manager.getOntologyFormat(owlOntology));
						System.out.println("Total Axioms: " + axioms + "\n");
					}
				}*/
				
				// getOntologies: java.util.Set<OWLOntology> getOntologies()
				/*java.util.Set<OWLOntology> importedOntologyList = manager.getOntologies();
				if (importedOntologyList.size() >0){
					for(OWLOntology owlOntology : importedOntologyList){
						axioms = owlOntology.getAxiomCount();
						System.out.println("Ontology Loaded...");
		                System.out.println("Ontology : " + owlOntology.getOntologyID());
		                System.out.println("Format      : " + manager.getOntologyFormat(owlOntology));
						System.out.println("Total Axioms: " + axioms + "\n");
					}
				}*/
				
				// getOntologies: java.util.Set<OWLOntology> getOntologies(OWLAxiom axiom)
				
				// contains: boolean contains(java.net.URI ontologyURI)
				boolean isContains = manager.contains(ontology.getOntologyID());
				if(isContains){
					System.out.println("The manager contains " + ontology.getOntologyID());
				}
				else{
					System.out.println("The manager does not contain " + ontology.getOntologyID());
				}
				
				
			}
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		PelletReasoner reasoner = null;
		try
		{
			// create the Pellet reasoner
			reasoner = PelletReasonerFactory.getInstance().createNonBufferingReasoner(ontology);
			if (reasoner != null)
			{
				System.out.println("Reasoner Name: " + reasoner.getReasonerName());
				System.out.println("Reasoner Version: " + reasoner.getReasonerVersion());
				// add the reasoner as an ontology change listener
				//manager.addOntologyChangeListener( reasoner );
				
				for(OWLClass owlCls : ontology.getClassesInSignature())
				{
					if(reasoner.isSatisfiable(owlCls)){
						//System.out.println("XXX: " + labelFor(owlCls));
					}
				}
				
			}
			
			reasoner.getKB().realize();
			reasoner.getKB().printClassTree();
		}
		catch(Exception ex)
		{
			
		}
		
		reasoner.dispose();
		
	}
	
	public KnowledgeBase getKnowledgeBase(){
		return null;
		
	}

}
