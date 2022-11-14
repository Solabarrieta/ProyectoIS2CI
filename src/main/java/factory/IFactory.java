package factory;

import businessLogic.BLFacade;
import configuration.ConfigXML;

public interface IFactory {
	public BLFacade createService(ConfigXML c);
}