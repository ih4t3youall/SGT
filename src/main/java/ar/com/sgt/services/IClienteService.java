/**
 * 
 */
package ar.com.sgt.services;

import ar.com.sgt.persistence.entity.Cliente;

/**
 * @author mauro.damian.plaquin
 * 
 */
public interface IClienteService {

    Cliente getClienteByPin(int pin);

}
