package ar.com.sgt.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SuppressWarnings("unused")
public class HistorialTicket implements Serializable{

    @Id
    @GeneratedValue(generator = "HistorialTicketSequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "HistorialTicketSequence", sequenceName = "HISTORIALTICKET_SEQ")
    private Integer idTicket;
    
    private String username;
    
    private String tipo;
    
    private Timestamp fechaInicio;
    
    private Timestamp fechaFinalizacion;
    
    private String estadoFinal;
    
}
