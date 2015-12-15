package ar.com.sgt.services.impl;

import ar.com.sgt.services.ISystemHelper;

public class SystemHelper implements ISystemHelper {

	@Override
	public String getCatalinaBase() {
		
		return System.getProperty("catalina.base");
		
	}

	@Override
	public String getTemporalDir() {
		return System.getProperty("java.io.tmpdir");
	}

	
}
