package com.stfx.cli.sew.owl.vocubulary;

import java.net.URI;
import java.util.Calendar;

/*
 * @author Mostafijur Rahman
 * @since 3rd March, 2015
 */

public class Xsd {

	
	public final static String ns = "http://www.w3.org/2001/XMLSchema#";

	public final static URI getURI() { return URI.create(ns); } 
	
    /** URI URI for xsd:float */
    public static URI xsdFloat = URI.create(ns + "float");
    
    /** URI URI for xsd:double */
    public static URI xsdDouble = URI.create(ns + "double");
    
    /** URI URI for xsd:int */
    public static URI xsdInt = URI.create(ns + "int");
    
    /** URI URI for xsd:long */
    public static URI xsdLong = URI.create(ns + "long");
       
    /** URI URI for xsd:short */
    public static URI xsdShort = URI.create(ns + "short");
       
    /** URI URI for xsd:byte */
    public static URI xsdByte = URI.create(ns + "byte");
       
    /** URI URI for xsd:boolean */
    public static URI xsdBoolean = URI.create(ns + "boolean");
    
    /** URI URI for xsd:string */
    public static URI xsdString = URI.create(ns + "string");
    
    /** URI URI for xsd:string */
    public static URI string = URI.create(ns + "string");
    
    /** URI URI for xsd:unsignedByte */
    public static URI unsignedByte = URI.create(ns + "unsignedByte");
       
    /** URI URI for xsd:unsignedShort */
    public static URI unsignedShort = URI.create(ns + "unsignedShort");
       
    /** URI URI for xsd:unsignedInt */
    public static URI unsignedInt = URI.create(ns + "unsignedInt");
       
    /** URI URI for xsd:unsignedLong */
    public static URI unsignedLong = URI.create(ns + "unsignedLong");
       
    /** URI URI for xsd:decimal */
    public static URI decimal = URI.create(ns + "decimal");
       
    /** URI URI for xsd:integer */
    public static URI integer = URI.create(ns + "integer");
       
    /** URI URI for xsd:nonPositiveInteger */
    public static URI nonPositiveInteger = URI.create(ns + "nonPositiveInteger");
       
    /** URI URI for xsd:nonNegativeInteger */
    public static URI nonNegativeInteger = URI.create(ns + "nonNegativeInteger");
       
    /** URI URI for xsd:positiveInteger */
    public static URI positiveInteger = URI.create(ns + "positiveInteger");
       
    /** URI URI for xsd:negativeInteger */
    public static URI negativeInteger = URI.create(ns + "negativeInteger");
       
    /** URI URI for xsd:normalizedString */
    public static URI normalizedString = URI.create(ns + "normalizedString");
    
    /** URI URI for xsd:anyURI */
    public static URI anyURI = URI.create(ns + "anyURI");
    
    /** URI URI for xsd:token */
    public static URI token = URI.create(ns + "token");

    /** URI URI for xsd:Name */
    public static URI Name = URI.create(ns + "Name");

    /** URI URI for xsd:QName */
    public static URI QName = URI.create(ns + "QName");

    /** URI URI for xsd:language */
    public static URI language = URI.create(ns + "language");

    /** URI URI for xsd:NMTOKEN */
    public static URI NMTOKEN = URI.create(ns + "NMTOKEN");

    /** URI URI for xsd:ENTITIES */
    public static URI ENTITIES = URI.create(ns + "ENTITIES");

    /** URI URI for xsd:NMTOKENS */
    public static URI NMTOKENS = URI.create(ns + "NMTOKENS");

    /** URI URI for xsd:ENTITY */
    public static URI ENTITY = URI.create(ns + "ENTITY");

    /** URI URI for xsd:ID */
    public static URI ID = URI.create(ns + "ID");

    /** URI URI for xsd:NCName */
    public static URI NCName = URI.create(ns + "NCName");

    /** URI URI for xsd:IDREF */
    public static URI IDREF = URI.create(ns + "IDREF");

    /** URI URI for xsd:IDREFS */
    public static URI IDREFS = URI.create(ns + "IDREFS");

