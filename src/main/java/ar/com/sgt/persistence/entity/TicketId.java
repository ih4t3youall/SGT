package ar.com.sgt.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
@SuppressWarnings("unused")
public class TicketId implements Serializable{

    @Column(name="ticket_id")
    private Integer ticketId;
    
    @Column(name="tipo")
    private String tipo;
}
