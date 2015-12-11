package ar.com.sgt.persistence.dao;

import ar.com.sgt.persistence.entity.Ticket;
import ar.com.sgt.persistence.entity.TicketId;

public interface ITicketDao extends IGenericJpaDao<Ticket, TicketId> {
    
    Integer getNextId(String tipo);

}
