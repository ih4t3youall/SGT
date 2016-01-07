//package ar.com.sgt.controllers;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.springframework.web.servlet.ModelAndView;
//
//public class EmpleadoControllerTest {
//
//	private EmpleadoController empleadoController =new EmpleadoController();
//	
//	@Test
//	public void loadPage(){
//		
//		
//		ModelAndView loadPage = empleadoController.loadPage();
//		
//		assertEquals(loadPage.getViewName(), "loginEmpleado");
//		
//	}
//	
//	@Test
//	public void loadPageFail(){
//		
//		ModelAndView loadPage = empleadoController.loadPageFail();
//		assertEquals(loadPage.getViewName(), "loginEmpleado");
//	}
//	
//	@Test
//	public void loadWelcomeEmpleado(){
//		ModelAndView loadWelcomeEmpleado = empleadoController.loadWelcomeEmpleado();
//		assertEquals(loadWelcomeEmpleado.getViewName(), "menuEmpleado");
//		
//	}
//	
//	
//}
