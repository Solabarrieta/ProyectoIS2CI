package factory;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class FactoryImpl implements IFactory{
	
	@Override
	public BLFacade createService(ConfigXML c) {
		if (c.isBusinessLogicLocal()) {
			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			
			return new BLFacadeImplementation(da);
		}else {
			String serviceName = "http://" + c.getBusinessLogicNode() + ":" + c.getBusinessLogicPort() + "/ws/"
					+ c.getBusinessLogicName() + "?wsdl";
			URL url;
			try {
				url = new URL(serviceName);
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				return service.getPort(BLFacade.class);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}