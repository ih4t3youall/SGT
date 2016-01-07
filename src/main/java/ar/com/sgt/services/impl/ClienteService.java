/**
 * 
 */
package ar.com.sgt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.sgt.persistence.dao.IClienteDao;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.services.IClienteService;

/**
 * @author mauro.damian.plaquin
 * 
 */
@Repository("clienteService")
public class ClienteService implements IClienteService {

	
	@Autowired
    private IClienteDao clienteDao;

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.sgt.services.IClienteService#getClienteByPin(int)
     */
    @Override
    public Cliente getClienteByPin(int pin) {
    	return clienteDao.getClienteByPin(pin);
    }

    /**
     * @return the clienteDao
     */
    public IClienteDao getClienteDao() {
	return clienteDao;
    }

    /**
     * @param clienteDao
     *            the clienteDao to set
     */
    public void setClienteDao(IClienteDao clienteDao) {
	this.clienteDao = clienteDao;
    }
    
    
    

}
