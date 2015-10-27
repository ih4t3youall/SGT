/**
 * 
 */
package ar.com.sgt.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mauro.damian.plaquin
 * 
 */
@Controller
public class EmpleadoController {

    @RequestMapping("/loginEmpleado")
    public ModelAndView loadPage(HttpServletRequest request,
	    HttpServletResponse response) {

	ModelAndView model = new ModelAndView("loginEmpleado");

	return model;
    }

    @RequestMapping("/loginFailEmpleado")
    public ModelAndView loadPageFail(HttpServletRequest request,
	    HttpServletResponse response) {

	ModelAndView model = new ModelAndView("loginEmpleado");
	model.addObject("error", "fail");

	return model;
    }

    @RequestMapping("/welcome")
    public ModelAndView loadWelcomeEmpleado(HttpServletRequest request,
	    HttpServletResponse response) {

	ModelAndView model = new ModelAndView("menuEmpleado");

	return model;
    }

}
