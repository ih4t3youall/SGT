package ar.com.sgt.services.impl;

import org.springframework.stereotype.Service;

import ar.com.sgt.persistence.dto.ClienteDTO;
import ar.com.sgt.services.IQueueService;


@Service
public class QueueService implements IQueueService{

	@Override
	public ClienteDTO obtenerSiguienteCliente(String numeroPuestp) {
	
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNombre("martin");
		clienteDTO.setApellido("lequerica");
		clienteDTO.setDni("36578976");
		clienteDTO.setCbu("123123");
		clienteDTO.setNumeroCliente("123123123");
		
		
		
		
		return clienteDTO;
	}


	
	
}
