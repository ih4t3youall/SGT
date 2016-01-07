package ar.com.sgt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import ar.com.sgt.persistence.dto.TurnoDTO;
import ar.com.sgt.services.ITurnoService;

public class TurnoService implements ITurnoService {

	@Autowired
	private SimpMessagingTemplate template;
	
	@Override
	public void sendTurno(TurnoDTO turnoDTO) {
		
		
		
		template.convertAndSend("/topic/ticket", turnoDTO);
		
	}

}
