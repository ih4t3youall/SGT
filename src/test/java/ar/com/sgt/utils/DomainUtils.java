package ar.com.sgt.utils;

import ar.com.sgt.persistence.entity.Cliente;

public class DomainUtils {

	
	
	
	
	public static Cliente getCliente(int idCliente){
		
			
			Cliente cliente = new Cliente(idCliente);
			cliente.setApellido("apellido");
			cliente.setNombre("nombre");
			cliente.setPin(1);
			cliente.setPwd("password");
			cliente.setUsuario("usuarioCliente");
			return cliente;
		
		
	}
}
