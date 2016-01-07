package ar.com.sgt.services.impl;

import org.springframework.stereotype.Repository;

import ar.com.sgt.services.ISystemHelper;


@Repository("systemHelper")
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
