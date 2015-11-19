/**
 * 
 */
package ar.com.sgt.services.impl;

import ar.com.sgt.persistence.dao.IClienteDao;
import ar.com.sgt.persistence.entity.Cliente;
import ar.com.sgt.services.IClienteService;

/**
 * @author mauro.damian.plaquin
 * 
 */
public class ClienteService implements IClienteService {

    private IClienteDao clienteDao;

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.sgt.services.IClienteService#getClienteByPin(int)
     */
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
