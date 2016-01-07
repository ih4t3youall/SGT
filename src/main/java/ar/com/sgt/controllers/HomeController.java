package ar.com.sgt.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import ar.com.sgt.persistence.dto.TurnoDTO;

@Controller
public class HomeController {

//	@Autowired
//	private SimpMessagingTemplate template;
	private TaskScheduler scheduler = new ConcurrentTaskScheduler();
	private Random rand = new Random(System.currentTimeMillis());

	/**
	 * Iterates stock list, update the price by randomly choosing a positive or
	 * negative percentage, then broadcast it to all subscribing clients
	 */
	@RequestMapping("/broadcast.htm")
	private void broadcastTurnos() {
		
		//mocked
		
		TurnoDTO turnoDTO = new TurnoDTO();
		turnoDTO.setNumero("908");
		turnoDTO.setPuesto("5");
		
		
//		template.convertAndSend("/topic/price", turnoDTO);
	}
	
	
	

	

	/**
	 * Invoked after bean creation is complete, this method will schedule
	 * updatePriceAndBroacast every 1 second
	 */

	/**
	 * Handler to add one stock
	 */
	@MessageMapping("/addStock")
	public void addStock(TurnoDTO turno) throws Exception {
		
		
		//este va para el placa
		System.out.println(turno.getNumero());
		System.out.println(turno.getPuesto());
		
		broadcastTurnos();
	}

	
	@RequestMapping("/turnoAceptado.htm")
	public void turnoAceptado(String turno){

		System.out.println(turno);
		
		Gson gson = new Gson();
		TurnoDTO turnoDTO = gson.fromJson(turno, TurnoDTO.class);
		
		
		
		
	}
	/**
	 * Handler to remove all stocks
	 */
	@MessageMapping("/removeAllStocks")
	public void removeAllStocks() {
		broadcastTurnos();
	}

	/**
	 * Serve the main page
	 */
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/martin.htm")
	public void nothing() {


	}

	
	
	
	

}
