package ar.com.sgt.services;

import ar.com.sgt.persistence.dto.ClienteDTO;

public interface IQueueService {

	
	public ClienteDTO obtenerSiguienteCliente(String numeroPuesto);
	
	
	
}
