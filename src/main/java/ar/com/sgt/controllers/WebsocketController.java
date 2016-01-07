package ar.com.sgt.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.entity.Greeting;
import ar.com.sgt.persistence.entity.HelloMessage;

@Controller
public class WebsocketController {

	@Autowired
	private SimpMessagingTemplate template;
	
    @MessageMapping("/admin/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        System.out.println(message.getName());
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("test");
    }
    
    
    @MessageMapping("/admin/ws")
    @SendTo("/topic/ws")
    public String greeting1(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        System.out.println(message.getName());
//        return new Greeting("Hello, " + message.getName() + "!");
return "ando";
        
        
    }
    
    @RequestMapping("/admin/nose")
    public void nose1(){
    	
		template.convertAndSend("/topic/ws", "nose");
    	
    	
    }
    
    
    
    @RequestMapping("/admin/pruebaWebsocket.htm")
    public ModelAndView pruebaWebsocket(){
    	ModelAndView mav = new ModelAndView("pruebaWebsocket");
    	
    	return mav;
    	
    	
    }

}