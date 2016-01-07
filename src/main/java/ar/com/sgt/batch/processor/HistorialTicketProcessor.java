package ar.com.sgt.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.sgt.persistence.dao.ITicketDao;
import ar.com.sgt.persistence.entity.HistorialTicket;
import ar.com.sgt.persistence.entity.Ticket;

@Repository("historialTicketProcessor")
public class HistorialTicketProcessor implements ItemProcessor<Ticket, HistorialTicket>{
	

    @Override
    public HistorialTicket process(Ticket ticket) throws Exception {
        HistorialTicket hTicket = new HistorialTicket();
        hTicket.setEstadoFinal(ticket.getEstado());
        hTicket.setFechaFinalizacion(ticket.getFechaFinalizacion());
        hTicket.setFechaInicio(ticket.getFechaInicio());
        hTicket.setTipo(ticket.getIdTicket().getTipo());
        if (ticket.getSesion()!=null){
            hTicket.setUsername(ticket.getSesion().getUser().getSsoId());
        }
        return hTicket;
    }

}
