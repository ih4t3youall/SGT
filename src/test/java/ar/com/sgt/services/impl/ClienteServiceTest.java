package ar.com.sgt.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import ar.com.sgt.persistence.dao.impl.ClienteDao;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.utils.DomainUtils;
public class ClienteServiceTest {

	
	@Test
	public void getClienteByPin(){
		
		ClienteService clienteService = new ClienteService();
		
		ClienteDao clienteDAO = mock(ClienteDao.class);
		Cliente cliente = DomainUtils.getCliente(1);
		Mockito.when(clienteDAO.getClienteByPin(1)).thenReturn(cliente);
		
		clienteService.setClienteDao(clienteDAO);
		Cliente clienteByPin = clienteService.getClienteByPin(1);
		assertNotNull(clienteByPin);
		
		
	}
	
	
	
	
	
	
	
	
}
