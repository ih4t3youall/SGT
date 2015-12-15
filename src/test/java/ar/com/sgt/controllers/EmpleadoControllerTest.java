package ar.com.sgt.controllers;

import org.springframework.web.servlet.ModelAndView;
import static org.junit.Assert.*;
public class EmpleadoControllerTest {

	private EmpleadoController empleadoController =new EmpleadoController();
	
	public void loadPage(){
		
		
		ModelAndView loadPage = empleadoController.loadPage(null,null);
		
		assertEquals(loadPage.getViewName(), "loginEmpleado");
		
	}
	public void loadPageFail(){
		
		ModelAndView loadPage = empleadoController.loadPageFail(null, null);
		assertEquals(loadPage.getViewName(), "loginEmpleado");
	}
	
	public void loadWelcomeEmpleado(){
		ModelAndView loadWelcomeEmpleado = empleadoController.loadWelcomeEmpleado(null, null);
		assertEquals(loadWelcomeEmpleado.getViewName(), "menuEmpleado");
		
	}
	
	
}
