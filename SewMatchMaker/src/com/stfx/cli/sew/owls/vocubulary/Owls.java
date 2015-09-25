package com.stfx.cli.sew.owls.vocubulary;

import com.stfx.cli.sew.owl.EntityFactory;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.utilities.UriUtils;

public class Owls{
	
	public static String base = "http://test.biocomalert.com/docs/services/core/";
	//public static String version = "1.2";
	public static String version = "";
	//public static String URI = base + version + "/";
	public static String URI = base + version;
	
	
	/**
	 * Vocabulary for the Service Ontology
	 *
	 */
	public static class Service {
		
		public static String URI = Owls.URI + "Service.owl#";	

		public static String Service;
		public static String ServiceProfile;
		public static String ServiceModel;
		public static String ServiceGrounding;

		public static String presentedBy;
		public static String presents;
		
		public static String describedBy;
		public static String describes;
		
		public static String supportedBy;
		public static String supports;
		
		public static String provides;
		public static String providedBy;
		
		static {
			Service = UriUtils.createURI(URI + "Service").toString();
			ServiceProfile = UriUtils.createURI(URI + "ServiceProfile").toString();
			ServiceModel = UriUtils.createURI(URI + "ServiceModel").toString();
			ServiceGrounding = UriUtils.createURI(URI + "ServiceGrounding").toString();

			presentedBy = UriUtils.createURI(URI + "presentedBy").toString();
			presents    = UriUtils.createURI(URI + "presents").toString();
			describedBy = UriUtils.createURI(URI + "describedBy").toString();
			describes   = UriUtils.createURI(URI + "describes").toString();
			supportedBy = UriUtils.createURI(URI + "supportedBy").toString();
			supports    = UriUtils.createURI(URI + "supports").toString();	
			provides = UriUtils.createURI(URI + "provides").toString();
			providedBy = UriUtils.createURI(URI + "providedBy").toString();
		}		
	}

	/**
	 * Vocabulary for the Profile Ontology
	 *
	 */
	public static class Profile {
		
		public static String URI = Owls.URI + "Profile.owl#";
		
		public static String Profile;

		public static String serviceName;
		public static String textDescription;
		
		public static String hasProcess;
		
		public static String ServiceParameter;
		public static String serviceParameter;
		public static String serviceParameterName;
		public static String sParameter;

		public static String ServiceCategory;
		public static String serviceCategory;
		public static String categoryName;
		public static String taxonomy;
		public static String value;
		public static String code;
		
		public static String serviceClassification;
		public static String serviceProduct;
		
		public static String hasInput;
		public static String hasOutput;
		public static String hasPrecondition;
		public static String hasParameter;
		public static String hasResult;

		public static String contactInformation;
		
		static {
			Profile         = UriUtils.createURI(URI + "Profile").toString();
			serviceName     = UriUtils.createURI(URI + "serviceName").toString();
			textDescription = UriUtils.createURI(URI + "textDescription").toString();
			
			ServiceParameter = UriUtils.createURI(URI + "ServiceParameter").toString();
			serviceParameter = UriUtils.createURI(URI + "serviceParameter").toString();
			serviceParameterName = UriUtils.createURI(URI + "serviceParameterName").toString();
			sParameter       = UriUtils.createURI(URI + "sParameter").toString();
			
			hasProcess      = UriUtils.createURI(URI + "has_process").toString();
			hasInput        = UriUtils.createURI(URI + "hasInput").toString();
			hasOutput       = UriUtils.createURI(URI + "hasOutput").toString();
			hasPrecondition = UriUtils.createURI(URI + "hasPrecondition").toString();
			hasParameter    = UriUtils.createURI(URI + "hasParameter").toString();			

			hasResult = UriUtils.createURI(URI + "hasResult").toString();

			
			ServiceCategory = UriUtils.createURI(URI + "ServiceCategory").toString();
			serviceCategory = UriUtils.createURI(URI + "serviceCategory").toString();
			categoryName    = UriUtils.createURI(URI + "categoryName").toString();
			taxonomy        = UriUtils.createURI(URI + "taxonomy").toString();
			value           = UriUtils.createURI(URI + "value").toString();
			code            = UriUtils.createURI(URI + "code").toString();	
			
			serviceClassification = UriUtils.createURI(URI + "serviceClassification").toString();
			serviceProduct = UriUtils.createURI(URI + "serviceProduct").toString();
			
			contactInformation = UriUtils.createURI(URI + "contactInformation").toString();
		}
	}

	
	public static class QosProfile{
		
