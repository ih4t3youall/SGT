package ar.com.sgt.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.persistence.entity.ClienteDTO;
import ar.com.sgt.persistence.entity.PinDTO;
import ar.com.sgt.services.IClienteService;
import ar.com.sgt.services.UserService;
import ar.com.sgt.services.impl.MenuService;

@Controller
public class ClienteController {

    private MenuService menuService;

    private UserService userService;

    private IClienteService clienteService;

    @RequestMapping("seleccionarUsuario")
    public ModelAndView seleccionarUsuario() {

	ModelAndView mav = new ModelAndView("seleccionTipoCliente");

	return mav;

    }

    @RequestMapping("usuarioCliente")
    public ModelAndView usuarioCliente() {

	HashMap<String, String> menuCliente = menuService.menuCliente();
	ModelAndView mav = new ModelAndView("ingresoCliente");
	mav.addObject("pinDTO", new PinDTO());

	return mav;

    }

    @RequestMapping("verificarPin")
    public ModelAndView verificarPin(PinDTO pinDTO) {
	ClienteDTO clienteDTO = userService.getUserByPin(pinDTO.getPin());
	Cliente cliente = clienteService.getClienteByPin(pinDTO.getPin());

	ModelAndView mav = new ModelAndView("opciones");
	HashMap<String, String> menuCliente = menuService.menuCliente();
	mav.addObject("opciones", menuCliente);
	mav.addObject("clienteDTO", cliente);

	return mav;
    }

    @RequestMapping("usuarioNoCliente")
    public ModelAndView usuarioNoCliente() {
	ModelAndView mav = new ModelAndView("opciones");
	HashMap<String, String> menuNoCliente = menuService.menuNoCliente();
	mav.addObject("opciones", menuNoCliente);
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

    /**
     * @return the clienteService
     */
    public IClienteService getClienteService() {
	return clienteService;
    }

    /**
     * @param clienteService
     *            the clienteService to set
     */
    public void setClienteService(IClienteService clienteService) {
	this.clienteService = clienteService;
    }

}