    /** URI URI for xsd:NOTATION */
    public static URI NOTATION = URI.create(ns + "NOTATION");

    /** URI URI for xsd:hexBinary */
    public static URI hexBinary = URI.create(ns + "hexBinary");

    /** URI URI for xsd:base64Binary */
    public static URI base64Binary = URI.create(ns + "base64Binary");

    /** URI URI for xsd:date */
    public static URI date = URI.create(ns + "date");

    /** URI URI for xsd:time */
    public static URI time = URI.create(ns + "time");

    /** URI URI for xsd:dateTime */
    public static URI dateTime = URI.create(ns + "dateTime");

    /** URI URI for xsd:duration */
    public static URI duration = URI.create(ns + "duration");

    /** URI URI for xsd:gDay */
    public static URI gDay = URI.create(ns + "gDay");

    /** URI URI for xsd:gMonth */
    public static URI gMonth = URI.create(ns + "gMonth");

    /** URI URI for xsd:gYear */
    public static URI gYear = URI.create(ns + "gYear");

    /** URI URI for xsd:gYearMonth */
    public static URI gYearMonth = URI.create(ns + "gYearMonth");

    /** URI URI for xsd:gMonthDay */
    public static URI gMonthDay = URI.create(ns + "gMonthDay");

    /*
     * This class returns the constructed class based on the URI parameter
    */
    public static URI getURIFromClass(Class parameterType) {
    	
    	String strType = parameterType.getName();
    	
    	if ("byte".equals(strType) || "java.lang.Byte".equals(strType))
			return Xsd.xsdByte;
		else if ("short".equals(strType) || "java.lang.Short".equals(strType))
			return Xsd.xsdShort;
		else if ("int".equals(strType) || "java.lang.Integer".equals(strType))
			return Xsd.integer;
		else if ("long".equals(strType) || "java.lang.Long".equals(strType))
			return Xsd.xsdLong;
		else if ("float".equals(strType) || "java.lang.Float".equals(strType))
			return Xsd.xsdFloat;
		else if ("double".equals(strType) || "java.lang.Double".equals(strType))
			return Xsd.xsdDouble;
		else if ("boolean".equals(strType) || "java.lang.Boolean".equals(strType))
			return Xsd.xsdBoolean;
		else if ("char".equals(strType) || "java.lang.Character".equals(strType))
			return Xsd.string;
		else if ("String".equals(strType) || "java.lang.String".equals(strType))
			return Xsd.string;
		
		return null;
    }
    
    /*
     * This class returns the constructed class based on the URI parameter
     */
    public static Class getClassFromURI(URI type) {
    	String strType = type.toString();
    	
    	if (strType.equals(Xsd.negativeInteger) || strType.equals(Xsd.nonNegativeInteger) || 
    			strType.equals(Xsd.unsignedInt))
			return Integer.class;
    	
		else if (strType.equals(Xsd.integer) || strType.equals(Xsd.xsdLong) || 
				strType.equals(Xsd.unsignedLong) || strType.equals(Xsd.nonPositiveInteger) ||
				strType.equals(Xsd.nonNegativeInteger) || strType.equals(Xsd.negativeInteger) ||
				strType.equals(Xsd.positiveInteger)) 
			return Long.class;
		
		else if (strType.equals(Xsd.xsdShort) || strType.equals(Xsd.unsignedShort))
			return Short.class;   	
		
		else if (strType.equals(Xsd.xsdByte) || strType.equals(Xsd.unsignedByte))
			return Byte.class;   	
		
		else if (strType.equals(Xsd.xsdFloat))
			return Float.class;   	
		
		else if (strType.equals(Xsd.xsdDouble))
			return Double.class;   	
		
		else if (strType.equals(Xsd.xsdBoolean))
			return Boolean.class;  
		
		else if (strType.equals(Xsd.string))
			return String.class;  
		
		else if (strType.equals(Xsd.xsdBoolean))
			return Boolean.class;  
		
		else if (strType.equals(Xsd.dateTime) || strType.equals(Xsd.date))
			return Calendar.class;  
		
    	return null;
    }
}