		public static String URI = Owls.URI + "QoSProfile.owl#";
		
		// Concepts
		public static String QoSProfile;
		public static String QoSConsumerProfile;
		public static String QoSProviderProfile;
		public static String QoSProperty;
		
		// Object Properties
		public static String hasQoSProfile;
		public static String hasQoSConsumerProfile;
		public static String hasQoSProviderProfile;
		public static String hasQoSProperty;
		
		// Data Properties
		public static String hasQoSCondition;
		public static String hasQoSParameter;
		public static String hasQoSValue;
		
		static {
			QoSProfile = UriUtils.createURI(URI + "QoSProfile").toString();
			QoSConsumerProfile = UriUtils.createURI(URI + "QoSConsumerProfile").toString();
			QoSProviderProfile = UriUtils.createURI(URI + "QoSProviderProfile").toString();
			QoSProperty = UriUtils.createURI(URI + "QoSProperty").toString();
			
			hasQoSProfile = UriUtils.createURI(URI + "hasQoSProfile").toString();
			hasQoSConsumerProfile = UriUtils.createURI(URI + "hasQoSConsumerProfile").toString();
			hasQoSProviderProfile = UriUtils.createURI(URI + "hasQoSProviderProfile").toString();
			hasQoSProperty = UriUtils.createURI(URI + "hasQoSProperty").toString();
			
			hasQoSCondition = UriUtils.createURI(URI + "hasQoSCondition").toString();
			hasQoSParameter = UriUtils.createURI(URI + "hasQoSParameter").toString();
			hasQoSValue = UriUtils.createURI(URI + "hasQoSValue").toString();
		}
	}
	
	
	/**
	 * Vocabulary for the QoSModel Ontology
	 *
	 */
	public static class QoSModel {
		
		public static String URI = Owls.URI + "QoSModel.owl#";
		
		/**
		 * String
		 */
		public static String QoSModel;
		public static String QoSProvider;
		public static String QoSConsumer;
		
		public static String QoSValue;
		public static String QoSCondition;
		
		public static String ResponseTime;
		public static String Reliability;
		public static String ExecutionPrice; 
		
		/**
		 * String
		 */
		
		public static String hasQoSConsumer;
		public static String hasQoSModel;
		public static String hasQoSProvider;
		public static String hasReliability;
		public static String hasResponseTime;
		public static String hasExecutionPrice;
		
		/**
		 * String
		 */
		public static String hasQoSCondition;
		public static String hasQoSValue;
		
		static {
			
			QoSModel = UriUtils.createURI(URI + "QoSModel").toString();
			QoSProvider = UriUtils.createURI(URI + "QoSProvider").toString();
			QoSConsumer = UriUtils.createURI(URI + "QoSConsumer").toString();
			QoSValue = UriUtils.createURI(URI + "QoSValue").toString();
			QoSCondition = UriUtils.createURI(URI + "QoSCondition").toString();
			ResponseTime = UriUtils.createURI(URI + "ResponseTime").toString();
			Reliability = UriUtils.createURI(URI + "Reliability").toString();
			ExecutionPrice = UriUtils.createURI(URI + "ExecutionPrice").toString();
			
			hasQoSConsumer = UriUtils.createURI(URI + "hasQoSConsumer").toString();
			hasQoSModel = UriUtils.createURI(URI + "hasQoSModel").toString();
			hasQoSProvider = UriUtils.createURI(URI + "hasQoSProvider").toString();
			hasReliability = UriUtils.createURI(URI + "hasReliability").toString();
			hasReliability = UriUtils.createURI(URI + "hasReliability").toString();
			hasExecutionPrice = UriUtils.createURI(URI + "hasExecutionPrice").toString();
			
			hasQoSCondition = UriUtils.createURI(URI + "hasQoSCondition").toString();
			hasQoSValue = UriUtils.createURI(URI + "hasQoSValue").toString();
		}
	}
		
	/**
	 * Vocabulary for the Process Ontology
	 *
	 */
	public static class Process {
		
        public static String URI = Owls.URI + "Process.owl#";	
		
		public static String Process;
		public static String AtomicProcess;
		public static String CompositeProcess;		
		public static String SimpleProcess;
		public static String Parameter;
		public static String Input;
		public static String Output;
		public static String Precondition;
		public static String Effect;
		
		public static String parameterType;
		public static String hasParameter;
		public static String hasInput;
		public static String hasOutput;
		public static String hasPrecondition;		
		
		public static String name;
		
