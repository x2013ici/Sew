package com.stfx.sew.parsers;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class ParseXML {
	
	private String country = "county";
	private String temperature = "temperature";
	private String humidity = "humidity";
	private String pressure = "pressure";
	
	private String TAG = "Weather";
	
	private String urlString = "http://test.biocomalert.com/docs/workflows/weather.xml";
	
	private XmlPullParserFactory xmlFactoryObject;
	public volatile boolean parsingComplete = true;
	   
	 public ParseXML(String url){
	     this.urlString = url;
	 }
	 public String getCountry(){
	     return country;
	 }
	 public String getTemperature(){
	    return temperature;
	 }
	 public String getHumidity(){
	    return humidity;
	 }
	 public String getPressure(){
	     return pressure;
	 }
	 
	 public ParseXML(){
		 
	 }
	 
	 public void parseWeatherAndStoreIt(XmlPullParser myParser){
		 
		 int event;
	      String text=null;
	      try {
	         event = myParser.getEventType();
	         while (event != XmlPullParser.END_DOCUMENT) {
	            String name=myParser.getName();
	            switch (event){
	               case XmlPullParser.START_TAG:
	            	   if(name.equals("city")){
	            		   String id = myParser.getAttributeValue(null, "id");
	            		   Log.i(TAG, "City Id: " + id);
	            		   String cityName = myParser.getAttributeValue(null, "name");
	            		   Log.i(TAG, "City Name: " +cityName);
	            		   
	            		   if(name.equals("coord")){
		            		   String lon = myParser.getAttributeValue(null, "lon");
		            		   Log.i(TAG,"Lon: " + lon);
		            		   String lat = myParser.getAttributeValue(null, "lat");
		            		   Log.i(TAG,"Lat: " +lat);
		            	   }
		            	   
		            	   if(name.equals("sun")){
		            		   String rise = myParser.getAttributeValue(null, "rise");
		            		   Log.i(TAG,"Rise: " + rise);
		            		   String set = myParser.getAttributeValue(null, "set");
		            		   Log.i(TAG,"Set: " +set);
		            	   }
		                  if(name.equals("country")){
		                     country = text;
		                  }
		                  else if(name.equals("humidity")){ 	
		                     humidity = myParser.getAttributeValue(null,"value");
		                     Log.i(TAG,"Humidity" + humidity);
		                     
		                     String hunit = myParser.getAttributeValue(null, "hunit");
		                     Log.i(TAG,hunit);
		                  }
		                  else if(name.equals("pressure")){
		                     pressure = myParser.getAttributeValue(null,"value");
		                     Log.i(TAG,"Pressure: " + pressure);
		                     
		                     String punit = myParser.getAttributeValue(null, "punit");
		                     Log.i(TAG,"PUnt: " +punit);
		                  }
		                  else if(name.equals("temperature")){
		                     temperature = myParser.getAttributeValue(null,"value");
		                     Log.i(TAG,"Temperature" + temperature);
		                     
		                     String min = myParser.getAttributeValue(null, "min");
		                     Log.i(TAG,"Min: " +min);
		                     
		                     String max = myParser.getAttributeValue(null, "max");
		                     Log.i(TAG,"Max: " + max);
		                     
		                     String tunit = myParser.getAttributeValue(null, "tunit");
		                     Log.i(TAG,"TUnit: " +tunit);
		                  }
	            	   }
	            	   break;
	               case XmlPullParser.TEXT:
	            	   text = myParser.getText();
	            	   Log.i(TAG,text);
	            	   break;

	               case XmlPullParser.END_TAG:
	            	  
	            	   if(name.equals("city")){
	            		   String id = myParser.getAttributeValue(null, "id");
	            		   Log.i(TAG, "City Id: " + id);
	            		   
	            		   String cityName = myParser.getAttributeValue(null, "name");
	            		   Log.i(TAG, "City Name: " +cityName);
	            	   }
	            	   if(name.equals("coord")){
	            		   String lon = myParser.getAttributeValue(null, "lon");
	            		   Log.i(TAG,"Lon: " + lon);
	            		   String lat = myParser.getAttributeValue(null, "lat");
	            		   Log.i(TAG,"Lat: " +lat);
	            	   }
	            	   
	            	   if(name.equals("sun")){
	            		   String rise = myParser.getAttributeValue(null, "rise");
	            		   Log.i(TAG,"Rise: " + rise);
	            		   String set = myParser.getAttributeValue(null, "set");
	            		   Log.i(TAG,"Set: " +set);
	            	   }
	                  if(name.equals("country")){
	                     country = text;
	                  }
	                  else if(name.equals("humidity")){ 	
	                     humidity = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Humidity" + humidity);
	                     
	                     String hunit = myParser.getAttributeValue(null, "hunit");
	                     Log.i(TAG,hunit);
	                  }
	                  else if(name.equals("pressure")){
	                     pressure = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Pressure: " + pressure);
	                     
	                     String punit = myParser.getAttributeValue(null, "punit");
	                     Log.i(TAG,"PUnt: " +punit);
	                  }
	                  else if(name.equals("temperature")){
	                     temperature = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Temperature" + temperature);
	                     
	                     String min = myParser.getAttributeValue(null, "min");
	                     Log.i(TAG,"Min: " +min);
	                     
	                     String max = myParser.getAttributeValue(null, "max");
	                     Log.i(TAG,"Max: " + max);
	                     
	                     String tunit = myParser.getAttributeValue(null, "tunit");
	                     Log.i(TAG,"TUnit: " +tunit);
	                  }
	                  else{
	                  }
	                  break;
	                  }		 
	                  event = myParser.next(); 

	              }
	              parsingComplete = false;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	 }
	 public  void parseXMLAndStoreIt(XmlPullParser myParser) {
		 
	      int event;
	      String text=null;
	      try {
	         event = myParser.getEventType();
	         while (event != XmlPullParser.END_DOCUMENT) {
	            String name=myParser.getName();
	            switch (event){
	               case XmlPullParser.START_TAG:
	            	   if(name.equals("city")){
	            		   String id = myParser.getAttributeValue(null, "id");
	            		   Log.i(TAG, "City Id: " + id);
	            		   String cityName = myParser.getAttributeValue(null, "name");
	            		   Log.i(TAG, "City Name: " +cityName);
	            	   }
	            	   break;
	               case XmlPullParser.TEXT:
	            	   text = myParser.getText();
	            	   Log.i(TAG,text);
	            	   break;

	               case XmlPullParser.END_TAG:
	            	  
	            	   if(name.equals("city")){
	            		   String id = myParser.getAttributeValue(null, "id");
	            		   Log.i(TAG, "City Id: " + id);
	            		   
	            		   String cityName = myParser.getAttributeValue(null, "name");
	            		   Log.i(TAG, "City Name: " +cityName);
	            	   }
	            	   if(name.equals("coord")){
	            		   String lon = myParser.getAttributeValue(null, "lon");
	            		   Log.i(TAG,"Lon: " + lon);
	            		   String lat = myParser.getAttributeValue(null, "lat");
	            		   Log.i(TAG,"Lat: " +lat);
	            	   }
	            	   
	            	   if(name.equals("sun")){
	            		   String rise = myParser.getAttributeValue(null, "rise");
	            		   Log.i(TAG,"Rise: " + rise);
	            		   String set = myParser.getAttributeValue(null, "set");
	            		   Log.i(TAG,"Set: " +set);
	            	   }
	                  if(name.equals("country")){
	                     country = text;
	                  }
	                  else if(name.equals("humidity")){ 	
	                     humidity = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Humidity" + humidity);
	                     
	                     String hunit = myParser.getAttributeValue(null, "hunit");
	                     Log.i(TAG,hunit);
	                  }
	                  else if(name.equals("pressure")){
	                     pressure = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Pressure: " + pressure);
	                     
	                     String punit = myParser.getAttributeValue(null, "punit");
	                     Log.i(TAG,"PUnt: " +punit);
	                  }
	                  else if(name.equals("temperature")){
	                     temperature = myParser.getAttributeValue(null,"value");
	                     Log.i(TAG,"Temperature" + temperature);
	                     
	                     String min = myParser.getAttributeValue(null, "min");
	                     Log.i(TAG,"Min: " +min);
	                     
	                     String max = myParser.getAttributeValue(null, "max");
	                     Log.i(TAG,"Max: " + max);
	                     
	                     String tunit = myParser.getAttributeValue(null, "tunit");
	                     Log.i(TAG,"TUnit: " +tunit);
	                  }
	                  else{
	                  }
	                  break;
	                  }		 
	                  event = myParser.next(); 

	              }
	              parsingComplete = false;
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	 }
	 
	 public void fetchXML(){
	      Thread thread = new Thread(new Runnable(){
	         @Override
	         public void run() {
	            try {
	               URL url = new URL(urlString);
	               HttpURLConnection conn = (HttpURLConnection) 
	               url.openConnection();
	                  conn.setReadTimeout(10000 /* milliseconds */);
	                  conn.setConnectTimeout(15000 /* milliseconds */);
	                  conn.setRequestMethod("GET");
	                  conn.setDoInput(true);
	                  conn.connect();
	            InputStream stream = conn.getInputStream();

	            xmlFactoryObject = XmlPullParserFactory.newInstance();
	            XmlPullParser myparser = xmlFactoryObject.newPullParser();

	            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
	            myparser.setInput(stream, null);
	            
	            parseXMLAndStoreIt(myparser);
	            //parseWeatherAndStoreIt(myparser);
	            stream.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	        }
	    });

	    thread.start(); 
	}

}
