package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class Ticket implements Serializable{

    @EmbeddedId
    private TicketId idTicket;
    
    private String fechaCreacion;
    
    private Date fechaInicio;
    
    private Date fechaFinalizacion;
    
    private String estado;
    
    @ManyToOne()
    @JoinColumn(name="sesion_id")
    private Sesion sesion;
    
    
}