		public static String ControlConstruct;
		public static String ControlConstructList;
		public static String ControlConstructBag;
		public static String Sequence;
		public static String AnyOrder;
		public static String Choice;
		public static String IfThenElse;
		public static String Produce;
		public static String Split;
		public static String SplitJoin;
		public static String Iterate;
		public static String RepeatUntil;
		public static String RepeatWhile;
		
		
		public static String ForEach;
		
		public static String theList;
		
		public static String theLoopVar;
		
		public static String iterateBody;
		
		public static String ValueOf;		

		public static String composedOf;
		public static String components;		
		public static String ifCondition;
		public static String thenP;
		public static String elseP;
		public static String untilProcess;
		public static String untilCondition;
		public static String whileProcess;
		public static String whileCondition;
		public static String producedBinding;
		public static String realizedBy;
		public static String expandsTo;
		
		public static String Perform;
		public static String process;
		public static String hasDataFrom;
		public static String Binding;
		public static String InputBinding;
		public static String OutputBinding;
		
		public static String parameterValue;
		
		public static String hasResult;
		public static String Result;
		public static String ResultVar;
		public static String hasResultVar;
		
		public static String hasLocal;
		public static String Local;
		
		public static String inCondition;
		public static String hasEffect;
		public static String toParam;
		public static String withOutput;
		public static String valueSource;
		public static String fromProcess;
		public static String theVar;
		
		public static String valueSpecifier;
		public static String valueFunction;
		public static String valueForm;
		public static String valueData;
        public static String valueObject;
        
		public static String TheParentPerform;
		public static String ThisPerform;
		
		static {
			Process          = UriUtils.createURI(URI + "Process").toString();
			AtomicProcess    = UriUtils.createURI(URI + "AtomicProcess").toString();
			CompositeProcess = UriUtils.createURI(URI + "CompositeProcess").toString();		
			SimpleProcess    = UriUtils.createURI(URI + "SimpleProcess").toString();
			Parameter        = UriUtils.createURI(URI + "Parameter").toString();
			Input            = UriUtils.createURI(URI + "Input").toString();
			Output           = UriUtils.createURI(URI + "Output").toString();
			Precondition     = UriUtils.createURI(URI + "Precondition").toString();
			Effect           = UriUtils.createURI(URI + "Effect").toString();
			
			parameterType   = UriUtils.createURI(URI + "parameterType").toString();
			hasParameter    = UriUtils.createURI(URI + "hasParameter").toString();
			hasInput        = UriUtils.createURI(URI + "hasInput").toString();
			hasOutput       = UriUtils.createURI(URI + "hasOutput").toString();
			hasPrecondition = UriUtils.createURI(URI + "hasPrecondition").toString();
			
			name			= UriUtils.createURI(URI + "name").toString();
			
			ControlConstructList = UriUtils.createURI(URI + "ControlConstructList").toString();
			ControlConstructBag = UriUtils.createURI(URI + "ControlConstructBag").toString();
			ControlConstruct = UriUtils.createURI(URI + "ControlConstruct").toString();
			Sequence         = UriUtils.createURI(URI + "Sequence").toString();
			AnyOrder         = UriUtils.createURI(URI + "Any-Order").toString();
			Choice           = UriUtils.createURI(URI + "Choice").toString();
			IfThenElse       = UriUtils.createURI(URI + "If-Then-Else").toString();
			Produce          = UriUtils.createURI(URI + "Produce").toString();
			Split            = UriUtils.createURI(URI + "Split").toString();
			SplitJoin        = UriUtils.createURI(URI + "Split-Join").toString();
			Iterate          = UriUtils.createURI(URI + "Iterate").toString();
			RepeatUntil      = UriUtils.createURI(URI + "Repeat-Until").toString();
			RepeatWhile      = UriUtils.createURI(URI + "Repeat-While").toString();
			
			
			ForEach    = UriUtils.createURI(URI + "For-Each").toString();
			theList = UriUtils.createURI(URI + "theList").toString();
			theLoopVar = UriUtils.createURI(URI + "theLoopVar").toString();
			iterateBody = UriUtils.createURI(URI + "iterateBody").toString();
			
			ValueOf          = UriUtils.createURI(URI + "ValueOf").toString();		

			composedOf   = UriUtils.createURI(URI + "composedOf").toString();
			components   = UriUtils.createURI(URI + "components").toString();
			ifCondition  = UriUtils.createURI(URI + "ifCondition").toString();
			thenP        = UriUtils.createURI(URI + "then").toString();
			elseP        = UriUtils.createURI(URI + "else").toString();
			untilProcess   = UriUtils.createURI(URI + "untilProcess").toString();
			untilCondition = UriUtils.createURI(URI + "untilCondition").toString();
			whileProcess   = UriUtils.createURI(URI + "whileProcess").toString();
			whileCondition = UriUtils.createURI(URI + "whileCondition").toString();
			producedBinding = UriUtils.createURI(URI + "producedBinding").toString();
			realizedBy = UriUtils.createURI(URI + "realizedBy").toString();
			expandsTo = UriUtils.createURI(URI + "expandsTo").toString();			
			
			Perform = UriUtils.createURI(URI + "Perform").toString();
			process = UriUtils.createURI(URI + "process").toString();
			hasDataFrom = UriUtils.createURI(URI + "hasDataFrom").toString();
			Binding = UriUtils.createURI(URI + "Binding").toString();
			InputBinding = UriUtils.createURI(URI + "InputBinding").toString();
			OutputBinding = UriUtils.createURI(URI + "OutputBinding").toString();
			
			parameterValue = UriUtils.createURI(URI + "parameterValue").toString();
			
			hasResult = UriUtils.createURI(URI + "hasResult").toString();
			Result = UriUtils.createURI(URI + "Result").toString();
			ResultVar = UriUtils.createURI(URI + "ResultVar").toString();
			hasResultVar = UriUtils.createURI(URI + "hasResultVar").toString();
			
			hasLocal = UriUtils.createURI(URI + "hasLocal").toString();
			Local = UriUtils.createURI(URI + "Local").toString();
			
			inCondition = UriUtils.createURI(URI + "inCondition").toString();
			hasEffect    = UriUtils.createURI(URI + "hasEffect").toString();
			toParam = UriUtils.createURI(URI + "toParam").toString();
			withOutput = UriUtils.createURI(URI + "withOutput").toString();
			valueSource = UriUtils.createURI(URI + "valueSource").toString();
			fromProcess = UriUtils.createURI(URI + "fromProcess").toString();
			theVar = UriUtils.createURI(URI + "theVar").toString();
			
			valueSpecifier = UriUtils.createURI(URI + "valueSpecifier").toString();
			valueFunction = UriUtils.createURI(URI + "valueFunction").toString();
			valueForm = UriUtils.createURI(URI + "valueFrom").toString();
			valueData = UriUtils.createURI(URI + "valueData").toString();
            valueObject = UriUtils.createURI(URI + "valueObject").toString();
					
			TheParentPerform = UriUtils.createURI(URI + "TheParentPerform").toString();
			ThisPerform = UriUtils.createURI(URI + "ThisPerform").toString();
			
		}		
	}

