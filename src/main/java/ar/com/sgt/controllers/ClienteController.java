package ar.com.sgt.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.dto.ClienteDTO;
import ar.com.sgt.dto.PinDTO;
import ar.com.sgt.services.UserService;
import ar.com.sgt.services.impl.MenuService;

@Controller
public class ClienteController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private UserService userService;

	@RequestMapping("seleccionarUsuario.htm")
	public ModelAndView seleccionarUsuario() {

		ModelAndView mav = new ModelAndView("recepcion/seleccionTipoCliente");

		return mav;

	}

	@RequestMapping("usuarioCliente.htm")
	public ModelAndView usuarioCliente() {

		HashMap<String, String> menuCliente = menuService.menuCliente();
		ModelAndView mav = new ModelAndView("recepcion/ingresoCliente");
		mav.addObject("pinDTO",new PinDTO());
		
		return mav;

	}
	
	@RequestMapping("verificarPin.htm")
	public ModelAndView verificarPin(PinDTO pinDTO){
		ClienteDTO clienteDTO = userService.getUserByPin(pinDTO.getPin());
		
		ModelAndView mav = new ModelAndView("recepcion/opciones");
		HashMap<String, String> menuCliente = menuService.menuCliente();
		mav.addObject("opciones",menuCliente);
		mav.addObject("clienteDTO",clienteDTO);
		
		
		return mav;
	}

	@RequestMapping("usuarioNoCliente.htm")
	public ModelAndView usuarioNoCliente() {
		ModelAndView mav = new ModelAndView("recepcion/opciones");
		HashMap<String, String> menuNoCliente = menuService.menuNoCliente();
		mav.addObject("opciones",menuNoCliente);
		return mav;

	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	

}
