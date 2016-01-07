/**
 * 
 */
package ar.com.sgt.persistence.dao;

import ar.com.sgt.persistence.entity.Cliente;

/**
 * @author mauro.damian.plaquin
 * 
 */
public interface IClienteDao  {

    /**
     * @param pin
     * @return
     */
    Cliente getClienteByPin(int pin);

}
