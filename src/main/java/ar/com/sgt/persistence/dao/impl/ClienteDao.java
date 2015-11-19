/**
 * 
 */
package ar.com.sgt.persistence.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgt.persistence.dao.IClienteDao;
import ar.com.sgt.persistence.entity.Cliente;

/**
 * @author mauro.damian.plaquin
 * 
 */
public class ClienteDao extends GenericJpaDao<Cliente, Integer> implements
	IClienteDao {

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.sgt.services.IClienteService#getClienteByPin(int)
     */
    @Override
    @Transactional
    public Cliente getClienteByPin(int pin) {
	Cliente cliente;
	Criteria criteria = getSession().createCriteria(Cliente.class);
	criteria.add(Restrictions.eq("pin", new Integer(pin)));
	cliente = (Cliente) criteria.uniqueResult();
	return cliente;
    }

}
