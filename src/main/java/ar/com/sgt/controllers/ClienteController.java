package ar.com.sgt.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.sgt.persistence.dto.PinDTO;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.services.IClienteService;
import ar.com.sgt.services.ITicketService;
//import ar.com.sgt.services.impl.JmsMessageSender;
import ar.com.sgt.services.impl.MenuService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ClienteController {

//	@Autowired
//	private JmsMessageSender jmsMessageSender;
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private IClienteService clienteService;
//	@Autowired
//	private ITicketService ticketService; clase comentada

	@RequestMapping("seleccionarUsuario")
	public ModelAndView seleccionarUsuario() {
		log.trace("entered seleccionarUsuario");
		ModelAndView mav = new ModelAndView("seleccionTipoCliente");
		log.trace("finished seleccionarUsuario");
		return mav;

	}
	
	
	@RequestMapping("tiles")
    public ModelAndView tiles() {
        log.trace("entered tiles");
        ModelAndView mav = new ModelAndView("loggedLayout");
        log.trace("finished seleccionarUsuario");
        return mav;

    }

	@RequestMapping("usuarioCliente")
	public ModelAndView usuarioCliente() {
		log.trace("entered usuarioCliente");
		ModelAndView mav = new ModelAndView("ingresoCliente");
		mav.addObject("pinDTO", new PinDTO());
		log.trace("finished usuarioCliente");
		return mav;

	}

	@RequestMapping("verificarPin")
	public ModelAndView verificarPin(PinDTO pinDTO) {
		log.debug("entered verificarPin");
		Cliente cliente = clienteService.getClienteByPin(pinDTO.getPin());
		if (cliente==null){
		    ModelAndView mav = new ModelAndView("ingresoCliente");
	        mav.addObject("pinDTO", new PinDTO());
	        mav.addObject("error", "El PIN es invalido");
	        return mav;
		}
		ModelAndView mav = new ModelAndView("opciones");
		Map<String, String> menuCliente = menuService.menuCliente();
		mav.addObject("opciones", menuCliente);
		mav.addObject("clienteDTO", cliente);
		log.debug("finished verificarPin");
		return mav;
	}

	@RequestMapping("usuarioNoCliente")
	public ModelAndView usuarioNoCliente() {
		log.debug("entered verificarPin");
		ModelAndView mav = new ModelAndView("opciones");
		Map<String, String> menuNoCliente = menuService.menuNoCliente();
		mav.addObject("opciones", menuNoCliente);
		log.debug("finished verificarPin");
		return mav;

	}
	
	
	@RequestMapping(value="createTicket")
	public ResponseEntity<byte[]> createTicket(@RequestParam("seleccion")String tipoTramite, @RequestParam("tipocliente")String tipoCliente) throws FileNotFoundException, IOException {
        log.debug("entered createTicket");
//        String path=ticketService.crearTicket(tipoCliente, tipoTramite);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//        String filename = "ticket.pdf";
//        headers.setContentDispositionFormData(filename, filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        byte[] contents = IOUtils.toByteArray(new FileInputStream(path));
//        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
//        return response;
//        clases comentadas
        return null;

    }
	
	@RequestMapping("/sendToJms")
	public void sendToJms(){
		
		// send to default destination
		
//	    jmsMessageSender.send("hello JMS");
	         
	    // send to a code specified destination
//	    Queue queue = new ActiveMQQueue("sgt");
//	    jmsMessageSender.send(queue, "hello Another Message");
		
	}
	
	
	
	@RequestMapping("/pruebaWs.htm")
	public ModelAndView nose1(){
		
		
		ModelAndView mav = new ModelAndView("pruebaWebsocket");
		
		return mav;
	}
	
	
	
	@RequestMapping("/readJms")
	public void readJms(){
		
	    Queue queue = new ActiveMQQueue("sgt");
	    
		
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
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

//    public ITicketService getTicketService() { clase comentada
//        return ticketService;
//    }
//
//    public void setTicketService(ITicketService ticketService) {
//        this.ticketService = ticketService;
//    }
	

}
