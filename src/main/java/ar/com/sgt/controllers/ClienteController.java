package ar.com.sgt.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.dto.PinDTO;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.services.IClienteService;
import ar.com.sgt.services.UserService;
import ar.com.sgt.services.impl.MenuService;

@Controller
public class ClienteController {
	static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);

	private MenuService menuService;

	private UserService userService;

	private IClienteService clienteService;

	@RequestMapping("seleccionarUsuario")
	public ModelAndView seleccionarUsuario() {
		LOG.trace("entered seleccionarUsuario");
		ModelAndView mav = new ModelAndView("seleccionTipoCliente");
		LOG.trace("finished seleccionarUsuario");
		return mav;

	}

	@RequestMapping("usuarioCliente")
	public ModelAndView usuarioCliente() {
		LOG.trace("entered usuarioCliente");
		ModelAndView mav = new ModelAndView("ingresoCliente");
		mav.addObject("pinDTO", new PinDTO());
		LOG.trace("finished usuarioCliente");
		return mav;

	}

	@RequestMapping("verificarPin")
	public ModelAndView verificarPin(PinDTO pinDTO) {
		LOG.debug("entered verificarPin");
		Cliente cliente = clienteService.getClienteByPin(pinDTO.getPin());

		ModelAndView mav = new ModelAndView("opciones");
		Map<String, String> menuCliente = menuService.menuCliente();
		mav.addObject("opciones", menuCliente);
		mav.addObject("clienteDTO", cliente);
		LOG.debug("finished verificarPin");
		return mav;
	}

	@RequestMapping("usuarioNoCliente")
	public ModelAndView usuarioNoCliente() {
		LOG.debug("entered verificarPin");
		ModelAndView mav = new ModelAndView("opciones");
		Map<String, String> menuNoCliente = menuService.menuNoCliente();
		mav.addObject("opciones", menuNoCliente);
		LOG.debug("finished verificarPin");
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
