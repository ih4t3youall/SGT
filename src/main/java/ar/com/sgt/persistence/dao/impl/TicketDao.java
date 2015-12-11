package ar.com.sgt.persistence.dao.impl;

import ar.com.sgt.persistence.dao.ITicketDao;
import ar.com.sgt.persistence.entity.Ticket;
import ar.com.sgt.persistence.entity.TicketId;

public class TicketDao extends GenericJpaDao<Ticket,TicketId> implements ITicketDao{
    
    public Integer getNextId(String tipo){
        Integer cantidad=((Number)getEntityManager().createNamedQuery("Ticket.getNextTicketId").
                setParameter("tipo", tipo).getSingleResult()).intValue();
        return ++cantidad;
    }
    
    
}
