package gui;

import java.awt.Color;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import factory.FactoryImpl;
import factory.IFactory;
import iterator.IExtendedIterator;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		MainGUI a=new MainGUI();
		a.setVisible(false);
		
		MainUserGUI b = new MainUserGUI(); 
		b.setVisible(true);


		try {
			
			IFactory fac = new FactoryImpl();
			BLFacade appFacadeInterface = fac.createService(c);
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
//			if (c.isBusinessLogicLocal()) {
//				
//				//In this option the DataAccess is created by FacadeImplementationWS
//				//appFacadeInterface=new BLFacadeImplementation();
//
//				//In this option, you can parameterize the DataAccess (e.g. a Mock DataAccess object)
//
//				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
//				appFacadeInterface=new BLFacadeImplementation(da);
//
//				
//			}
//			
//			else { //If remote
//				
//				 String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
//				 
//				//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
//				URL url = new URL(serviceName);
//
//		 
//		        //1st argument refers to wsdl document above
//				//2nd argument is service name, refer to wsdl document above
////		        QName qname = new QName("http://businessLogic/", "FacadeImplementationWSService");
//		        QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
//		 
//		        Service service = Service.create(url, qname);
//
//		         appFacadeInterface = service.getPort(BLFacade.class);
//			} 
			/*if (c.getDataBaseOpenMode().equals("initialize")) 
				appFacadeInterface.initializeBD();
				*/
			MainGUI.setBussinessLogic(appFacadeInterface);
			Date date = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date eventDate=null;
			try {
				date = sdf.parse("17/12/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IExtendedIterator iter = appFacadeInterface.getEventsIterator(date);
			System.out.println("Tiene next: " + iter.hasNext());
			System.out.println("Siguiente: " + iter.next());
			System.out.println("Tiehne prev: " + iter.hasPrevious());
			System.out.println("Anterior: " + iter.previous());
			System.out.println("Tiene prev: " + iter.hasPrevious());
			

		

			
		}catch (Exception e) {
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
