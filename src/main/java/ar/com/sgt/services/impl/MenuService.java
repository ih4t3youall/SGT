package ar.com.sgt.services.impl;

import java.util.HashMap;

public class MenuService {

	public HashMap<String, String> menuCliente() {

		HashMap<String, String> menuCliente = new HashMap<String,String>();
		menuCliente.put("Banca personal", "urla");
		menuCliente.put("Cajas", "urlb");
		menuCliente.put("Seguros", "urlc");
		menuCliente.put("Premium", "urld");
		menuCliente.put("Gestion", "urld");
		menuCliente.put("Inversiones", "urld");
		
		return menuCliente;
	}

	public HashMap<String, String> menuNoCliente() {

		
		HashMap<String, String> menuNoCliente = new HashMap<String,String>();
		menuNoCliente.put("Cajas", "urla");
		menuNoCliente.put("Gestion", "urlb");
		menuNoCliente.put("Altas", "urlc");
		menuNoCliente.put("Consultas", "urld");

		return menuNoCliente;
	}

}
