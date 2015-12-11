package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;


@Entity
@SuppressWarnings("unused")
@NamedQueries({
    @NamedQuery(name="Ticket.getNextTicketId",
                query="SELECT count(*) FROM Ticket t where tipo.tipo=:tipo")})
@Data
public class Ticket implements Serializable{

    @EmbeddedId
    private TicketId idTicket;
    
    private Timestamp fechaCreacion;
    
    private Timestamp fechaInicio;
    
    private Timestamp fechaFinalizacion;
    
    private String estado;
    
    private String tipoCliente;
    
    @ManyToOne()
    @JoinColumn(name="sesion_id",nullable=true)
    private Sesion sesion;
    
    @ManyToOne()
    @JoinColumn(name="tipo",referencedColumnName="tipo",insertable = false, updatable = false)
    private TipoTramite tipo;
    
    
}
