package com.stfx.cli.sew.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


public class Utils {
	
    public static boolean DEBUG = false;
    
    
    public static Object getHashtableKey(Hashtable h, Object value) {
		Iterator e = h.entrySet().iterator();
		while(e.hasNext()) {
		    Map.Entry entry = (Map.Entry) e.next();
		    
		    if(entry.getValue().equals(value))
		    	return entry.getKey();
		}    	
		
		return null;
    }
	
    
	public static void printTime(String msg) {
		System.out.println("Time: (" + System.currentTimeMillis() + ") " + msg);
	}    
	
	public static String toString(Object[] array) {
		String s = "[Array ";
		if(array != null && array.length > 0) {
			s += array[0];
			for(int i = 1; i < array.length; i++)
				s += "," + array[i];
		}
		s += "]";
		
		return s;
	}    
	
	public static boolean getBoolean(String str) {
		return (str == null) ? false :
				str.toLowerCase().equals("true") ||
				str.equals("1");
	}
		
	public static String toString(boolean b) {
		return b ? "true" : "false";
	}
		
	public static String readURL(URL fileURL) throws IOException {
		return readAll(new InputStreamReader(fileURL.openStream()));
	}
	
	public static String readFile(String fileName) throws FileNotFoundException, IOException {
		return readAll(new FileReader(fileName));
	}
	
	public static String readAll(Reader reader) throws IOException {
		StringBuffer buffer = new StringBuffer();
				
		BufferedReader in = new BufferedReader(reader);
		int ch;
		while ((ch = in.read()) > -1) {
			buffer.append((char)ch);
		}
		in.close();

		return buffer.toString();
	}		
}
