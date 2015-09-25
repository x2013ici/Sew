package com.stfx.cli.sew.utilities;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.stfx.cli.sew.domain.DrugOntology;
import com.stfx.cli.sew.domain.impl.DrugOntologyParser;
import com.stfx.cli.sew.exceptions.InvalidUriException;


/**
 * @author Mostafijur Rahman
 * @since 3rd March, 2015 
 */
public class UriUtils {
	
    

    public static String getNameSpace( URI uri ) {
        return getNameSpace( uri.toString() );
    }

    public static String getNameSpace( String uri ) {
        int index = splitPos( uri );

        if( index == -1 ) 
        	return null;

        return uri.substring( 0, index + 1 );
    }

    private static int splitPos( String uri ) {
        
    	int pos = uri.indexOf( "#" );

        return pos;
    }
    
    public static String getBaseUrl (String uri){
    	
    	String baseURL = null;
    	
    	if (uri == null)
    		return null;
    	
    	if (isValidURI(uri)){
    		String[] splittedString = uri.split("#");
    		if (splittedString.length >0){
    			baseURL = splittedString[0];
    		}
    	}
    	
		return baseURL;
    }
    
    public static String getConcept(String uri){
    	
    	String concept = null;
    	
    	if (uri == null)
    		return null;
    	
    	if (isValidURI(uri)){
    		String[] splittedString = uri.split("#");
    		if (splittedString.length >0){
    			concept = splittedString[1];
    		}
    	}
    	
		return concept;
    }
    
    public static ArrayList<String> getParsedList(String input, String separator){
    	
    	String[] splittedList;
    	String processedItem;
    	ArrayList<String> processedList = new ArrayList<String>();
    	
    	try{
    	
    		if(!input.isEmpty()){
    			splittedList = input.split(separator);
    			if(splittedList.length >0){
    				for(int index=0;index<splittedList.length;index++){
    					
    					String value = splittedList[index];
    					//System.out.println(value);
    					processedItem = DrugOntology.drugOntologyURI + splittedList[index];
    					processedList.add(processedItem);
    				}
    			}
    		}
    	}
    	catch(Exception ex){
    		return processedList;
    	}
    	return processedList;
    }
    
    public static String getCoreUrl (String uri){
    	return uri.substring(1,uri.length()-1);
    }

    public static URI createURI( String uri ) throws InvalidUriException {
        try {
            return new URI( uri.replaceAll( " ", "%20" ) );
        }
        catch( URISyntaxException e ) {
            throw new InvalidUriException( e.getMessage() );
        }
    }

    /**
     * Create a URI with the given baseURI and localName
     * 
     * @param baseURI
     * @param localName
     * @return
     * @throws InvalidUriException
     */
    public static URI createURI( URI baseURI, String localName ) throws InvalidUriException {
        try {
            return new URI( baseURI.getScheme(), baseURI.getSchemeSpecificPart(), localName );
        }
        catch( URISyntaxException e ) {
            throw new InvalidUriException( e.getMessage() );
        }
    }

    public static URI standardURI( URI uri ) throws InvalidUriException {
        if( uri.getFragment() != null ) {
            try {
                uri = new URI( uri.getScheme(), uri.getSchemeSpecificPart(), null );
            }
            catch( URISyntaxException e ) {
                throw new InvalidUriException( e.getMessage() );
            }
        }

        return uri;
    }

    public static boolean relaxedMatch( String uri1, String uri2 ) {
        if( uri1 == null || uri2 == null ) 
        	return false;

        if( uri1.equals( uri2 ) ) 
        	return true;

        String name1 = getLocalName( uri1 );
        String name2 = getLocalName( uri2 );

        if( name1 == null || name2 == null ) 
        	return false;

        return name1.equals( name2 );
    }
    
    public static boolean isValidURI(String uri) {
    	try {
    		URI.create(uri);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public static String getLocalName( URI uri ) {
        return getLocalName( uri.toString() );
    }

    public static String getLocalName( String uri ) {
        int index = splitPos( uri );

        if( index == -1 ) 
        	return null;

        return uri.substring( index + 1 );
    }
}
