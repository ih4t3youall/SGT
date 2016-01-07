package ar.com.sgt.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.dto.PinDTO;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.services.impl.ClienteService;
import ar.com.sgt.services.impl.MenuService;
import ar.com.sgt.utils.DomainUtils;

public class ClienteControllerTest {

	ClienteController clienteController = new ClienteController();
	
	@Test
	public void seleccionarUsuario(){
		ModelAndView seleccionarUsuario = clienteController.seleccionarUsuario();
		assertEquals(seleccionarUsuario.getViewName(), "seleccionTipoCliente");
	}
	
	@Test
	public void usuarioCliente(){
		ModelAndView usuarioCliente = clienteController.usuarioCliente();
		int cont = 0;
		if(usuarioCliente.getViewName().equals("ingresoCliente")){
		
			cont++;
			
		}
		
		Object object = usuarioCliente.getModel().get("pinDTO");
		
		
		if(object!= null){
			
			cont ++;
		}
		
		if(cont ==2 ){
			
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		
		
	}
	
	
	@Test 
	public void verificarPin(){
		
		
		mock();
		
		
		PinDTO pinDTO = new PinDTO();
		pinDTO.setPin(1);
        ModelAndView verificarPin = clienteController.verificarPin(pinDTO);
		Cliente cliente = (Cliente)verificarPin.getModel().get("clienteDTO");
		
		assertEquals(cliente.getIdcliente(), new Integer(1));
	}
	
	
	
	@Test 
	public void usuarioNoCliente(){
		mock();
		ModelAndView usuarioNoCliente = clienteController.usuarioNoCliente();
		
		Object object = usuarioNoCliente.getModel().get("opciones");
		int cont  = 0;
		if(object != null){
			cont ++;
			
		}
		
		if (usuarioNoCliente.getViewName().equals("opciones")){
			
			cont ++;
		}
		
		
		
		if (cont == 2){
			
		assertTrue(true);
		}else {
			
			assertTrue(false);	
			
		}
		
		
		
		
		
	}
	
//	@Test 
//	public void createTicketFileNotFound(){
//		mock();
//		TicketService ticketSercice = Mockito.mock(TicketService.class);
//		Mockito.when(ticketSercice.crearTicket(Mockito.anyString(), Mockito.anyString())).thenReturn("//un//path");
//		Boolean flag = false;
//		clienteController.setTicketService(ticketSercice);
//		try {
//			clienteController.createTicket("un", "ticketmu");
//		} catch (FileNotFoundException e) {
//			flag = true;
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//		}
//		
//		assertTrue(flag);
//		
//	}
//	
//	
//	@Test 
//	public void createTicket(){
//		mock();
//		TicketService ticketSercice = Mockito.mock(TicketService.class);
//		String property = System.getProperty("user.home");
//		property+="\\Desktop\\archivo.pdf";
//		crearArchivo(property);
//		Mockito.when(ticketSercice.crearTicket(Mockito.anyString(), Mockito.anyString())).thenReturn(property);
//		clienteController.setTicketService(ticketSercice);
//		try {
//			clienteController.createTicket("un", "ticketmu");
//		} catch (FileNotFoundException e) {
//			assertTrue(false);
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			assertTrue(false);
//		}
//		removeDir(property);
//		assertTrue(true);
//		
//		
//	}
	
	
	public void removeDir(String property){
		
		
		
		File file = new File(property);
		file.delete();
		
		
		
	}
	public void crearArchivo(String property){
		
		
		File f  = new File(property);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void mock(){
		
		ClienteService clienteService = Mockito.mock(ClienteService.class);
		Mockito.when(clienteService.getClienteByPin(1)).thenReturn(DomainUtils.getCliente(1));
		clienteController.setClienteService(clienteService);
		
		MenuService menuService = Mockito.mock(MenuService.class);
		Map<String,String> mapa = new HashMap<String, String>();
		mapa.put("menu1", "opcion1");
		Mockito.when(menuService.menuCliente()).thenReturn(mapa);
		Mockito.when(menuService.menuNoCliente()).thenReturn(mapa);
		clienteController.setMenuService(menuService);
		
		
		
		
		
		
		
		
		
	}
	
	
}
