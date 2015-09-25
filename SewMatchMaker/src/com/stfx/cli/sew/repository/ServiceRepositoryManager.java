package com.stfx.cli.sew.repository;

import java.util.ArrayList;

import com.stfx.cli.sew.datamodels.OwlsService;
import com.stfx.cli.sew.datamodels.OwlsServiceFile;
import com.stfx.cli.sew.datamodels.OwlsServiceList;

public class ServiceRepositoryManager {

	
	/**
	 * Owl-s Service File Type
	 * Service: 1
	 * Profile: 2
	 * QosProfile:3
	 * Process:4
	 * Grounding: 5
	 * WsdlGrounding:6
	 */
	
	public static final int Service = 1;
	public static final int Profile = 2;
	public static final int QosProfile = 3;
	public static final int Process = 4;
	public static final int Grounding = 5;
	public static final int WsdlGrounding =6;
	
	public static volatile ServiceRepositoryManager serviceRepositoryManager = null;
	public static ServiceRepositoryManager createServiceRepositoryManagerInstance(){
		if(serviceRepositoryManager ==null){
			synchronized(ServiceRepositoryManager.class){
				serviceRepositoryManager = new ServiceRepositoryManager();
			}
		}
		return serviceRepositoryManager;
	}
	
	/* Drug Discovery related Web Services */
	//---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Service Id: 1
	 * @return
	 */
	public static OwlsService getCef3Service(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsCef3ServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try
		{
			/**
			 * Service Section
			 * Cef3Service.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl	http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl
			 */
			
			OwlsServiceFile owlsCef3Service = new OwlsServiceFile();
			owlsCef3Service.setServiceFileName("Cef3Service.owl");
			owlsCef3Service.setMimeType("application/rdf+xml");
			owlsCef3Service.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl");
			owlsCef3Service.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl");
			owlsCef3Service.setServiceFileType(Service);
			owlsCef3ServiceFileList.add(owlsCef3Service);
			
			/**
			 * Profile Section
			 * Cef3Profile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl	http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl
			 */
			
			OwlsServiceFile owlsCef3Profile = new OwlsServiceFile();
			owlsCef3Profile.setServiceFileName("Cef3Profile.owl");
			owlsCef3Profile.setMimeType("application/rdf+xml");
			owlsCef3Profile.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl");
			owlsCef3Profile.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3Profile.owl");
			owlsCef3Profile.setServiceFileType(Profile);
			owlsCef3ServiceFileList.add(owlsCef3Profile);
			
			/**
			 * QosProfile Section
			 * Cef3QosProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl	http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl
			 */
			OwlsServiceFile owlsCef3QosProfile = new OwlsServiceFile();
			owlsCef3QosProfile.setServiceFileName("Cef3QosProfile.owl");
			owlsCef3QosProfile.setMimeType("application/rdf+xml");
			owlsCef3QosProfile.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl");
			owlsCef3QosProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3QosProfile.owl");
			owlsCef3QosProfile.setServiceFileType(QosProfile);
			owlsCef3ServiceFileList.add(owlsCef3QosProfile);
			
			/**
			 * Process Section
			 * Cef3Process.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl	http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl
			 */
			
			OwlsServiceFile owlsCef3Process = new OwlsServiceFile();
			owlsCef3Process.setServiceFileName("Cef3Process.owl");
			owlsCef3Process.setMimeType("application/rdf+xml");
			owlsCef3Process.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl");
			owlsCef3Process.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3Process.owl");
			owlsCef3Process.setServiceFileType(Process);
			owlsCef3ServiceFileList.add(owlsCef3Process);
			
			/**
			 * Grounding Section
			 * Cef3Grounding.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl	http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl
			 */
			OwlsServiceFile owlsCef3Grounding = new OwlsServiceFile();
			owlsCef3Grounding.setServiceFileName("Cef3Process.owl");
			owlsCef3Grounding.setMimeType("application/rdf+xml");
			owlsCef3Grounding.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl");
			owlsCef3Grounding.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.owl");
			owlsCef3Grounding.setServiceFileType(Grounding);
			owlsCef3ServiceFileList.add(owlsCef3Grounding);
			
			/**
			 * Grounding Wsdl Section
			 * Cef3Grounding.wsdl	application/wsdl+xml	http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl	http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl
			 */
			OwlsServiceFile owlsCef3Groundingwsdl = new OwlsServiceFile();
			owlsCef3Groundingwsdl.setServiceFileName("Cef3Grounding.wsdl");
			owlsCef3Groundingwsdl.setMimeType("application/wsdl+xml");
			owlsCef3Groundingwsdl.setWebUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl");
			owlsCef3Groundingwsdl.setPhysicalPath("http://test.biocomalert.com/docs/services/cef3/Cef3Grounding.wsdl");
			owlsCef3Groundingwsdl.setServiceFileType(WsdlGrounding);
			owlsCef3ServiceFileList.add(owlsCef3Groundingwsdl);
			
			owlsService = new OwlsService();
			owlsService.setId(1);
			owlsService.setServiceName("Cef3 Service");
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This service provide option to search Cef3Serape drug based on patient physical condition");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/cef3/Cef3Service.owl");
			owlsService.setOwlsServiceList(owlsCef3ServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	/**
	 * Service Id: 2
	 * @return
	 */
	public static OwlsService getAmbroxService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsAmrboxServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try
		{
			/**
			 * Service Section
			 * AmbroxService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl	http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl
			 */
			OwlsServiceFile owlsAmbroxService = new OwlsServiceFile();
			owlsAmbroxService.setServiceFileName("AmbroxService.owl");
			owlsAmbroxService.setMimeType("application/rdf+xml");
			owlsAmbroxService.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl");
			owlsAmbroxService.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl");
			owlsAmbroxService.setServiceFileType(Service);
			owlsAmrboxServiceFileList.add(owlsAmbroxService);
			
			/**
			 * Profile Section
			 * AmbroxProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl	http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl
			 */
			
			OwlsServiceFile owlsAmbroxProfile = new OwlsServiceFile();
			owlsAmbroxProfile.setServiceFileName("AmbroxProfile.owl");
			owlsAmbroxProfile.setMimeType("application/rdf+xml");
			owlsAmbroxProfile.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl");
			owlsAmbroxProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxProfile.owl");
			owlsAmbroxProfile.setServiceFileType(Profile);
			owlsAmrboxServiceFileList.add(owlsAmbroxProfile);
			
			/**
			 * QosProfile Section
			 * AmbroxQosProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxQosProfile.owl	http://test.biocomalert.com/docs/services/ambrox/AmbroxQosProfile.owl	1
			 */
			OwlsServiceFile owlsAmbroxQosProfile = new OwlsServiceFile();
			owlsAmbroxQosProfile.setServiceFileName("AmbroxQosProfile.owl");
			owlsAmbroxQosProfile.setMimeType("application/rdf+xml");
			owlsAmbroxQosProfile.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxQosProfile.owl");
			owlsAmbroxQosProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxQosProfile.owl");
			owlsAmbroxQosProfile.setServiceFileType(QosProfile);
			owlsAmrboxServiceFileList.add(owlsAmbroxQosProfile);
			
			/**
			 * Process Section
			 * AmbroxProcess.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl	http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl
			 */
			
			OwlsServiceFile owlsAmbroxProcess = new OwlsServiceFile();
			owlsAmbroxProcess.setServiceFileName("AmbroxProcess.owl");
			owlsAmbroxProcess.setMimeType("application/rdf+xml");
			owlsAmbroxProcess.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl");
			owlsAmbroxProcess.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxProcess.owl");
			owlsAmbroxProcess.setServiceFileType(Process);
			owlsAmrboxServiceFileList.add(owlsAmbroxProcess);
			
			/**
			 * Grounding Section
			 * AmbroxGrounding.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl	http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl
			 */
			OwlsServiceFile owlsAmbroxGrounding = new OwlsServiceFile();
			owlsAmbroxGrounding.setServiceFileName("AmbroxGrounding.owl");
			owlsAmbroxGrounding.setMimeType("application/rdf+xml");
			owlsAmbroxGrounding.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl");
			owlsAmbroxGrounding.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.owl");
			owlsAmbroxGrounding.setServiceFileType(Grounding);
			owlsAmrboxServiceFileList.add(owlsAmbroxGrounding);
			
			/**
			 * Grounding Wsdl Section
			 * AmbroxGrounding.wsdl	application/wsdl+xml	http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl	http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl
			 */
			OwlsServiceFile owlsAmbroxGroundingwsdl = new OwlsServiceFile();
			owlsAmbroxGroundingwsdl.setServiceFileName("AmbroxGrounding.wsdl");
			owlsAmbroxGroundingwsdl.setMimeType("application/wsdl+xml");
			owlsAmbroxGroundingwsdl.setWebUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl");
			owlsAmbroxGroundingwsdl.setPhysicalPath("http://test.biocomalert.com/docs/services/ambrox/AmbroxGrounding.wsdl");
			owlsAmbroxGroundingwsdl.setServiceFileType(WsdlGrounding);
			owlsAmrboxServiceFileList.add(owlsAmbroxGroundingwsdl);
			
			owlsService = new OwlsService();
			owlsService.setId(2);
			owlsService.setServiceName("Ambrox Service");
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This  service provide option to search Ambrox drug based on patient physical condition");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/ambrox/AmbroxService.owl");
			owlsService.setOwlsServiceList(owlsAmrboxServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	
	
	/**
	 * Service Id: 3
	 * @return
	 */
	public static OwlsService getGmaxService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsGmaxServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try
		{
			/**
			 * Service Section
			 * GmaxService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/gmax/GmaxService.owl	http://test.biocomalert.com/docs/services/gmax/GmaxService.owl
			 */
			OwlsServiceFile owlsGmaxService = new OwlsServiceFile();
			owlsGmaxService.setServiceFileName("GmaxService.owl");
			owlsGmaxService.setMimeType("application/rdf+xml");
			owlsGmaxService.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxService.owl");
			owlsGmaxService.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxService.owl");
			owlsGmaxService.setServiceFileType(Service);
			owlsGmaxServiceFileList.add(owlsGmaxService);
			
			/**
			 * Profile Section
			 * GmaxProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl	http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl
			 */
			
			OwlsServiceFile owlsGmaxProfile = new OwlsServiceFile();
			owlsGmaxProfile.setServiceFileName("GmaxProfile.owl");
			owlsGmaxProfile.setMimeType("application/rdf+xml");
			owlsGmaxProfile.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl");
			owlsGmaxProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxProfile.owl");
			owlsGmaxProfile.setServiceFileType(Profile);
			owlsGmaxServiceFileList.add(owlsGmaxProfile);
			
			/**
			 * QosProfile Section
			 * GmaxQosProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl	http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl
			 */
			OwlsServiceFile owlsGmaxQosProfile = new OwlsServiceFile();
			owlsGmaxQosProfile.setServiceFileName("GmaxQosProfile.owl");
			owlsGmaxQosProfile.setMimeType("application/rdf+xml");
			owlsGmaxQosProfile.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl");
			owlsGmaxQosProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxQosProfile.owl");
			owlsGmaxQosProfile.setServiceFileType(QosProfile);
			owlsGmaxServiceFileList.add(owlsGmaxQosProfile);
			
			/**
			 * Process Section
			 * GmaxProcess.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl	http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl
			 */
			
			OwlsServiceFile owlsGmaxProcess = new OwlsServiceFile();
			owlsGmaxProcess.setServiceFileName("GmaxProcess.owl");
			owlsGmaxProcess.setMimeType("application/rdf+xml");
			owlsGmaxProcess.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl");
			owlsGmaxProcess.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxProcess.owl");
			owlsGmaxProcess.setServiceFileType(Process);
			owlsGmaxServiceFileList.add(owlsGmaxProcess);
			
			/**
			 * Grounding Section
			 * GmaxGrounding.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl	http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl
			 */
			OwlsServiceFile owlsGmaxGrounding = new OwlsServiceFile();
			owlsGmaxGrounding.setServiceFileName("GmaxGrounding.owl");
			owlsGmaxGrounding.setMimeType("application/rdf+xml");
			owlsGmaxGrounding.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl");
			owlsGmaxGrounding.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.owl");
			owlsGmaxGrounding.setServiceFileType(Grounding);
			owlsGmaxServiceFileList.add(owlsGmaxGrounding);
			
			/**
			 * Grounding Wsdl Section
			 * GmaxGrounding.wsdl	application/wsdl+xml	http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl	http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl
			 */
			OwlsServiceFile owlsGmaxGroundingwsdl = new OwlsServiceFile();
			owlsGmaxGroundingwsdl.setServiceFileName("GmaxGrounding.wsdl");
			owlsGmaxGroundingwsdl.setMimeType("application/wsdl+xml");
			owlsGmaxGroundingwsdl.setWebUrl("http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl");
			owlsGmaxGroundingwsdl.setPhysicalPath("http://test.biocomalert.com/docs/services/gmax/GmaxGrounding.wsdl");
			owlsGmaxGroundingwsdl.setServiceFileType(WsdlGrounding);
			owlsGmaxServiceFileList.add(owlsGmaxGroundingwsdl);
			
			owlsService = new OwlsService();
			owlsService.setId(3);
			owlsService.setServiceName("Gmax Service");
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Gmax drug based on patient physical condition");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/gmax/GmaxService.owl");
			owlsService.setOwlsServiceList(owlsGmaxServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	/**
	 * Service Id: 4
	 * @return
	 */
	public static OwlsService getNapaService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsNapaServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try
		{
			/**
			 * Service Section
			 * NapaService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/napa/NapaService.owl	http://test.biocomalert.com/docs/services/napa/NapaService.owl
			 */
			OwlsServiceFile owlsNapaService = new OwlsServiceFile();
			owlsNapaService.setServiceFileName("NapaService.owl");
			owlsNapaService.setMimeType("application/rdf+xml");
			owlsNapaService.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaService.owl");
			owlsNapaService.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaService.owl");
			owlsNapaService.setServiceFileType(Service);
			owlsNapaServiceFileList.add(owlsNapaService);
			
			/**
			 * Profile Section
			 * NapaProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/napa/NapaProfile.owl	http://test.biocomalert.com/docs/services/napa/NapaProfile.owl
			 */
			
			OwlsServiceFile owlsNapaProfile = new OwlsServiceFile();
			owlsNapaProfile.setServiceFileName("NapaProfile.owl");
			owlsNapaProfile.setMimeType("application/rdf+xml");
			owlsNapaProfile.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaProfile.owl");
			owlsNapaProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaProfile.owl");
			owlsNapaProfile.setServiceFileType(Profile);
			owlsNapaServiceFileList.add(owlsNapaProfile);
			
			/**
			 * QosProfile Section
			 * NapaQosProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl	http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl
			 */
			OwlsServiceFile owlsNapaQosProfile = new OwlsServiceFile();
			owlsNapaQosProfile.setServiceFileName("NapaQosProfile.owl");
			owlsNapaQosProfile.setMimeType("application/rdf+xml");
			owlsNapaQosProfile.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl");
			owlsNapaQosProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaQosProfile.owl");
			owlsNapaQosProfile.setServiceFileType(QosProfile);
			owlsNapaServiceFileList.add(owlsNapaQosProfile);
			
			/**
			 * Process Section
			 * NapaProcess.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/napa/NapaProcess.owl	http://test.biocomalert.com/docs/services/napa/NapaProcess.owl
			 */
			
			OwlsServiceFile owlsNapaProcess = new OwlsServiceFile();
			owlsNapaProcess.setServiceFileName("NapaProcess.owl");
			owlsNapaProcess.setMimeType("application/rdf+xml");
			owlsNapaProcess.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaProcess.owl");
			owlsNapaProcess.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaProcess.owl");
			owlsNapaProcess.setServiceFileType(Process);
			owlsNapaServiceFileList.add(owlsNapaProcess);
			
			/**
			 * Grounding Section
			 * NapaGrounding.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl	http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl
			 */
			OwlsServiceFile owlsNapaGrounding = new OwlsServiceFile();
			owlsNapaGrounding.setServiceFileName("NapaGrounding.owl");
			owlsNapaGrounding.setMimeType("application/rdf+xml");
			owlsNapaGrounding.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl");
			owlsNapaGrounding.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaGrounding.owl");
			owlsNapaGrounding.setServiceFileType(Grounding);
			owlsNapaServiceFileList.add(owlsNapaGrounding);
			
			/**
			 * Grounding Wsdl Section
			 * NapaGrounding.wsdl	application/wsdl+xml	http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl	http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl	
			 */
			OwlsServiceFile owlsNapaGroundingwsdl = new OwlsServiceFile();
			owlsNapaGroundingwsdl.setServiceFileName("NapaGrounding.wsdl");
			owlsNapaGroundingwsdl.setMimeType("application/wsdl+xml");
			owlsNapaGroundingwsdl.setWebUrl("http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl");
			owlsNapaGroundingwsdl.setPhysicalPath("http://test.biocomalert.com/docs/services/napa/NapaGrounding.wsdl");
			owlsNapaGroundingwsdl.setServiceFileType(WsdlGrounding);
			owlsNapaServiceFileList.add(owlsNapaGroundingwsdl);
			
			owlsService = new OwlsService();
			owlsService.setId(4);
			owlsService.setServiceName("Napa Service");
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Napa drug based on patient physical condition");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/napa/NapaService.owl");
			owlsService.setOwlsServiceList(owlsNapaServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	/**
	 * Service Id: 5
	 */
	public static OwlsService getSerapeService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try
		{
			/**
			 * Service Section
			 * SerapeService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/serape/SerapeService.owl	http://test.biocomalert.com/docs/services/serape/SerapeService.owl
			 */
			OwlsServiceFile owlsSerapeService = new OwlsServiceFile();
			owlsSerapeService.setServiceFileName("SerapeService.owl");
			owlsSerapeService.setMimeType("application/rdf+xml");
			owlsSerapeService.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeService.owl");
			owlsSerapeService.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeService.owl");
			owlsSerapeService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsSerapeService);
			
			/**
			 * Profile Section
			 * SerapeProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl	http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl	1
			 */
			
			OwlsServiceFile owlsSerapeProfile = new OwlsServiceFile();
			owlsSerapeProfile.setServiceFileName("SerapeProfile.owl");
			owlsSerapeProfile.setMimeType("application/rdf+xml");
			owlsSerapeProfile.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl");
			owlsSerapeProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeProfile.owl");
			owlsSerapeProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsSerapeProfile);
			
			/**
			 * QosProfile Section
			 * SerapeQosProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/serape/SerapeQosProfile.owl	http://test.biocomalert.com/docs/services/serape/SerapeQosProfile.owl
			 */
			OwlsServiceFile owlsSerapeQosProfile = new OwlsServiceFile();
			owlsSerapeQosProfile.setServiceFileName("SerapeQosProfile.owl");
			owlsSerapeQosProfile.setMimeType("application/rdf+xml");
			owlsSerapeQosProfile.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeQosProfile.owl");
			owlsSerapeQosProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeQosProfile.owl");
			owlsSerapeQosProfile.setServiceFileType(QosProfile);
			owlsSerapeServiceFileList.add(owlsSerapeQosProfile);
			
			
			/**
			 * Process Section
			 * SerapeProcess.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl	http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl	1
			 */
			
			OwlsServiceFile owlsSerapeProcess = new OwlsServiceFile();
			owlsSerapeProcess.setServiceFileName("SerapeProcess.owl");
			owlsSerapeProcess.setMimeType("application/rdf+xml");
			owlsSerapeProcess.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl");
			owlsSerapeProcess.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeProcess.owl");
			owlsSerapeService.setServiceFileType(Process);
			owlsSerapeServiceFileList.add(owlsSerapeProcess);
			
			/**
			 * Grounding Section
			 * SerapeGrounding.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl	http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl
			 */
			OwlsServiceFile owlsSerapeGrounding = new OwlsServiceFile();
			owlsSerapeGrounding.setServiceFileName("SerapeGrounding.owl");
			owlsSerapeGrounding.setMimeType("application/rdf+xml");
			owlsSerapeGrounding.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl");
			owlsSerapeGrounding.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeGrounding.owl");
			owlsSerapeGrounding.setServiceFileType(Grounding);
			owlsSerapeServiceFileList.add(owlsSerapeGrounding);
			
			/**
			 * Grounding Wsdl Section
			 * SerapeGrounding.wsdl	application/wsdl+xml	http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl	http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl	
			 */
			OwlsServiceFile owlsSerapeGroundingwsdl = new OwlsServiceFile();
			owlsSerapeGroundingwsdl.setServiceFileName("SerapeGrounding.wsdl");
			owlsSerapeGroundingwsdl.setMimeType("application/wsdl+xml");
			owlsSerapeGroundingwsdl.setWebUrl("http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl");
			owlsSerapeGroundingwsdl.setPhysicalPath("http://test.biocomalert.com/docs/services/serape/SerapeGrounding.wsdl");
			owlsSerapeGroundingwsdl.setServiceFileType(WsdlGrounding);
			owlsSerapeServiceFileList.add(owlsSerapeGroundingwsdl);
			
			owlsService = new OwlsService();
			owlsService.setId(5);
			owlsService.setServiceName("Serape Service");
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Gmax drug based on patient physical condition");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/serape/SerapeService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	public static OwlsServiceList PopulateOwlsServiceList(){
		
		ArrayList<OwlsService> owlsServiceList = new ArrayList<OwlsService>();
		OwlsServiceList owlsServiceListResponse = new OwlsServiceList();
		
		try
		{
			/**
			 * Cer3 Service
			 */
			OwlsService owlsCef3Service = ServiceRepositoryManager.getCef3Service();
			if(owlsCef3Service !=null){
				owlsServiceList.add(owlsCef3Service);
			}
			
			/**
			 * Ambrox Service
			 */
			OwlsService owlsAmbroxService = ServiceRepositoryManager.getAmbroxService();
			if(owlsAmbroxService !=null){
				owlsServiceList.add(owlsAmbroxService);
			}
			
			/**
			 * Gmax Service
			 */
			OwlsService owlsGmaxService = ServiceRepositoryManager.getGmaxService();
			if(owlsGmaxService != null){
				owlsServiceList.add(owlsGmaxService);
			}
			
			/**
			 * Napa Service
			 */
			OwlsService owlsNapaService = ServiceRepositoryManager.getNapaService();
			if(owlsNapaService != null){
				owlsServiceList.add(owlsNapaService);
			}
			
			
			/**
			 * Serape Service
			 */
			OwlsService owlsSerapeService = ServiceRepositoryManager.getSerapeService();
			if(owlsSerapeService !=null){
				owlsServiceList.add(owlsSerapeService);
			}
			
			owlsServiceListResponse.setIsResult(1);
			owlsServiceListResponse.setIsOperationSuccessfull(1);
			owlsServiceListResponse.setOwlsServiceList(owlsServiceList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsServiceListResponse;
	}
	//---------------------------------------------------------------------------------------------------------------------------
	/* Hospice Palliative Care Workflow Task Related Web Service */
	
	/**
	 * Discover Patient Service
	 * Service Id: 6
	 * @return
	 */
	public static OwlsService getDiscoverPatientService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			/**
			 * Service Section
			 * DiscoverPatientService.owl  	application/rdf+xml	http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl
			 */
			OwlsServiceFile owlsDiscoverPatientService = new OwlsServiceFile();
			owlsDiscoverPatientService.setServiceFileName("DiscoverPatientService.owl");
			owlsDiscoverPatientService.setMimeType("application/rdf+xml");
			owlsDiscoverPatientService.setWebUrl("http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl");
			owlsDiscoverPatientService.setPhysicalPath("http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl");
			owlsDiscoverPatientService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsDiscoverPatientService);
			
			/**
			 * Profile Section
			 * DiscoverPatientProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl
			 */
			
			OwlsServiceFile owlsAppoinmentProfile = new OwlsServiceFile();
			owlsAppoinmentProfile.setServiceFileName("DiscoverPatientProfile.owl");
			owlsAppoinmentProfile.setMimeType("application/rdf+xml");
			owlsAppoinmentProfile.setWebUrl("http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl");
			owlsAppoinmentProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/patient/DiscoverPatientProfile.owl");
			owlsAppoinmentProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsAppoinmentProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Discover Patient Service");
			owlsService.setId(6);
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This service contains information about patient referral initiated by different community cares");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/patient/DiscoverPatientService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	/**
	 * Discover Physician Service
	 * Service Id: 7
	 * @return
	 */
	
	public static OwlsService getDiscoverPhysicianService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			/**
			 * Service Section
			 * DiscoverPatientService.owl  	application/rdf+xml	http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl
			 */
			OwlsServiceFile owlsDiscoverPatientService = new OwlsServiceFile();
			owlsDiscoverPatientService.setServiceFileName("DiscoverPhysicianService.owl");
			owlsDiscoverPatientService.setMimeType("application/rdf+xml");
			owlsDiscoverPatientService.setWebUrl("http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl");
			owlsDiscoverPatientService.setPhysicalPath("http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl");
			owlsDiscoverPatientService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsDiscoverPatientService);
			
			/**
			 * Profile Section
			 * DiscoverPhysicianProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl
			 */
			
			OwlsServiceFile owlsAppoinmentProfile = new OwlsServiceFile();
			owlsAppoinmentProfile.setServiceFileName("DiscoverPhysicianProfile.owl");
			owlsAppoinmentProfile.setMimeType("application/rdf+xml");
			owlsAppoinmentProfile.setWebUrl("http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl");
			owlsAppoinmentProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianProfile.owl");
			owlsAppoinmentProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsAppoinmentProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Discover Physician Service");
			owlsService.setId(7);
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This service contains information about Pallliative Care Physician List");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/physician/DiscoverPhysicianService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	/**
	 * Setup Appointment Service
	 * Service Id: 8
	 * @return
	 */
	public static OwlsService getAppointmentService(){
	
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * AppointService.owl  	application/rdf+xml	http://test.biocomalert.com/docs/services/appoint/AppointService.owl 
			 */
			OwlsServiceFile owlsAppoinmentService = new OwlsServiceFile();
			owlsAppoinmentService.setServiceFileName("AppointService.owl");
			owlsAppoinmentService.setMimeType("application/rdf+xml");
			owlsAppoinmentService.setWebUrl("http://test.biocomalert.com/docs/services/appoint/AppointService.owl");
			owlsAppoinmentService.setPhysicalPath("http://test.biocomalert.com/docs/services/appoint/AppointService.owl");
			owlsAppoinmentService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsAppoinmentService);
			
			/**
			 * Profile Section
			 * AppointProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl
			 */
			
			OwlsServiceFile owlsAppoinmentProfile = new OwlsServiceFile();
			owlsAppoinmentProfile.setServiceFileName("AppointProfile.owl");
			owlsAppoinmentProfile.setMimeType("application/rdf+xml");
			owlsAppoinmentProfile.setWebUrl("http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl");
			owlsAppoinmentProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/appoint/AppointProfile.owl");
			owlsAppoinmentProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsAppoinmentProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Apointment Service");
			owlsService.setId(8);
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This service saves appointment schedules for the selected patient and the physician");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/appoint/AppointService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	
	}
	
	/**
	 * Consult Service
	 * Service Id: 9
	 * @return
	 */
	public static OwlsService getConsultService(){
	
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * ConsultService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/consult/ConsultService.owl
			 */
			OwlsServiceFile owlsConsultService = new OwlsServiceFile();
			owlsConsultService.setServiceFileName("ConsultService.owl");
			owlsConsultService.setMimeType("application/rdf+xml");
			owlsConsultService.setWebUrl("http://test.biocomalert.com/docs/services/consult/ConsultService.owl");
			owlsConsultService.setPhysicalPath("http://test.biocomalert.com/docs/services/consult/ConsultService.owl");
			owlsConsultService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsultService);
			
			/**
			 * Profile Section
			 * ConsultProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl
			 */
			
			OwlsServiceFile owlsConsultProfile = new OwlsServiceFile();
			owlsConsultProfile.setServiceFileName("ConsultProfile.owl");
			owlsConsultProfile.setMimeType("application/rdf+xml");
			owlsConsultProfile.setWebUrl("http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl");
			owlsConsultProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/consult/ConsultProfile.owl");
			owlsConsultProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsultProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Consult Service");
			owlsService.setId(9);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service saves consulation details to the data source ontology");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/consult/ConsultService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
		return owlsService;
		
	}
	
	/**
	 * Explanation Service:
	 * Service Id: 10
	 */
	
	public static OwlsService getExplationService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * ExplainService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/explain/ExplainService.owl
			 */
			OwlsServiceFile owlsConsultService = new OwlsServiceFile();
			owlsConsultService.setServiceFileName("ExplainService.owl");
			owlsConsultService.setMimeType("application/rdf+xml");
			owlsConsultService.setWebUrl("http://test.biocomalert.com/docs/services/explain/ExplainService.owl");
			owlsConsultService.setPhysicalPath("http://test.biocomalert.com/docs/services/explain/ExplainService.owl");
			owlsConsultService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsultService);
			
