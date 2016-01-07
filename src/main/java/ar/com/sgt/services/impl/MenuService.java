package ar.com.sgt.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
@Service
public class MenuService {

	public Map<String, String> menuCliente() {

		HashMap<String, String> menuCliente = new HashMap<String,String>();
		menuCliente.put("Banca personal", "C");
		menuCliente.put("Cajas", "A");
		menuCliente.put("Seguros", "E");
		menuCliente.put("Premium", "D");
		menuCliente.put("Gestion", "B");
		menuCliente.put("Inversiones", "F");
		
		return menuCliente;
	}

	public Map<String, String> menuNoCliente() {

		
		HashMap<String, String> menuNoCliente = new HashMap<String,String>();
		menuNoCliente.put("Cajas", "A");
		menuNoCliente.put("Gestion", "B");
		menuNoCliente.put("Altas", "G");
		menuNoCliente.put("Consultas", "H");

		return menuNoCliente;
	}

}
