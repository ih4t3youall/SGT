package ar.com.sgt.services.impl;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MenuServiceTest {

	
	private MenuService menuService = new MenuService();
	
	@Test
	public void menuCliente(){
		
		Map<String, String> menuCliente = menuService.menuCliente();
		Map<String, String> crearMenu = crearMenu();
		boolean equals = crearMenu.equals(menuCliente);
		assertTrue(equals);
		
	}
	
	@Test 
	public void menuNoCliente(){
		
		Map<String, String> crearMenuNoCliente = crearMenuNoCliente();
		Map<String, String> menuNoCliente = menuService.menuNoCliente();
		boolean equals = menuNoCliente.equals(crearMenuNoCliente);
		assertTrue(equals);
		
		
	}
	
	private Map<String,String> crearMenuNoCliente(){
		
		HashMap<String, String> menuNoCliente = new HashMap<String,String>();
		menuNoCliente.put("Cajas", "A");
		menuNoCliente.put("Gestion", "B");
		menuNoCliente.put("Altas", "G");
		menuNoCliente.put("Consultas", "H");
		
		return menuNoCliente;
	}
	
	
	
	private Map<String,String> crearMenu(){
		HashMap<String, String> menuCliente = new HashMap<String,String>();
		menuCliente.put("Banca personal", "C");
		menuCliente.put("Cajas", "A");
		menuCliente.put("Seguros", "E");
		menuCliente.put("Premium", "D");
		menuCliente.put("Gestion", "B");
		menuCliente.put("Inversiones", "F");
		
		return menuCliente;
	}
	
}
