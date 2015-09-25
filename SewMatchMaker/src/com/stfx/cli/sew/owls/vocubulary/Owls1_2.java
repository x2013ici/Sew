package com.stfx.cli.sew.owls.vocubulary;

import com.stfx.cli.sew.owl.EntityFactory;
import com.stfx.cli.sew.owl.OwlClass;
import com.stfx.cli.sew.owl.OwlDataProperty;
import com.stfx.cli.sew.owl.OwlIndividual;
import com.stfx.cli.sew.owl.OwlObjectProperty;
import com.stfx.cli.sew.utilities.UriUtils;

/**
 * 
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class Owls1_2 {
	
	public static String base = "http://test.biocomalert.com/docs/services/core/";
	//public static String version = "1.2";
	public static String version = "";
	public static String URI = base + version + "/";
	
	
	/**
	 * Vocabulary for the Service Ontology
	 *
	 */
	public static class Service {
		
		public static String URI = Owls1_2.URI + "Service.owl#";	

		public static OwlClass Service;
		public static OwlClass ServiceProfile;
		public static OwlClass ServiceModel;
		public static OwlClass ServiceGrounding;

		public static OwlObjectProperty presentedBy;
		public static OwlObjectProperty presents;
		public static OwlObjectProperty describedBy;
		public static OwlObjectProperty describes;
		public static OwlObjectProperty supportedBy;
		public static OwlObjectProperty supports;
		
		static {
			Service = EntityFactory.createClass(UriUtils.createURI(URI + "Service"));
			ServiceProfile = EntityFactory.createClass(UriUtils.createURI(URI + "ServiceProfile"));
			ServiceModel = EntityFactory.createClass(UriUtils.createURI(URI + "ServiceModel"));
			ServiceGrounding = EntityFactory.createClass(UriUtils.createURI(URI + "ServiceGrounding"));

			presentedBy = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "presentedBy"));
			presents    = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "presents"));
			describedBy = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "describedBy"));
			describes   = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "describes"));
			supportedBy = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "supportedBy"));
			supports    = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "supports"));			
		}		
	}

	/**
	 * Vocabulary for the Profile Ontology
	 *
	 */
	public static class Profile {
		
		public static String URI = Owls1_2.URI + "Profile.owl#";
		
		public static OwlClass Profile;

		public static OwlDataProperty serviceName;
		public static OwlDataProperty textDescription;
		
		public static OwlObjectProperty hasProcess;
		
		public static OwlClass ServiceParameter;
		public static OwlObjectProperty serviceParameter;
		public static OwlDataProperty serviceParameterName;
		public static OwlObjectProperty sParameter;

		public static OwlClass ServiceCategory;
		public static OwlObjectProperty serviceCategory;
		public static OwlDataProperty categoryName;
		public static OwlDataProperty taxonomy;
		public static OwlDataProperty value;
		public static OwlDataProperty code;
		
		public static OwlDataProperty serviceClassification;
		public static OwlDataProperty serviceProduct;
		
		public static OwlObjectProperty hasInput;
		public static OwlObjectProperty hasOutput;
		public static OwlObjectProperty hasPrecondition;
		public static OwlObjectProperty hasParameter;
		public static OwlObjectProperty hasResult;

		public static OwlObjectProperty contactInformation;
		
		static {
			Profile         = EntityFactory.createClass(UriUtils.createURI(URI + "Profile"));
			serviceName     = EntityFactory.createDataProperty(UriUtils.createURI(URI + "serviceName"));
			textDescription = EntityFactory.createDataProperty(UriUtils.createURI(URI + "textDescription"));
			
			ServiceParameter = EntityFactory.createClass(UriUtils.createURI(URI + "ServiceParameter"));
			serviceParameter = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "serviceParameter"));
			serviceParameterName = EntityFactory.createDataProperty(UriUtils.createURI(URI + "serviceParameterName"));
			sParameter       = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "sParameter"));
			
			hasProcess      = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "has_process"));
			hasInput        = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasInput"));
			hasOutput       = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasOutput"));
			hasPrecondition = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasPrecondition"));
			hasParameter    = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasParameter"));			

			hasResult = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasResult"));

			
			ServiceCategory = EntityFactory.createClass(UriUtils.createURI(URI + "ServiceCategory"));
			serviceCategory = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "serviceCategory"));
			categoryName    = EntityFactory.createDataProperty(UriUtils.createURI(URI + "categoryName"));
			taxonomy        = EntityFactory.createDataProperty(UriUtils.createURI(URI + "taxonomy"));
			value           = EntityFactory.createDataProperty(UriUtils.createURI(URI + "value"));
			code            = EntityFactory.createDataProperty(UriUtils.createURI(URI + "code"));	
			
			serviceClassification = EntityFactory.createDataProperty(UriUtils.createURI(URI + "serviceClassification"));
			serviceProduct = EntityFactory.createDataProperty(UriUtils.createURI(URI + "serviceProduct"));
			
			contactInformation = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "contactInformation"));
		}
	}

	/**
	 * Vocabulary for the QoSModel Ontology
	 *
	 */
	public static class QoSModel {
		
		public static String URI = Owls1_2.URI + "QoSModel.owl#";
		
		/**
		 * OwlClass
		 */
		public static OwlClass QoSModel;
		public static OwlClass QoSProvider;
		public static OwlClass QoSConsumer;
		
		public static OwlClass QoSValue;
		public static OwlClass QoSCondition;
		
		public static OwlClass ResponseTime;
		public static OwlClass Reliability;
		public static OwlClass ExecutionPrice; 
		
		/**
		 * OwlObjectProperty
		 */
		
		public static OwlObjectProperty hasQoSConsumer;
		public static OwlObjectProperty hasQoSModel;
		public static OwlObjectProperty hasQoSProvider;
		public static OwlObjectProperty hasReliability;
		public static OwlObjectProperty hasResponseTime;
		public static OwlObjectProperty hasExecutionPrice;
		
		/**
		 * OwlDataProperty
		 */
		public static OwlDataProperty hasQoSCondition;
		public static OwlDataProperty hasQoSValue;
		
		static {
			
			QoSModel = EntityFactory.createClass(UriUtils.createURI(URI + "QoSModel"));
			QoSProvider = EntityFactory.createClass(UriUtils.createURI(URI + "QoSProvider"));
			QoSConsumer = EntityFactory.createClass(UriUtils.createURI(URI + "QoSConsumer"));
			QoSValue = EntityFactory.createClass(UriUtils.createURI(URI + "QoSValue"));
			QoSCondition = EntityFactory.createClass(UriUtils.createURI(URI + "QoSCondition"));
			ResponseTime = EntityFactory.createClass(UriUtils.createURI(URI + "ResponseTime"));
			Reliability = EntityFactory.createClass(UriUtils.createURI(URI + "Reliability"));
			ExecutionPrice = EntityFactory.createClass(UriUtils.createURI(URI + "ExecutionPrice"));
			
			hasQoSConsumer = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasQoSConsumer"));
			hasQoSModel = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasQoSModel"));
			hasQoSProvider = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasQoSProvider"));
			hasReliability = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasReliability"));
			hasReliability = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasReliability"));
			hasExecutionPrice = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasExecutionPrice"));
			
			hasQoSCondition = EntityFactory.createDataProperty(UriUtils.createURI(URI + "hasQoSCondition"));
			hasQoSValue = EntityFactory.createDataProperty(UriUtils.createURI(URI + "hasQoSValue"));
		}
	}
		
	/**
	 * Vocabulary for the Process Ontology
	 *
	 */
	public static class Process {
		
        public static String URI = Owls1_2.URI + "Process.owl#";	
		
		public static OwlClass Process;
		public static OwlClass AtomicProcess;
		public static OwlClass CompositeProcess;		
		public static OwlClass SimpleProcess;
		public static OwlClass Parameter;
		public static OwlClass Input;
		public static OwlClass Output;
		public static OwlClass Precondition;
		public static OwlClass Effect;
		
		public static OwlDataProperty parameterType;
		public static OwlObjectProperty hasParameter;
		public static OwlObjectProperty hasInput;
		public static OwlObjectProperty hasOutput;
		public static OwlObjectProperty hasPrecondition;		
		
		public static OwlDataProperty name;
		
		public static OwlClass ControlConstruct;
		public static OwlClass ControlConstructList;
		public static OwlClass ControlConstructBag;
		public static OwlClass Sequence;
		public static OwlClass AnyOrder;
		public static OwlClass Choice;
		public static OwlClass IfThenElse;
		public static OwlClass Produce;
		public static OwlClass Split;
		public static OwlClass SplitJoin;
		public static OwlClass Iterate;
		public static OwlClass RepeatUntil;
		public static OwlClass RepeatWhile;
		
		
		public static OwlClass ForEach;
		
		public static OwlObjectProperty theList;
		
		public static OwlObjectProperty theLoopVar;
		
		public static OwlObjectProperty iterateBody;
		
		public static OwlClass ValueOf;		

		public static OwlObjectProperty composedOf;
		public static OwlObjectProperty components;		
		public static OwlObjectProperty ifCondition;
		public static OwlObjectProperty thenP;
		public static OwlObjectProperty elseP;
		public static OwlObjectProperty untilProcess;
		public static OwlObjectProperty untilCondition;
		public static OwlObjectProperty whileProcess;
		public static OwlObjectProperty whileCondition;
		public static OwlObjectProperty producedBinding;
		public static OwlObjectProperty realizedBy;
		public static OwlObjectProperty expandsTo;
		
		public static OwlClass Perform;
		public static OwlObjectProperty process;
		public static OwlObjectProperty hasDataFrom;
		public static OwlClass Binding;
		public static OwlClass InputBinding;
		public static OwlClass OutputBinding;
		
		public static OwlDataProperty parameterValue;
		
		public static OwlObjectProperty hasResult;
		public static OwlClass Result;
		public static OwlClass ResultVar;
		public static OwlObjectProperty hasResultVar;
		
		public static OwlObjectProperty hasLocal;
		public static OwlClass Local;
		
		public static OwlObjectProperty inCondition;
		public static OwlObjectProperty hasEffect;
		public static OwlObjectProperty toParam;
		public static OwlObjectProperty withOutput;
		public static OwlObjectProperty valueSource;
		public static OwlObjectProperty fromProcess;
		public static OwlObjectProperty theVar;
		
		public static OwlDataProperty valueSpecifier;
		public static OwlDataProperty valueFunction;
		public static OwlDataProperty valueForm;
		public static OwlDataProperty valueData;
        public static OwlObjectProperty valueObject;
        
		public static OwlIndividual TheParentPerform;
		public static OwlIndividual ThisPerform;
		
		static {
			Process          = EntityFactory.createClass(UriUtils.createURI(URI + "Process"));
			AtomicProcess    = EntityFactory.createClass(UriUtils.createURI(URI + "AtomicProcess"));
			CompositeProcess = EntityFactory.createClass(UriUtils.createURI(URI + "CompositeProcess"));		
			SimpleProcess    = EntityFactory.createClass(UriUtils.createURI(URI + "SimpleProcess"));
			Parameter        = EntityFactory.createClass(UriUtils.createURI(URI + "Parameter"));
			Input            = EntityFactory.createClass(UriUtils.createURI(URI + "Input"));
			Output           = EntityFactory.createClass(UriUtils.createURI(URI + "Output"));
			Precondition     = EntityFactory.createClass(UriUtils.createURI(URI + "Precondition"));
			Effect           = EntityFactory.createClass(UriUtils.createURI(URI + "Effect"));
			
			parameterType   = EntityFactory.createDataProperty(UriUtils.createURI(URI + "parameterType"));
			hasParameter    = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasParameter"));
			hasInput        = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasInput"));
			hasOutput       = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasOutput"));
			hasPrecondition = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasPrecondition"));
			
			name			= EntityFactory.createDataProperty(UriUtils.createURI(URI + "name"));
			
			ControlConstructList = EntityFactory.createClass(UriUtils.createURI(URI + "ControlConstructList"));
			ControlConstructBag = EntityFactory.createClass(UriUtils.createURI(URI + "ControlConstructBag"));
			ControlConstruct = EntityFactory.createClass(UriUtils.createURI(URI + "ControlConstruct"));
			Sequence         = EntityFactory.createClass(UriUtils.createURI(URI + "Sequence"));
			AnyOrder         = EntityFactory.createClass(UriUtils.createURI(URI + "Any-Order"));
			Choice           = EntityFactory.createClass(UriUtils.createURI(URI + "Choice"));
			IfThenElse       = EntityFactory.createClass(UriUtils.createURI(URI + "If-Then-Else"));
			Produce          = EntityFactory.createClass(UriUtils.createURI(URI + "Produce"));
			Split            = EntityFactory.createClass(UriUtils.createURI(URI + "Split"));
			SplitJoin        = EntityFactory.createClass(UriUtils.createURI(URI + "Split-Join"));
			Iterate          = EntityFactory.createClass(UriUtils.createURI(URI + "Iterate"));
			RepeatUntil      = EntityFactory.createClass(UriUtils.createURI(URI + "Repeat-Until"));
			RepeatWhile      = EntityFactory.createClass(UriUtils.createURI(URI + "Repeat-While"));
			
			
			ForEach    = EntityFactory.createClass(UriUtils.createURI(URI + "For-Each"));
			theList = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "theList"));
			theLoopVar = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "theLoopVar"));
			iterateBody = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "iterateBody"));
			
			ValueOf          = EntityFactory.createClass(UriUtils.createURI(URI + "ValueOf"));		

			composedOf   = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "composedOf"));
			components   = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "components"));
			ifCondition  = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "ifCondition"));
			thenP        = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "then"));
			elseP        = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "else"));
			untilProcess   = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "untilProcess"));
			untilCondition = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "untilCondition"));
			whileProcess   = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "whileProcess"));
			whileCondition = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "whileCondition"));
			producedBinding = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "producedBinding"));
			realizedBy = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "realizedBy"));
			expandsTo = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "expandsTo"));			
			
			Perform = EntityFactory.createClass(UriUtils.createURI(URI + "Perform"));
			process = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "process"));
			hasDataFrom = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasDataFrom"));
			Binding = EntityFactory.createClass(UriUtils.createURI(URI + "Binding"));
			InputBinding = EntityFactory.createClass(UriUtils.createURI(URI + "InputBinding"));
			OutputBinding = EntityFactory.createClass(UriUtils.createURI(URI + "OutputBinding"));
			
			parameterValue = EntityFactory.createDataProperty(UriUtils.createURI(URI + "parameterValue"));
			
			hasResult = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasResult"));
			Result = EntityFactory.createClass(UriUtils.createURI(URI + "Result"));
			ResultVar = EntityFactory.createClass(UriUtils.createURI(URI + "ResultVar"));
			hasResultVar = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasResultVar"));
			
			hasLocal = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasLocal"));
			Local = EntityFactory.createClass(UriUtils.createURI(URI + "Local"));
			
			inCondition = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "inCondition"));
			hasEffect    = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasEffect"));
			toParam = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "toParam"));
			withOutput = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "withOutput"));
			valueSource = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "valueSource"));
			fromProcess = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "fromProcess"));
			theVar = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "theVar"));
			
			valueSpecifier = EntityFactory.createDataProperty(UriUtils.createURI(URI + "valueSpecifier"));
			valueFunction = EntityFactory.createDataProperty(UriUtils.createURI(URI + "valueFunction"));
			valueForm = EntityFactory.createDataProperty(UriUtils.createURI(URI + "valueFrom"));
			valueData = EntityFactory.createDataProperty(UriUtils.createURI(URI + "valueData"));
            valueObject = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "valueObject"));
					
			TheParentPerform = EntityFactory.createIndividual(UriUtils.createURI(URI + "TheParentPerform"));
			ThisPerform = EntityFactory.createIndividual(UriUtils.createURI(URI + "ThisPerform"));
			
		}		
	}

	/**
	 * Vocabulary for the Grounding Ontology
	 *
	 */
	public static class Grounding {
		public static String URI = Owls1_2.URI + "Grounding.owl#";
		
		public static OwlClass WsdlGrounding;

		public static OwlObjectProperty hasAtomicProcessGrounding;
		public static OwlClass WsdlAtomicProcessGrounding;

		public static OwlObjectProperty wsdlOperation;
		public static OwlClass WsdlOperationRef;
		public static OwlDataProperty portType;
		public static OwlDataProperty operation;
		
		public static OwlDataProperty wsdlDocument;
		public static OwlDataProperty wsdlService;
		public static OwlObjectProperty owlsProcess;

		public static OwlDataProperty wsdlInputMessage;
		public static OwlObjectProperty wsdlInput;
		
		public static OwlDataProperty wsdlOutputMessage;
		public static OwlObjectProperty wsdlOutput;
		
		public static OwlClass WsdlMessageMap;
		public static OwlClass WsdlInputMessageMap;
		public static OwlClass WsdlOutputMessageMap;
		public static OwlDataProperty wsdlMessagePart;
		public static OwlObjectProperty owlsParameter;
		public static OwlDataProperty xsltTransformation;
		public static OwlDataProperty xsltTransformationString;
		public static OwlDataProperty xsltTransformationURI;
		
		static {
			
			WsdlGrounding = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlGrounding"));
			WsdlAtomicProcessGrounding = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlAtomicProcessGrounding"));
			WsdlOperationRef = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlOperationRef"));
			
			hasAtomicProcessGrounding = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "hasAtomicProcessGrounding"));
			wsdlDocument      = EntityFactory.createDataProperty(UriUtils.createURI(URI + "wsdlDocument"));
			wsdlOperation     = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "wsdlOperation"));
			portType          = EntityFactory.createDataProperty(UriUtils.createURI(URI + "portType"));
			operation         = EntityFactory.createDataProperty(UriUtils.createURI(URI + "operation"));
			owlsProcess       = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "owlsProcess"));
			wsdlInputMessage  = EntityFactory.createDataProperty(UriUtils.createURI(URI + "wsdlInputMessage"));
			wsdlOutputMessage = EntityFactory.createDataProperty(UriUtils.createURI(URI + "wsdlOutputMessage"));
			wsdlInput         = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "wsdlInput"));
			wsdlOutput        = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "wsdlOutput"));
			
			WsdlMessageMap    = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlMessageMap"));
			WsdlInputMessageMap    = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlInputMessageMap"));
			WsdlOutputMessageMap    = EntityFactory.createClass(UriUtils.createURI(URI + "WsdlOutputMessageMap"));
			wsdlMessagePart   = EntityFactory.createDataProperty(UriUtils.createURI(URI + "wsdlMessagePart"));
			owlsParameter     = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "owlsParameter"));
			xsltTransformation = EntityFactory.createDataProperty(UriUtils.createURI(URI + "xsltTransformation"));		
			xsltTransformationString = EntityFactory.createDataProperty(UriUtils.createURI(URI + "xsltTransformationString"));		
			xsltTransformationURI = EntityFactory.createDataProperty(UriUtils.createURI(URI + "xsltTransformationURI"));		
		}
	}

	/**
	 * Vocabulary for the Expression Ontology
	 *
	 */
	public static class Expression {
		
		public static String URI = Owls1_2.URI + "generic/Expression.owl#";
		
		public static OwlClass LogicLanguage;
		public static OwlClass Expression;	
		public static OwlClass Condition;	
		
		public static OwlIndividual KIF;
		public static OwlIndividual SWRL;	
		public static OwlIndividual DRS;	
		
		public static OwlClass KIF_Condition;	
		public static OwlClass SWRL_Condition;	
		public static OwlClass DRS_Condition;	
		
		public static OwlClass KIF_Expression;	
		public static OwlClass SWRL_Expression;	
		public static OwlClass DRS_Expression;	
		
		public static java.net.URI KIFref;	
		public static java.net.URI SWRLref;	
		public static java.net.URI DRSref;	
		public static java.net.URI SPARQLref;
		
		public static OwlDataProperty refURI;
		public static OwlObjectProperty expressionLanguage;
		public static OwlDataProperty expressionBody;
		public static OwlDataProperty expressionData;
        public static OwlObjectProperty expressionObject;
        
        public static OwlIndividual AlwaysTrue;
		
		static {
			
			LogicLanguage = EntityFactory.createClass(UriUtils.createURI(URI + "LogicLanguage"));
			Expression = EntityFactory.createClass(UriUtils.createURI(URI + "Expression"));	
			Condition = EntityFactory.createClass(UriUtils.createURI(URI + "Condition"));	
			
			expressionLanguage = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "expressionLanguage"));
			expressionBody = EntityFactory.createDataProperty(UriUtils.createURI(URI + "expressionBody"));
			expressionData = EntityFactory.createDataProperty(UriUtils.createURI(URI + "expressionData"));
            expressionObject = EntityFactory.createObjectProperty(UriUtils.createURI(URI + "expressionObject"));
			refURI = EntityFactory.createDataProperty(UriUtils.createURI(URI + "refURI"));
			
			KIF_Condition = EntityFactory.createClass(UriUtils.createURI(URI + "KIF-Condition"));	
			SWRL_Condition = EntityFactory.createClass(UriUtils.createURI(URI +  "SWRL-Condition"));	
			DRS_Condition = EntityFactory.createClass(UriUtils.createURI(URI + "DRS-Condition"));	
			
			KIF_Expression = EntityFactory.createClass(UriUtils.createURI(URI + "KIF-Expression"));	
			SWRL_Expression = EntityFactory.createClass(UriUtils.createURI(URI +  "SWRL-Expression"));	
			DRS_Expression = EntityFactory.createClass(UriUtils.createURI(URI + "DRS-Expression"));	
			
			KIF  = EntityFactory.createIndividual(UriUtils.createURI(URI + "KIF"));	
			SWRL = EntityFactory.createIndividual(UriUtils.createURI(URI + "SWRL"));	
			DRS  = EntityFactory.createIndividual(UriUtils.createURI(URI + "DRS"));			
			
			DRS.setProperty(refURI, DRS);
            
            AlwaysTrue = EntityFactory.createIndividual(UriUtils.createURI(URI + "AlwaysTrue"));
		}
	}
	
	/**
	 * Vocabulary for the Actor Ontology
	 *
	 */
	public static class Actor {
	    public static String URI = Owls1_2.URI + "ActorDefault.owl#";
	        
	    public static OwlClass Actor = EntityFactory.createClass(UriUtils.createURI(URI + "Actor"));
	    public static OwlDataProperty email = EntityFactory.createDataProperty(UriUtils.createURI(URI + "email"));
	    public static OwlDataProperty fax = EntityFactory.createDataProperty(UriUtils.createURI(URI + "fax"));
	    public static OwlDataProperty name = EntityFactory.createDataProperty(UriUtils.createURI(URI + "name"));
	    public static OwlDataProperty phone = EntityFactory.createDataProperty(UriUtils.createURI(URI + "phone"));
	    public static OwlDataProperty physicalAddress = EntityFactory.createDataProperty(UriUtils.createURI(URI + "physicalAddress"));
	    public static OwlDataProperty title = EntityFactory.createDataProperty(UriUtils.createURI(URI + "title"));
	    public static OwlDataProperty webURL = EntityFactory.createDataProperty(UriUtils.createURI(URI +  "webURL"));
	}
}
