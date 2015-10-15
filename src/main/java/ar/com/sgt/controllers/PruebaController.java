package ar.com.sgt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.dao.PersonaDAO;
import ar.com.sgt.dominio.Persona;
@Controller
public class PruebaController {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@RequestMapping("inicio.htm")
	public ModelAndView unModelAndView(){
		

         

         
        Persona person = new Persona();
        person.setName("Pankaj");
        person.setConuntry("India");
        person.setId(1);
         
        personaDAO.save(person);
         
        System.out.println("Person::"+person);
         
        List<Persona> list = personaDAO.list();
         
        for(Persona p : list){
            System.out.println("Person List::"+p);
        }
		
		
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
}
