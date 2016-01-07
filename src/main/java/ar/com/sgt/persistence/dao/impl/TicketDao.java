package ar.com.sgt.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import ar.com.sgt.persistence.dao.AbstractDao;
import ar.com.sgt.persistence.dao.ITicketDao;
import ar.com.sgt.persistence.entity.Ticket;
import ar.com.sgt.persistence.entity.TicketId;

@Repository("ticketDao")
public class TicketDao extends AbstractDao<Ticket,TicketId> implements ITicketDao{
    
    @Override
    public Integer getNextId(String tipo){
    	//TODO to fix
//        Integer cantidad=((Number)getEntityManager().createNamedQuery("Ticket.getNextTicketId").
//                setParameter("tipo", tipo).getSingleResult()).intValue();
    	int cantidad =1;
        return ++cantidad;
    }
    
    
}