			/**
			 * Profile Section
			 * ExplainProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl
			 */
			
			OwlsServiceFile owlsConsultProfile = new OwlsServiceFile();
			owlsConsultProfile.setServiceFileName("ExplainProfile.owl");
			owlsConsultProfile.setMimeType("application/rdf+xml");
			owlsConsultProfile.setWebUrl("http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl");
			owlsConsultProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/explain/ExplainProfile.owl");
			owlsConsultProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsultProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Explanation Service");
			owlsService.setId(10);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service saves explanation details to the data source ontology");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/explain/ExplainService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
		return owlsService;
	}
	
	/**
	 * Discover Physician Service
	 * Service Id: 11
	 * @return
	 */
	public static OwlsService getDiscoverCareGiverService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * CareGiverService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl
			 */
			OwlsServiceFile owlsConsultService = new OwlsServiceFile();
			owlsConsultService.setServiceFileName("CareGiverService.owl");
			owlsConsultService.setMimeType("application/rdf+xml");
			owlsConsultService.setWebUrl("http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl");
			owlsConsultService.setPhysicalPath("http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl");
			owlsConsultService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsultService);
			
			/**
			 * Profile Section
			 * CareGiverProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl
			 */
			
			OwlsServiceFile owlsConsultProfile = new OwlsServiceFile();
			owlsConsultProfile.setServiceFileName("CareGiverProfile.owl");
			owlsConsultProfile.setMimeType("application/rdf+xml");
			owlsConsultProfile.setWebUrl("http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl");
			owlsConsultProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl");
			owlsConsultProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsultProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Discover Caregiver Service");
			owlsService.setId(11);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service returns services about Palliative Care Caregivers");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/caregiver/CareGiverService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
		return owlsService;
		
	}
	
	/**
	 * Deliver Service
	 * Service Id: 12
	 * @return
	 */
	public static OwlsService getDeliverCareService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * DeliverCareService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl
			 */
			OwlsServiceFile owlsConsultService = new OwlsServiceFile();
			owlsConsultService.setServiceFileName("DeliverCareService.owl");
			owlsConsultService.setMimeType("application/rdf+xml");
			owlsConsultService.setWebUrl("http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl");
			owlsConsultService.setPhysicalPath("http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl");
			owlsConsultService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsultService);
			
			/**
			 * Profile Section
			 * DeliverCareProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl
			 */
			
			OwlsServiceFile owlsConsultProfile = new OwlsServiceFile();
			owlsConsultProfile.setServiceFileName("DeliverCareProfile.owl");
			owlsConsultProfile.setMimeType("application/rdf+xml");
			owlsConsultProfile.setWebUrl("http://test.biocomalert.com/docs/services/caregiver/CareGiverProfile.owl");
			owlsConsultProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/delivercare/DeliverCareProfile.owl");
			owlsConsultProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsultProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Delliver Service");
			owlsService.setId(12);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service returns services about Care Delivery");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/delivercare/DeliverCareService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
		return owlsService;
		
	}
	
	/**
	 * Prescribe Drug Service
	 * Service Id: 13
	 * @return
	 */
	public static OwlsService getPrescribeDrugService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			/**
			 * Service Section
			 * PrescribeDrugService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl
			 */
			OwlsServiceFile owlsConsultService = new OwlsServiceFile();
			owlsConsultService.setServiceFileName("PrescribeDrugService.owl");
			owlsConsultService.setMimeType("application/rdf+xml");
			owlsConsultService.setWebUrl("http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl");
			owlsConsultService.setPhysicalPath("http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl");
			owlsConsultService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsultService);
			
			/**
			 * Profile Section
			 * PrescribeDrugProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl
			 */
			
			OwlsServiceFile owlsConsultProfile = new OwlsServiceFile();
			owlsConsultProfile.setServiceFileName("PrescribeDrugProfile.owl");
			owlsConsultProfile.setMimeType("application/rdf+xml");
			owlsConsultProfile.setWebUrl("http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl");
			owlsConsultProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/drug/PrescribeDrugProfile.owl");
			owlsConsultProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsultProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Prescribe Drug Service");
			owlsService.setId(13);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service returns services about Care Delivery");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/drug/PrescribeDrugService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
		return owlsService;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static OwlsServiceList getHpcWorkflowServiceList(){
		
		ArrayList<OwlsService> hpcWorkflowServiceList = new ArrayList<OwlsService>();
		OwlsServiceList hpcWorkflowServiceListResponse = new OwlsServiceList();
		
		try{
			
			/**
			 * Discover Patient Service
			 */
			OwlsService owlsDiscoverPatientService = ServiceRepositoryManager.getDiscoverPatientService();
			if(owlsDiscoverPatientService !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPatientService);
			}
			
			OwlsService owlsDiscoverPatientService2 = ServiceRepositoryManager.getDiscoverPatientService();
			if(owlsDiscoverPatientService2 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPatientService2);
			}
			
			OwlsService owlsDiscoverPatientService3 = ServiceRepositoryManager.getDiscoverPatientService();
			if(owlsDiscoverPatientService3 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPatientService3);
			}
			
			OwlsService owlsDiscoverPatientService4 = ServiceRepositoryManager.getDiscoverPatientService();
			if(owlsDiscoverPatientService4 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPatientService4);
			}
			
			/**
			 * Discover Physician Service
			 */

			OwlsService owlsDiscoverPhysicianService = ServiceRepositoryManager.getDiscoverPhysicianService();
			if(owlsDiscoverPhysicianService !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPhysicianService);
			}
			
			OwlsService owlsDiscoverPhysicianService2 = ServiceRepositoryManager.getDiscoverPhysicianService();
			if(owlsDiscoverPhysicianService2 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPhysicianService2);
			}
			
			OwlsService owlsDiscoverPhysicianService3 = ServiceRepositoryManager.getDiscoverPhysicianService();
			if(owlsDiscoverPhysicianService3 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPhysicianService3);
			}
			
			OwlsService owlsDiscoverPhysicianService4 = ServiceRepositoryManager.getDiscoverPhysicianService();
			if(owlsDiscoverPhysicianService4 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverPhysicianService4);
			}
			
			/**
			 * Appointment Service
			 */
			
			OwlsService owlsAppointmentService = ServiceRepositoryManager.getAppointmentService();
			if(owlsAppointmentService !=null){
				hpcWorkflowServiceList.add(owlsAppointmentService);
			}
			
			OwlsService owlsAppointmentService2 = ServiceRepositoryManager.getAppointmentService();
			if(owlsAppointmentService2 !=null){
				hpcWorkflowServiceList.add(owlsAppointmentService2);
			}
			
			OwlsService owlsAppointmentService3 = ServiceRepositoryManager.getAppointmentService();
			if(owlsAppointmentService3 !=null){
				hpcWorkflowServiceList.add(owlsAppointmentService3);
			}
			
			OwlsService owlsAppointmentService4 = ServiceRepositoryManager.getAppointmentService();
			if(owlsAppointmentService4 !=null){
				hpcWorkflowServiceList.add(owlsAppointmentService4);
			}
			
			/**
			 * Consult Service
			 */
			
			OwlsService owlsConsultService = ServiceRepositoryManager.getConsultService();
			if(owlsConsultService !=null){
				hpcWorkflowServiceList.add(owlsConsultService);
			}
			
			OwlsService owlsConsultService2 = ServiceRepositoryManager.getConsultService();
			if(owlsConsultService2 !=null){
				hpcWorkflowServiceList.add(owlsConsultService2);
			}
			
			OwlsService owlsConsultService3 = ServiceRepositoryManager.getConsultService();
			if(owlsConsultService3 !=null){
				hpcWorkflowServiceList.add(owlsConsultService3);
			}
			
			OwlsService owlsConsultService4 = ServiceRepositoryManager.getConsultService();
			if(owlsConsultService4 !=null){
				hpcWorkflowServiceList.add(owlsConsultService4);
			}
			
			/**
			 * Explanation Service
			 */
			OwlsService owlsExplanationService = ServiceRepositoryManager.getExplationService();
			if(owlsExplanationService !=null){
				hpcWorkflowServiceList.add(owlsExplanationService);
			}
			
			OwlsService owlsExplanationService2 = ServiceRepositoryManager.getExplationService();
			if(owlsExplanationService2 !=null){
				hpcWorkflowServiceList.add(owlsExplanationService2);
			}
			
			OwlsService owlsExplanationService3 = ServiceRepositoryManager.getExplationService();
			if(owlsExplanationService3 !=null){
				hpcWorkflowServiceList.add(owlsExplanationService3);
			}
			
			OwlsService owlsExplanationService4 = ServiceRepositoryManager.getExplationService();
			if(owlsExplanationService4 !=null){
				hpcWorkflowServiceList.add(owlsExplanationService4);
			}
			
			/**
			 * Discover Caregiver Service
			 */
			
			OwlsService owlsDiscoverCaregiverService = ServiceRepositoryManager.getDiscoverCareGiverService();
			if(owlsDiscoverCaregiverService !=null){
				hpcWorkflowServiceList.add(owlsDiscoverCaregiverService);
			}
			
			OwlsService owlsDiscoverCaregiverService2 = ServiceRepositoryManager.getDiscoverCareGiverService();
			if(owlsDiscoverCaregiverService2 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverCaregiverService2);
			}
			
			OwlsService owlsDiscoverCaregiverService3 = ServiceRepositoryManager.getDiscoverCareGiverService();
			if(owlsDiscoverCaregiverService3 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverCaregiverService3);
			}
			
			OwlsService owlsDiscoverCaregiverService4 = ServiceRepositoryManager.getDiscoverCareGiverService();
			if(owlsDiscoverCaregiverService4 !=null){
				hpcWorkflowServiceList.add(owlsDiscoverCaregiverService4);
			}
			
			/**
			 * Care Delivery Service
			 */
			
			OwlsService owlsDeliverCareService = ServiceRepositoryManager.getDeliverCareService();
			if(owlsDeliverCareService !=null){
				hpcWorkflowServiceList.add(owlsDeliverCareService);
			}
			
			OwlsService owlsDeliverCareService2 = ServiceRepositoryManager.getDeliverCareService();
			if(owlsDeliverCareService2 !=null){
				hpcWorkflowServiceList.add(owlsDeliverCareService2);
			}
			
			OwlsService owlsDeliverCareService3 = ServiceRepositoryManager.getDeliverCareService();
			if(owlsDeliverCareService3 !=null){
				hpcWorkflowServiceList.add(owlsDeliverCareService3);
			}
			
			OwlsService owlsDeliverCareService4 = ServiceRepositoryManager.getDeliverCareService();
			if(owlsDeliverCareService4 !=null){
				hpcWorkflowServiceList.add(owlsDeliverCareService4);
			}
			
			/**
			 * Prescribe Drug Service
			 */
			
			OwlsService owlsPrescribeDrugService = ServiceRepositoryManager.getPrescribeDrugService();
			if(owlsPrescribeDrugService !=null){
				hpcWorkflowServiceList.add(owlsPrescribeDrugService);
			}
			
			OwlsService owlsPrescribeDrugService2 = ServiceRepositoryManager.getPrescribeDrugService();
			if(owlsPrescribeDrugService2 !=null){
				hpcWorkflowServiceList.add(owlsPrescribeDrugService2);
			}
			
			OwlsService owlsPrescribeDrugService3 = ServiceRepositoryManager.getPrescribeDrugService();
			if(owlsPrescribeDrugService3 !=null){
				hpcWorkflowServiceList.add(owlsPrescribeDrugService3);
			}
			
			OwlsService owlsPrescribeDrugService4 = ServiceRepositoryManager.getPrescribeDrugService();
			if(owlsPrescribeDrugService4 !=null){
				hpcWorkflowServiceList.add(owlsPrescribeDrugService4);
			}
			
			hpcWorkflowServiceListResponse.setIsResult(1);
			hpcWorkflowServiceListResponse.setIsOperationSuccessfull(1);
			hpcWorkflowServiceListResponse.setOwlsServiceList(hpcWorkflowServiceList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return hpcWorkflowServiceListResponse;
	}
	
	/*public static OwlsService getAppointment2Service(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			*//**
			 * Service Section
			 * Appoint2Service.owl  	application/rdf+xml	http://test.biocomalert.com/docs/services/appoint2/Appoint2Service.owl 
			 *//*
			OwlsServiceFile owlsAppointment2Service = new OwlsServiceFile();
			owlsAppointment2Service.setServiceFileName("Appoint2Service.owl");
			owlsAppointment2Service.setMimeType("application/rdf+xml");
			owlsAppointment2Service.setWebUrl("http://test.biocomalert.com/docs/services/appoint2/Appoint2Service.owl");
			owlsAppointment2Service.setPhysicalPath("http://test.biocomalert.com/docs/services/appoint2/Appoint2Service.owl");
			owlsAppointment2Service.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsAppointment2Service);
			
			*//**
			 * Profile Section
			 * AppointProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/appoint2/Appoint2Profile.owl	http://test.biocomalert.com/docs/services/appoint2/Appoint2Profile.owl	1
			 *//*
			
			OwlsServiceFile owlsAppoinment2Profile = new OwlsServiceFile();
			owlsAppoinment2Profile.setServiceFileName("Appoint2Profile.owl");
			owlsAppoinment2Profile.setMimeType("application/rdf+xml");
			owlsAppoinment2Profile.setWebUrl("http://test.biocomalert.com/docs/services/appoint2/Appoint2Profile.owl");
			owlsAppoinment2Profile.setPhysicalPath("http://test.biocomalert.com/docs/services/appoint2/Appoint2Profile.owl");
			owlsAppoinment2Profile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsAppoinment2Profile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Apoinment 2 Service");
			owlsService.setId(10);
			owlsService.setServiceProvider("Center for Logic and Information");
			owlsService.setServiceDescription("This service provide option to search Referral details based on patient and medical centre information");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/appoint2/Appoint2Service.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
		
	}
	
	public static OwlsService getConsult2Service(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			*//**
			 * Service Section
			 * Consult2Service.owl 	application/rdf+xml	http://test.biocomalert.com/docs/services/consult2/Consult2Service.owl 	http://test.biocomalert.com/docs/services/consult2/Consult2Service.owl 
			 *//*
			OwlsServiceFile owlsConsult2Service = new OwlsServiceFile();
			owlsConsult2Service.setServiceFileName("Consult2Service.owl");
			owlsConsult2Service.setMimeType("application/rdf+xml");
			owlsConsult2Service.setWebUrl("http://test.biocomalert.com/docs/services/consult2/Consult2Service.owl");
			owlsConsult2Service.setPhysicalPath("http://test.biocomalert.com/docs/services/consult2/Consult2Service.owl");
			owlsConsult2Service.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsConsult2Service);
			
			*//**
			 * Profile Section
			 * ConsultProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/consult2/Consult2Profile.owl	http://test.biocomalert.com/docs/services/consult2/Consult2Profile.owl	1
			 *//*
			
			OwlsServiceFile owlsConsult2Profile = new OwlsServiceFile();
			owlsConsult2Profile.setServiceFileName("Consult2Profile.owl");
			owlsConsult2Profile.setMimeType("application/rdf+xml");
			owlsConsult2Profile.setWebUrl("http://test.biocomalert.com/docs/services/consult2/Consult2Profile.owl");
			owlsConsult2Profile.setPhysicalPath("http://test.biocomalert.com/docs/services/consult2/Consult2Profile.owl");
			owlsConsult2Profile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsConsult2Profile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Consult 2 Service");
			owlsService.setId(9);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Referral details based on patient and medical centre information");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/consult2/Consult2Service.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
		
	}
	
	public static OwlsService getReferral2Service(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			*//**
			 * Service Section
			 * ReferralService2.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/referral2/ReferralService2.owl	http://test.biocomalert.com/docs/services/referral2/ReferralService2.owl
			 *//*
			OwlsServiceFile owlsReferral2Service = new OwlsServiceFile();
			owlsReferral2Service.setServiceFileName("ReferralService2.owl");
			owlsReferral2Service.setMimeType("application/rdf+xml");
			owlsReferral2Service.setWebUrl("http://test.biocomalert.com/docs/services/referral2/ReferralService2.owl");
			owlsReferral2Service.setPhysicalPath("http://test.biocomalert.com/docs/services/referral2/ReferralService2.owl");
			owlsReferral2Service.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsReferral2Service);
			
			*//**
			 * Profile Section
			 * ReferralProfile2.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/referral2/ReferralProfile2.owl	http://test.biocomalert.com/docs/services/referral2/ReferralProfile2.owl	1
			 *//*
			
			OwlsServiceFile owlsReferral2Profile = new OwlsServiceFile();
			owlsReferral2Profile.setServiceFileName("ReferralProfile2.owl");
			owlsReferral2Profile.setMimeType("application/rdf+xml");
			owlsReferral2Profile.setWebUrl("http://test.biocomalert.com/docs/services/referral2/ReferralProfile2.owl");
			owlsReferral2Profile.setPhysicalPath("http://test.biocomalert.com/docs/services/referral2/ReferralProfile2.owl");
			owlsReferral2Profile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsReferral2Profile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Referral 2 Service");
			owlsService.setId(7);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Referral details based on patient and medical centre information");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/referral2/ReferralService2.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}
	
	public static OwlsService getReferralService(){
		
		OwlsService owlsService = null;
		ArrayList<OwlsServiceFile> owlsSerapeServiceFileList = new ArrayList<OwlsServiceFile>();
		
		try{
			
			*//**
			 * Service Section
			 * ReferralService.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/referral/ReferralService.owl	http://test.biocomalert.com/docs/services/referral/ReferralService.owl
			 *//*
			OwlsServiceFile owlsReferralService = new OwlsServiceFile();
			owlsReferralService.setServiceFileName("ReferralService.owl");
			owlsReferralService.setMimeType("application/rdf+xml");
			owlsReferralService.setWebUrl("http://test.biocomalert.com/docs/services/referral/ReferralService.owl");
			owlsReferralService.setPhysicalPath("http://test.biocomalert.com/docs/services/referral/ReferralService.owl");
			owlsReferralService.setServiceFileType(Service);
			owlsSerapeServiceFileList.add(owlsReferralService);
			
			*//**
			 * Profile Section
			 * ReferralProfile.owl	application/rdf+xml	http://test.biocomalert.com/docs/services/referral/ReferralProfile.owl	http://test.biocomalert.com/docs/services/referral/ReferralProfile.owl	1
			 *//*
			
			OwlsServiceFile owlsReferralProfile = new OwlsServiceFile();
			owlsReferralProfile.setServiceFileName("ReferralProfile.owl");
			owlsReferralProfile.setMimeType("application/rdf+xml");
			owlsReferralProfile.setWebUrl("http://test.biocomalert.com/docs/services/referral/ReferralProfile.owl");
			owlsReferralProfile.setPhysicalPath("http://test.biocomalert.com/docs/services/referral/ReferralProfile.owl");
			owlsReferralProfile.setServiceFileType(Profile);
			owlsSerapeServiceFileList.add(owlsReferralProfile);
			
			owlsService = new OwlsService();
			owlsService.setServiceName("Referral Service");
			owlsService.setId(6);
			owlsService.setServiceProvider("St. Francis Xavier University");
			owlsService.setServiceDescription("This service provide option to search Referral details based on patient and medical centre information");
			owlsService.setRootServiceUrl("http://test.biocomalert.com/docs/services/referral/ReferralService.owl");
			owlsService.setOwlsServiceList(owlsSerapeServiceFileList);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return owlsService;
	}*/
	
}
