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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.entity.Greeting;
import ar.com.sgt.persistence.entity.HelloMessage;

@Controller
public class WebsocketController {

	@Autowired
	private SimpMessagingTemplate template;
	
	//solo responde a los mensajes /admin/hello y el send to significa que cuando finalice va a enviar un mensaje al canal /topic/greetings
    @MessageMapping("/admin/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        System.out.println(message.getName());
        return new Greeting("Hello, " + message.getName() + "!");
    }

    
    
    //cuando se ingresa aca , se hace un broadcast a todos los clientes que esten suscritos a /topic/ws
    @RequestMapping("/admin/enviar")
    public @ResponseBody String enviar(String mensaje){
    	//envia por broadcast a todos los subscritos a /topic/ws el objeto greeting que dentro tiene el mensaje "mensaje!"
    	Greeting greeting = new Greeting(mensaje);
		template.convertAndSend("/topic/ws", greeting);
		
    	return "Broadcast con exito! revise la otra pantalla";
    	
    }
    
    
    //devuelve la jsp de prueba de websocket
    @RequestMapping("/admin/pruebaWebsocket.htm")
    public ModelAndView pruebaWebsocket(){
    	ModelAndView mav = new ModelAndView("pruebaWebsocket");
    	
    	return mav;
    	
    	
    }
    
    @RequestMapping("/admin/broadcast.htm")
    public ModelAndView broadcast(){
    	
    	ModelAndView mav = new ModelAndView("broadcast");
    	return mav;
    	
    }

}