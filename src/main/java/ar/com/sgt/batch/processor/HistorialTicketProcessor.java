package ar.com.sgt.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import ar.com.sgt.persistence.entity.HistorialTicket;
import ar.com.sgt.persistence.entity.Ticket;

public class HistorialTicketProcessor implements ItemProcessor<Ticket, HistorialTicket>{

    @Override
    public HistorialTicket process(Ticket ticket) throws Exception {
        HistorialTicket hTicket = new HistorialTicket();
        hTicket.setEstadoFinal(ticket.getEstado());
        hTicket.setFechaFinalizacion(ticket.getFechaFinalizacion());
        hTicket.setFechaInicio(ticket.getFechaInicio());
        hTicket.setTipo(ticket.getIdTicket().getTipo());
        if (ticket.getSesion()!=null){
            hTicket.setUsername(ticket.getSesion().getUser().getUsername());
        }
        return hTicket;
    }

}