	/**
	 * Vocabulary for the Grounding Ontology
	 *
	 */
	public static class Grounding {
		public static String URI = Owls.URI + "Grounding.owl#";
		
		public static String WsdlGrounding;

		public static String hasAtomicProcessGrounding;
		public static String WsdlAtomicProcessGrounding;

		public static String wsdlOperation;
		public static String WsdlOperationRef;
		public static String portType;
		public static String operation;
		
		public static String wsdlDocument;
		public static String wsdlService;
		public static String owlsProcess;

		public static String wsdlInputMessage;
		public static String wsdlInput;
		
		public static String wsdlOutputMessage;
		public static String wsdlOutput;
		
		public static String WsdlMessageMap;
		public static String WsdlInputMessageMap;
		public static String WsdlOutputMessageMap;
		public static String wsdlMessagePart;
		public static String owlsParameter;
		public static String xsltTransformation;
		public static String xsltTransformationString;
		public static String xsltTransformationURI;
		
		static {
			
			WsdlGrounding = UriUtils.createURI(URI + "WsdlGrounding").toString();
			WsdlAtomicProcessGrounding = UriUtils.createURI(URI + "WsdlAtomicProcessGrounding").toString();
			WsdlOperationRef = UriUtils.createURI(URI + "WsdlOperationRef").toString();
			
			hasAtomicProcessGrounding = UriUtils.createURI(URI + "hasAtomicProcessGrounding").toString();
			wsdlDocument      = UriUtils.createURI(URI + "wsdlDocument").toString();
			wsdlOperation     = UriUtils.createURI(URI + "wsdlOperation").toString();
			portType          = UriUtils.createURI(URI + "portType").toString();
			operation         = UriUtils.createURI(URI + "operation").toString();
			owlsProcess       = UriUtils.createURI(URI + "owlsProcess").toString();
			wsdlInputMessage  = UriUtils.createURI(URI + "wsdlInputMessage").toString();
			wsdlOutputMessage = UriUtils.createURI(URI + "wsdlOutputMessage").toString();
			wsdlInput         = UriUtils.createURI(URI + "wsdlInput").toString();
			wsdlOutput        = UriUtils.createURI(URI + "wsdlOutput").toString();
			
			WsdlMessageMap    = UriUtils.createURI(URI + "WsdlMessageMap").toString();
			WsdlInputMessageMap    = UriUtils.createURI(URI + "WsdlInputMessageMap").toString();
			WsdlOutputMessageMap    = UriUtils.createURI(URI + "WsdlOutputMessageMap").toString();
			wsdlMessagePart   = UriUtils.createURI(URI + "wsdlMessagePart").toString();
			owlsParameter     = UriUtils.createURI(URI + "owlsParameter").toString();
			xsltTransformation = UriUtils.createURI(URI + "xsltTransformation").toString();		
			xsltTransformationString = UriUtils.createURI(URI + "xsltTransformationString").toString();		
			xsltTransformationURI = UriUtils.createURI(URI + "xsltTransformationURI").toString();		
		}
	}

