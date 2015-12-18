/**
 * 
 */
package ar.com.sgt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import ar.com.sgt.persistence.dto.ClienteDTO;
import ar.com.sgt.persistence.dto.UserDTO;
import ar.com.sgt.services.IQueueService;
import ar.com.sgt.services.IUserService;

/**
 * @author mauro.damian.plaquin
 * 
 */
@Controller
public class EmpleadoController {

	static final Logger LOG = LoggerFactory.getLogger(EmpleadoController.class);

	private IUserService userService;
	private IQueueService queueService;

	@RequestMapping("/loginEmpleado")
	public ModelAndView loadPage() {

		ModelAndView model = new ModelAndView("loginEmpleado");

		return model;
	}

	@RequestMapping("/loginFailEmpleado")
	public ModelAndView loadPageFail() {

		ModelAndView model = new ModelAndView("loginEmpleado");
		model.addObject("error", "fail");

		return model;
	}

	@RequestMapping("/welcome")
	public ModelAndView loadWelcomeEmpleado() {

		ModelAndView model = new ModelAndView("menuEmpleado");

		return model;
	}

	@RequestMapping("/pantallaEmpleado.htm")
	public ModelAndView pantallaEmpelado() {
		ModelAndView mav = new ModelAndView("pantallaEmpleado");
		UserDTO empleadoDTO = userService.getUserDTO();
		mav.addObject("empleadoDTO", empleadoDTO);
		return mav;

	}
	
	@RequestMapping("puestoLibre.htm")
	public @ResponseBody String puestoLibre(String numeroPuesto){
		ClienteDTO obtenerSiguienteCliente = queueService.obtenerSiguienteCliente(numeroPuesto);
		Gson gson = new Gson();
		String respuesta = gson.toJson(obtenerSiguienteCliente);
		
		return respuesta;
		
	}
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setQueueService(IQueueService queueService) {
		this.queueService = queueService;
	}

	
	
	

}
