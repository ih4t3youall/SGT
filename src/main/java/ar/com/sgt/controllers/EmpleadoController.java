
/**
 * 
 */
package ar.com.sgt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import ar.com.sgt.persistence.dto.ClienteDTO;
import ar.com.sgt.security.model.User;
import ar.com.sgt.services.IQueueService;
import ar.com.sgt.services.IUserService;

/**
 * @author mauro.damian.plaquin
 * 
 */
@Controller
public class EmpleadoController {

	static final Logger LOG = LoggerFactory.getLogger(EmpleadoController.class);

	@Autowired
	private IUserService userService;
	@Autowired
	private IQueueService queueService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(ModelMap modelMap) {
		return "loginEmpleado";
	}

	
	
	
	@RequestMapping("/loginFailEmpleado")
	public ModelAndView loadPageFail() {

		ModelAndView model = new ModelAndView("loginEmpleado");
		model.addObject("error", "fail");

		return model;
	}

	@RequestMapping("/empleado/welcome.htm")
	public ModelAndView loadWelcomeEmpleado() {

		ModelAndView model = new ModelAndView("menuEmpleado");

		return model;
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "login/accessDenied";
	}

	@RequestMapping(value = "/empleado/pantallaEmpleado.htm", method = RequestMethod.GET)
	public ModelAndView pantallaEmpelado() {
		ModelAndView mav = new ModelAndView("pantallaEmpleado");
		User findBySso = userService.findBySso("nombre");
		// TODO fix me
		// mav.addObject("empleadoDTO", empleadoDTO);
		return mav;

	}

	@RequestMapping("/empleado/puestoLibre.htm")
	public @ResponseBody String puestoLibre(String numeroPuesto) {
		ClienteDTO obtenerSiguienteCliente = queueService.obtenerSiguienteCliente(numeroPuesto);
		Gson gson = new Gson();
		String respuesta = gson.toJson(obtenerSiguienteCliente);

		return respuesta;

	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setQueueService(IQueueService queueService) {
		this.queueService = queueService;
	}

}