	/**
	 * Vocabulary for the Expression Ontology
	 *
	 */
	public static class Expression {
		
		public static String URI = Owls.URI + "generic/Expression.owl#";
		
		public static String LogicLanguage;
		public static String Expression;	
		public static String Condition;	
		
		public static OwlIndividual KIF;
		public static OwlIndividual SWRL;	
		public static OwlIndividual DRS;	
		
		public static String KIF_Condition;	
		public static String SWRL_Condition;	
		public static String DRS_Condition;	
		
		public static String KIF_Expression;	
		public static String SWRL_Expression;	
		public static String DRS_Expression;	
		
		public static java.net.URI KIFref;	
		public static java.net.URI SWRLref;	
		public static java.net.URI DRSref;	
		public static java.net.URI SPARQLref;
		
		public static String refURI;
		public static String expressionLanguage;
		public static String expressionBody;
		public static String expressionData;
        public static String expressionObject;
        
        public static OwlIndividual AlwaysTrue;
		
		static {
			
			LogicLanguage = UriUtils.createURI(URI + "LogicLanguage").toString();
			Expression = UriUtils.createURI(URI + "Expression").toString();	
			Condition = UriUtils.createURI(URI + "Condition").toString();	
			
			expressionLanguage = UriUtils.createURI(URI + "expressionLanguage").toString();
			expressionBody = UriUtils.createURI(URI + "expressionBody").toString();
			expressionData = UriUtils.createURI(URI + "expressionData").toString();
            expressionObject = UriUtils.createURI(URI + "expressionObject").toString();
			refURI = UriUtils.createURI(URI + "refURI").toString();
			
			KIF_Condition = UriUtils.createURI(URI + "KIF-Condition").toString();	
			SWRL_Condition = UriUtils.createURI(URI +  "SWRL-Condition").toString();	
			DRS_Condition = UriUtils.createURI(URI + "DRS-Condition").toString();	
			
			KIF_Expression = UriUtils.createURI(URI + "KIF-Expression").toString();	
			SWRL_Expression = UriUtils.createURI(URI +  "SWRL-Expression").toString();	
			DRS_Expression = UriUtils.createURI(URI + "DRS-Expression").toString();	
			
			KIF  = EntityFactory.createIndividual(UriUtils.createURI(URI + "KIF"));	
			SWRL = EntityFactory.createIndividual(UriUtils.createURI(URI + "SWRL"));	
			DRS  = EntityFactory.createIndividual(UriUtils.createURI(URI + "DRS"));			
			
			//DRS.setProperty(refURI, DRS);
            
            AlwaysTrue = EntityFactory.createIndividual(UriUtils.createURI(URI + "AlwaysTrue"));
		}
	}
	
	/**
	 * Vocabulary for the Actor Ontology
	 *
	 */
	public static class Actor {
	    public static String URI = Owls.URI + "ActorDefault.owl#";
	        
	    public static String Actor = UriUtils.createURI(URI + "Actor").toString();
	    public static String email = UriUtils.createURI(URI + "email").toString();
	    public static String fax = UriUtils.createURI(URI + "fax").toString();
	    public static String name = UriUtils.createURI(URI + "name").toString();
	    public static String phone = UriUtils.createURI(URI + "phone").toString();
	    public static String physicalAddress = UriUtils.createURI(URI + "physicalAddress").toString();
	    public static String title = UriUtils.createURI(URI + "title").toString();
	    public static String webURL = UriUtils.createURI(URI +  "webURL").toString();
	}

}
